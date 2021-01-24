//Jewoo Lee (260910789)
//I used the code provided in the lecture slide by Professor Ferrie

public class Stack {

	public Stack() 
	{
		top = null;
	}
	
	public void push(String arg)
	{
		listNode node = new listNode(arg);
		
		if(top != null)
		{
			top.next = node;
			node.prev = top;
		}				
		top = node;							
	}
	
	public String pop()
	{
		if(top == null) 					
			return null;					
		
		else
		{
			String arg = top.data; 
			this.top = this.top.prev;
			return arg;
		}						
	}
	
//	public String top()
//	{
//		if(top == null)
//			return null;
//		else
//			return top.data;
//	}
	
	public boolean Empty()
	{
		return top == null;
	}
	
	listNode top = null;		
	
}
