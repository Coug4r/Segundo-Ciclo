package javaapplicationpoo;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombreCompleto;
    private double acd;  // nota de ACD
    private double aa;   // nota de AA
    private double ape;  // nota de APE

    public Estudiante(String nombreCompleto, double ACD, double AA, double APE) {
        this.nombreCompleto = nombreCompleto;
        this.acd = ACD;
        this.aa = AA;
        this.ape = APE;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getACD() {
        return acd;
    }

    public double getAA() {
        return aa;
    }

    public double getAPE() {
        return ape;
    }

    @Override
    public String toString() {
        return "Estudiante [nombreCompleto=" + nombreCompleto +
               ", ACD=" + acd +
               ", AA=" + aa +
               ", APE=" + ape + "]";
    }
}
