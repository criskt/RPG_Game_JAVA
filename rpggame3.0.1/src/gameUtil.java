import java.awt.Color;
import java.awt.Graphics;

public class gameUtil
{
	static int lostBasicLife = 7;
	//int basic;
	//计算丢失的生命值
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
	//产生随机数
	public static int randomRange(int start, int end)
	{
		return (int)(Math.random()*(end - start) + start);
	}
	//躲避的方法
	public static boolean isHidden(int hideRate, int agile)
	{
		int sucRate = agile * hideRate / 100;
		int ran = randomRange(1,101);
		//判断躲避成功
		if (ran < sucRate)
		{
			return true;
		}
		return false;
	}
	public static void drawLife(int x,int y,int height,int width,int curLife,int maxLife,Graphics g) {
		//画生命
		g.drawRect(x-1, y+height+2, width+1, 10);
		g.setColor(Color.GREEN);
		g.fillRect(x, y+height+3, width*curLife/maxLife, 9);
	}

}