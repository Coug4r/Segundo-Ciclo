package com.biblioteca.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static Connection DbConection() {
		try {
			String jdbcUrl = "jdbc:sqlite:C:\\Users\\nasnd\\OneDrive\\Desktop\\UTPL\\PROGRAMACION CLASES\\Segundo-Ciclo\\POO\\Proyectos\\ExamenBimetralB2\\Biblioteca\\biblioteca";
			Connection conexion = DriverManager.getConnection(jdbcUrl);
			System.out.println("Conexion exitosa!");
			return conexion;
		} catch (Exception e) {
			System.err.println("Error en la conexiona la base de datos!");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
