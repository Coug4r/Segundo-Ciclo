package com.biblioteca.entidades;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String tipo;

    public Usuario(int id, String nombre, String correo, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public abstract void mostrarInfo();
}
