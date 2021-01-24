import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class ln2pj2 extends ConsoleProgram {

	public void run () 
	{
		println("This program is an infix to postfix conerter. To exit the program, type exit.");

		while(true) 
		{

			String inFix = readLine("Enter string: ");
			if(inFix.equals(SENTINAL)) 
				break;

			StringTokenizer st = new StringTokenizer(inFix,"+-*/()^",true); 

			Queue inQueue = new Queue(); 
			Queue outQueue = new Queue(); 
			Stack opStack = new Stack(); 

			while(st.hasMoreTokens()) 
			{
				inQueue.enqueue(st.nextToken()); 
			}

			while(inQueue.front != null) 
			{
				if(!inQueue.front.data.equals("*") 
						&& !inQueue.front.data.equals("/") 
						&& !inQueue.front.data.equals("+") 
						&& !inQueue.front.data.equals("-")
						&& !inQueue.front.data.equals("(") 
						&& !inQueue.front.data.equals(")")) 
				{
					outQueue.enqueue(inQueue.dequeue());
				} 
				else if (inQueue.front.data.equals("*")
						|| inQueue.front.data.equals("/")
						|| inQueue.front.data.equals("+")
						|| inQueue.front.data.equals("-")) 
				{
					if (opStack.top != null) 
					{
						while (!opStack.top.data.equals("(") && 
								((precedence(opStack.top.data) > precedence(inQueue.front.data))
										|| (precedence(opStack.top.data) == precedence(inQueue.front.data)))) 
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
				if (inQueue.front == null) 
				{
					while (opStack.top != null) 
					{
						outQueue.enqueue(opStack.pop());
					}
				}
			}

			print("Postfix: ");

			while (outQueue.front != null) 
			{
				print(outQueue.dequeue() + " ");
			}
			print("\n");
		}
		System.exit(0);
	}

	private int precedence(String value) 
	{
		switch (value) 
		{
		case "+": return 0;
		case "-": return 0;
		case "*": return 1;
		case "/": return 1;
		
		default:
			throw new IllegalArgumentException("Invalid operator: " + value);
		}
	}

	public final String SENTINAL = "exit";
}
