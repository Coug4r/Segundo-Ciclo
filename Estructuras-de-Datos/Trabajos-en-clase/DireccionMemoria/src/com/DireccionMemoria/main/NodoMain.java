package com.DireccionMemoria.main;

import com.DireccionMemoria.entidades.Nodo;

public class NodoMain {
	public static void main(String args[]) {
		Nodo objA = new Nodo(8);
		System.out.println("OjetoA: "+objA);
		
		Nodo objB = new Nodo(4);
		System.out.println("OjetoB: "+objB);
		
		objA.concatenar(objB);
		objA.imprimir();
	}
}
