package com.sqliteJava.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class PooDB {
    public static Connection ConnectionDB() {
        System.out.println("GESTIÓN DE LA BASE DE DATOS CON SQLITE");
        try {
            String jdbcUrl = "jdbc:sqlite:C:\\Users\\nasnd\\OneDrive\\Documentos\\sqlite-tools-win-x64-3530300\\poodb";
            Connection connection = DriverManager.getConnection(jdbcUrl);
            System.out.println("Conexión exitosa!");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
