package ejercicios;

import java.util.Scanner;

public class metodoSuma {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el numero a factorizar: ");
		int num = sc.nextInt();
		System.out.println("El factorial de "+num+" es "+ suma(num));
	}
	public static int suma(int n) {
		if(n == 1) {
			return 1;
		}else {
			return(n + suma(n-1));
		}
	}
}
