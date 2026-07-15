package ejercicios;

public class ArbolBinario {

    // Clase interna que representa un nodo del arbol
    static class NodoArbol {
        int dato;
        NodoArbol izq;
        NodoArbol der;

        NodoArbol(int dato) {
            this.dato = dato;
            this.izq = null;
            this.der = null;
        }
    }

    NodoArbol raiz;

    // Inserta un valor en el arbol binario de busqueda
    // (menores a la izquierda, mayores a la derecha)
    void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbol insertarRec(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return new NodoArbol(valor);
        }
        if (valor < nodo.dato) {
            nodo.izq = insertarRec(nodo.izq, valor);
        } else if (valor > nodo.dato) {
            nodo.der = insertarRec(nodo.der, valor);
        }
        return nodo;
    }

    // Busca el numero mayor del arbol: es el nodo mas a la derecha
    int buscarMayor() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return -1;
        }
        NodoArbol actual = raiz;
        while (actual.der != null) {
            actual = actual.der;
        }
        return actual.dato;
    }

    // Busca el numero menor del arbol: es el nodo mas a la izquierda
    int buscarMenor() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return -1;
        }
        NodoArbol actual = raiz;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual.dato;
    }

    // Recorrido inorden, util para verificar el contenido del arbol
    void mostrarInorden() {
        mostrarInordenRec(raiz);
        System.out.println();
    }

    private void mostrarInordenRec(NodoArbol nodo) {
        if (nodo == null) return;
        mostrarInordenRec(nodo.izq);
        System.out.print(nodo.dato + " ");
        mostrarInordenRec(nodo.der);
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = {50, 30, 70, 20, 40, 60, 90, 10, 25};

        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.print("Recorrido inorden del arbol (de menor a mayor): ");
        arbol.mostrarInorden();

        System.out.println("Numero mayor del arbol: " + arbol.buscarMayor());
        System.out.println("Numero menor del arbol: " + arbol.buscarMenor());
    }
}
