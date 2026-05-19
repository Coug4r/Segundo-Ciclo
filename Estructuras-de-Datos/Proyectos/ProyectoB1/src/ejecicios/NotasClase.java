package ejecicios;
import java.util.Scanner;

public class NotasClase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] notas = new double[20][4];

        // Ingreso de notas
        for (int i = 0; i < 20; i++) {

            System.out.println("\nAlumno " + (i + 1));

            for (int j = 0; j < 4; j++) {

                System.out.print("Nota asignatura " + (j + 1) + ": ");
                notas[i][j] = sc.nextDouble();
            }
        }

        // Media de cada alumno
        System.out.println("\nMEDIA DE CADA ALUMNO");

        for (int i = 0; i < 20; i++) {

            double suma = 0;

            for (int j = 0; j < 4; j++) {
                suma += notas[i][j];
            }

            double media = suma / 4;

            System.out.println("Alumno " + (i + 1) + ": " + media);
        }

        // Media de cada asignatura
        System.out.println("\nMEDIA DE CADA ASIGNATURA");

        for (int j = 0; j < 4; j++) {

            double suma = 0;

            for (int i = 0; i < 20; i++) {
                suma += notas[i][j];
            }

            double media = suma / 20;

            System.out.println("Asignatura " + (j + 1) + ": " + media);
        }

        // Media general de la clase
        double sumaTotal = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 4; j++) {
                sumaTotal += notas[i][j];
            }
        }

        double mediaClase = sumaTotal / (20 * 4);

        System.out.println("\nMedia general de la clase: " + mediaClase);
    }
}