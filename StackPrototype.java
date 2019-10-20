import java.util.HashMap;
import java.util.Scanner;

public class Hello {
	class Node{
		Node next = null;
		int data;
		public Node(int d) {data = d;}
		
	}
	class Stack{
		Node top;
		Node pop() {
			if(top!= null) {
				Node temp = top;
				top = top.next;
				return temp;
			}
			return null;
		}
		void push(int d) {
			Node temp = new Node(d);
			temp.next = top;
			top = temp;
		}
	}
	public static void main(String[] args) {
		
	}
}
