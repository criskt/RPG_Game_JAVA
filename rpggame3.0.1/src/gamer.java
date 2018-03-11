import java.util.ArrayList;
import java.util.List;

public class gamer
{
	hunter hunter;


	List<enemy> ene;
	
	public gamer(hunter hunter)
	{
		this.hunter = hunter;
		ene = new ArrayList<enemy>();
		ene.add(new monster(1));
		ene.add(new monster(2));
		ene.add(new monster(3));
		ene.add(new monster(2));
		ene.add(new monster(1));
		ene.add(new Vampire(1));
		ene.add(new Vampire(2));
		ene.add(new Vampire(3));
		ene.add(new Vampire(2));
		ene.add(new Vampire(1));
		ene.add(new Vampire(3));
		ene.add(new caw());
		ene.add(new snake());
		ene.add(new snake());
		
	}
	public void start()
	{


		while (true)
		{
			int ran = gameUtil.randomRange(0,ene.size());
			if (!hunter.isLive())
			{
				break;
			}
			if (ene.size()<=0)
			{
				break;
			}

			enemy ee = ene.get(ran);
			hunter.fight(ee);
			if(!ee.isLive()) {
				ene.remove(ee);
			}
			
			//使程序休息2秒
			try
			{
				System.out.println("============ 请等待  对手寻找中 =============");
				Thread.sleep(2000);
			}
			catch (Exception e)
			{
			}
		}
		end();
	}
	public void end()
	{
		if (hunter.isLive())
		{
			System.out.println("【【【   你很强！！！   】】】");
		}else
		{
			System.out.println("】】】   你被怪兽杀死了   【【【");
		}
	}

}