public class Stack{
	listNode node;
	public void push(String data)
	{
		listNode node = new listNode();  // create new entry
		node.data = data;  // load data
		node.next = node.top;  // link to rest of stack
		node.top = node;  // this new entry
	}
	
	public String pop()
	{
		if (node.top == null) return null;  // check if stack is empty
		else
		{
			String data = node.top.data;  // otherwise get at top
			node.top = node.top.next;  // top to item below this
			return data;  // return data
		}	
	}
	

	
	
}
