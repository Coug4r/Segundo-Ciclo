package com.herencia.ejemplos;

public class Gato extends Animal {
	
	private String pelo;
	
	public Gato(String nombre, int edad, String pelo) {
		super(nombre, edad);
		this.pelo=pelo;
	}

	public String getPelo() {
		return pelo;
	}

	public void setPelo(String pelo) {
		this.pelo = pelo;
	}

	@Override
	public String toString() {
		return "Gato [pelo=" + pelo + ", getPelo()=" + getPelo() + ", getNombre()=" + getNombre() + ", getEdad()="
				+ getEdad() + "]";
	}
	
	public void calcularEdad() {
		System.out.println("El gato tiene: "+(getEdad()-1)+" vidas");
	}
}
