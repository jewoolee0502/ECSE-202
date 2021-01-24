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

			Queue2 inQueue = new Queue2(); 
			Queue2 outQueue = new Queue2(); 
			Stack2 opStack = new Stack2(); 

			while(st.hasMoreTokens()) 
			{
				inQueue.enqueue(st.nextToken()); 
			}

			while(inQueue.getFront() != null) 
			{
				if(!inQueue.getFront().data.equals("*") 
						&& !inQueue.getFront().data.equals("/") 
						&& !inQueue.getFront().data.equals("+") 
						&& !inQueue.getFront().data.equals("-")
						&& !inQueue.getFront().data.equals("(") 
						&& !inQueue.getFront().data.equals(")")) 
				{
					outQueue.enqueue(inQueue.dequeue());
				} 
				else if (inQueue.getFront().data.equals("*")
						|| inQueue.getFront().data.equals("/")
						|| inQueue.getFront().data.equals("+")
						|| inQueue.getFront().data.equals("-")) 
				{
					if (opStack.getTop() != null) 
					{
						while (!opStack.getTop().data.equals("(") && 
								((precedence(opStack.getTop().data) > precedence(inQueue.getFront().data))
										|| (precedence(opStack.getTop().data) == precedence(inQueue.getFront().data)))) 
						{
							if (opStack.getTop().data.equals("(")) 
								break;

							outQueue.enqueue(opStack.pop());

							if (opStack.getTop() == null) 
							{
								break;
							}
						}
					}

					opStack.push(inQueue.dequeue());
				} 
				else if(inQueue.getFront().data.equals("(")) 
				{
					opStack.push(inQueue.dequeue());
				} 
				else if(inQueue.getFront().data.equals(")")) 
				{
					inQueue.dequeue();

					while (!opStack.getTop().data.equals("(")) 
					{
						outQueue.enqueue(opStack.pop());

						if (opStack.getTop() == null) 
						{
							break;
						}
					}

					opStack.pop();
				} 
				if (inQueue.getFront() == null) 
				{
					while (opStack.getTop() != null) 
					{
						outQueue.enqueue(opStack.pop());
					}
				}
			}

			print("Postfix: ");

			while (outQueue.getFront() != null) 
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
