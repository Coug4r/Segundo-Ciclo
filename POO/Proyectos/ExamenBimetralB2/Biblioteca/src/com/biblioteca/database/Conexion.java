package com.biblioteca.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static Connection DbConection() {
		try {
			String jdbcUrl = "jdbc:sqlite:C:/Users/nasnd/OneDrive/Documentos/sqlite-tools-win-x64-3530300/biblioteca";
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
