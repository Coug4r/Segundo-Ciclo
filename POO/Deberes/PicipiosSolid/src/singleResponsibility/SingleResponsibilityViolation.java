package singleResponsibility;

// Compilar: javac SingleResponsibilityViolation.java
// Ejecutar: java SingleResponsibilityViolation
import java.util.*;

public class SingleResponsibilityViolation {
    public static void main(String[] args) {
        Order o = new Order(Arrays.asList(new Item("A", 2, 10.0)));
        OrderManager m = new OrderManager();
        m.processOrder(o);
    }
}

class Item {
    String name; int qty; double price;
    Item(String n,int q,double p){name=n;qty=q;price=p;}
}

class Order {
    List<Item> items;
    Order(List<Item> items){ this.items = items; }
}

class OrderManager {
    // Valida, calcula total y guarda en BD en la misma clase
    public void processOrder(Order o) {
        if (o == null || o.items.isEmpty()) {
            System.out.println("Orden inválida");
            return;
        }
        double total = 0;
        for (Item it : o.items) total += it.price * it.qty;
        System.out.println("Total: " + total);
        saveToDatabase(o);
    }
    private void saveToDatabase(Order o) {
    	//Simulacion metodo guardar en base de datos
        System.out.println("Guardando orden en la base de datos");
    }
}
