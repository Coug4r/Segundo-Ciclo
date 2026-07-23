package com.biblioteca.menus;

	import java.util.List;
import java.util.Scanner;

import com.biblioteca.dao.PrestamoDAO;
import com.biblioteca.entidades.Prestamo;

	public class MenuPrincipal {

	    private Scanner sc = new Scanner(System.in);
	    private UsuariosMenu menuUsuarios = new UsuariosMenu();
	    private LibrosMenu menuLibros = new LibrosMenu();
	    private PrestamosMenu menuPrestamos = new PrestamosMenu();
	    private PrestamoDAO prestamoDAO = new PrestamoDAO();

	    public void mostrarMenu() {
	        int opcion;
	        do {
	            System.out.println("================================");
	            System.out.println("    SISTEMA DE BIBLIOTECA");
	            System.out.println("================================");
	            System.out.println("1. Gestionar usuarios");
	            System.out.println("2. Gestionar libros");
	            System.out.println("3. Gestionar préstamos");
	            System.out.println("4. Consultar préstamos activos");
	            System.out.println("5. Consultar historial");
	            System.out.println("6. Salir");
	            System.out.print("Seleccione una opción: ");
	            opcion = sc.nextInt();
	            sc.nextLine(); // limpiar buffer

	            switch (opcion) {
	                case 1 -> menuUsuarios.mostrarMenu();
	                case 2 -> menuLibros.mostrarMenu();
	                case 3 -> menuPrestamos.mostrarMenu();
	                case 4 -> listarActivos();
	                case 5 -> listarHistorial();
	                case 6 -> System.out.println("Saliendo del sistema...");
	                default -> System.out.println("Opción inválida.");
	            }
	        } while (opcion != 6);
	    }

	    private void listarActivos() {
	        List<Prestamo> prestamos = prestamoDAO.listarActivos();
	        if (prestamos != null) {
	            System.out.println("=== Préstamos Activos ===");
	            for (Prestamo p : prestamos) {
	                System.out.println(p.getId() + " - Usuario: " + p.getUsuarioId() +
	                                   " - Libro: " + p.getLibroId() +
	                                   " - Fecha préstamo: " + p.getFechaPrestamo() +
	                                   " - Estado: " + p.getEstado());
	            }
	        }
	    }

	    private void listarHistorial() {
	        List<Prestamo> prestamos = prestamoDAO.listarHistorial();
	        if (prestamos != null) {
	            System.out.println("=== Historial de Préstamos ===");
	            for (Prestamo p : prestamos) {
	                System.out.println(p.getId() + " - Usuario: " + p.getUsuarioId() +
	                                   " - Libro: " + p.getLibroId() +
	                                   " - Fecha préstamo: " + p.getFechaPrestamo() +
	                                   " - Fecha devolución: " + p.getFechaDevolucion() +
	                                   " - Estado: " + p.getEstado());
	            }
	        }
	    }
	}
