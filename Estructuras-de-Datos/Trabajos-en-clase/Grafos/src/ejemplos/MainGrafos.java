package ejemplos;

public class MainGrafos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo grafo = new Grafo(5);
		
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 1);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 0);
		
		grafo.mostrar();
		
		grafo.removeEdge(1, 2);
		grafo.removeEdge(4, 3);
		
		System.out.println("\n");
		
		grafo.mostrar();
	}

}
