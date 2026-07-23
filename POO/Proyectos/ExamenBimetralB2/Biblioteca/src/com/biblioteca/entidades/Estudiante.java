package com.biblioteca.entidades;

public class Estudiante extends Usuario {
	    public Estudiante(int id, String nombre, String correo) {
	        super(id, nombre, correo, "Estudiante");
	    }

	    @Override
	    public void mostrarInfo() {
	        System.out.println("Estudiante: " + nombre + " - " + correo);
	    }
}
