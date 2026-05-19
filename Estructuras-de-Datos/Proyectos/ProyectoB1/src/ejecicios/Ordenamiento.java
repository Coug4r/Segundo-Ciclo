package ejecicios;

import java.util.Scanner;

public class Ordenamiento {

    // Método Burbuja
    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    // Método Inserción
    public static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int clave = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = clave;
        }
    }

    // Método Selección
    public static void seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int aux = arr[min];
            arr[min] = arr[i];
            arr[i] = aux;
        }
    }

    // Método QuickSort
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(arr, inicio, fin);

            quickSort(arr, inicio, pivote - 1);
            quickSort(arr, pivote + 1, fin);
        }
    }

    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;

                int aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
            }
        }

        int aux = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = aux;

        return i + 1;
    }

    // Mostrar arreglo
    public static void mostrar(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese tamaño del arreglo: ");
        int n = sc.nextInt();

        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese número [" + i + "]: ");
            arreglo[i] = sc.nextInt();
        }

        System.out.println("\n1. Burbuja");
        System.out.println("2. Inserción");
        System.out.println("3. Selección");
        System.out.println("4. QuickSort");

        System.out.print("Elija opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                burbuja(arreglo);
                break;
            case 2:
                insercion(arreglo);
                break;
            case 3:
                seleccion(arreglo);
                break;
            case 4:
                quickSort(arreglo, 0, arreglo.length - 1);
                break;
            default:
                System.out.println("Opción inválida");
        }

        System.out.println("Arreglo ordenado:");
        mostrar(arreglo);
    }
}