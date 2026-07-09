package com.sqliteJava.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sqliteJava.conexion.PooDB;
public class Statemens {
	private static Connection con = null;

    static {
        try {
            con = PooDB.ConnectionDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
	public static void Select() {
        try {
            // Crear un Statement
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            String sqlString = "SELECT * FROM estudiantes_2";
            rs = stmt.executeQuery(sqlString);
            while(rs.next()) {
            	System.out.printf("%-5d | %-15s | %-25s | %-3d%n",
            	        rs.getInt("id"),
            	        rs.getString("nombre"),
            	        rs.getString("email"),
            	        rs.getInt("edad")
            	    );
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
       }
	}
	public static void Insert() {
		try {
			Statement st = con.createStatement();
			String sqlString = "INSERT INTO estudiantes_2(nombre,apellido,email,edad) VALUES"+
							   "('Juan', 'Sanches', 'Juan@gmail', 22)";
			st.execute(sqlString);
			System.out.println("\nEstudiante agregado Correctamente");
			Select();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
