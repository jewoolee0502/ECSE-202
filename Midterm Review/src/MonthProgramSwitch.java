import acm.program.ConsoleProgram;

public class MonthProgramSwitch extends ConsoleProgram {
	public void run()
	{
		println("This program tells you how many days are in a month. ");
		int month = readInt("Enter a month (Jan = 1): ");
		
		switch (month)
		{
		case 2:
			println("There are 28 days, 29 in a leap year.");
			break;
			
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			println("There are 31 days.");
			break;
			
		case 4: case 6: case 9: case 11:
			println("There are 30 days.");
			break;
			
		default:
			println("Illegal month.");
			break;
		}
	}

}
