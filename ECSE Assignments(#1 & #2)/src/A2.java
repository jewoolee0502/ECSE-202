// Jewoo Lee (260910789)
// I have used the code that Professor Ferrie has provided in the instructions for Assignment 2 as a listFile.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import acm.program.*;
/**
 * This program reads a specified text file and echos it to standard
 * display. You can use this as the basis of Assignment 2, adding the
 * necessary components to implement the program specifications.
 * @author ferrie
 *
 */
public class A2 extends ConsoleProgram {


	bTree myTree = new bTree();
	public static Stack lineStack;
	
	public void run() 
	{

		// Prompt user for a file name. If no name is entered, terminate
		// the program, otherwise attempt to open the file. If file open
		// is not successful, prompt again for a new name. Keep doing this
		// until successful open, or a blank line is entered.

		System.out.println("Simple File Listing Program");
		Scanner sc = new Scanner(System.in);
		BufferedReader rd = null;
		while(rd == null) 
		{
			System.out.print("Enter the name of file to list (with extension if needed): ");
			String filename = sc.nextLine();

			// String filename is "Names.txt" (need extension in this case) 
			// for testing

			if (filename.equals("")) 
			{
				System.out.println("Program terminated.");
				System.exit(0); // Exit
			}

			// Opening the specified file

			try 
			{
				rd = new BufferedReader(new FileReader(filename));
			}
			catch (IOException ex) 
			{
				System.out.println("Unable to open file, try again.");
			}
		}

		// Read the file a line per time as a string. 
		// Print as read to the output display. Modify the code below as necessary.

		System.out.println("");
		try 
		{
			while (true) 
			{
				String line = rd.readLine();   // Read a line of the text
				if (line == null) break;   // Exit if at end of file
				myTree.addNode(line);
			}   // to current line
		}
		catch (IOException ex) 
		{
			System.out.println("Input/Output Error - Program terminated");
			System.exit(-1);
		}
		System.out.println("\n"+"File in sort order: ");
		myTree.inorder();

		System.out.println("\n"+"File in reverse order: ");
		myTree.reverseorder();

	}
}
