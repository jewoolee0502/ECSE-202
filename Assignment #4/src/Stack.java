
/** Stack class for Assignment #4
 * 
 * @author Jewoo Lee (260910789)
 * I used the code provided in the lecture slide by Professor Ferrie
 */

public class Stack {

	/** push method
	 * creates new nodes and adds it to the top of the stack
	 * 
	 * @param arg A string that is in the listNode and it is being added to the top
	 */
	
	public void push(String arg)
	{
		listNode node = new listNode();		//it creates a new node
		node.data = arg;					//keeps all the data
		node.next = top;					//next node becomes the top of the stack
		top = node;							//top now becomes the new node
	}
	
	/** pop method
	 * returns the string held in the top of the node
	 * and sets the next node to be at the top
	 * also checks if the top of the node is empty
	 *
	 * @return returns the data that was held at the top of the node, if empty, return null
	 */
	
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
