public class bTree {
	
	// Instance variables
	
	bNode root=null;
/**
 * addNode method - adds a new node by descending to the leaf node
 *                  using a while loop in place of recursion.
 */
	
	
	public void addNode(String data) {
		
		bNode current;

// Empty tree
		
		if (root == null) {
			root = makeNode(data);
		}
		
// If not empty, descend to the leaf node according to
// the input data.  
		
		else {
			current = root;
			while (true) {
				if (data.compareToIgnoreCase(current.data)<0) {					
// New data < data at node, branch left
					
					if (current.left == null) {				// leaf node
						current.left = makeNode(data);		// attach new node here
						break;
					}
					else {									// otherwise
						current = current.left;				// keep traversing
					}
				}
				else {
// New data >= data at node, branch right
					
					if (current.right == null) {			// leaf node	
						current.right = makeNode(data);		// attach
						break;
					}
					else {									// otherwise 
						current = current.right;			// keep traversing
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
 * @param	int data   Data to be added
 * @return  bNode node Node created
 */
	
	bNode makeNode(String data) {
		bNode node = new bNode();							// create new object
		node.data = data;									// initialize data field
		node.left = null;									// set both successors
		node.right = null;									// to null
		return node;										// return handle to new object
	}
	
	
/**
 * inorder method - inorder traversal via call to recursive method
 */
	
	public void inorder() {									// hides recursion from user
		traverse_inorder(root);
	}
	
/**
 * traverse_inorder method - recursively traverses tree in order (LEFT-Root-RIGHT) and prints each node.
 */
	
	private void traverse_inorder(bNode root) {
		if (root.left != null) traverse_inorder(root.left);
		System.out.println(root.data);
		if (root.right != null) traverse_inorder(root.right);
	}


		public void reverseorder() {									// hides recursion from user
			reverse_inorder(root);
			while(true) {
				System.out.println(bStack.pop());
				if (bStack.isEmpty()) break;
			}
		}
		
		Stack bStack = new Stack();
		private void reverse_inorder(bNode root) {
			if (root.left != null) reverse_inorder(root.left);
			bStack.push(root.data);
			if (root.right != null) reverse_inorder(root.right);
		
		
			
		}

	}






