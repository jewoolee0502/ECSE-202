//Jewoo Lee (260910789)

import acm.program.ConsoleProgram;

/**
* A Java program must consist of at least one class containing one method.
* In the examples done in the lectures, our main class was an extension of
* one of the acm classes (ConsoleProgram, DialogProgram, GraphicsProgram).
* For this assignment we will use ConsoleProgram.
*/

//I used the code provided in the Assignment Introduction sheet by the Professor Ferrie as a start point of this assignment

public class Assignment1try1 extends ConsoleProgram{
	
	/**
	 * 
	 * @param input: a string of numbers provided by the user
	 * @param inBase: an integer provided by the user that represents the base of the string
	 * @return: the initial string as an integer
	 */
	
	private int String2Int(String input, int inBase)
	{
		int power = 1;
		int sum = 0;
		int currentDigit;
		
		for( int i = input.length() - 1; i >= 0; i--)
		{
			currentDigit = Char2Int(input.charAt(i));
			sum = sum + currentDigit * power;
			power = power * inBase;
		}
		
		return sum;
	}
	
	/**
	 * 
	 * @param input: a character of the string provided by the user
	 * @return: the equivalent integer corresponding to the character or a random integer to show that it is an error
	 */
	
	private int Char2Int(char input)
	{
		if(input == '0') return 0;
		else if(input == '1') return 1;
		else if(input == '2') return 2;
		else if(input == '3') return 3;
		else if(input == '4') return 4;
		else if(input == '5') return 5;
		else if(input == '6') return 6;
		else if(input == '7') return 7;
		else if(input == '8') return 8;
		else if(input == '9') return 9;
		else if(input == 'a' || input == 'A') return 10;
		else if(input == 'b' || input == 'B') return 11;
		else if(input == 'c' || input == 'C') return 12;
		else if(input == 'd' || input == 'D') return 13;
		else if(input == 'e' || input == 'E') return 14;
		else if(input == 'f' || input == 'F') return 15;
		else return -1; // this is a random integer to show that it is an error of this function
	}
	
	/**
	 * 
	 * @param numBase10
	 * @param targetBase
	 * @return
	 */
	
	private String Dec2Base(int numBase10, int targetBase)
	{
		String string = "";
		
		while(numBase10 > 0)
		{
			int currentBit = numBase10 % targetBase;
			numBase10 = numBase10 / targetBase;
			char currentChar = Int2Char(currentBit);
			string = currentChar + string;
		}
		
		return string;
	}
	
	/**
	 * 
	 * @param digit: 
	 * @return: 
	 */
	
	private char Int2Char(int digit)
	{
		if(0 <= digit && digit <= 9) 
			return (char) ('0' + digit);
		if (10 <= digit && digit <= 15) 
			return (char) ('a' + digit - 10);
		else return 'm'; // A type of checking any errors made in the program
	}
	
	/**
	* The run method is called when the program is run; consequently it is
	* the starting point for our program. Our strategy will be to keep this
	* method simple – communicate with the user and call other methods to
	3/7
	* perform the requisite functions.
	*/ 
	
	public void run()
	{
		println("This program is a Base Conversion Program."); // I am identifying what this program is
		
		
		//This program runs in a loop until the user enters a blank line. It starts off
		//by prompting the user to enter a number to be converted which is read in as a
		//character string. The program then prompts for an integer corresponding to the
		//input base.
		
		
		while(true)
		{
			String input = readLine("Enter a number that has a Base from 2 ~ 16: "); //read the input that the reader has put in as a string
			if (input.contentEquals("")) 
				break; // this loop will break if the reader didn't write anything
			int inBase = readInt("Enter the corresponding base that is written above as an integer: "); //read the input base
			
		
			//Convert the input string to an integer using the String2Int method (which you will have to write). 
			//Echo the result back to the user.
			
			
			int numBase10 = String2Int(input,inBase); //I don't know how to convert string into an integer!
			println("The decimal equivalent of your input is "+numBase10+". "); // to what extent can we use the code given in the instruction sheet
			
			
			//Finally, prompt the user for the base in which to render the final result.
			//Call the Dec2Base method (again, which you need to write) to perform the conversion, and print the result.
			
			
			int targetBase = readInt("Enter the target base for conversion (2-16): "); // Read target base
			String output = Dec2Base(numBase10,targetBase); // Int Base10 to target
			println(input+" Base-"+inBase+" ---> "+output+" Base-"+targetBase); // Print result
			println();
			
		}
		println("Program Terminated.");
	}

}
