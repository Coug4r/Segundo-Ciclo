package ejemplos;

public class Grafo {
	private boolean adjMatix[][];
	private int numVertices;
	
	public Grafo(int numVertices) {	
		this.numVertices = numVertices;
		adjMatix = new boolean[numVertices][numVertices];
	}
	
	public void addEdge(int i, int j) {
		adjMatix[i][j] = true;
		adjMatix[j][i] = true;
	}
	
	public void removeEdge(int i, int j) {
		adjMatix[i][j] = false;
		adjMatix[j][i] = false;
	}
	
	public void mostrar() {
	    final String ANSI_GREEN = "\u001B[32m";
	    final String ANSI_RED = "\u001B[31m";
	    final String ANSI_RESET = "\u001B[0m";

	    for (int i = 0; i < numVertices; i++) {
	        System.out.print(i + " | ");
	        for (int j = 0; j < numVertices; j++) {
	            if (adjMatix[i][j]) {
	                System.out.print(ANSI_GREEN + adjMatix[i][j] + ANSI_RESET + " | ");
	            } else {
	                System.out.print(ANSI_RED + adjMatix[i][j] + ANSI_RESET + " | ");
	            }
	        }
	        System.out.println("\n");
	    }
	}

}
