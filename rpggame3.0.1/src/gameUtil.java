import java.awt.Color;
import java.awt.Graphics;

public class gameUtil
{
	static int lostBasicLife = 7;
	//int basic;
	//���㶪ʧ������ֵ
	public static int callostLife(int attack, int defend)
	{
		int cel = 0;
		int lostLife = attack - defend;
		if (lostLife <=0)
		{
			cel = lostBasicLife;
		}else 
		{
			cel = (lostLife+lostBasicLife);
		}
		return cel;
	}
	//���������
	public static int randomRange(int start, int end)
	{
		return (int)(Math.random()*(end - start) + start);
	}
	//��ܵķ���
	public static boolean isHidden(int hideRate, int agile)
	{
		int sucRate = agile * hideRate / 100;
		int ran = randomRange(1,101);
		//�ж϶�ܳɹ�
		if (ran < sucRate)
		{
			return true;
		}
		return false;
	}
	public static void drawLife(int x,int y,int height,int width,int curLife,int maxLife,Graphics g) {
		//������
		g.drawRect(x-1, y+height+2, width+1, 10);
		g.setColor(Color.GREEN);
		g.fillRect(x, y+height+3, width*curLife/maxLife, 9);
	}

}