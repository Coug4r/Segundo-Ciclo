package ejemplos;
import java.util.Scanner;
public class MiMatriz {
	public static void main(String args[]) {
		int[][] newArreglo = llenarArreglo();
		imprimir(newArreglo);	
		//traspuesta(newArreglo);
		traspuestaInversa(newArreglo);
	}
	
	public static void imprimir(int [][] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print("["+arr[i][j]+"]");
			}
			System.out.println();
		}
	}
	
	public static int[][] llenarArreglo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el numero de filas: ");
		int x = sc.nextInt();
		System.out.print("Ingrese el numero de columnas: ");
		int y = sc.nextInt();
		
		int [][] arr = new int[x][y];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print("Ingrese dato para posicion ["+i+","+j+"]: ");
				arr[i][j]=sc.nextInt();
			}
		}
		sc.close();
		return arr;
	}
	
	public static void diagonalPrin(int [][] arr) {
		System.out.println("Diagonal principal:");
		if(arr.length == arr[0].length) {
			for(int i=0;i<arr.length;i++) {
				System.out.print("["+arr[i][i]+"]");
			}
		}else {
			System.err.println("Matriz no cuadrada");
		}
	}
	
	public static void traspuesta(int[][] arr) {
		System.out.println("Traspuestal:");
		int tras[][] = new int[arr[0].length][arr.length];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				tras[j][i] = arr[i][j];
			}
		}
		
		for (int i = 0; i < tras.length; i++) {
	        for (int j = i ; j < tras[i].length; j++) {
	            tras[i][j] = 0;
	        }
	    }
		imprimir(tras);
	}
	public static void traspuestaInversa(int[][] arr) {
	    System.out.println("Traspuesta inversa:");
	    int filas = arr.length;
	    int columnas = arr[0].length;
	    int[][] tras = new int[columnas][filas];

	    for (int i = 0; i < filas; i++) {
	        for (int j = 0; j < columnas; j++) {
	            tras[columnas - 1 - j][filas - 1 - i] = arr[i][j];
	        }
	    }
	    imprimir(tras);
	}

}

