import acm.program.ConsoleProgram;

public class AverageList extends ConsoleProgram {
	public void run()
	{
		println("This program finds the average of a list of numbers. ");
		println("Use "+SENTINEL+" to end the program.");
		
		int total = 0;
		int count = 0;
		
		while(true)
		{
			int value = readInt("Enter a value: ");
			if(value == SENTINEL)
				break;
			total += value;
			count++;
		}
		double avg = (double) total/count;
		println("The average of the list of numbers is "+avg+". ");
	}
	
	private static final int SENTINEL = -1; 

}
