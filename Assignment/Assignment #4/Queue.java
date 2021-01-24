//Jewoo Lee (260910789)
//I used the code provided in the lecture slide by Professor Ferrie

public class Queue {
	
	public void enqueue(String arg)
	{
		listNode node = new listNode(arg); 
		
		if(rear == null)
		{
			rear = node;
			front = node;
		}
		else
		{
			node.next = rear;
			rear.prev = node;
			rear = node;
		}
	}
		
	public String dequeue()
	{
		if (front == null)					
			return null;
		
		String str = front.data;
		
		if(front.prev == null)
		{
			front = null;
			rear = null;
		}
		else
		{
			listNode pfront = front.prev;
			pfront.next = null;
			front = pfront;
		}
		return str;
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	listNode front = null;					
	listNode rear = null;
}