package com.biblioteca.entidades;

public class Investigador extends Usuario {
    public Investigador(int id, String nombre, String correo) {
        super(id, nombre, correo, "Investigador");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Investigador: " + nombre + " - " + correo);
    }
}
