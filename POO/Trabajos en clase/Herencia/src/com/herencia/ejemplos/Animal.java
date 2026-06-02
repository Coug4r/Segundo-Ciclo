package com.herencia.ejemplos;

public class Animal {
	private String nombre;
	private int edad;
	
	public Animal(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	public void dormir() {
		System.out.println("Duerme");
	}
	
	public void comer() {
		System.out.println("Come");
	}
}

