
public class snake extends enemy {
	public snake()
	{
		this.setType("�۾�����");
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
			System.out.println("��Ҫ��Ķ��� "+hunter.getName()+"  �Ѿ���������Ҫ��ʬ������");
			return;
		}
		if (isLive())
		{
			System.out.println("[[["+getType()+": ������������ "+hunter.getName()+" !!!]]]");
			hunter.injured(this);
		}else
		{
			System.out.println(getType() +"::  ���Ѿ����ˣ����ܴ��ˡ�����");
		}
	}
	
}
