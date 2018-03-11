import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class gameFrame extends JFrame {

	public final static int GAME_WIDTH = 600;
	public final static int GAME_HEIGTH = 500;
	private hunter hunter;
	private enemy enemy;
	private gamePanel gp;
	
	public static void main(String[] args) {
		new gameFrame();
	}
	
	public gameFrame() {
		//����hunter����
		hunter = new hunter( );
		enemy = new Vampire(3);
		//hunter����������
		hunter.setLocation(10,10,5);
		//��������ڴ��ڵ�λ��
		this.setLocation(300, 100);
		//���崰�ڵĴ�С�ߴ�
		this.setSize(GAME_WIDTH, GAME_HEIGTH);
		//���崰��ı���
		this.setTitle("Game Hunter");
		//���ô���رյ�ͬʱ�Ƴ�����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ô��岻���Ե�����С
		this.setResizable(false);
		//��ش���Ķ������˴���ص��Ǽ����¼�
		this.addKeyListener(new myKeyEvent());
		//��һ�����
		gp = new gamePanel();
		//�������ӵ�������
		this.add(gp);
		
		//���ô���ɼ�
		this.setVisible(true);
	}
	public class gamePanel extends JPanel{
		@Override
		//����һ�������������������ܶද��
		public void paint(Graphics g) {
			super.paint(g);
			//���ñ���ɫΪ��ɫ
			g.setColor(Color.BLACK);
			//�����������
			g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGTH);
			//�����֮�Ϲ�����hunter����
			hunter.drew(g);
			//������л�������
			hunter.getWeapon().drew(hunter, g);
			//����enemy����
			enemy.drew(g);
		}
	}
	private class myKeyEvent extends KeyAdapter{
		@Override
		//�����¼�
		public void keyPressed(KeyEvent e) {
			//�жϰ��µĽ����������ң�ͬʱ������Ӧ�ķ������
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				hunter.setDir(direction.DOWN);
				//�����ƶ�����
				hunter.move();
			}else if(e.getKeyCode()==KeyEvent.VK_UP){
				hunter.setDir(direction.UP);
				hunter.move();
			}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				hunter.setDir(direction.RIGHT);
				hunter.move();
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
				hunter.setDir(direction.LEFT);
				hunter.move();
			}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				//����sapce������ʱ��sishowΪtrue
				hunter.getWeapon().setIsshow(true);
			}
			//�����������������ײ��hunter����
			if(checkHit(hunter, enemy)) {
				hunter.injured(enemy);
			}
			if(checkHit(hunter.getWeapon(), enemy)) {
				hunter.fight(enemy);
			}
			//�����������ˢ��ͼ�񣬱���Ҫ��
			gp.repaint();
		}
		@Override
		//�����ͷ��¼�
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			//���ͷŵ�ʱ����������ʧ
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				hunter.getWeapon().setIsshow(false);
			}
			gp.repaint();
		}
		private boolean checkHit(hunter hunter,enemy enemy) {
			//�ж�������Ӱ����ǲ����غϣ��Ƿ���true�����Ƿ���false
			return hunter.getArea().intersects(enemy.getArea());
		}
		private boolean checkHit(weapon weapon,enemy enemy) {
			//�ж�������Ӱ����ǲ����غϣ��Ƿ���true�����Ƿ���false
			return weapon.getArea(hunter).intersects(enemy.getArea());
		}
	}
}
