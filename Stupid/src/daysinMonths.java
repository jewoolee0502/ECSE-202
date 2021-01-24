import acm.program.ConsoleProgram;

public class daysinMonths extends ConsoleProgram{

	public void run()
	{
		println("This program shows the number of days in a month.");

		while(true)
		{
			int month = readInt("Enter the month in a numeric value (Jan = 1): ");
			switch(month)
			{
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				println("There are 31 days. ");
				break;

			case 2:
				println("There is 28 days. ");
				break;

			case 4: case 6: case 9: case 11:
				println("There are 30 days. ");
				break;

			default:
				println("Illegal month.");
				
				
			}
		}
	}
}
