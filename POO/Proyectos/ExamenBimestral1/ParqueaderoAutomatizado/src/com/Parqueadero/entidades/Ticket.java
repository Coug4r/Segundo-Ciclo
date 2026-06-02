package com.Parqueadero.entidades;

import java.io.Serializable;

public class Ticket implements Serializable{
	private int numeroTicket = 0;
	private int horaEntrada;
	private int horaSalida;
	private boolean activo;
	private Vehiculo vehiculoAsociado;
	
	public Ticket( int horaEntrada, Vehiculo vehiculoAsociado) {
		super();
		this.numeroTicket = numeroTicket++;
		this.horaEntrada = horaEntrada;
		this.horaSalida=0;
		this.activo = true;
		this.vehiculoAsociado = vehiculoAsociado;
	}
	
	public int getNumeroTicket() {
		return numeroTicket;
	}
	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	public int getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public int getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Vehiculo getVehiculoAsociado() {
		return vehiculoAsociado;
	}
	public void setVehiculoAsociado(Vehiculo vehiculoAsociado) {
		this.vehiculoAsociado = vehiculoAsociado;
	}
	
	public int calcularHorasPermanencia() {
		return this.horaSalida - this.horaEntrada;
	}
	
}
