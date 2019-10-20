import java.util.HashMap;
import java.util.Scanner;

public class Hello {
	class Node{
		Node next = null;
		int data;
		public Node(int d) {data = d;}
		
	}
	class Queue{
		Node first,last;
		void enque(int d) {
			Node temp = new Node(d);
			if(first == null) {
				//Check this statement
				first = last = temp;
			}else {
				last.next = temp;
				last = temp;
			}
		}
		Node deque() {
			if (first != null) {
				Node temp = first;
				first = first.next;
				return temp;
			}
			return null;
		}
		
	}
	public static void main(String[] args) {
		
	}
}
