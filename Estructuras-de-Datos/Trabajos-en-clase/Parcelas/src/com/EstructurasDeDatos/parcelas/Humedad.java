package com.EstructurasDeDatos.parcelas;
import java.util.Scanner;
public class Humedad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el numero de parcelas: ");
		int parcelas = sc.nextInt();
		System.out.println("¿Como desea ingresar la informacion(1.Diaria o 2.Mesual)?");
		int opcion = sc.nextInt();
		int columnas;
		if (opcion == 1) {
            columnas = 7;
        } else {
        	boolean validez = true;
        	do {
	            System.out.print("Ingrese el número de días del mes: ");
	            columnas = sc.nextInt();
	            if(columnas != 28 && columnas != 29 && columnas != 30 & columnas != 31) {
	            	System.err.println("No existen meses con "+columnas+" dias!");
	            	validez = false;
	            }
        	}while(validez == false);
        }
		
		double [][] humedad = ingresarDatos(parcelas, columnas);
		menu(parcelas, columnas, humedad);
		sc.close();
	}	
	
	public static double[][] ingresarDatos(int filas, int columnas) {
		Scanner sc = new Scanner(System.in);
		double [][] mat = new double[filas][columnas];
		for(int i=0; i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				double valor;
				do {
					System.out.print("Ingrese el valor para Parcela "+(i+1)+" Dia "+(j+1)+": ");
					valor = sc.nextDouble();
					if(valor <= 0 || valor >100) {
						System.err.println("Dato no valido");
					}
				}while(valor <= 0 || valor >100);
				mat[i][j]=valor;
			}
		}
		return mat;
	}
	
	public static void menu(int parcelas, int columnas, double[][] humedad) {
		Scanner sc = new Scanner(System.in);
		int menu;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Promedios por parcela");
            System.out.println("2. Promedios por día");
            System.out.println("3. Promedio total");
            System.out.println("4. Mayor humedad");
            System.out.println("5. Menor humedad");
            System.out.println("6. Editar datos");
            System.out.println("7. Imprimir datos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1: 
                    for (int i = 0; i < parcelas; i++) {
                        double suma = 0;
                        for (int j = 0; j < columnas; j++) {
                            suma += humedad[i][j];
                        }
                        System.out.printf("Promedio parcela %d: %.2f%%\n", i+1, suma/columnas);
                    }
                    break;

                case 2: 
                    for (int j = 0; j < columnas; j++) {
                        double suma = 0;
                        for (int i = 0; i < parcelas; i++) {
                            suma += humedad[i][j];
                        }
                        System.out.printf("Promedio día %d: %.2f%%\n", j+1, suma/parcelas);
                    }
                    break;

                case 3: 
                    double sumaTotal = 0;
                    int totalDatos = parcelas * columnas;
                    for (int i = 0; i < parcelas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            sumaTotal += humedad[i][j];
                        }
                    }
                    System.out.printf("Promedio total: %.2f%%\n", sumaTotal/totalDatos);
                    break;

                case 4:
                    double max = humedad[0][0];
                    int piMax = 0, pjMax = 0;
                    for (int i = 0; i < parcelas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            if (humedad[i][j] > max) {
                                max = humedad[i][j];
                                piMax = i;
                                pjMax = j;
                            }
                        }
                    }
                    System.out.printf("Mayor humedad: %.2f%% en parcela %d, día %d\n", max, piMax+1, pjMax+1);
                    break;

                case 5:
                    double min = humedad[0][0];
                    int piMin = 0, pjMin = 0;
                    for (int i = 0; i < parcelas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            if (humedad[i][j] < min) {
                                min = humedad[i][j];
                                piMin = i;
                                pjMin = j;
                            }
                        }
                    }
                    System.out.printf("Menor humedad: %.2f%% en parcela %d, día %d\n", min, piMin+1, pjMin+1);
                    break;

                case 6:
                    editar(humedad);
                    imprimir(humedad);
                case 7:
                	 imprimir(humedad);
                case 8:
               	 System.out.println("Saliendo del programa...");
               	 break;
                default:
                    System.err.println(" Opción inválida.");
            }
        } while (menu != 7);
	
	}
	
	public static void editar(double [][] mat) {
		Scanner sc = new Scanner(System.in);
		int parcela;
		int columna;
		do {
			System.out.println("Ingrese en que parcela quiere editar: ");
			parcela = sc.nextInt();
			System.out.println("Ingrese la columna que quiere editar: ");
			columna = sc.nextInt();
		}while (parcela < 1 || parcela > mat.length || columna < 1 || columna > mat[0].length);
		
		System.out.println("Ingrese el nuevo dato para Parcela "+parcela+" Columna "+columna+": ");
		mat[parcela-1][columna-1] = sc.nextDouble();
		System.out.println("Dato actualizado...");
	}
	public static void imprimir(double[][] mat) {
		System.out.print("           "); 
		for (int j = 0; j < mat[0].length; j++) {
		    System.out.printf("Día%-4d", (j + 1));
		}
		System.out.println();

		for (int i = 0; i < mat.length; i++) {
		    System.out.printf("Parcela %-2d", (i + 1));
		    for (int j = 0; j < mat[i].length; j++) {
		        System.out.printf("[%4.2f] ", mat[i][j]);
		    }
		    System.out.println();
		}
	}
}
	
	
	
