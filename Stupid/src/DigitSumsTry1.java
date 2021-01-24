import acm.program.ConsoleProgram;

public class DigitSumsTry1 extends ConsoleProgram // I don't understnad this at all
{
	public void run()
	{
		println("This program sums the digits in an integer.");
		int n = readInt("Enter a positive integer: ");
		int dsum = 0;
		while ( n > 0 ) 
		{
			dsum += n % 10;
			n /= 10;	
		}
		println("The sum of the digits is " + dsum);
	}

}
