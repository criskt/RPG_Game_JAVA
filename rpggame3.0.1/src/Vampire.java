class Vampire extends enemy
{

	private int getLifeRate;
	//int person = 1;

	//定义构造函数
	public Vampire(int mt)
	{
		this.setLive(true);
		this.setHideRate(70);
		if (mt == 1)
		{
			this.setType("小号吸血鬼");
			this.setLife(50);
			this.setAttack(10);
			this.setDefend(10);
			this.setAgile(20);
			this.setGetLifeRate(20);
		}else if (mt == 2)
		{
			this.setType("中号吸血鬼");
			this.setLife(75);
			this.setAttack(15);
			this.setDefend(8);
			this.setAgile(30);
			this.setGetLifeRate(40);
		}else if (mt == 3)
		{
			this.setType("大号吸血鬼");
			this.setLife(100);
			this.setAttack(20);
			this.setDefend(5);
			this.setAgile(40);
			this.setGetLifeRate(50);
		}
		this.setExplife(getLife());
	}

/*	public int getGetLifeRate() {
		return getLifeRate;
	}*/

	public void setGetLifeRate(int getLifeRate) {
		this.getLifeRate = getLifeRate;
	}

	//吸血
	public void getLife(int damage)
	{
		int getlive = damage * getLifeRate / 100;

		if (getlive + getLife() >= getExplife())
		{
			setLife(getExplife()); 
		}else
		{
			//life += getlive;
			this.setLife(getLife()+getlive);
		}
		System.out.println("《《《《《  吸血成功， 吸取了 ："+getlive+" 滴血！！》》》》》==================================================");
	}


	public void kill(hunter hunter)
	{
		if (!hunter.isLive())
		{
			System.out.println("你要打的对象： "+hunter.getName()+"  已经死亡，不要暴尸啊！！");
			return;
		}
		if (isLive())
		{
			System.out.println("[[["+getType()+": 反向出击，打击 "+hunter.getName()+" !!!]]]");
			int lostlive = hunter.injured(this);
			this.getLife(lostlive);
		}else
		{
			System.out.println(getType() +"::  我已经死了，不能打了。。。");
		}
/*		int lostlive = hunter.injured(this);
		this.getLife(lostlive);*/
	}

}