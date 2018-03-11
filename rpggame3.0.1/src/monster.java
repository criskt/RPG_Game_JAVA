class monster extends enemy
{
	//int person = 0;
	//定义构造函数
	public monster(int mt)
	{
		setLive(true);
		setHideRate(70);
		if (mt == 1)
		{
			setType("小怪兽");
			setLife(50);
			setAttack(10);
			setDefend(10);
			setAgile(20);
		}else if (mt == 2)
		{
			setType("中怪兽");
			setLife(75);
			setAttack(15);
			setDefend(8);
			setAgile(30);
		}else if (mt == 3)
		{
			setType("大怪兽");
			setLife(100);
			setAttack(20);
			setDefend(5);
			setAgile(40);
		}
		setExplife(getLife());
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
			hunter.injured(this);
		}else
		{
			System.out.println(getType() +"::  我已经死了，不能打了。。。");
		}
	}

}