package com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.database.Conexion;
import com.biblioteca.entidades.Docente;
import com.biblioteca.entidades.Estudiante;
import com.biblioteca.entidades.Investigador;
import com.biblioteca.entidades.Usuario;
import com.biblioteca.interfaces.UsuarioDAOInterfas;

public class UsuarioDAO implements UsuarioDAOInterfas {

    Connection con = Conexion.DbConection();

    @Override
    public void crear(Usuario usuario) {
        String sql = "INSERT INTO usuario(nombre, correo, tipo) VALUES (?,?,?);";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getTipo());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario creado correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
        }
    }

    @Override
    public Usuario buscarPorID(int id) {
        String sql = "SELECT id, nombre, correo, tipo FROM usuario WHERE id = ?;";
        Usuario usuario = null;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idrec = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String tipo = rs.getString("tipo");

                switch (tipo) {
                    case "Estudiante":
                        usuario = new Estudiante(idrec, nombre, correo);
                        break;
                    case "Docente":
                        usuario = new Docente(idrec, nombre, correo);
                        break;
                    case "Investigador":
                        usuario = new Investigador(idrec, nombre, correo);
                        break;
                    default:
                        System.err.println("Tipo de usuario desconocido: " + tipo);
                }
            }
            return usuario;
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario: " + e.getMessage());
            return null;
        }
    }


    @Override
    public List<Usuario> listar() {
        String sql = "SELECT * FROM usuario;";
        List<Usuario> usuarios = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idrec = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String tipo = rs.getString("tipo");

                Usuario usuario = null;
                switch (tipo) {
                    case "Estudiante":
                        usuario = new Estudiante(idrec, nombre, correo);
                        break;
                    case "Docente":
                        usuario = new Docente(idrec, nombre, correo);
                        break;
                    case "Investigador":
                        usuario = new Investigador(idrec, nombre, correo);
                        break;
                    default:
                        System.err.println("Tipo de usuario desconocido: " + tipo);
                }

                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
            return usuarios;
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre = ?, correo = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, usuario.getId());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID: " + usuario.getId());
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}