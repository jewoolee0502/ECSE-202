import acm.program.ConsoleProgram;

public class AddNIntegersUntilSentinelIdiom extends ConsoleProgram {
	public void run()
	{
		println("This program adds integers. ");
		println("Use 0 to stop adding integers.");
		
		int total = 0;
		while(true)
		{
			int value = readInt("Enter an integer: ");
			if (value == 0) break;
			total = total + value;
		}
		println("The sum of the integers is "+total+". ");
	}

}
