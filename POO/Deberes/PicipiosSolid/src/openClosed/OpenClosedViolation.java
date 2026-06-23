package openClosed;

// Compilar: javac OpenClosedViolation.java
// Ejecutar: java OpenClosedViolation
public class OpenClosedViolation {
    public static void main(String[] args) {
        Product p = new Product(100.0);
        TaxCalculator calc = new TaxCalculator();
        System.out.println("Sin impuesto: " + calc.applyTax(p.getPrice(), "NONE"));
        System.out.println("IVA: " + calc.applyTax(p.getPrice(), "IVA"));
    }
}

class Product {
    private double price;
    Product(double p){ price = p; }
    double getPrice(){ return price; }
}

class TaxCalculator {
    // Cada vez que aparece un nuevo tipo hay que modificar esta clase
    public double applyTax(double amount, String type) {
        if ("NONE".equals(type)) return amount;
        if ("IVA".equals(type)) return amount * 1.12;
        if ("REDUCIDO".equals(type)) return amount * 1.05;
        return amount;
    }
}
