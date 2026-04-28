/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coche;
public class MainCoche {
    public static void main(String[] args) {
        Coche F150 = new Coche("verde", 80,3.2f);
        Coche Camaro = new Coche("rojo", 80,3.2f);
        Coche Pichirilo = new Coche("amarillo", 80,3.2f);
        Coche Mazda = new Coche("azul", 80,3.2f);
        Coche Nissan = new Coche("violeta", 80,3.2f);
        
        F150.avanzar();
        Camaro.parar();
        Pichirilo.avanzar();
        Mazda.girarDerecha();
        Nissan.girarIzquierda();
    }
}