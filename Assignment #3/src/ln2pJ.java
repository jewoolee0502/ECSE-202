//Jewoo Lee (260910789)
//I used the code provided in the Assignment #3 Introduction sheet 
//by the Professor Ferrie as a start point for this assignment

import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class ln2pJ extends ConsoleProgram {

	private int precedence(String value)
	{
		switch(value)
		{
		case "+": return 2;
		case "-": return 2;
		case "*": return 3;
		case "/": return 3;

		default:
			throw new IllegalArgumentException("Invalid precedence value: " + value);
		}
	}
	
	public void run() 
	{
		println("This program is an Infix to Postfix Converter.");

		while(true)
		{
			String inFix = readLine("Enter string (blank line to exit): ");
			StringTokenizer st = new StringTokenizer(inFix, "+-*/()", true); 			//new string tokenizer
																						//separate input string by tokens (+,-,/,*,(,and ))
			if(inFix.equals(""))														//if input is empty
				System.exit(0);															//exit the program

			Stack opStack = new Stack();												//set a Stack to hold the operator
			String postFix = "";														//set a postFix to be an empty string, which is defined later
			Queue inQueue = new Queue();												//set a Queue to hold the input
			Queue outQueue = new Queue();												//set a Queue to hold the output

			while (st.hasMoreTokens()) 
			{				
				inQueue.enqueue(st.nextToken());										//enqueue next token to the input Queue
			}

			while(inQueue.front != null)
			{
				if(inQueue.front.data.equals("+") 										//if the next element is an operator/symbol
						|| inQueue.front.data.equals("-")
						|| inQueue.front.data.equals("*")
						|| inQueue.front.data.equals("/"))
				{
					if(opStack.top != null)
					{
						while(!opStack.top.data.equals("(") 							//while the operator at the top is not a left bracket
								&& ((precedence(opStack.top.data) >= precedence(inQueue.front.data))))
							//and if the precedence at operator is greater than or equal to inQueue
						{	
							if(opStack.top.data.equals("("))							//break if its a left bracket
								break;

							outQueue.enqueue(opStack.pop());							//pop operator from the stack using outQueue
							
							if(opStack.top == null)										//if operator at the top is null, break
								break;
						}
					}
					opStack.push(inQueue.dequeue()); 									//push to the operator stack
				}
				else if(inQueue.front.data.equals(")"))									//if right bracket
				{
					inQueue.dequeue();

					while(!opStack.top.data.equals("("))								//while operator at the top is not a left bracket
					{
						outQueue.enqueue(opStack.pop());								//pop operators to output Queue
								
						if(opStack.top == null)											//while popping out operators, and right bracket not found, give error and break
						{
							break;
						}
					}

					opStack.pop();
				}
				else if(inQueue.front.data.equals("("))									//if left bracket
				{
					opStack.push(inQueue.dequeue());									//push until right bracket is found
				}
				else 
					outQueue.enqueue(inQueue.dequeue());

				if(inQueue.front == null)												//if input Queue is empty
				{
					while(opStack.top != null)											//while operator at the top is not empty
					{
						outQueue.enqueue(opStack.pop());								//pop operator until it is empty
					}
				}
			}

			while(outQueue.front != null)
			{
				postFix = postFix + outQueue.dequeue()+ " ";							//define what postFix is
			}

			println("Postfix: " + postFix);												//print postFix
		}
	}
}