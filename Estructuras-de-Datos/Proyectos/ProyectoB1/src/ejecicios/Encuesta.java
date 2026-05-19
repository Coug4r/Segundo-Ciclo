package ejecicios;

import java.util.Scanner;

public class Encuesta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Número de encuestas: ");
        n = sc.nextInt();
        sc.nextLine();

        String[][] matriz = new String[n][4];

        // Ingreso de datos
        for (int i = 0; i < n; i++) {

            System.out.println("\nEncuesta " + (i + 1));

            System.out.print("Edad: ");
            matriz[i][0] = sc.nextLine();

            System.out.print("¿Vive en Loja? (SI/NO): ");
            matriz[i][1] = sc.nextLine();

            System.out.print("Tipo de música: ");
            matriz[i][2] = sc.nextLine();

            System.out.print("Eventos asistidos: ");
            matriz[i][3] = sc.nextLine();
        }

        // Presentar información
        System.out.println("\nDATOS DE ENCUESTAS");

        for (int i = 0; i < n; i++) {
            System.out.println(
                matriz[i][0] + " | " +
                matriz[i][1] + " | " +
                matriz[i][2] + " | " +
                matriz[i][3]
            );
        }

        int menores = 0;
        int loja = 0;
        int rock = 0;
        int mas3 = 0;

        for (int i = 0; i < n; i++) {

            int edad = Integer.parseInt(matriz[i][0]);
            int eventos = Integer.parseInt(matriz[i][3]);

            if (edad < 18) {
                menores++;
            }

            if (matriz[i][1].equalsIgnoreCase("SI")) {
                loja++;
            }

            if (matriz[i][2].equalsIgnoreCase("rock")) {
                rock++;
            }

            if (eventos > 3) {
                mas3++;
            }
        }

        System.out.println("\nRESULTADOS");
        System.out.println("Menores de edad: " + menores);
        System.out.println("Personas de Loja: " + loja);
        System.out.println("Personas que gustan del rock: " + rock);
        System.out.println("Asistieron a más de 3 eventos: " + mas3);
    }
}