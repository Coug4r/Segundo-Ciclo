package listaCircular;

public class MainListaCircular {
	public static void main(String args[]) {
		SinglyLinkedListC listC = new SinglyLinkedListC();
		listC.add(10);
		listC.add(20);
		listC.add(30);
		listC.add(40);
		listC.print();
		listC.addStart(5);
		listC.print();
		listC.addStart(0);
		listC.print();
		//listC.delete(20);
		//listC.print();		
		//listC.delete(200);
	}
}
