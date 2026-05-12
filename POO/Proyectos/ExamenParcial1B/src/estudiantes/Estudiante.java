package estudiantes;

public class Estudiante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] notas1 = {10,8,5,9,4};
		double[] notas2 = {7,8,5.5,9,4};
		double[] notas3 = {5,4.3,5,9.2,4};
		double[] notas4 = {0,0,0,0,0.0};
		
		EstudianteMet est1 =  new EstudianteMet("David", notas1);
		EstudianteMet est2 =  new EstudianteMet("Paco", notas2);
		EstudianteMet est3 =  new EstudianteMet("Pedro", notas3);
		EstudianteMet est4 =  new EstudianteMet("Juan", notas4);
		
		System.out.println("El estudiante "+est1.getNombre()+" esta "+est1.estado(notas1));
		System.out.println("El estudiante "+est2.getNombre()+" esta "+est2.estado(notas1));
		System.out.println("El estudiante "+est3.getNombre()+" esta "+est3.estado(notas1));
		System.out.println("El estudiante "+est4.getNombre()+" esta "+est4.estado(notas1));
	}
}
class EstudianteMet {
		private String nombre;
		private double[] notas;
		
		public EstudianteMet(String nombre, double[] notas) {
			super();
			this.nombre = nombre;
			this.notas = notas;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public double[] getNotas() {
			return notas;
		}
		public void setNotas(double[] notas) {
			this.notas = notas;
		}
		
		public double prom(double[] notas) {
			double prom=0;
			for(int i=0; i<notas.length;i++) {
				prom += notas[i];
			}
			return prom/notas.length;
		}
		
		public String estado(double[] not) {
			if(prom(notas)>= 7.0) {
				return "Aprobado";
			}else {
				return "Desaprobado";
			}
		}	
	}



