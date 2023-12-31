public class IntBst {
	private IntBstNode root;

	public IntBst() {
		this.root = null;
	}

	public void addNode(int data) {
		IntBstNode p=root;
		IntBstNode prev=null;

		if (root==null) { // empty tree
			root = new IntBstNode(data);
			return;
		}

		while (p!=null) {	// find a replace for insertion
			prev = p;
			if (data < p.getData())
				p = p.getLeft();
			else 
				p = p.getRight();
		}

		if (data < prev.getData()) 
			prev.setLeft(new IntBstNode(data));
		else
		prev.setRight(new IntBstNode(data));
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	public void preorder(IntBstNode v) {
		System.out.print(v.getData() + " ");
		if (v.getLeft() != null) 
			preorder(v.getLeft());
		if (v.getRight() != null)
			preorder(v.getRight());
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	public void inorder(IntBstNode v) {
		if (v.getLeft() != null) 
			inorder(v.getLeft());
		System.out.print(v.getData() + " ");
		if (v.getRight() != null)
			inorder(v.getRight());
	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	public void postorder(IntBstNode v) {
		if (v.getLeft() != null) 
			postorder(v.getLeft());
		if (v.getRight() != null)
			postorder(v.getRight());
		System.out.print(v.getData() + " ");
	}
}

			


