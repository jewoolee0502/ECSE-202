import acm.program.ConsoleProgram;

public class SwitchStatement extends ConsoleProgram {
	public void run()
	{
		println("This program shows the number of days in a month.");
		int month = readInt("Enter numeric month (Jan=1): ");
		switch (month) 
		{
		case 2:
			println("28 days (29 days in a leap year). ");
			break;
		case 4: case 6: case 9: case 12:
			println("30 days");
			break;
		case 1: case 3: case 5: case 7: case 8: case 11:
			println("31 days");
			break;
		default:
			println("Illegal month number");
			break;
		}
	}

}
