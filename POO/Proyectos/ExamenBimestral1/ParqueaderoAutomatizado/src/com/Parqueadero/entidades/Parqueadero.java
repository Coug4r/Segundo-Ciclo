package com.Parqueadero.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero implements Serializable{
	private String nombre;
	private List<Ticket> tikects;
	private int capacidadMaxima;
	private int contadorTickets;
	
	public Parqueadero(String nombre, int capacidadMaxima) {
		super();
		this.nombre = nombre;
		this.capacidadMaxima = capacidadMaxima;
		this.tikects = new ArrayList<Ticket>();
		this.contadorTickets = 0; 
	}
	
	public void registrarIngreso(Vehiculo veh,int horaEntrada) {
		Ticket nuevo = new Ticket(horaEntrada,veh);
		tikects.add(nuevo);
	}
	public Ticket buscarTicketPorPlaca(String placa) {
		Ticket res = null;
		for(Ticket t:tikects) {
			if(t.getVehiculoAsociado().getPlaca().equals(placa)) {
				res = t;
			}
		}
		return res;
	}
	public double procesarSalida(String placa, int horaSalida) {
		Ticket ticket = buscarTicketPorPlaca(placa);
		double total = 0;
		if(ticket != null) {
			ticket.setHoraSalida(horaSalida);
			int horas = ticket.calcularHorasPermanencia();
			if(ticket.getHoraEntrada()>ticket.getHoraSalida()) {
				System.err.println("Error cambio de dia no soportado!");
				return 0;
			}
			if(ticket.getVehiculoAsociado().getTipo().equals("Auto")) {
				total = horas * 2;
			}else if(ticket.getVehiculoAsociado().getTipo().equals("Moto")) {
				total = horas;
			}else {System.out.println("Tipo de vehiculo incorrecto");}
			if(horas>5) {
				total = total - (total*0.1);
			}
			ticket.setActivo(false);
			return total;
		}else {
			System.err.println("Vehiculo con placas "+placa+" no encontrado en el sistema!");
			return total;
		}
		
	}
	
}
