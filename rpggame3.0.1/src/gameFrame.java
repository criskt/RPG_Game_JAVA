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
		//创建hunter对象
		hunter = new hunter( );
		enemy = new Vampire(3);
		//hunter的形体属性
		hunter.setLocation(10,10,5);
		//定义出现在窗口的位置
		this.setLocation(300, 100);
		//定义窗口的大小尺寸
		this.setSize(GAME_WIDTH, GAME_HEIGTH);
		//定义窗体的标题
		this.setTitle("Game Hunter");
		//设置窗体关闭的同时推出程序
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置窗体不可以调整大小
		this.setResizable(false);
		//监控窗体的动作，此处监控的是键盘事件
		this.addKeyListener(new myKeyEvent());
		//画一个面板
		gp = new gamePanel();
		//将面板添加到窗体中
		this.add(gp);
		
		//设置窗体可见
		this.setVisible(true);
	}
	public class gamePanel extends JPanel{
		@Override
		//勾画一个面板出来，面板可以做很多动作
		public void paint(Graphics g) {
			super.paint(g);
			//设置背景色为黑色
			g.setColor(Color.BLACK);
			//设置面板的填充
			g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGTH);
			//在面板之上勾画出hunter对象
			hunter.drew(g);
			//在面板中画出武器
			hunter.getWeapon().drew(hunter, g);
			//画出enemy对象
			enemy.drew(g);
		}
	}
	private class myKeyEvent extends KeyAdapter{
		@Override
		//键盘事件
		public void keyPressed(KeyEvent e) {
			//判断按下的健是上下左右，同时传递相应的方向参数
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				hunter.setDir(direction.DOWN);
				//调用移动方法
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
				//键盘sapce健出发时将sishow为true
				hunter.getWeapon().setIsshow(true);
			}
			//如果两个对象发生了碰撞，hunter受伤
			if(checkHit(hunter, enemy)) {
				hunter.injured(enemy);
			}
			if(checkHit(hunter.getWeapon(), enemy)) {
				hunter.fight(enemy);
			}
			//这个函数用来刷新图像，必须要有
			gp.repaint();
		}
		@Override
		//键盘释放事件
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			//当释放的时候，让武器消失
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				hunter.getWeapon().setIsshow(false);
			}
			gp.repaint();
		}
		private boolean checkHit(hunter hunter,enemy enemy) {
			//判断两个阴影面积是不是重合，是返回true，不是返回false
			return hunter.getArea().intersects(enemy.getArea());
		}
		private boolean checkHit(weapon weapon,enemy enemy) {
			//判断两个阴影面积是不是重合，是返回true，不是返回false
			return weapon.getArea(hunter).intersects(enemy.getArea());
		}
	}
}
