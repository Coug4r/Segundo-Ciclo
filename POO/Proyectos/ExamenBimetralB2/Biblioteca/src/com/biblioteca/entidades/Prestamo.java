package com.biblioteca.entidades;

public class Prestamo {
    private int id;
    private int usuarioId;
    private int libroId;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String estado; 

    public Prestamo(int id, int usuarioId, int libroId, String fechaPrestamo, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() { return id; }
    public int getUsuarioId() { return usuarioId; }
    public int getLibroId() { return libroId; }
    public String getFechaPrestamo() { return fechaPrestamo; }
    public String getFechaDevolucion() { return fechaDevolucion; }
    public String getEstado() { return estado; }

    public void registrarDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.estado = "DEVUELTO";
    }
}
