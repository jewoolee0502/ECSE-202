import acm.program.DialogProgram;

public class Adding2IntegersDIALOGUE extends DialogProgram {
	public void run()
	{
		println("This program adds two integers.");
		int n1 = readInt("Enter your first integer: ");
		int n2 = readInt("Enter your second integer: ");
		int n3 = n1 + n2;
		println("The sum of the two integers you inputed is "+n3+". ");
	}

}
