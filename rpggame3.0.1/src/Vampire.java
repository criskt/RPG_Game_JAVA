class Vampire extends enemy
{

	private int getLifeRate;
	//int person = 1;

	//���幹�캯��
	public Vampire(int mt)
	{
		this.setLive(true);
		this.setHideRate(70);
		if (mt == 1)
		{
			this.setType("С����Ѫ��");
			this.setLife(50);
			this.setAttack(10);
			this.setDefend(10);
			this.setAgile(20);
			this.setGetLifeRate(20);
		}else if (mt == 2)
		{
			this.setType("�к���Ѫ��");
			this.setLife(75);
			this.setAttack(15);
			this.setDefend(8);
			this.setAgile(30);
			this.setGetLifeRate(40);
		}else if (mt == 3)
		{
			this.setType("�����Ѫ��");
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

	//��Ѫ
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
		System.out.println("����������  ��Ѫ�ɹ��� ��ȡ�� ��"+getlive+" ��Ѫ��������������==================================================");
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
			int lostlive = hunter.injured(this);
			this.getLife(lostlive);
		}else
		{
			System.out.println(getType() +"::  ���Ѿ����ˣ����ܴ��ˡ�����");
		}
/*		int lostlive = hunter.injured(this);
		this.getLife(lostlive);*/
	}

}