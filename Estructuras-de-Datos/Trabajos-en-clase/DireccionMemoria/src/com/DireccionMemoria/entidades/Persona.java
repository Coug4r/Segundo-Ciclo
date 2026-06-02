package com.DireccionMemoria.entidades;

public class Persona {
	private String nombre;
	private int edad;
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public void cambiar(String n, int e) {
		this.nombre = n;
		this.edad = e;
	}
	public void mostrarDatos() {
		String msg = "Nombre: "+nombre+"\nEdad: "+edad;
		System.out.println(msg);
	}
	
}
