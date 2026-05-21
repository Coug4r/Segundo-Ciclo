package conciertoPrivado;
import java.util.Scanner;
public class VentaEntradas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tipo;
		String[][] asientos = new String[4][5];
		do {
		System.out.println("======Sistema de Venta======\nIngrese el tipo de entrada(1.VIP,2.Palco,3.General) o 4 para salir:");
		tipo = sc.nextInt();
		sc.nextLine();
		switch (tipo) {
		case 1: {
			int asiento = disponible(asientos, 1);
			if(asiento != -1) {
				System.out.println("Ingrese numero de cedula del comprador:");
				String cedula = sc.nextLine();
				asientos[0][asiento] = cedula;
				System.out.println("Comprador con cedula "+ cedula+" tiene el asiento "+ (asiento+1));
			}else {
				System.out.println("No hay VIP's disponibles!");
			}
			break;
		}
		case 2: {
			int asiento = disponible(asientos, 2);
			if(asiento != -1) {
				System.out.println("Ingrese numero de cedula del comprador:");
				String cedula = sc.nextLine();
				asientos[1][asiento] = cedula;
				System.out.println("Comprador con cedula "+ cedula+" tiene el asiento "+ (asiento+6));
			}else {
				System.out.println("No hay Palcos disponibles!");
			}
			break;
		}
		case 3: {
			int asiento = disponible(asientos, 3);
			if(asiento != -1) {
				System.out.println("Ingrese numero de cedula del comprador:");
				String cedula = sc.nextLine();
				asientos[2][asiento] = cedula;
				System.out.println("Comprador con cedula "+ cedula+" tiene el asiento "+ (asiento+11));
			}else {
				int asiento2 = disponible(asientos, 4);
				if(asiento2 != -1) {
					System.out.println("Ingrese numero de cedula del comprador:");
					String cedula = sc.nextLine();
					asientos[3][asiento2] = cedula;
					System.out.println("Comprador con cedula "+ cedula+" tiene el asiento "+ (asiento2+16));
				}else {System.out.println("No hay asientos disponibles en General!");}
			}
			break;
		}
		case 4:{
			System.out.println("Saliendo!");
			break;
		}
		default:
			System.err.println("Opcion invalida");
			break;
		}
	}while(tipo != 4);
	}
	public static int disponible(String[][] mat, int fila) {
		
		for(int i=0;i<mat[fila-1].length;i++) {
			if(mat[fila-1][i]== null || mat[fila-1][i].isBlank()) {
				return i;
			}
		}
		return -1;
	}
}
