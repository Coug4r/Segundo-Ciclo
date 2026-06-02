package com.DireccionMemoria.entidades;

public class Nodo {
	private int dato;
	private Nodo next;
	
	public Nodo() {
		super();
	}

	public Nodo(int a) {
		this.dato=a;
		this.next=null;
	}
	
	public void concatenar(Nodo nod) {
		this.next = nod;
	}
	
	public void imprimir() {
		System.out.println("Dato: "+dato+" Next: "+next);
	}
}
