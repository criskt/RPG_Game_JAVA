
public class sword extends weapon {

	public sword(String name) {
		this.setName(name);
		this.setWeep("������״��");
		this.setLength(hunter.HUNTER_WIDTH/2+20);
	}

	@Override
	public int damage(hunter hunter, enemy enemy) {
		int dd = enemy.injured(hunter);
		return dd;
	}

}
