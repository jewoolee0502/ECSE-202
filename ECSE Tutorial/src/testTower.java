import acm.program.ConsoleProgram;

public class testTower extends ConsoleProgram {
	public static final int NUMTOWERS = 100;
	
	public void run()
	{
		SignalTower start = null;
		SignalTower end = null;
		
		for(Integer i = 0; i < NUMTOWERS; i++)
		{
			SignalTower myTower = new SignalTower("Tower" + i.toString(), null, this);
			
			if(start == null)
			{
				start = myTower;
				end = start;
			}
			else
			{
				end.nextTower = myTower;
				end = myTower;			}
		}
		start.signal();
	}
	
}
