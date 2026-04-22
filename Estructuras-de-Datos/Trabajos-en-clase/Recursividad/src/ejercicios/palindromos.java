package ejercicios;

public class palindromos {

	public static void main(String[] args) {
		String palabra1 = "oso";
        String palabra2 = "holamundo";

        System.out.println(palabra1 + " -> " + esPalindromo(palabra1));
        System.out.println(palabra2 + " -> " + esPalindromo(palabra2));
	}
	public static boolean esPalindromo(String texto) {
		int inicio = 0;
		int fin = texto.length()-1;
        if (inicio >= fin) {
            return true;
        }
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }
        return esPalindromo(texto.substring(1, texto.length() - 1));
    }
}
