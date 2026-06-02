package com.Parqueadero.main;

import com.Parqueadero.entidades.Parqueadero;
import com.Parqueadero.entidades.Vehiculo;
import com.Parqueadero.utilitarios.GestorArchivo;

public class TestParqueadero {

	public static void main(String[] args) {
		Parqueadero parq1 = new Parqueadero("PARQUEADERO UTPL", 10);
		Vehiculo auto1 = new Vehiculo("LBA123", "FORD", "Auto");
		Vehiculo auto2 = new Vehiculo("IG003C", "KTM", "Moto");
		parq1.registrarIngreso(auto1, 12);
		parq1.registrarIngreso(auto2, 14);
		System.out.println("El vehiculo con placa "+auto1.getPlaca()+" debe pagar: "+parq1.procesarSalida("LBA123", 15)+" USD");
		System.out.println("El vehiculo con placa "+auto2.getPlaca()+" debe pagar: "+parq1.procesarSalida("IG003C", 18)+" USD");
		GestorArchivo.guardarEstado(parq1);
		
		Parqueadero parqRecuperado = GestorArchivo.cargarEstado();
		System.out.println("El vehiculo con placa "+auto2.getPlaca()+" debe pagar: "+parqRecuperado.procesarSalida("IG003C", 18)+" USD");
	}

}
