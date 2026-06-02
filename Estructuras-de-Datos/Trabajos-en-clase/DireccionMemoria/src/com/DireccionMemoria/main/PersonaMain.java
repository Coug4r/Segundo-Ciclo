package com.DireccionMemoria.main;

import com.DireccionMemoria.entidades.Persona;

public class PersonaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona personaA = new Persona("David",20);
		Persona personaB = new Persona("Maria",24);
		Persona personaC = personaA;
		
		personaA.mostrarDatos();
		personaB.mostrarDatos();
		personaC.mostrarDatos();
		
		personaB.cambiar("Juan", 22);
		personaB.mostrarDatos();
	}

}
