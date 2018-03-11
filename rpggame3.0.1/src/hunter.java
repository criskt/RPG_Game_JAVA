import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class hunter
{
	public final static int HUNTER_WIDTH =30;
	public final static int HUNTER_HEIGHT = 30;
	
	private int x, y, speed;
	private direction dir;
	
	
	private String name;
	private boolean isLive;
	private weapon weapon;

	private int curLife;
	private int maxLife;

	//增加攻击力和防御力
	private int attack;
	private int defend;

	//经验值和登记
	private int level;
	private int exp;

	//躲避的设置
	private int agile;		//敏捷
	private int hideRate;	//躲避最大几率
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	public direction getDir() {
		return dir;
	}

	public void setDir(direction dir) {
		this.dir = dir;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(weapon weapon) {
		this.weapon = weapon;
	}

	public int getCurLife() {
		return curLife;
	}

	public void setCurLife(int curLife) {
		this.curLife = curLife;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
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
	//默认构造器
	public hunter()
	{
		this.name = "傻瓜";
		//this.weapon = new axe("大肠");
		this.weapon = new getLifeSkill(new axe("香肠"), 34) ;
		//System.out.println(weapon.getLength());
		maxLife = 180;
		curLife = maxLife;
		isLive = true;
		attack = 30;
		defend = 8;
		level = 1;
		exp = 0;
		agile = 50;
		hideRate = 60;
		//默认方向为右
		dir = direction.RIGHT;
	}
	//定义构造函数
	public hunter(String name,weapon weapon)
	{
		this.name = name;
		this.weapon = weapon;
		maxLife = 180;
		curLife = maxLife;
		isLive = true;
		attack = 30;
		defend = 8;
		level = 1;
		exp = 0;
		agile = 50;
		hideRate = 60;
		dir = direction.RIGHT;
	}
	//画hunter形象。需要传入一个Graphics的g画笔
	public void drew(Graphics g) {
		//如果hunter dead，hunter体消失
		if(!isLive()) return;
		//背景色
		g.setColor(Color.RED);
		//画一个长方形体
		g.fillRect(x, y, HUNTER_WIDTH, HUNTER_HEIGHT);
		//勾画hunter的眼睛
		int eyeR = 5;	//眼睛为园型，半径
		int eyeX = 0;	//圆心的坐标
		int eyeY = 0;	//圆心的坐标
		//移动的时候设置小球的位置，形成动态的变化
		if(dir == direction.LEFT) {
			eyeX = x;
			eyeY = y+(HUNTER_HEIGHT/2)-eyeR;
		}else if(dir == direction.RIGHT) {
			eyeX = x+HUNTER_WIDTH-2*eyeR;
			eyeY= y+(HUNTER_HEIGHT/2)-eyeR;
		}else if(dir == direction.UP) {
			eyeY = y;
			eyeX = x+HUNTER_WIDTH/2-eyeR;
		}else if(dir == direction.DOWN) {
			eyeY = y+HUNTER_HEIGHT-2*eyeR;
			eyeX = x+HUNTER_WIDTH/2-eyeR;
		}
		g.setColor(Color.blue);
		//画一个园出来，充当眼睛
		g.fillOval(eyeX, eyeY, 2*eyeR, 2*eyeR);
		//通过添加String增加名字
		g.setColor(Color.YELLOW);
		g.drawString(this.name, x-2, y-4);
		//增加生命条
		//先画一个外框
		g.drawRect(x, y+HUNTER_HEIGHT+2, HUNTER_WIDTH+1, 10);
		//添加内框,同时乘以相应的比例
		g.setColor(Color.green);	//绿色
		g.fillRect(x, y+HUNTER_HEIGHT+3, HUNTER_WIDTH*curLife/maxLife, 9);
		
	}
	public Rectangle getArea() {
		//用来返回坐标所标识的面积，提供的是位置信息
		//同样需要设置一个空的位置信息
		if(!isLive) {
			return new Rectangle();
		}
		return new Rectangle(x,y,HUNTER_WIDTH,HUNTER_HEIGHT);
	}
	//创建移动的方法
 	public void move() {
		//根据方向的移动进行移动
		if(dir == direction.UP) {
			this.y -= speed;
		}else if(dir == direction.DOWN) {
			this.y += speed;
		}else if(dir == direction.RIGHT) {
			this.x += speed;
		}else if(dir == direction.LEFT) {
			this.x -= speed;
		}
	}
 	//设置形象的高长和移动速度
	public void setLocation(int x,int y,int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public void fight(enemy em)
	{
		if (!isLive)
		{
			System.out.println(name +"::  我已经死了，不能打了。。。");
			return;
		}
		if (!em.isLive())
		{
			System.out.println("你要打的对象： "+em.getType()+"  已经死亡，不要暴尸啊！！");
			return;
		}
		System.out.println("<<<"+name+":挥舞着\""+weapon.getWeep()+"\"\""+weapon.getName()+"\" 打向 "+ em.getType()+">>>");

		weapon.damage(this, em);	
		
		//自动反击、
		if (!em.isLive())
		{
			//增加经验值
			expadd(em);
		}else {
			em.show();
			System.out.println("["+em.getType()+"]"+":我要反击了，接招：：：");
			em.kill(this);
		}
	}


	//躲避的方法
	public boolean hidden()
	{
		return gameUtil.isHidden( hideRate,  agile);
	}

	public int injured(enemy em)
	{
		back();
		if (hidden())
		{
			System.out.println(name+":  -=-=-=好尴尬啊，我躲避你的攻击了-=-=-=-=]]]]]]]]]]]]]]]]]]]]]");
			return 0;
		}
		//调用函数
		int lostlive = gameUtil.callostLife(em.getAttack(),defend);
		curLife -= lostlive;
		if (curLife <= 0)
		{
			death();
			//show();		//死亡之后的调用属性值
			return (lostlive - curLife);		//这个return，在IF条件成立的时候，会跳出方法，下面的语句不再执行。
		}
		System.out.println("TTTMMMMMDDDDD "+name+":  我挨打了!  "+em.getType()+" hit me...MMMMMMM");
		show();
		return lostlive;
	}
	//后退函数，在hunter碰到enemy时后退
	public void back() {
		if(dir==direction.UP) {
			this.y+=speed+5;
		}else if(dir==direction.DOWN) {
			this.y-=speed+5;
		}else if(dir==direction.LEFT) {
			this.x+=speed+5;
		}else if(dir==direction.RIGHT) {
			this.x-=speed+5;
		}
	}
	public void expadd(enemy em)
	{
		exp += em.getExplife();		//这里exp前面默认添加了this

		//升级
		int needExp = 0;
		for (int i=1; i<=level; i++ )
		{
			needExp += 40*i;
		}
		if (exp > needExp)
		{
			uplvl();
		}
	}

	//升级
	public void uplvl()
	{
		System.out.println("========I am lvl uper, goog !========");
		attack += 25;
		defend += 12;
		maxLife += 20;
		curLife = maxLife;
		level ++;
		show();
	}

	public void death()
	{

		System.out.println(name + "::  i am dead , please do not disturb me more .   ");
		isLive = false;
		show();
	}
	public void show()
	{
		System.out.println("<<<"+name+"  Level: "+level+"  EXP: "+exp+"  curlife:"+curLife+"  maxlife:"+maxLife+"   Alive:"+isLive+"  Attack:"+attack+"  Defend:"+defend+">>>");
	}
}