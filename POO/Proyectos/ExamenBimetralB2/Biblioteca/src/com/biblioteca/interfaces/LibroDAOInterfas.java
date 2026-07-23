package com.biblioteca.interfaces;

import java.util.List;

import com.biblioteca.entidades.Libro;

public interface LibroDAOInterfas {
	void crear(Libro libro);
	Libro buscarPorID(int id);
	List<Libro> listar();
	void actualizarInformacion(Libro libro);
	void eliminarLibro(int id);
}
