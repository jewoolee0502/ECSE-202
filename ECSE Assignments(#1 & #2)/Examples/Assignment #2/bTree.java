
public class bTree {

	// Instance Variables

	bNode root = null;
	public static Stack bTreeStack;

	public void addNode(String data)
	{
		bNode current;

		//Empty Tree

		if (root == null)
		{
			root = makeNode(data);
		}

		// If not empty, descend to the leaf node according
		// to the input data.

		else
		{
			current = root;
			while(true)
			{
				if (data.compareTo(current.data) < 0)
				{

					// New data < data at node, branch left

					if (current.left == null)  // leaf node
					{
						current.left = makeNode(data);  // attach new node here
						break;
					}
					else  // otherwise
					{
						current = current.left;  //keep traversing
					}
				}
				else
				{

					// New data >= data at node, branch right

					if (current.right == null)  // leaf node
					{
						current.right = makeNode(data); //attach
						break;
					}
					else  // otherwise
					{
						current = current.right;  // keep traversing
					}
				}
			}
		}
	}
	
	bNode makeNode(String data)
	{
		bNode node = new bNode();  // create new object
		node.data = data;  // initialize data field
		node.left = null;  // set both successors
		node.right = null; // to null
		return node;  // return handle to new object
	}
	
	public void inorder()  // hides recursion from user
	{
		traverse_inorder(root);
	}
	
	private void traverse_inorder(bNode root)
	{
		if (root.left != null) traverse_inorder(root.left);
		System.out.println(root.data);
		bTreeStack.push(root.data);
		if (root.right != null) traverse_inorder(root.right);
	}
}
