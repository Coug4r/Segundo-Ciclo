package navegadorX;

import java.util.Scanner;

public class Pila {
    private int MAX;       
    private int TOPE;       
    private String[] PILA;
    private Scanner teclado = new Scanner(System.in);


    public Pila(int capacidad) {
        this.MAX = capacidad;
        this.TOPE = -1;
        this.PILA = new String[capacidad];
    }
	public boolean PilaVacia() {
        return this.TOPE == -1;
    }
    public boolean PilaLlena() {
        return this.TOPE == this.MAX - 1;
    }
    public void InsertarPila() {
        if (this.PilaLlena()) {
            System.err.println("Limite de busqueda alcanzado!");
        } else {
            System.out.print("Ingrese la url a insertar: ");
            String ITEM = teclado.nextLine();
            this.TOPE++;
            this.PILA[this.TOPE] = ITEM;
            System.out.println("Se visito " + ITEM );
        }
    }
    
    public void Regresar() {
    	if (PilaVacia()) {
            System.out.println("No hay páginas para regresar");
        } else {
            String pagina = this.PILA[TOPE--];
            System.out.println("Regresando desde: " + pagina +" a "+this.PILA[TOPE]);
        }
    }

    public void MostrarHistorial() {
        if (this.PilaVacia()) {
            System.out.println(" Historial vacío");
        } else {
            System.out.println("=== Historial ===");
            for (int i = this.TOPE; i >= 0; i--) {
                System.out.println(this.PILA[i]);
            }
        }
    }
    
}