public class BinarySearchTree {
	class Node{
		int data;
		Node left = null, right = null;
		public Node(int d) {data = d;}
	}
	public Node root;
	
	void inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	void preorder(Node root){
		if(root != null){
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	void postorder(Node root){
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	void insert(int d) {
		root = insertRec(root, d);
	}
	
	Node insertRec(Node root, int d){
		if(root == null){
			root = new Node(d);
			return root;
		}
		else if(d<root.data){
			//Goto left subtree
			root.left =  insertRec(root.left,d);
		}else{
			//Goto right subtree
			root.right = insertRec(root.right,d);
		}
		return root;
	}
	
	Node search(Node root,int d) {
		if(root == null) {
			System.out.println("Element not present");
			return null;
		}else if(root.data == d) {
			System.out.println("Element is present");
			return root; 
		}else if(d<root.data) {
			return search(root.left,d);
		}
		return search(root.right,d);
		
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
  
        // print inorder traversal of the BST 
        tree.inorder(tree.root); 
        System.out.println("");
        tree.preorder(tree.root);
        System.out.println("");
        tree.postorder(tree.root);
        
        tree.search(tree.root, 80);
        tree.search(tree.root, 100);
        
        
	}
}
