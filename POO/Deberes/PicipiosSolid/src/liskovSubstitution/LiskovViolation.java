package liskovSubstitution;

// Compilar: javac LiskovViolation.java
// Ejecutar: java LiskovViolation
public class LiskovViolation {
    public static void main(String[] args) {
        Rectangle r = new Square(); // rompe expectativas
        r.setWidth(5);
        r.setHeight(4);
        System.out.println("Area esperada 20 pero Square dará: " + r.area());
    }
}

class Rectangle {
    protected int width, height;
    public void setWidth(int w){ width = w; }
    public void setHeight(int h){ height = h; }
    public int area(){ return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int w){ width = w; height = w; }
    @Override
    public void setHeight(int h){ width = h; height = h; }
}
