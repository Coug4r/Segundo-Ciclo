package com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.database.Conexion;
import com.biblioteca.entidades.Libro;
import com.biblioteca.interfaces.LibroDAOInterfas;

public class LibroDAO implements LibroDAOInterfas{ 
	Connection con = Conexion.DbConection();

	@Override
	public void crear(Libro libro) {
		String sql = "INSERT INTO libro(titulo, autor, isbn, disponible) VALUES (?,?,?,?);";
		try(PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setString(3, libro.getIsbn());
			ps.setBoolean(4, libro.isDisponible());;
			int filas = ps.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Libro creado correctamente.");
	        }
		}catch(SQLException e) {
			System.err.println("Error al crear libro: "+ e.getMessage());
		}
	}

	@Override
	public Libro buscarPorID(int id) {
		String sql = "SELECT id,titulo, autor, isbn, disponible FROM libro WHERE id = ?;";
		Libro nuevoLibro = null;
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				int idrec = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String isbn = rs.getString("isbn");
				boolean disponible = rs.getBoolean("disponible");
				nuevoLibro = new Libro(idrec,titulo, autor, isbn, disponible);
			}
			return nuevoLibro;
		} catch (SQLException e) {
			System.err.println("Error al buscar el libro: "+ e.getMessage());
			return null;
		}
	}

	@Override
	public List<Libro> listar() {
		String sql = "SELECT * FROM libro;";
		List<Libro> libros = new ArrayList<>();
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idrec = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String isbn = rs.getString("isbn");
				boolean disponible = rs.getBoolean("disponible");
				Libro nuevoLibro = new Libro(idrec,titulo, autor, isbn, disponible);
				libros.add(nuevoLibro);
			}
			return libros;
		} catch (SQLException e) {
			System.err.println("Error al listar los libros: "+ e.getMessage());
			return null;
		}
	}

	@Override
	public void actualizarInformacion(Libro libro) {
	    String sql = "UPDATE libro SET titulo = ?, autor = ?, isbn = ?, disponible = ? WHERE id = ?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, libro.getTitulo());
	        ps.setString(2, libro.getAutor());
	        ps.setString(3, libro.getIsbn());
	        ps.setBoolean(4, libro.isDisponible());
	        ps.setInt(5, libro.getId());
	        int filas = ps.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Libro actualizado correctamente.");
	        } else {
	            System.out.println("No se encontró el libro con ID: " + libro.getId());
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al actualizar libro: " + e.getMessage());
	    }
	}


	@Override
	public void eliminarLibro(int id) {
	    String checkSql = "SELECT COUNT(*) FROM prestamo WHERE id = ?";
	    try (PreparedStatement ps = con.prepareStatement(checkSql)) {
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next() && rs.getInt(1) > 0) {
	            System.out.println("No se puede eliminar el libro, tiene préstamos registrados.");
	            return;
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al verificar préstamos del libro: " + e.getMessage());
	        return;
	    }

	    String sql = "DELETE FROM libro WHERE id = ?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        int filas = ps.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Libro eliminado correctamente.");
	        } else {
	            System.out.println("No se encontró el libro con ID: " + id);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al eliminar el libro: " + e.getMessage());
	    }
	}


}
