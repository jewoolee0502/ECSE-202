/**
 * Simple stack class implementation
 * @author ferrie
 *
 */
public class Stack {
listNode top = null;
	void push (String input) {
		listNode node = new listNode();
		node.data = input;
		node.next = top;
		top = node;
	}
	
	String pop() {
		if (top == null) return null;
		String output = top.data;
		top = top.next;
		return output;
	}


    public boolean isEmpty() 
    { 
        if (top == null) { 
            return true; 
        } 
        else
            return false; 
    } 
  
}

