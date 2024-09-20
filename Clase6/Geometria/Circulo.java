package clase6.Geometria;
public class Circulo extends Figura implements Dibujable{
    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Se ha dibujado un circulo.");
    }

}
