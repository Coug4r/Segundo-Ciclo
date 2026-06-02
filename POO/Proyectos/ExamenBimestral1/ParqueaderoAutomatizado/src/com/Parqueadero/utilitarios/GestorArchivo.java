package com.Parqueadero.utilitarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.Parqueadero.entidades.Parqueadero;

public class GestorArchivo {
    public static void guardarEstado(Parqueadero parqueadero) {
        try {
            FileOutputStream archivo = new FileOutputStream("parqueadero.dat");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(parqueadero);
            System.out.println("Respaldo exitoso!");
            salida.close();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static Parqueadero cargarEstado() {
        Parqueadero retorno = null;
        try {
            FileInputStream archivo = new FileInputStream("parqueadero.dat");
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            retorno = (Parqueadero) entrada.readObject();
            System.out.println("Carga exitosa!");
            entrada.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
        return retorno;
    }
}
