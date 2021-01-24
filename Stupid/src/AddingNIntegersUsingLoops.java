import acm.program.ConsoleProgram;

public class AddingNIntegersUsingLoops extends ConsoleProgram
{
	public void run()
	{
		println("This program adds a list of integers.");
		println("Enter values, one per line, using " + SENTINEL +" to signal the end of the list.");
		//println("To signal the end of the list.");
		int total = 0;
		while (true)
		{
			int value = readInt("Enter an integer: ");
			if (value == SENTINEL)
				break;
			total += value;
		}
		println("The total is " +total+ ". ");
	}
	private static final int SENTINEL = 0;
}
