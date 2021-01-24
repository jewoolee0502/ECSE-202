//Jewoo Lee (260910789)

class listNode {  
	
	String data;  
	listNode next;	
	listNode top = null;  
}

public class Stack {

	listNode top = null;

	void push (String input)
	{
		listNode node = new listNode();  // create a new entry
		node.data = input;  // load data
		node.next = top;  // link to the rest of the stack
		top = node;   // top now points to this new entry
	}

	public String pop()
	{
		if (top == null) return null; // pops each line of strings in reverse order
		String output = top.data;
		top = top.next;
		return output;
	}

	public boolean isEmpty()
	{
		if (top == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}