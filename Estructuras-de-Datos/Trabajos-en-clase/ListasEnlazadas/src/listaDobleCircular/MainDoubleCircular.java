package listaDobleCircular;

public class MainDoubleCircular {
    // Probar
    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertFront(5);

        System.out.println("Recorrido hacia adelante:");
        list.printForward();

        System.out.println("Recorrido hacia atrás:");
        list.printBackward();

        list.delete(20);
        System.out.println("Después de eliminar 20:");
        list.printForward();
        list.printBackward();
        System.out.println("Modificar");
        list.modificar(10, 1);
        list.printForward();
        list.modificar(100, 1);
        
    }
}
