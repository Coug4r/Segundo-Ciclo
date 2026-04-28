package ejemplos;

import java.util.Scanner;

public class arrays {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int[] arraynum;
		arraynum = new int[5];
		System.out.println("**************DATOS********************");
		for(int i=0; i<5;i++) {
			System.out.print("Ingrese el num en posicion ["+i+"]: ");
			arraynum[i]=in.nextInt();
		}
		System.out.println("**************ARREGLO*****************");
		for(int i=0; i<arraynum.length;i++) {
			System.out.println("Num en posicion ["+i+"]: "+ arraynum[i]);
		}
		System.out.println("**************BUSCAR****************");
		System.out.print("Ingrese el numero a buscar: ");
		int num = in.nextInt();
		int indiceEncontrado = Buscar(arraynum,num);
		if(indiceEncontrado != -1) {
			System.out.println("El numero se encuentra en el indice "+indiceEncontrado);
		}else {
			System.out.println("El numero no se encuentra en el arreglo! ");
		}
	}
	public static int Buscar(int[] array, int elem) {
		int indice=-1;
		for(int i=0; i<array.length;i++) {
			if(array[i]==elem) {
				indice = i;
			}
		}
		return indice;
	}
}

