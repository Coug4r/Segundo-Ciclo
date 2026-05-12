package ejemplos;

public class LibretaCalificaciones {
	private String estudiante;
	private double promedio;
	private String promedioCualitativo;
	private double[] calificaciones;
	
	public LibretaCalificaciones(String estudiante, double[] calificaciones) {
		super();
		this.estudiante = estudiante;
		this.calificaciones = calificaciones;
	}
	
	public String getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	public String getPromedioCualitativo() {
		return promedioCualitativo;
	}
	public void setPromedioCualitativo(String promedioCualitativo) {
		this.promedioCualitativo = promedioCualitativo;
	}
	public double[] getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(double[] calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	public void promedio() {
		double pro=0;
		for(double c : calificaciones) {
			pro += c;
		}
		this.promedio =  pro/calificaciones.length;
	}
	public void promedioCualitativo() {
		String prom;
		if(promedio>=0 && promedio < 3.09) {
			prom = "Regular";
		}else if(promedio>= 3.1 && promedio<=5.09) {
			prom = "Insuficiente";
		}else if(promedio>=5.1 && promedio<=7.09) {
			prom = "Bueno";
		}else if(promedio>=7.1 && promedio<=9.09) {
			prom = "Muy Bueno";
		}else if(promedio>=9.1 && promedio<=10) {
			prom = "Sobresaliente";
		}else {
			prom = "Sin Rango";
		}
		this.promedioCualitativo = prom;
	}
	public void info() {
		promedio();
		promedioCualitativo();
		System.out.printf("\nEstudiante: %s\nPromedio: %.2f \nPromedio cualitativo: %s\nCalificaciones: \n ",estudiante,promedio,promedioCualitativo);
		for(double c :  calificaciones) {
			System.out.printf("[%.2f]",c);
		}
	}
}
