/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coche;
public class Coche {
    private String color;
    private int velocidad;
    private float tamaño;
    public Coche (String color, int velocidad, float tamaño){
        this.color=color;
        this.velocidad=velocidad;
        this.tamaño=tamaño;
    }
    public void avanzar(){
        System.out.println("El coche "+ this.color +" esta avanzando!");
    }
    public void parar(){
        System.out.println("El coche "+ this.color +" para!");
    }
    public void girarDerecha(){
    System.out.println("El coche "+ this.color +" esta girando a la derecha!");}
    public void girarIzquierda(){
        System.out.println("El coche "+ this.color +" esta girando a la izquierda!");
    }
}
