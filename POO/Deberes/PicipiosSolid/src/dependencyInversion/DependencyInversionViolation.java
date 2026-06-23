package dependencyInversion;

// Compilar: javac DependencyInversionViolation.java
// Ejecutar: java DependencyInversionViolation
public class DependencyInversionViolation {
    public static void main(String[] args) {
        Service s = new Service();
        s.doWork();
    }
}

class FileLogger {
    public void log(String m){ System.out.println("Log a archivo: " + m); }
}

class Service {
    private FileLogger logger = new FileLogger(); // dependencia concreta
    public void doWork(){
        logger.log("Iniciando trabajo");
    }
}
