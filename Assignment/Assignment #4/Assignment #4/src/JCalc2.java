import java.util.Objects;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class JCalc2 extends ConsoleProgram {
	public void run()
	{
		println("This program is a Postfix Interpreter. Enter blank line to exit.");

		while(true)
		{
			String str = readLine("expr: ");
			StringTokenizer st = new StringTokenizer(str, "+-*/()", true);

			if(str.contentEquals(""))
				System.exit(0);

			Queue Qin = new Queue();
			Queue pfQ = new Queue();
			Stack opStack = new Stack();
			Stack evStack = new Stack();

			while(st.hasMoreTokens())
			{
				Qin.enqueue(st.nextToken());
			}

			while(!Qin.isEmpty())
			{
				String next = Qin.dequeue();

				if(next.equals("+")||next.equals("-"))
				{
					if (opStack.Empty())
					{
						opStack.push(next);
					}
					else if (opStack.top.equals("+")||opStack.top.equals("-"))
					{
						pfQ.enqueue(opStack.pop());
						opStack.push(next);
					}
					else 
					{
						while (!opStack.Empty()
								&& !Objects.equals(opStack.top.data,"("))
						{
							pfQ.enqueue(opStack.pop());
						}
						opStack.push(next);
					}
				}
				else if(next.equals("*")||next.equals("/"))
				{
					if (opStack.Empty())
					{
						opStack.push(next);
					}
					else if(opStack.top.equals("*")||opStack.top.equals("/"))
					{
						pfQ.enqueue(opStack.pop());
						opStack.push(next);
					}
					else if(Objects.equals(opStack.top.data, "("))
					{
						opStack.push(next);
					}
					else 
					{
						while (!opStack.Empty() 
								&& (Objects.equals(opStack.top.data,"*") || 
										Objects.equals(opStack.top.data,"/")) )
						{
							pfQ.enqueue(opStack.pop());
						}
					}
					opStack.push(next);
				}
			else if ( Objects.equals(next,"("))
			{
				opStack.push(next);

				// if string value matches right parenthesis
			}
			else if (Objects.equals(next,")"))
			{

				// while top operator on operator stack is not left parenthesis
				while ( !Objects.equals(opStack.top.data,"(") )
				{
					pfQ.enqueue(opStack.pop());	
				}

				// getting rid of left parenthesis
				if(opStack.top.prev == null) 
				{
					opStack.top = null;

				}
				else 
				{
					listNode newtop2 = opStack.top.prev;
					newtop2.next = null;
					opStack.top = newtop2;		
				}
			}

				else
				{
					pfQ.enqueue(next);
				}
			}

			while(!opStack.Empty())
			{
				pfQ.enqueue(opStack.pop());
			}

			while (!pfQ.isEmpty())
			{
				String elem = pfQ.dequeue();
				if (elem.equals("+"))
				{
					String elem1 = evStack.pop();
					String elem2 = evStack.pop();

					double num1 = Double.parseDouble(elem1);
					double num2 = Double.parseDouble(elem2);
					double rslt = num2 + num1;

					String sum = Double.toString(rslt);
					evStack.push(sum);
				}
				else if (elem.equals("-"))
				{
					String elem1 = evStack.pop();
					String elem2 = evStack.pop();

					double num1 = Double.parseDouble(elem1);
					double num2 = Double.parseDouble(elem2);
					double rslt = num2 - num1;

					String diff = Double.toString(rslt);
					evStack.push(diff);
				}
				else if (elem.equals("*"))
				{
					String elem1 = evStack.pop();
					String elem2 = evStack.pop();

					double num1 = Double.parseDouble(elem1);	
					double num2 = Double.parseDouble(elem2);	
					double rslt = num2 * num1;

					String prod = Double.toString(rslt);
					evStack.push(prod);
				}
				else if (elem.equals("/"))
				{
					String elem1 = evStack.pop();
					String elem2 = evStack.pop();

					double num1 = Double.parseDouble(elem1);
					double num2 = Double.parseDouble(elem2);
					double rslt = num2 / num1;

					String quot = Double.toString(rslt);
					evStack.push(quot);
				}
				else 
				{
					evStack.push(elem);
				}
			}

			String value = evStack.pop();
			println(str + " = " + value);
		}
	}
}