
public class axe extends weapon {

	public axe(String name) {
		this.setName(name);
		this.setWeep("��ͷ��״��");
		//�����ֵ̬����ֱ�ӵ��á�
		this.setLength(hunter.HUNTER_WIDTH/2+20);
	}

	@Override
	public int damage(hunter hunter, enemy enemy) {
		int dd = enemy.injured(hunter);
		return dd;
	}

}
