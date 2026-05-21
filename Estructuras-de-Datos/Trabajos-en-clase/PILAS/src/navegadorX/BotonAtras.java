package navegadorX;
import java.util.Scanner;
public class BotonAtras {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Pila navegacion = new Pila(4);
		int opc;
		do {
		System.out.println("\n1.Visitar Pagina\n2.Mostrar Historial\n3.Regresar a la pagina anterior\n4.Verificar Pila vacia\n5.Salir");
		opc = sc.nextInt();
		String pagina = "";
		switch (opc) {
		case 1: {
			navegacion.InsertarPila();
		break;
		}
		case 2:{
			navegacion.MostrarHistorial();;
			break;
		}
		case 3:{
			navegacion.Regresar();
			break;
		}
		case 4:{
			if(navegacion.PilaVacia()) {
				System.out.println("La pila esta vacia!");
			}else {
				System.out.println("La pila no esta vacia!");
			}
		break;
		}
		case 5:{
			System.out.println("Saliendo...");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opc);
		}
		}while(opc != 5);
	}
}
