import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import acm.program.ConsoleProgram;

public class A2 extends ConsoleProgram {

	bTree myTree = new bTree();
	public static String line;
	public static Stack lineStack;

	//public static void main(String args[]) {

	
	public void run() {
		// Prompt user for a file name.  If no name is entered, terminate
		// the program, otherwise attempt to open the file. If file open
		// is not successful, prompt again for a new name.  Keep doing this
		// until successful open, or a blank line is entered.
				
				System.out.println("Simple File Listing Program");
				Scanner sc = new Scanner(System.in);
				BufferedReader rd = null;
				
				while(rd == null) {
					System.out.print("Enter name of file to list: ");
					String filename = sc.nextLine();
					if (filename.equals("")) {
						System.out.println("Program terminated");
						System.exit(0);									// Exit
					}
		// Try to open the specified file
					try {
						rd = new BufferedReader(new FileReader(filename));
					}
					catch (IOException ex) {
						System.out.println("Unable to open file, try again.");
					}
				}

		// Read the file a line at a time into a string.  Print as read to the output display.
		// Modify the code below as necessary.
				
				System.out.println("");
				try {
					while (true) {
						String line = rd.readLine();							// Read a line of text
						lineStack.push(line);
						if (line == null) break;								// Exit if at end of file
						System.out.println(line);							// Print (or do whatever) to
						//lineStack.push(line);
					}														// current line
				}
				catch (IOException ex) {
					System.out.println("I/O Error - program terminated");
					System.exit(-1);
				}
							
				System.out.println("\n\nProgram terminated");

/*
		while(true)
		{
			if (lineStack.pop() == null) 
				break;
			else
			{
				myTree.addNode(lineStack.pop());
			}

		}

		print("Print in order:");
		myTree.inorder(); // print in order

		print("Print in reverse order:");

		while(true) 
		{
			if (bTree.bTreeStack.pop() == null) 
				break;
			else 
			{
				bTree.bTreeStack.pop();
			}

		}
	}*/

}
}