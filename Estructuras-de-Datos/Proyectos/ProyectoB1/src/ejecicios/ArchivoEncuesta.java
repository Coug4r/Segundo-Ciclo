package ejecicios;
import java.io.*;
import java.util.Scanner;

public class ArchivoEncuesta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            FileWriter fw = new FileWriter("encuesta.txt");
            PrintWriter pw = new PrintWriter(fw);

            // Escribir encuestas
            for (int i = 0; i < 10; i++) {

                System.out.println("\nEncuesta " + (i + 1));

                System.out.print("Edad: ");
                String edad = sc.nextLine();

                System.out.print("¿Vive en Loja?: ");
                String loja = sc.nextLine();

                System.out.print("Tipo de música: ");
                String musica = sc.nextLine();

                System.out.print("Eventos asistidos: ");
                String eventos = sc.nextLine();

                pw.println(edad + "," + loja + "," + musica + "," + eventos);
            }

            pw.close();

            System.out.println("\nDatos guardados correctamente.");

            // Leer archivo
            BufferedReader br = new BufferedReader(new FileReader("encuesta.txt"));

            String linea;

            System.out.println("\nCONTENIDO DEL ARCHIVO");

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}