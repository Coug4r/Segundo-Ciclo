package ejemplos;
import java.util.Scanner;
public class MainLibretaCalificaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el nombre del estudiante: ");
		String nombre = sc.nextLine();
		int num=0;
		double[] calificaciones;
		do {
			System.out.print("Ingrese el numero de calificaciones: ");
			num = sc.nextInt();
			calificaciones = new double[num];
			for(int i=0; i<calificaciones.length;i++) {
				do {
					System.out.print("Ingrese la calificacion "+(i+1)+": ");
					calificaciones[i]= sc.nextDouble();
					System.err.println((calificaciones[i] < 0) ? "Error datos negativos\n":"");
				}while(calificaciones[i]<0);
			}
		}while(num<=0);
		LibretaCalificaciones est1 = new LibretaCalificaciones(nombre, calificaciones);
		est1.info();
		sc.close();
	}
}