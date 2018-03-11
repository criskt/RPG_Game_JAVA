
public class getLifeSkill extends skillDecorate {
	private weapon weapon;
	private int getLifeRate;
	
	public getLifeSkill(weapon weapon, int getLifeRate) {
		this.setName(weapon.getName());
		this.weapon = weapon;
		this.getLifeRate = getLifeRate;
		//System.out.println(weapon.getLength());
	}

	@Override
	public String getWeep() {
		return "����Ѫ��"+weapon.getWeep();
	}

	@Override
	public int damage(hunter hunter, enemy enemy) {
		int dd = weapon.damage(hunter, enemy);
		if(dd > 0) {
			
			//�˴���һ���ܴ�����⣬���ǣ�hunter����������֮��û��������Ѫ��������ִ������޵ķ���֮�����Ѫ��
			//��Ҫ���������⡣��
			//��hunter����Ӳ�����ɴ˹���
			
			getLife(hunter,dd);
		}
		return dd;
	}
	public void getLife(hunter hunter,int damage) {
		int getlive = damage * getLifeRate / 100;
		System.out.println(hunter.getName()+"��ȡ�� "+getlive+" ��Ѫ��");
		if (getlive + hunter.getCurLife() >= hunter.getMaxLife())
		{
			hunter.setCurLife(hunter.getMaxLife());
		}else
		{
			hunter.setCurLife(hunter.getCurLife()+getlive);
		}
	}

}
