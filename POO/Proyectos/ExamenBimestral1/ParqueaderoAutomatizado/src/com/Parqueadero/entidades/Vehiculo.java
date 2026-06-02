package com.Parqueadero.entidades;

import java.io.Serializable;

public class Vehiculo implements Serializable{
	private String placa;
	private String marca;
	private String tipo;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Vehiculo(String placa, String marca, String tipo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.tipo = tipo;
	}
	
	public void mostrarDatos() {
		String msg = "Placa: "+placa+"\nMarca: "+marca+"\nTipo: "+tipo;
		System.out.println(msg);
	}
}
