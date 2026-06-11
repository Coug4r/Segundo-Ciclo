package listaSimple;

public class SinglyLinkedList {

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
    // Referencia al primer nodo empieza en null
    Node head;

    // Insertar al final de la lista
    public void insert(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
        }else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        System.out.println("Dato insertado!");
    }

    // Imprimir la lista
    public void print() {
        Node currNode = head;
        if(currNode!=null) {
	        System.out.print("\nLinkedList: ");
	        while (currNode != null) {
	            System.out.print(currNode.data + " ");
	            currNode = currNode.next;
	        }
	        System.out.println("\n");
        }else {
        	System.err.println("Lista vacia!");
        }
    }

    // Eliminar un nodo por valor
    public void delete(int key) {
        if (head == null) {
            System.err.println("Lista vacia!");
            return;
        }

        Node currNode = head;
        Node prev = null;

        // Buscar el nodo
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        // Si no se encontró
        if (currNode == null) {
            System.out.println(key + " not found");
            return;
        }

        // Si es el primer nodo
        if (prev == null) {
            head = currNode.next;
        } else {
            prev.next = currNode.next;
        }

        currNode.next = null;
        System.out.println(key + " found and deleted");
    }
}