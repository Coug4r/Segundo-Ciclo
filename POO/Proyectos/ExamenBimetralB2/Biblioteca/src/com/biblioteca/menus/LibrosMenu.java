package com.biblioteca.menus;

import java.util.Scanner;
import java.util.List;
import com.biblioteca.dao.LibroDAO;
import com.biblioteca.entidades.Libro;

public class LibrosMenu {

    private LibroDAO libroDAO = new LibroDAO();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("========== LIBROS ===========");
            System.out.println("1. Registrar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> listarLibros();
                case 3 -> buscarLibro();
                case 4 -> actualizarLibro();
                case 5 -> eliminarLibro();
                case 6 -> System.out.println("Regresando al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private void registrarLibro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Disponible (true/false): ");
        boolean disponible = sc.nextBoolean();
        sc.nextLine();

        Libro libro = new Libro(0, titulo, autor, isbn, disponible); // id autoincrementado
        libroDAO.crear(libro);
    }

    private void listarLibros() {
        List<Libro> libros = libroDAO.listar();
        if (libros != null) {
            for (Libro l : libros) {
                System.out.println(l.getId() + " - " + l.getTitulo() + " - " + l.getAutor() + " - " + l.getIsbn() + " - Disponible: " + l.isDisponible());
            }
        }
    }

    private void buscarLibro() {
        System.out.print("Ingrese ID del libro: ");
        int id = sc.nextInt();
        sc.nextLine();
        Libro libro = libroDAO.buscarPorID(id);
        if (libro != null) {
            System.out.println(libro.getId() + " - " + libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getIsbn() + " - Disponible: " + libro.isDisponible());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void actualizarLibro() {
        System.out.print("Ingrese ID del libro a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Libro libroExistente = libroDAO.buscarPorID(id);
        if (libroExistente != null) {
            System.out.print("Nuevo título: ");
            String titulo = sc.nextLine();
            System.out.print("Nuevo autor: ");
            String autor = sc.nextLine();
            System.out.print("Nuevo ISBN: ");
            String isbn = sc.nextLine();
            System.out.print("Disponible (true/false): ");
            boolean disponible = sc.nextBoolean();
            sc.nextLine();
            Libro libroActualizado = new Libro(id, titulo, autor, isbn, disponible);
            libroDAO.actualizarInformacion(libroActualizado);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
    private void eliminarLibro() {
        System.out.print("Ingrese ID del libro a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        libroDAO.eliminarLibro(id);
    }
}
