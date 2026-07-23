package com.biblioteca.interfaces;

import java.util.List;

import com.biblioteca.entidades.Usuario;

public interface UsuarioDAOInterfas {
	void crear(Usuario usuario);
	Usuario buscarPorID(int id);
	List<Usuario> listar();
	void actualizarUsuario(Usuario usuario);
	void eliminarUsuario(int id);
}
