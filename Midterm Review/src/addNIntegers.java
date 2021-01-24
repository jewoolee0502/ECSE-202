import acm.program.ConsoleProgram;

public class addNIntegers extends ConsoleProgram {
	public void run()
	{
		println("This program adds 100 integers.");
		
		int total = 0;
		
		for (int i = 0; i < 100; i++)
		{
			int value = readInt("Enter an integer: ");
			total = total + value;
		}
		println("The total is: " +total+ ". ");
	}

}
