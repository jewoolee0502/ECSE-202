//Jewoo Lee (260910789)
//I used the code provided in the lecture slide by Professor Ferrie

public class Stack {

	public void push(String arg)
	{
		listNode node = new listNode();		//it creates a new node
		node.data = arg;					//keeps all the data
		node.next = top;					//next node becomes the top of the stack
		top = node;							//top now becomes the new node
	}
	
	public String pop()
	{
		if (top == null) 					//checking if the stack is empty
			return null;					//return null if it is
		
		String data = top.data; 			//if not, pop data at top
		top = top.next;						//top to item below this, next
		
		return data;						//return data
	}
	
	listNode top = null;					//instance variable
	
}
