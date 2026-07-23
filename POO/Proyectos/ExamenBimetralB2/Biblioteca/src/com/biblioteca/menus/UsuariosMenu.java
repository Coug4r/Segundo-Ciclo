package com.biblioteca.menus;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.dao.UsuarioDAO;
import com.biblioteca.entidades.Docente;
import com.biblioteca.entidades.Estudiante;
import com.biblioteca.entidades.Investigador;
import com.biblioteca.entidades.Usuario;

public class UsuariosMenu {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("========= USUARIOS ==========");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    buscarUsuario();
                    break;
                case 4:
                    actualizarUsuario();
                    break;
                case 5:
                    eliminarUsuario();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private void registrarUsuario() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Tipo (Estudiante/Docente/Investigador): ");
        String tipo = sc.nextLine();

        Usuario usuario = null;
        switch (tipo) {
            case "Estudiante":
                usuario = new Estudiante(0, nombre, correo);
                break;
            case "Docente":
                usuario = new Docente(0, nombre, correo);
                break;
            case "Investigador":
                usuario = new Investigador(0, nombre, correo);
                break;
            default:
                System.out.println("Tipo inválido. Debe ser Estudiante, Docente o Investigador.");
                return;
        }

        usuarioDAO.crear(usuario);
    }

    private void listarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listar();
        if (usuarios != null) {
            for (Usuario u : usuarios) {
                u.mostrarInfo();
            }
        }
    }

    private void buscarUsuario() {
        System.out.print("Ingrese ID del usuario: ");
        int id = sc.nextInt();
        sc.nextLine();
        Usuario usuario = usuarioDAO.buscarPorID(id);
        if (usuario != null) {
            usuario.mostrarInfo();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private void actualizarUsuario() {
        System.out.print("Ingrese ID del usuario a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Usuario usuario = usuarioDAO.buscarPorID(id);
        if (usuario != null) {
            System.out.print("Nuevo nombre: ");
            usuario.setNombre(sc.nextLine());
            System.out.print("Nuevo correo: ");
            usuario.setCorreo(sc.nextLine());
            System.out.print("Nuevo tipo: ");
            usuario.setTipo(sc.nextLine());
            usuarioDAO.actualizarUsuario(usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private void eliminarUsuario() {
        System.out.print("Ingrese ID del usuario a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        usuarioDAO.eliminarUsuario(id);
    }
}
