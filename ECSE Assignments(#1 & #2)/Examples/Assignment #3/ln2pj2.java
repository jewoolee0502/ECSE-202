import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class ln2pj2 extends ConsoleProgram {

	public void run () 
	{
		println("Infix to Postfix converter");

		while(true) 
		{

			String inFix = readLine("Enter string (blank line to exit): ");  
			if (inFix.equals("")) System.exit(0);
			

			StringTokenizer st = new StringTokenizer(inFix,"+-*/()^",true); 

			Queue2 inQueue = new Queue2(); 
			Queue2 outQueue = new Queue2(); 
			Stack2 opStack = new Stack2(); 
			String Postfix = "";

			while(st.hasMoreTokens()) 
			{
				inQueue.enqueue(st.nextToken()); 
			}

			while(inQueue.front != null) 
			{
				if (inQueue.front.data.equals("*")
						|| inQueue.front.data.equals("/")
						|| inQueue.front.data.equals("+")
						|| inQueue.front.data.equals("-")) 
				{

					if (opStack.top != null) 
					{
						while (!opStack.top.data.equals("(") && 
								( 
										(  precedence(opStack.top.data) > precedence(inQueue.front.data)  )
										|| (
												precedence(opStack.top.data) == precedence(inQueue.front.data)
												)
										) ) 
						{

							if (opStack.top.data.equals("(")) 
								break;

							outQueue.enqueue(opStack.pop());

							if (opStack.top == null) 
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
					while (!opStack.top.data.equals("(")) 
					{
						outQueue.enqueue(opStack.pop());
						if (opStack.top == null) 
						{
							break;
						}
					}
					opStack.pop();
				} 
				
				
				else outQueue.enqueue(inQueue.dequeue());

				
				if (inQueue.front == null) 
				{
					while (opStack.top != null) 
					{
						outQueue.enqueue(opStack.pop());
					}
				}
			}


			while (outQueue.front != null) 
			{
				Postfix = Postfix + outQueue.dequeue()+" ";
			}
			println ("Postfix: "+Postfix);

		}
	}

	private int precedence(String value) 
	{
		switch (value) {
		case "+": return 2;
		case "-": return 2;
		case "*": return 3;
		case "/": return 3;
		default:
			throw new IllegalArgumentException("Invalid operator: " + value);
		}
	}

}
