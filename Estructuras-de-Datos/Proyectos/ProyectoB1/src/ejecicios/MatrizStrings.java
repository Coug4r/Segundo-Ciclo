package ejecicios;

import java.util.Scanner;

public class MatrizStrings {

    public static void ingresar(String[][] nombres) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                System.out.print("Ingrese nombre [" + (i+1) + "][" + (j+1) + "]: ");
                nombres[i][j] = sc.nextLine();
            }
        }
    }

    public static void presentar(String[][] nombres) {
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                System.out.print(nombres[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 
    
    public static void ordenar(String[][] nombres) {
        int filas = nombres.length;
        int columnas = nombres[0].length;
        String[] plano = new String[filas * columnas];

        int k = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                plano[k++] = nombres[i][j];
            }
        }
        //
        for (int i = 0; i < plano.length - 1; i++) {
            for (int j = 0; j < plano.length - i - 1; j++) {
                if (plano[j].compareToIgnoreCase(plano[j + 1]) > 0) {
                    String aux = plano[j];
                    plano[j] = plano[j + 1];
                    plano[j + 1] = aux;
                }
            }
        }
        // 
        k = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nombres[i][j] = plano[k++];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Número de columnas: ");
        int columnas = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String[][] nombres = new String[filas][columnas];

        ingresar(nombres);

        System.out.println("\nDatos ingresados:");
        presentar(nombres);

        ordenar(nombres);

        System.out.println("\nDatos ordenados:");
        presentar(nombres);

        sc.close();
    }
}
