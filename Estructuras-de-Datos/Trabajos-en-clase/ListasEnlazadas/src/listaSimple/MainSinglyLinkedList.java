package listaSimple;

public class MainSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        list.delete(100);
        list.print();
        
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.print();

        list.delete(20);
        list.print();
        list.delete(100); // no existe
    }
}