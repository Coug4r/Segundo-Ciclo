package taller_1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TallerPalindromoArchivo {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try(BufferedOutputStream myBufferedOutputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\nasnd\\OneDrive\\Desktop\\Taller.txt",true))){
			String data1;
			do {
			System.out.print("Ingrese la palabra(E para salir): ");
			data1 = sc.nextLine();
			if(!data1.equals("E")) {
				if(esPalindromo(data1)) {
					data1 = "La palabra " +data1 + " es un palindromo\n";
				}else {
					data1 = "La palabra " +data1 + " NO es un palindromo\n";
				}
				byte b1[] = data1.getBytes();
				myBufferedOutputStream.write(b1);
				System.out.println(data1);
			}
			}while(!data1.equals("E"));
			System.out.println("Saliendo...");
			sc.close();
		}catch(IOException e) {
			System.err.println("Error de escritura en archivo");
		}
	}
	public static boolean esPalindromo(String texto) {
		int inicio = 0;
		int fin = texto.length()-1;
        if (inicio >= fin) {
            return true;
        }
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }
        return esPalindromo(texto.substring(1, texto.length() - 1));
    }
}
