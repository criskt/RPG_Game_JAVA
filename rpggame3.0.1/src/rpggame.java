public class rpggame
{
	public static void main(String[] args) 
	{

		hunter h = new hunter("��ɵ",new getLifeSkill(new axe("�㳦"),25));
		new gamer(h).start();
	}
}
