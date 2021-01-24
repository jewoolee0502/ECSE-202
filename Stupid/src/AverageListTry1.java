import acm.program.ConsoleProgram;

public class AverageListTry1 extends ConsoleProgram
{
	public void run()
	{
		println("This program averages a list of numbers.");
		println("Enter values, one per line, using " + SENTINEL +" to signal the end of the list.");
		
		int total = 0;
		int count = 0;
		while (true) 
		{
				int value = readInt("Enter an integer: ");
				if (value == SENTINEL) 
					break;
				total += value;
				count++;
		}
		double average = (double) total / count;
		println("The average is " + average + ".");
	}
	private static final int SENTINEL = -1;
}
