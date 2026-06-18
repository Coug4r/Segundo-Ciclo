package listaDobleCircular;

public class DoublyCircularLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
        }
    }

    private Node head = null;
    private Node tail = null;

    // Insertar al final usando tail
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.prev = tail;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        }
    }

    // Insertar al inicio 
    public void insertFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            head.prev = tail;
        } else {
            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode; // actualizar head
        }
    }

    // Eliminar un nodo por valor
    public void delete(int data) {
        if (head == null) return;

        Node current = head;
        do {
            if (current.data == data) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                    if (current == head) head = current.next;
                    if (current == tail) tail = current.prev;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Mostrar hacia adelante
    public void printForward() {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Mostrar hacia atrás
    public void printBackward() {
        if (tail == null) {
            System.out.println("Lista vacía");
            return;
        }
        Node current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }
    
    //Modificar
    public void modificar(int data, int new_data) {
    	if(tail == null) {
    		System.out.println("Lista vacia!");
    		return;
    	}
    	Node current = tail;
    	do {
    		if(current.data == data) {
    			current.data = new_data;
    			System.out.println("Dato modificado con exito!");
    			return;
    		}
    		current = current.next;
    	}while(current!=tail);
    	System.err.println("Dato no encontrado!");
    }
}