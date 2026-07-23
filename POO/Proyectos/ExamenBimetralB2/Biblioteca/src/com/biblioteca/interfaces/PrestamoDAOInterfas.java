package com.biblioteca.interfaces;

import java.util.List;

import com.biblioteca.entidades.Prestamo;

public interface PrestamoDAOInterfas {
    
    void insertar(Prestamo prestamo);
    Prestamo buscarPorId(int id);
    List<Prestamo> listar();
    void actualizar(Prestamo prestamo);
    void eliminar(int id);
    List<Prestamo> listarActivos();
    List<Prestamo> listarHistorial();
    void registrarDevolucion(int idPrestamo);
}
