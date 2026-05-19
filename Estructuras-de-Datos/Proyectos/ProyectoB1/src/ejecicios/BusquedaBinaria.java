package ejecicios;

import java.util.Scanner;

public class BusquedaBinaria {

    public static int busquedaBinaria(int[] arr, int valor) {

        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (arr[medio] == valor) {
                return medio;
            }

            if (arr[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arreglo = {2, 4, 6, 8, 10, 12, 14};

        System.out.print("Ingrese número a buscar: ");
        int numero = sc.nextInt();

        int posicion = busquedaBinaria(arreglo, numero);

        if (posicion != -1) {
            System.out.println("Número encontrado en posición: " + (posicion+1));
        } else {
            System.out.println("Número no encontrado");
        }
    }
}