class monster extends enemy
{
	//int person = 0;
	//���幹�캯��
	public monster(int mt)
	{
		setLive(true);
		setHideRate(70);
		if (mt == 1)
		{
			setType("С����");
			setLife(50);
			setAttack(10);
			setDefend(10);
			setAgile(20);
		}else if (mt == 2)
		{
			setType("�й���");
			setLife(75);
			setAttack(15);
			setDefend(8);
			setAgile(30);
		}else if (mt == 3)
		{
			setType("�����");
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