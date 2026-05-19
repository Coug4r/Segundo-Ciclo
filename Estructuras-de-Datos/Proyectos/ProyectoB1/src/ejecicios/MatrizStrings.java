package ejecicios;

import java.util.Scanner;

public class MatrizStrings {

    public static void ingresar(String[] nombres) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese nombre: ");
            nombres[i] = sc.nextLine();
        }
    }

    public static void presentar(String[] nombres) {
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public static void ordenar(String[] nombres) {

        for (int i = 0; i < nombres.length - 1; i++) {
            for (int j = 0; j < nombres.length - i - 1; j++) {

                if (nombres[j].compareToIgnoreCase(nombres[j + 1]) > 0) {

                    String aux = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de nombres: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[n];

        ingresar(nombres);

        System.out.println("\nDatos ingresados:");
        presentar(nombres);

        ordenar(nombres);

        System.out.println("\nDatos ordenados:");
        presentar(nombres);
    }
}