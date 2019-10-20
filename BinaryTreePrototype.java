import java.util.HashMap;
import java.util.Scanner;

public class Hello {
	
	class BST{
		class Node{
			//making data and left right public for testing only 
			public int data;
			public Node left = null, right = null;
			public Node(int d) {data = d;}
		}
		Node root;

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
				System.out.print(root.data + " ")
			}
		}

		void insertRec(Node root, int d){
			if(root == null){
				root = new Node(d);
				return root;
			}
			else if(d<root.data){
				//Goto left subtree
				return insertRec(root.left,d);
			}else{
				//Goto right subtree
				return insertRec(root.right,d);
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
