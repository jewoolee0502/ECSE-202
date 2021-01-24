
/** Queue class for Assignment #4
 * 
 * @author Jewoo Lee (260910789)
 * I used the code provided in the lecture slide by Professor Ferrie
 */

public class Queue {
	
	/** enqueue new node to the rear of the queue
	 * 
	 * @param arg the string being carried by the listNode is now added to the queue
	 */
	
	public void enqueue(String arg)
	{
		listNode node = new listNode();  	//Creates a new node at rear
		node.data = arg;  					//Save data 
		node.next = null;  					//Node now becomes the next empty node
		
		if (rear != null)  					//If queue is not empty
		{
			rear.next = node;  				//attach it to the new node at rear
		}		
		else  								
		{
			front = node; 					//otherwise, make front point to new node.					
		}									
		
		rear = node;						//rear points to new node
	}										
	
	/** dequeues the front data of the queue
	 * 
	 * @return returns the front data of the queue
	 */
	
	public String dequeue()
	{
		
		if (front != null)					//If queue is not empty,
		{
			if (front != rear) 				//if front is not equal to the rear
				rear = null;				//set rear to null
			
			String reData = front.data;		//For all empty cases, 
			front = front.next;				//unload data from front
			return reData;					//and move to the next node
		}
		else								//If queue is empty
			return null;
	}
	
	listNode front = null;					//instance variables
	listNode rear = null;
}
