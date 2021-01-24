import acm.program.ConsoleProgram;

public class StringTutorial1 extends ConsoleProgram 
{
	public void outputString(String ourString) 
	{
		for(int i =0; i < ourString.length(); i++)   // I don't understand this part!
		{
			println(ourString.charAt(i));
		}
	}
	
	public void addString(String ourString)
	{
		int total =0;
		for(int i =0; i < ourString.length(); i++)
		{
			char current = ourString.charAt(i);
			
			if(current >= '0' && current <= '9')   // both of these statements must be passed to proceed this code, statement
			{
				total = total + (current-'0');
			}
			else
			{
				return;
			}
		}
		println(total);
	}
	
	public void run() 
	{
		for(int i =0; i < 3; i++)
		{
			String input = readLine("Enter an integer: ");
		
			addString(input);
		}
	}

}
