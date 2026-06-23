package interfaceSegregation;

// Compilar: javac InterfaceSegregationViolation.java
// Ejecutar: java InterfaceSegregationViolation
public class InterfaceSegregationViolation {
    public static void main(String[] args) {
        Worker w = new Robot();
        w.work();
        w.eat(); // lanza excepción porque Robot no come
    }
}

interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work(){ System.out.println("Robot trabaja"); }
    public void eat(){ throw new UnsupportedOperationException("Robots no comen"); }
}
