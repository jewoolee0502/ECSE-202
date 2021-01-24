import acm.program.ConsoleProgram;
import acm.program.DialogProgram;

/*public class add2Integers extends ConsoleProgram {
	public void run()
	{
		println("This program adds two integers. ");
		
		int n1 = readInt("Enter a first integer: ");
		int n2 = readInt("Enter a second integer: ");
		int n3 = n1 + n2;
		
		println("The sum of "+n1+" and "+n2+" is "+n3+". ");
	}

}
**/
public class add2Integers extends DialogProgram {
	public void run()
	{
		println("This program adds two integers. ");
		
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int n3 = n1 + n2;
		
		println("The sum of the two integer is "+n3+". ");
	}
}

