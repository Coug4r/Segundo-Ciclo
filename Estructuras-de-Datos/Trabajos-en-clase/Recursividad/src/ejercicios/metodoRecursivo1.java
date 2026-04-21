package ejercicios;

import java.util.Scanner;

public class metodoRecursivo1 {
	public class main {
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Ingrese el numero a factorizar: ");
			int num = sc.nextInt();
			System.out.println("El factorial de "+num+" es "+factorial(num));
		}
	}
	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}else {
			return (n*factorial(n-1));
		}
	}
}