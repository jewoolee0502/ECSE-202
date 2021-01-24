
public class Stack2 {

	private listNode top;

	/** Push method for stack class 
	 * Adds a listNode containing the data specified to the top of the stack.
	 * 
	 * @param data The data (in this case a string), that is to be stored by the listNode that is being added to the top of the stack.
	 */
	public void push(String data) {
		listNode node = new listNode();
		node.data = data;
		node.next = top;
		top = node;
	}

	/** Pop method for the stack class
	 *  returns the data held by the top node of the stack as a string
	 *  then sets the top of the stack to be the next Node in the stack.
	 *  
	 *  Also checks if the stack is empty by checking if top of stack is null.
	 * 
	 * @return returns the data that is held by the node that was just popped from the stack, returns null if stack is empty [String]
	 */
	public String pop () {
		if(top == null) return null;
		String data = top.data;
		top = top.next;

		return data;
	}

	/** getTop method for stack class
	 *  returns the top listNode of the stack
	 * 
	 * @return returns the listNode object that is the top of the stack, returns null if stack is empty
	 */
	public listNode getTop () {
		return top;
	}
}
