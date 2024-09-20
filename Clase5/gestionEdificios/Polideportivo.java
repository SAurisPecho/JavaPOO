package clase5.gestionEdificios;
public class Polideportivo extends Edificio {

    private String nombre;
    private String tipoInstalacion;

    public Polideportivo(double ancho, double alto, double largo, String nombre, String tipoInstalacion) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    @Override
    public double calcularSuperficie() {
        return ancho * largo;
    }

    @Override
    public double calcularVolumen() {
        return largo * ancho * alto;
    }
}