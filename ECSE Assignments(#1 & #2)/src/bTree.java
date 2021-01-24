//Jewoo Lee (260910789)
// I have used the code provided by Professor Ferrie in the Lecture slide.

class bNode {
	
// data is a string and made it to be public for other class to use it
	
	public String data;  
	public bNode left;
	public bNode right;

}

public class bTree {

	// Instance variable
	
	bNode root = null;   

	/**
	 * addNode method - It adds a new node by descending to the leaf node
	 *                  using a while loop in place of recursion.
	 */

	public void addNode(String data)
	{
		bNode current;   

		// create an empty tree

		if (root == null)
		{
			root = makeNode(data);
		}

		// If not empty, descend to the leaf node according to the input data

		else
		{
			current = root;
			while (true)
			{
				if (data.compareTo(current.data) < 0)  // New data < data at node, record it to the left side
				{

					// Use compareTo() because string is not a primitive data and 
					// cannot use the < > == operators

					if (current.left == null)   // leaf node
					{
						current.left = makeNode(data);  // attach new node to the left since it is null
						break;
					}
					else  // otherwise
					{
						current = current.left;  // keep traversing to the left until it is null
					}
				}
				else  // New data >= data at node, branch right
				{
					if (current.right == null)  // leaf node
					{
						current.right = makeNode(data);  // create a new node to the right
						break;
					}
					else  // otherwise
					{
						current = current.right;  // keep traversing until it is node to the right
					}
				}
			}
		}
	}

	/**
	 * makeNode
	 * 
	 * Creates a single instance of a bNode
	 * 
	 * @param	String data   Data to be added
	 * @return  bNode node Node created
	 */

	bNode makeNode(String data)
	{
		bNode node = new bNode();  // create new object
		node.data = data;  // initialize data field
		node.left = null;  // set both successors
		node.right = null;  // to null
		return node;  // return handle to new object
	}

	/**
	 * inorder method - inorder traversal via call to recursive method
	 */

	public void inorder()
	{
		traverse_inorder(root);  // hides recursion from user
	}

	/**
	 * traverse_inorder method - recursively traverses tree in order (LEFT-Root-RIGHT) and prints each node.
	 */

	private void traverse_inorder(bNode root)
	{
		if (root.left != null) traverse_inorder(root.left);
			System.out.println(root.data);
		if (root.right != null) traverse_inorder(root.right);
	}

	public void reverseorder() 
	{									// hides recursion from user
		reverse_inorder(root);
		while(true) 
		{
			System.out.println(bStack.pop());  // creates the string in reverseorder
			if (bStack.isEmpty()) 
				break;
		}
	}

	Stack bStack = new Stack();

	private void reverse_inorder(bNode root) 
	{
		if (root.left != null) reverse_inorder(root.left);
			bStack.push(root.data);	
		if (root.right != null) reverse_inorder(root.right);	

	}
}

