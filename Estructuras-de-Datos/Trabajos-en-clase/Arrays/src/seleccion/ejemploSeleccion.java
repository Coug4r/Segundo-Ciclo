package seleccion;
import java.util.Scanner;
public class ejemploSeleccion {
	    public static void ordSeleccion(int[] a) {
	        int i, j, k, aux;
	        for (i = 0; i < a.length - 1; i++) {
	            k = i;
	            for (j = i + 1; j <= a.length - 1; j++) {
	                if (a[j] < a[k]) k = j;
	            }
	            if (k != i) {
	                aux = a[k];
	                a[k] = a[i];
	                a[i] = aux;
	            }
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
	        
	        ordSeleccion(miArray);

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
