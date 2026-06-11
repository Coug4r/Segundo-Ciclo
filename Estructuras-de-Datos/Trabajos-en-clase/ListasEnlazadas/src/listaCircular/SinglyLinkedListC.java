package listaCircular;

public class SinglyLinkedListC {
	
	// Clase interna Node
    class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }
	
	public Node head = null;
    public Node tail = null;
    
    //Insertar datos al final
    public void add(int data) {
    	Node new_node = new Node(data);
    	if(head == null) {
    		head = new_node;
    		tail = new_node;
    		new_node.next = head;
    	}else {
    		tail.next = new_node;
    		tail = new_node;
    		tail.next = head;
    	}
    }
    //Insertar datos al inicio
    public void addStart(int data) {
    	Node new_node = new Node(data);
    	if(head == null) {
    		head = new_node;
    		tail = new_node;
    		new_node.next = head;
    	}else {
    		tail.next = new_node;
    		new_node.next = head;
    		head = new_node;
    	}
    }
    
    public void print() {
    	Node curretNode = head;
    	if(head == null) {
    		System.err.println("Lista vacia!");
    	}else {
    		System.out.print("Nodos Lista circular: ");
    		do {
    			System.out.print(" "+curretNode.data);
    			curretNode = curretNode.next;
    		}while(curretNode != head);
    		System.out.println();
    	}
    }
    
    //Eliminar 
    public void delete(int key) {
    	if(head == null) {
    		System.err.println("Lista Vacia!");
    	}
    	Node current = head;
    	Node prev = tail;
    	do {
	    	if(current.data == key) {
	    		//Un solo nodo en la lista
	    		if(current == head && prev == tail) {
	    			head = null;
	    			tail = null;
	    		}
	    		//Eliminar cabeza
	    		else if(current == head) {
	    			head = head.next;
	    			tail.next = head;
	    		}
	    		//Eliminar cola
	    		else if(current == tail) {
	    			tail = prev;
	    			tail.next = head;
	    		}
	    		//Eliminar nodo intermedio
	    		else {
	    			prev.next = current.next;
	    		}
	    		current.next = null;
	    		System.out.println(key + " found and deleted");
	    		return;
	    	}
	    	prev = current;
	    	current = current.next;
	    	
    	}while(current != head);
    	System.err.println(key + " Not found");
    }
}
