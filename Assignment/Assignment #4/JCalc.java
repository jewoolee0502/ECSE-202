import acm.program.ConsoleProgram;

public class JCalc extends ConsoleProgram {
	
	Queue Qin = new Queue();  // Queue for input expressions  
	postFix pf = new postFix();  // Postfix converter and interpreter   
	
	// Entry point   
	
	public void run() {  
		
		println("Infix expression evaluator, enter expression of blank line to exit.");      
		
		while (true) {   
			String input = readLine("expr: ");  	// Get expression    
			if (input.equals("")) break;   	// Terminate on blank line    
			pf.parse(input, Qin);    	// Parse    
			double result = pf.doExpression(Qin); 	// Evaluate   
			println(input+" = "+result);   // Display result      
			
		}  
		
		println("Program terminated.");  
	
		}
	}

