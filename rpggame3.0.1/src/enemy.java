import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class enemy
{
	private int x,y,width,height;
	private String type;
	private int life;
	private int explife;
	private boolean isLive;
	private int agile;
	private int hideRate;
	//定义攻击力和防御力
	private int attack;
	private int defend;
	private int person;
	//躲避的方法
	
	public enemy() {
		super();
		x=100;
		y=100;
		width=30;
		height=30;
	}
	
	public String getType() {
		return type;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getExplife() {
		return explife;
	}

	public void setExplife(int explife) {
		this.explife = explife;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getAgile() {
		return agile;
	}

	public void setAgile(int agile) {
		this.agile = agile;
	}

	public int getHideRate() {
		return hideRate;
	}

	public void setHideRate(int hideRate) {
		this.hideRate = hideRate;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefend() {
		return defend;
	}

	public void setDefend(int defend) {
		this.defend = defend;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public void drew(Graphics g) {
		if(!isLive) return;
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		g.drawString(this.type, x-5, y-2);
		gameUtil.drawLife(x, y, height, width, life, explife, g);
	
	}
	public Rectangle getArea() {
		//同样返回该对象的位置信息，这个位置信息使用的参数是X,Y，
		//所以在enemydead之后依然存在这个区域，需要将其释放。
		if(!isLive) {
			//此句等价于Rectangle()，默认的就是0,0位置的空对象
			return new Rectangle(0,0,0,0);
		}
		return new Rectangle(x,y,width,height);
	}
	
	public boolean hidden()
	{
		return gameUtil.isHidden( hideRate,  agile);
	}
	//后退函数
	private void back(hunter hunter) {
		if(hunter.getDir()==direction.UP) {
			this.y-=hunter.getSpeed()+3;
		} else if(hunter.getDir()==direction.LEFT) {
			this.x-=hunter.getSpeed()+3;
		} else if(hunter.getDir()==direction.RIGHT) {
			this.x+=hunter.getSpeed()+3;
		} else if(hunter.getDir()==direction.DOWN) {
			this.y+=hunter.getSpeed()+3;
		}
	}
	public int injured(hunter hunter)
	{
		int losttlif = 0;
		if (hidden())
		{
			System.out.println(type+":  =-=-=-=-=-= 额滴神呐，差点打着我 =-=-=-=-=-【【【【【【【【【【");
		}else
		{
			losttlif = gameUtil.callostLife(hunter.getAttack(),defend);
			life -= losttlif;
			if (life <= 0)
			{
				death(hunter);
				return losttlif;
			}
			System.out.println("eee "+type+":  我挨打了! "+hunter.getName()+" hit me...");
		}
		back(hunter);
		return losttlif;
	}
	//抽象方法
	public abstract void kill(hunter hunter);

	public void death(hunter hunter)
	{
		
		System.out.println(type +"::  i am dead , please do not disturb me more .   ");
		isLive = false;
		show();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ dead line ~~~~~~~~~~~~~~");

	}
	public void show()
	{
		System.out.println("[[[ "+type+":  life:"+life+"   Alive:"+isLive+"  attack:"+attack+"  defend:"+defend +" ]]]");
	}
}