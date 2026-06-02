package com.notas.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javaapplicationpoo.Estudiante;

public class NotasDavidBurneo {
    public static void main(String[] args) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("notas4.dat"))) {
            Estudiante est = (Estudiante) entrada.readObject();
            System.out.println("Objeto deserializado: " + est);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
