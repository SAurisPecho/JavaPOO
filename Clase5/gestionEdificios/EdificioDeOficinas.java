package clase5.gestionEdificios;
public class EdificioDeOficinas extends Edificio {

    private int numeroOficinas;
    private int cantidadPersonasPorOficina;
    private int numeroPisos;

    public EdificioDeOficinas(double ancho, double alto, double largo, int numeroOficinas, int cantidadPersonasPorOficina, int numeroPisos) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.cantidadPersonasPorOficina = cantidadPersonasPorOficina;
        this.numeroPisos = numeroPisos;
    }

    @Override
    public double calcularSuperficie() {
        return ancho * largo * numeroPisos;
    }

    @Override
    public double calcularVolumen() {
        return ancho * largo * alto;
    }

    public int cantPersonas() {
        return cantidadPersonasPorOficina * numeroOficinas * numeroPisos;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public int getCantidadPersonasPorOficina() {
        return cantidadPersonasPorOficina;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

}
