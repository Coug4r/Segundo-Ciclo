package PracticaListasEnlazadas;

public class ListaEnlazada {
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	Node head;
	
	//Insertar al final
	public void insertar(int i) {
		Node new_node = new Node(i);
		if(head == null) {
			head = new_node;
		}else {
			Node last = head;
			while(last.next!=null) {
				last = head.next;
			}
			last.next = new_node;
		}
	}
	
	//Imprimir lista
	public void imprimir() {
		
	}
}
