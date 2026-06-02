package com.herencia.ejemplos;

public class MainHerencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perro dalmata = new Perro("Firulais", 9, "Dalmata");
		dalmata.comer();
		dalmata.dormir();
		dalmata.getRaza();
		dalmata.ladrar();
		System.out.println("===========================");
		Gato michi = new Gato("Mishifuz", 6, "Cruzado");
		michi.comer();
		michi.dormir();
		michi.calcularEdad();
	}

}
