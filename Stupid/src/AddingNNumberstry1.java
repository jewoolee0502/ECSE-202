import acm.program.ConsoleProgram;

public class AddingNNumberstry1 extends ConsoleProgram {
	public void run()
	{
		println("This program adds " +N+ " numbers.");
		int total = 0; //Why do we set the int total to equal zero
		for (int i = 0; i < N; i++)
		{
			int value = readInt("Enter an integer: ");
			total = total + value; //Why is this total + value? How does this doesn't mess up with the name.
		}
		println("The total is " +total+ ".");
	}
	private static final int N = 100;

}