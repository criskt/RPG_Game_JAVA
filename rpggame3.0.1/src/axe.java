
public class axe extends weapon {

	public axe(String name) {
		this.setName(name);
		this.setWeep("斧头形状的");
		//这个静态值可以直接调用。
		this.setLength(hunter.HUNTER_WIDTH/2+20);
	}

	@Override
	public int damage(hunter hunter, enemy enemy) {
		int dd = enemy.injured(hunter);
		return dd;
	}

}
