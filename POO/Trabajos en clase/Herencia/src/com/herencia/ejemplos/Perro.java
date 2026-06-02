package com.herencia.ejemplos;

public class Perro extends Animal{

	private String raza;
	
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		this.raza = raza;
	}
	
	public void ladrar() {
		System.out.println("Guaau Guaau");
	}

	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", getRaza()=" + getRaza() + ", getNombre()=" + getNombre() + ", getEdad()="
				+ getEdad() + "]";
	}
}
