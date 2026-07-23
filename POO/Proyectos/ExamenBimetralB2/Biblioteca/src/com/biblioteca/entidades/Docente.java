package com.biblioteca.entidades;

public class Docente extends Usuario {
    public Docente(int id, String nombre, String correo) {
        super(id, nombre, correo, "Docente");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Docente: " + nombre + " - " + correo);
    }
}