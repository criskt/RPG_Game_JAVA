
public class caw extends enemy {

	public caw()
	{
		this.setType("牛头大怪");
		this.setAgile(56);
		this.setAttack(75);
		this.setDefend(76);
		this.setHideRate(85);
		this.setLife(46);
		this.setLive(true);
		this.setExplife(getLife());
	}
	@Override
	public void kill(hunter hunter) {
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
