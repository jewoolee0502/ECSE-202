import acm.program.ConsoleProgram;

public class DigitSum extends ConsoleProgram {
	public void run()
	{
		println("This program adds up the digits of the integer. ");
		int dsum = 0;
		int n = readInt("Enter an integer: ");
		
		while (n>0)
		{
			dsum = dsum + n % 10; //% this sign only outputs the remainder of the two integers being divided
			n = n/10;  // as both are indicated as integers, no decimals showing
		}
		println("The sum of the digit is "+dsum+". ");
	}

}
