package insercion;
import java.util.Scanner;
public class ejemploInsercion {
	    public static void ordInsercion(int[] a) {
	        for (int i = 1; i < a.length; i++) {
	            int aux = a[i];
	            int j = i;
	            for (; j > 0 && aux < a[j - 1]; j--) {
	                a[j] = a[j - 1];
	            }
	            a[j] = aux;
	        }
	    }

	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	        System.out.print("Ingrese el tamaño del arreglo: ");
	        int n = sc.nextInt();
	        int[] miArray = new int[n];
	        System.out.println("Ingrese los elementos del arreglo:");
	        for (int i = 0; i < n; i++) {
	            System.out.print("Elemento " + (i + 1) + ": ");
	            miArray[i] = sc.nextInt();
	        }
	        ordInsercion(miArray);
	        
	        System.out.print("\nArreglo ordenado: [");
	        for (int i = 0; i < miArray.length; i++) {
	        	if(i!=miArray.length-1) {
	            System.out.print(miArray[i]+",");
	        	}else {
	        		System.out.print(miArray[i]);
	        	}
	        }
	        System.out.print("]");
	        sc.close();
	    }
}