
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
		return "会吸血的"+weapon.getWeep();
	}

	@Override
	public int damage(hunter hunter, enemy enemy) {
		int dd = weapon.damage(hunter, enemy);
		if(dd > 0) {
			
			//此处有一个很大的问题，就是：hunter用武器攻击之后没有立即吸血，而是在执行完怪兽的反击之后才吸血。
			//需要解决这个问题。。
			//在hunter中添加操作完成此功能
			
			getLife(hunter,dd);
		}
		return dd;
	}
	public void getLife(hunter hunter,int damage) {
		int getlive = damage * getLifeRate / 100;
		System.out.println(hunter.getName()+"吸取了 "+getlive+" 滴血。");
		if (getlive + hunter.getCurLife() >= hunter.getMaxLife())
		{
			hunter.setCurLife(hunter.getMaxLife());
		}else
		{
			hunter.setCurLife(hunter.getCurLife()+getlive);
		}
	}

}
