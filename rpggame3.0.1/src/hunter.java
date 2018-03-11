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

	//���ӹ������ͷ�����
	private int attack;
	private int defend;

	//����ֵ�͵Ǽ�
	private int level;
	private int exp;

	//��ܵ�����
	private int agile;		//����
	private int hideRate;	//��������
	
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
	//Ĭ�Ϲ�����
	public hunter()
	{
		this.name = "ɵ��";
		//this.weapon = new axe("��");
		this.weapon = new getLifeSkill(new axe("�㳦"), 34) ;
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
		//Ĭ�Ϸ���Ϊ��
		dir = direction.RIGHT;
	}
	//���幹�캯��
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
	//��hunter������Ҫ����һ��Graphics��g����
	public void drew(Graphics g) {
		//���hunter dead��hunter����ʧ
		if(!isLive()) return;
		//����ɫ
		g.setColor(Color.RED);
		//��һ����������
		g.fillRect(x, y, HUNTER_WIDTH, HUNTER_HEIGHT);
		//����hunter���۾�
		int eyeR = 5;	//�۾�Ϊ԰�ͣ��뾶
		int eyeX = 0;	//Բ�ĵ�����
		int eyeY = 0;	//Բ�ĵ�����
		//�ƶ���ʱ������С���λ�ã��γɶ�̬�ı仯
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
		//��һ��԰�������䵱�۾�
		g.fillOval(eyeX, eyeY, 2*eyeR, 2*eyeR);
		//ͨ�����String��������
		g.setColor(Color.YELLOW);
		g.drawString(this.name, x-2, y-4);
		//����������
		//�Ȼ�һ�����
		g.drawRect(x, y+HUNTER_HEIGHT+2, HUNTER_WIDTH+1, 10);
		//����ڿ�,ͬʱ������Ӧ�ı���
		g.setColor(Color.green);	//��ɫ
		g.fillRect(x, y+HUNTER_HEIGHT+3, HUNTER_WIDTH*curLife/maxLife, 9);
		
	}
	public Rectangle getArea() {
		//����������������ʶ��������ṩ����λ����Ϣ
		//ͬ����Ҫ����һ���յ�λ����Ϣ
		if(!isLive) {
			return new Rectangle();
		}
		return new Rectangle(x,y,HUNTER_WIDTH,HUNTER_HEIGHT);
	}
	//�����ƶ��ķ���
 	public void move() {
		//���ݷ�����ƶ������ƶ�
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
 	//��������ĸ߳����ƶ��ٶ�
	public void setLocation(int x,int y,int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public void fight(enemy em)
	{
		if (!isLive)
		{
			System.out.println(name +"::  ���Ѿ����ˣ����ܴ��ˡ�����");
			return;
		}
		if (!em.isLive())
		{
			System.out.println("��Ҫ��Ķ��� "+em.getType()+"  �Ѿ���������Ҫ��ʬ������");
			return;
		}
		System.out.println("<<<"+name+":������\""+weapon.getWeep()+"\"\""+weapon.getName()+"\" ���� "+ em.getType()+">>>");

		weapon.damage(this, em);	
		
		//�Զ�������
		if (!em.isLive())
		{
			//���Ӿ���ֵ
			expadd(em);
		}else {
			em.show();
			System.out.println("["+em.getType()+"]"+":��Ҫ�����ˣ����У�����");
			em.kill(this);
		}
	}


	//��ܵķ���
	public boolean hidden()
	{
		return gameUtil.isHidden( hideRate,  agile);
	}

	public int injured(enemy em)
	{
		back();
		if (hidden())
		{
			System.out.println(name+":  -=-=-=�����ΰ����Ҷ����Ĺ�����-=-=-=-=]]]]]]]]]]]]]]]]]]]]]");
			return 0;
		}
		//���ú���
		int lostlive = gameUtil.callostLife(em.getAttack(),defend);
		curLife -= lostlive;
		if (curLife <= 0)
		{
			death();
			//show();		//����֮��ĵ�������ֵ
			return (lostlive - curLife);		//���return����IF����������ʱ�򣬻������������������䲻��ִ�С�
		}
		System.out.println("TTTMMMMMDDDDD "+name+":  �Ұ�����!  "+em.getType()+" hit me...MMMMMMM");
		show();
		return lostlive;
	}
	//���˺�������hunter����enemyʱ����
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
		exp += em.getExplife();		//����expǰ��Ĭ�������this

		//����
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

	//����
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