package com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.database.Conexion;
import com.biblioteca.entidades.Libro;
import com.biblioteca.entidades.Prestamo;
import com.biblioteca.interfaces.PrestamoDAOInterfas;

public class PrestamoDAO implements PrestamoDAOInterfas {

    Connection con = Conexion.DbConection();

    @Override
    public void insertar(Prestamo prestamo) {
        LibroDAO libroDAO = new LibroDAO();
        Libro libro = libroDAO.buscarPorID(prestamo.getLibroId());

        if (libro == null) {
            System.out.println("El libro no existe.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible para préstamo.");
            return;
        }

        String sql = "INSERT INTO prestamo(usuario_id , libro_id, fecha_prestamo , estado) VALUES (?,?,?,?);";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, prestamo.getUsuarioId());
            ps.setInt(2, prestamo.getLibroId());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, "ACTIVO"); // siempre inicia como ACTIVO

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Préstamo registrado correctamente.");

                // Cambiar estado del libro a NO DISPONIBLE
                libro.setDisponible(false);
                libroDAO.actualizarInformacion(libro);
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar préstamo: " + e.getMessage());
        }
    }


    @Override
    public Prestamo buscarPorId(int id) {
        String sql = "SELECT * FROM prestamo WHERE id = ?;";
        Prestamo prestamo = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prestamo = new Prestamo(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getInt("libro_id"),
                    rs.getString("fecha_prestamo"),
                    rs.getString("estado")
                );

                LibroDAO libroDAO = new LibroDAO();
                Libro libro = libroDAO.buscarPorID(prestamo.getLibroId());
                if (libro == null) {
                    System.out.println("Libro no encontrado");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar préstamo: " + e.getMessage());
        }
        return prestamo;
    }

    @Override
    public List<Prestamo> listar() {
        String sql = "SELECT * FROM prestamo;";
        List<Prestamo> prestamos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getInt("libro_id"),
                    rs.getString("fecha_prestamo"),
                    rs.getString("estado")
                );
                prestamos.add(prestamo);
            }
            return prestamos;
        } catch (SQLException e) {
            System.err.println("Error al listar préstamos: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        String sql = "UPDATE prestamo SET usuario_id=?, libro_id=?, fecha_prestamo=?, fecha_devolucion=?, estado=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, prestamo.getUsuarioId());
            ps.setInt(2, prestamo.getLibroId());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, prestamo.getFechaDevolucion());
            ps.setString(5, prestamo.getEstado());
            ps.setInt(6, prestamo.getId());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Préstamo actualizado correctamente.");
            } else {
                System.out.println("No se encontró el préstamo con ID: " + prestamo.getId());
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar préstamo: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM prestamo WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Préstamo eliminado correctamente.");
            } else {
                System.out.println("No se encontró el préstamo con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar préstamo: " + e.getMessage());
        }
    }

    @Override
    public List<Prestamo> listarActivos() {
        String sql = "SELECT * FROM prestamo WHERE estado = 'ACTIVO';";
        List<Prestamo> prestamos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getInt("libro_id"),
                    rs.getString("fecha_prestamo"),
                    rs.getString("estado")
                );
                prestamos.add(prestamo);
            }
            return prestamos;
        } catch (SQLException e) {
            System.err.println("Error al listar préstamos activos: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Prestamo> listarHistorial() {
        String sql = "SELECT * FROM prestamo WHERE estado = 'DEVUELTO';";
        List<Prestamo> prestamos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getInt("libro_id"),
                    rs.getString("fecha_prestamo"),
                    rs.getString("estado")
                );
                prestamos.add(prestamo);
            }
            return prestamos;
        } catch (SQLException e) {
            System.err.println("Error al listar historial de préstamos: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void registrarDevolucion(int idPrestamo) {
        String sql = "UPDATE prestamo SET estado = 'DEVUELTO', fecha_devolucion = date('now') WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPrestamo);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Devolución registrada correctamente.");
                Prestamo prestamo = buscarPorId(idPrestamo);
                if (prestamo != null) {
                    LibroDAO libroDAO = new LibroDAO();
                    Libro libro = libroDAO.buscarPorID(prestamo.getLibroId());
                    if (libro != null) {
                        libro.setDisponible(true);
                        libroDAO.actualizarInformacion(libro);
                        System.out.println("El libro con ID " + libro.getId() + " ahora está DISPONIBLE.");
                    }
                }
            } else {
                System.out.println("No se encontró el préstamo con ID: " + idPrestamo);
            }
        } catch (SQLException e) {
            System.err.println("Error al registrar devolución: " + e.getMessage());
        }
    }

}
