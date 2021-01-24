
import acm.program.ConsoleProgram;

/** JCalc class for Assignment #4
 * 
 * @author Jewoo Lee (260910789)
 * I used the code provided by Professor Ferrie in Assignment #4 instruction sheet
 */

public class JCalc extends ConsoleProgram {

	Queue Qin = new Queue();  									// Queue for input expressions  
	postFix pf = new postFix();  								// Postfix converter and interpreter   
	
	public void run() 											// Entry point
	{  
		this.resize(500, 400); 									//set the console to a specific size
		println("This porgram is an Infix expression evaluator. Enter expression of blank line to exit.");      

		while (true) 
		{   
			String input = readLine("expr: ");  				// Get expression    
			
			if (input.equals("")) 
				break;   										// Terminate on blank line    
			
			pf.parse(input, Qin);    							// Parse    
			double result = pf.doExpression(Qin); 				// Evaluate   

			println(input + " = " + result);   					// Display result      	
		}  
		println("Program terminated.");  
	}
}

