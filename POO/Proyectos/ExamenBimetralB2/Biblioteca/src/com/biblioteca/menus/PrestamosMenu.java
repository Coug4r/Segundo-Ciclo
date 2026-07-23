package com.biblioteca.menus;

import java.util.Scanner;
import java.util.List;
import com.biblioteca.dao.PrestamoDAO;
import com.biblioteca.entidades.Prestamo;

public class PrestamosMenu {

    private PrestamoDAO prestamoDAO = new PrestamoDAO();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("======== PRÉSTAMOS ==========");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Listar préstamos");
            System.out.println("3. Registrar devolución");
            System.out.println("4. Consultar préstamos activos");
            System.out.println("5. Consultar historial");
            System.out.println("6. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> listarPrestamos();
                case 3 -> registrarDevolucion();
                case 4 -> listarActivos();
                case 5 -> listarHistorial();
                case 6 -> System.out.println("Regresando al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private void registrarPrestamo() {
        System.out.print("ID Usuario: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        System.out.print("ID Libro: ");
        int idLibro = sc.nextInt();
        sc.nextLine();
        System.out.print("Fecha préstamo (YYYY-MM-DD): ");
        String fechaPrestamo = sc.nextLine();

        Prestamo prestamo = new Prestamo(0, idUsuario, idLibro, fechaPrestamo, "ACTIVO");
        prestamoDAO.insertar(prestamo);
    }

    private void listarPrestamos() {
        List<Prestamo> prestamos = prestamoDAO.listar();
        if (prestamos != null) {
            for (Prestamo p : prestamos) {
                System.out.println(p.getId() + " - Usuario: " + p.getUsuarioId() +
                                   " - Libro: " + p.getLibroId() +
                                   " - Prestado: " + p.getFechaPrestamo() +
                                   " - Devolución: " + p.getFechaDevolucion() +
                                   " - Estado: " + p.getEstado());
            }
        }
    }

    private void registrarDevolucion() {
        System.out.print("Ingrese ID del préstamo a devolver: ");
        int idPrestamo = sc.nextInt();
        sc.nextLine();
        prestamoDAO.registrarDevolucion(idPrestamo);
    }

    private void listarActivos() {
        List<Prestamo> prestamos = prestamoDAO.listarActivos();
        if (prestamos != null) {
            for (Prestamo p : prestamos) {
                System.out.println(p.getId() + " - Usuario: " + p.getUsuarioId() +
                                   " - Libro: " + p.getLibroId() +
                                   " - Prestado: " + p.getFechaPrestamo() +
                                   " - Estado: " + p.getEstado());
            }
        }
    }

    private void listarHistorial() {
        List<Prestamo> prestamos = prestamoDAO.listarHistorial();
        if (prestamos != null) {
            for (Prestamo p : prestamos) {
                System.out.println(p.getId() + " - Usuario: " + p.getUsuarioId() +
                                   " - Libro: " + p.getLibroId() +
                                   " - Prestado: " + p.getFechaPrestamo() +
                                   " - Devuelto: " + p.getFechaDevolucion() +
                                   " - Estado: " + p.getEstado());
            }
        }
    }
}
