import acm.program.ConsoleProgram;

public class fridayTutorialExample extends ConsoleProgram {
	
	public int printString(String str)  // This will intake String
	{
		for(int i = 0; i < str.length(); i ++)
		{
			println(str.charAt(i));
		}
		return str.length();
	}
	
	public int addString(String str)
	{
		int total = 0;
		for(int i = 0; i < str.length(); i++)
		{
			char current = str.charAt(i);
			if(current >= '0' && current <= '9')
			{
				int value = current - '0';
				total = total + value;
			}
		}
		return total;
	}
	
	public void run() 
	{
		for(int i = 0; i < 3; i++)
		{
			String input = readLine("Enter a string: ");
			
			int total = addString(input);
			printString(input);
			println(total + " ");
		}
		
	}
	

}
