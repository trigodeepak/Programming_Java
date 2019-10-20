import java.util.HashMap;
import java.util.Scanner;

public class Hello {
	class Node{
		Node next = null;
		int data;
		public Node(int d) {data = d;}
		void appendToTail(int d) {
			Node temp = new Node(d);
			Node n = this;
			while(n.next!= null) {
				n = n.next;
			}
			n.next = temp;
		}
		Node deleteNode(Node head,int d) {
			Node n = head;
			if(n.data== d) {
				head = head.next;
				return head;
			}
			while(n != null) {
				if(n.next.data == d) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
			return head;
		}
	}
	public static void main(String[] args) {
		
	}
}
