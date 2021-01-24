
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/** postFix class for Assignment #4
 * 
 * @author Jewoo Lee (260910789)
 * 
 */

public class postFix extends ConsoleProgram {

	public void shuntingYard(Queue inQueue, Queue outQueue, Stack opStack) 
	{
		while(inQueue.front != null) 
		{
			if(inQueue.front.data.equals("+")
					|| inQueue.front.data.equals("-")
					|| inQueue.front.data.equals("*")
					|| inQueue.front.data.equals("/")) 
			{
				if(opStack.top != null) 
				{
					while(!opStack.top.data.equals("(") 
							&& ((precedence(opStack.top.data) >= precedence(inQueue.front.data)))) 
					{
						if(opStack.top.data.equals("(")) 
							break;
						outQueue.enqueue(opStack.pop());

						if(opStack.top == null) 
						{
							break;
						}
					}
				}
				opStack.push(inQueue.dequeue());

			} 
			else if(inQueue.front.data.equals("(")) 
			{
				opStack.push(inQueue.dequeue());
			} 
			else if(inQueue.front.data.equals(")")) 
			{
				inQueue.dequeue();
				while(!opStack.top.data.equals("(")) 
				{
					outQueue.enqueue(opStack.pop());
					
					if(opStack.top == null) 
					{
						break;
					}
				}
				opStack.pop();
			} 
			else 
				outQueue.enqueue(inQueue.dequeue());

			if(inQueue.front == null) 
			{
				while (opStack.top != null) 
				{
					outQueue.enqueue(opStack.pop());
				}
			}
		}
	}

	private int precedence(String value) 
	{
		switch (value) 
		{
		case "+": return 2;
		case "-": return 2;
		case "*": return 3;
		case "/": return 3;
		
		default:
			throw new IllegalArgumentException("Invalid operator: " + value);
		}
	}


	public void parse(String arg, Queue Qin) 
	{
		StringTokenizer st = new StringTokenizer(arg, "+-*/()", true); 

		while(st.hasMoreTokens()) 
		{
			Qin.enqueue(st.nextToken()); 
		}
	}

	public double doExpression(Queue Qin) 
	{
		Queue outQueue = new Queue(); 
		Stack opStack = new Stack(); 

		shuntingYard(Qin, outQueue, opStack);

		return PostEval(outQueue);
	}

	public double PostEval(Queue PostFix) 
	{
		Stack stack = new Stack();

		while(PostFix.front != null) 
		{
			if (PostFix.front.data.equals("+")
					|| PostFix.front.data.equals("-")
					|| PostFix.front.data.equals("*")
					|| PostFix.front.data.equals("/")) 
			{
				Double result;
				String Token = PostFix.dequeue();
				String OP_A = stack.pop();
				String OP_B = stack.pop();
				Double A = Double.parseDouble(OP_A);  
				Double B = Double.parseDouble(OP_B); 

				switch (Token) 
				{  
				case "+":   
					result = B+A;   
					break;

				case "-":
					result = B-A;
					break;

				case "*":   
					result = B*A;   
					break;

				case "/":
					result = B/A;
					break;

				default :
					result = (double)0;
					break;
				} 
				stack.push(Double.toString(result)); 
			}
			else 
				stack.push(PostFix.dequeue());	
		}
		return Double.parseDouble(stack.pop());
	}
}
