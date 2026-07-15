package ejercicios;

public class ListaSimple {

    // Clase interna que representa un nodo de la lista
    static class Nodo {
        int dato;
        Nodo sig;

        Nodo(int dato) {
            this.dato = dato;
            this.sig = null;
        }
    }

    Nodo cabeza;

    // Inserta un valor al final de la lista
    void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.sig != null) {
            actual = actual.sig;
        }
        actual.sig = nuevo;
    }

    // Imprime la lista en el formato: lista -> v1 -> v2 -> ... -> NULL
    void mostrarLista() {
        Nodo actual = cabeza;
        StringBuilder sb = new StringBuilder("lista -> ");
        while (actual != null) {
            sb.append(actual.dato).append(" -> ");
            actual = actual.sig;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }

    /* ---------- EJERCICIO 1 ---------- */
    // Elimina el nodo que contiene el valor mayor de toda la lista
    void eliminarNodoMayor() {
        if (cabeza == null) return;

        Nodo actual = cabeza;
        Nodo anterior = null;

        Nodo mayor = cabeza;
        Nodo anteriorDelMayor = null;

        while (actual != null) {
            if (actual.dato > mayor.dato) {
                mayor = actual;
                anteriorDelMayor = anterior;
            }
            anterior = actual;
            actual = actual.sig;
        }

        if (anteriorDelMayor == null) {
            // El nodo mayor es la cabeza de la lista
            cabeza = mayor.sig;
        } else {
            anteriorDelMayor.sig = mayor.sig;
        }
    }

    /* ---------- EJERCICIO 2 ---------- */
    // Elimina todos los nodos cuyo valor sea mayor que 'limite'
    void eliminarMayoresQueLimite(int limite) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.dato > limite) {
                if (anterior == null) {
                    cabeza = actual.sig;
                    actual = cabeza;
                } else {
                    anterior.sig = actual.sig;
                    actual = actual.sig;
                }
            } else {
                anterior = actual;
                actual = actual.sig;
            }
        }
    }

    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        int[] valores = {56, 36, 95, 13, 25, 69};

        for (int v : valores) {
            lista.insertarFinal(v);
        }

        System.out.println("=== Ejercicio 1: eliminar el nodo con el valor mayor ===");
        System.out.println("Lista original:");
        lista.mostrarLista();
        lista.eliminarNodoMayor();
        System.out.println("Lista despues de eliminar el nodo con el valor mayor:");
        lista.mostrarLista();

        // Reconstruimos la lista original para probar el ejercicio 2
        ListaSimple lista2 = new ListaSimple();
        for (int v : valores) {
            lista2.insertarFinal(v);
        }

        System.out.println("\n=== Ejercicio 2: eliminar elementos mayores que un limite ===");
        System.out.println("Lista original:");
        lista2.mostrarLista();
        int limite = 43;
        lista2.eliminarMayoresQueLimite(limite);
        System.out.println("Lista resultante (limite = " + limite + "):");
        lista2.mostrarLista();
    }
}
