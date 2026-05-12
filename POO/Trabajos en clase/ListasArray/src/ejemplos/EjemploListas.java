package ejemplos;

import java.util.HashMap;
import java.util.Map;

public class EjemploListas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] ciudades = new String [3];
		ciudades[0] = "Loja";
		ciudades[1] = "Quito";
		ciudades[2] = "Guayaquil";
		
		String [] provincia = new String [3];
		provincia[0] = "Loja";
		provincia[1] = "Pichincha";
		provincia[2] = "Guayas";
		
		Map<String, String> reglas = new HashMap<>();
        reglas.put("Loja", "Loja");
        reglas.put("Quito", "Pichincha");
        reglas.put("Guayaquil", "Guayas");
        
        for (int i = 0; i < ciudades.length; i++) {
            String ciudad = ciudades[i];
            String prov = provincia[i];

            if (reglas.containsKey(ciudad) && reglas.get(ciudad).equals(prov)) {
                System.out.println("Coincidencia: " + ciudad + " -> " + prov);
            }
        }	
	}

}
