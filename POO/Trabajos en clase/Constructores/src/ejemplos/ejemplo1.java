package ejemplos;

public class ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] salario = {600,455,8,900,250.56};
		Persona per1 = new Persona("Juan", 22,"jaun@gmail", salario);
//		per1.setNombre("David");
//		per1.setEdad(20);
////		per1.setEmail("david@gmail");
//		System.out.println("Nombre: "+per1.getNombre());
//		System.out.println("Edad: "+per1.getEdad());
//		System.out.println("Correo: "+per1.getEmail());
		
		per1.info();
		System.out.println("Promedio del salario: "+per1.promSalario(salario));
		
	}
}
	class Persona {
		private String nombre;
		private int edad;
		private String email;
		private double[] salario;
		
		public Persona(String nombre, int edad, String email, double[] salario) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.email = email;
			this.salario = salario;
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void info() {
			System.out.println("Nombre: "+ nombre);
			System.out.println("Edad: "+ edad);
			System.out.println("Correo: "+email);
		}
		public double promSalario(double[] salario) {
			double prom=0;
			for(int i=0;i<salario.length;i++) {
				prom += salario[i];
			}
			return prom/salario.length;
		}
	}	
