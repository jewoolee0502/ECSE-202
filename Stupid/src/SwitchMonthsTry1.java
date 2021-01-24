import acm.program.ConsoleProgram;

public class SwitchMonthsTry1 extends ConsoleProgram
{
	public void run()
	{
		println("This program shows the number of days in a month.");
		int month = readInt("Enter a numeric month (Jan=1): ");
		switch (month)
		{
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			println("There are 31 days.");
			break;
		case 2:
			println("there are 28 days, except when it is a leap year. Then there are 29 days.");
			break;
		case 4: case 6: case 9: case 11:
			println("Thre are 30 days.");
			break;
		default:
			println("illegal month number.");
			break;
		}
	}

}
