import acm.program.ConsoleProgram;

public class LiftOffTry1 extends ConsoleProgram
{
	public void run()
	{
		println("This program counts down from 20. ");
		pause(1000);
		for (int i = 20; i >= 0; i--)
		{
			println(i);
			pause(500);
		}
	println("Lift Off!");
	}

}
