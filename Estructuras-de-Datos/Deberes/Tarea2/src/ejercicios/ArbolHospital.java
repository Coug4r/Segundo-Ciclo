package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class ArbolHospital {

    // Clase interna que representa un nodo del arbol
    static class NodoHospital {
        String codigo;
        String nombre;
        List<NodoHospital> hijos;

        NodoHospital(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.hijos = new ArrayList<>();
        }

        void agregarHijo(NodoHospital hijo) {
            hijos.add(hijo);
        }
    }

    NodoHospital raiz;

    // Construye el arbol exactamente como se muestra en la figura del enunciado
    void crearArbolHospital() {
        raiz = new NodoHospital("C00", "Enfermedades cardiovasculares");

        NodoHospital cardiopatias = new NodoHospital("C01", "Cardiopatias");
        NodoHospital vasculares = new NodoHospital("C02", "Enfermedades vasculares");
        raiz.agregarHijo(cardiopatias);
        raiz.agregarHijo(vasculares);

        NodoHospital infarto = new NodoHospital("C011", "Infarto");
        NodoHospital insuficiencia = new NodoHospital("C012", "Insuficiencia");
        cardiopatias.agregarHijo(infarto);
        cardiopatias.agregarHijo(insuficiencia);

        NodoHospital aneurisma = new NodoHospital("C021", "Aneurisma");
        NodoHospital aterosclerosis = new NodoHospital("C022", "Aterosclerosis");
        vasculares.agregarHijo(aneurisma);
        vasculares.agregarHijo(aterosclerosis);

        NodoHospital arritmias = new NodoHospital("C0111", "Arritmias");
        infarto.agregarHijo(arritmias);

        NodoHospital shock = new NodoHospital("C0121", "Shock cardiogenico");
        insuficiencia.agregarHijo(shock);
    }

    // Muestra todos los nodos del arbol (recorrido preorden, con sangria por nivel)
    void mostrarNodos() {
        mostrarNodosRec(raiz, 0);
    }

    private void mostrarNodosRec(NodoHospital nodo, int nivel) {
        if (nodo == null) return;
        StringBuilder sangria = new StringBuilder();
        for (int i = 0; i < nivel; i++) sangria.append("  ");
        System.out.println(sangria + "- [" + nodo.codigo + "] " + nodo.nombre);

        for (NodoHospital hijo : nodo.hijos) {
            mostrarNodosRec(hijo, nivel + 1);
        }
    }

    // Muestra cada nodo padre junto con la lista de sus hijos directos
    void mostrarPadresHijos() {
        mostrarPadresHijosRec(raiz);
    }

    private void mostrarPadresHijosRec(NodoHospital nodo) {
        if (nodo == null) return;

        if (!nodo.hijos.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Padre: [").append(nodo.codigo).append("] ").append(nodo.nombre);
            sb.append("  ->  Hijos: ");
            for (int i = 0; i < nodo.hijos.size(); i++) {
                NodoHospital hijo = nodo.hijos.get(i);
                sb.append("[").append(hijo.codigo).append("] ").append(hijo.nombre);
                if (i < nodo.hijos.size() - 1) sb.append(", ");
            }
            System.out.println(sb.toString());
        }

        for (NodoHospital hijo : nodo.hijos) {
            mostrarPadresHijosRec(hijo);
        }
    }

    // Muestra los nodos hoja (los que no tienen ningun hijo)
    void mostrarHojas() {
        mostrarHojasRec(raiz);
    }

    private void mostrarHojasRec(NodoHospital nodo) {
        if (nodo == null) return;

        if (nodo.hijos.isEmpty()) {
            System.out.println("- [" + nodo.codigo + "] " + nodo.nombre);
        }

        for (NodoHospital hijo : nodo.hijos) {
            mostrarHojasRec(hijo);
        }
    }

    public static void main(String[] args) {
        ArbolHospital arbol = new ArbolHospital();
        arbol.crearArbolHospital();

        System.out.println("=== Todos los nodos del arbol (recorrido preorden) ===");
        arbol.mostrarNodos();

        System.out.println("\n=== Padres junto a sus hijos ===");
        arbol.mostrarPadresHijos();

        System.out.println("\n=== Nodos hoja ===");
        arbol.mostrarHojas();
    }
}
