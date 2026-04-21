package ejercicios;

import java.util.Scanner;

public class metdodSuma2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int start;
		int end;
		do {
		System.out.print("Ingrese el numero de inicio en la suma: ");
		start = sc.nextInt();
		System.out.print("Ingrese el numero de fin en la suma: ");
		end = sc.nextInt();
		if(start < end) {
			System.err.println("El numero de inicio debe ser mayor al del fin!");
		}
		}while(start < end);
		System.out.println("La suma total es "+sumar(start, end));
	}
	public static int sumar(int start, int end) {
		if(start == end) {
			return end;
		}else {
			return (start + sumar(start -1,end));
		}
	}
}
