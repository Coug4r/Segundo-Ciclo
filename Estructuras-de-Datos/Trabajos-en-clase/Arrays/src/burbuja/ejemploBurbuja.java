package burbuja;

import java.util.Scanner;

public class ejemploBurbuja {
    public static int[] burbuja(int[] array) {
        int aux;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        return array;
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

        int[] arrayOrdenado = burbuja(miArray);

        System.out.print("\nArreglo ordenado: [");
        for (int i = 0; i < arrayOrdenado.length; i++) {
        	if(i!=arrayOrdenado.length-1) {
            System.out.print(arrayOrdenado[i]+",");
        	}else {
        		System.out.print(arrayOrdenado[i]);
        	}
        }
        System.out.print("]");
        sc.close();
    }
}