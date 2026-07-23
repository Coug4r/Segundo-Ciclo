package Listas;
	
public class DoblementeEnlazadas {
	public class Node{
		private int data;
		private Node next;
		private Node prev;
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	Node head;
	Node tail;
	public void add(int value) {
		Node nuevoNodo = new Node(value);
		if(head == null & tail == null) {
			head = tail =  nuevoNodo;
		}
		tail = nuevoNodo;
		
	}
}
