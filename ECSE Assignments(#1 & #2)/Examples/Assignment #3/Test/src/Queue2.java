
public class Queue2 {

	private listNode front;
	private listNode rear;

	/** Adds a new listNode to the rear of the queue.
	 * 
	 * @param data The data to be carried by the listNode being added to the queue [String]
	 */
	public void enqueue (String data) {
		listNode node = new listNode();
		node.data = data;
		node.next = null;

		if(rear != null) {
			rear.next = node;
		} else {
			rear = node;
			front = node;
		}

		rear = node;
	}

	/** Returns the data carried by the listNode at the front of the queue and removes it from the queue.
	 * 
	 * @return Returns the data held by the listNode at the front of the queue [String]
	 */
	public String dequeue () {
		if(rear==null) return null;

		String rData = front.data;
		front = front.next;

		return rData;
	}

	/** Returns the front listNode.
	 * 
	 * @return handle to listNode at front of Queue
	 */
	public listNode getFront () {
		return front;
	}

	/** Returns the rear listNode (the last node to be added)
	 * 
	 * @return handle to listNode at rear of Queue
	 */
	public listNode getRear () {
		return rear;
	}
}
