package clase6.Geometria;
public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(8);
        Rectangulo rectangulo = new Rectangulo(9, 5);
        Triangulo triangulo = new Triangulo(6, 4, 5, 7, 9);

        System.out.println("Circulo:\nArea: "+circulo.calcularArea()+"\nPerimetro: "+circulo.calcularPerimetro());
        System.out.println("Rectangulo:\nArea: "+rectangulo.calcularArea()+"\nPerimetro: "+rectangulo.calcularPerimetro());
        System.out.println("Triangulo:\nArea: "+triangulo.calcularArea()+"\nPerimetro: "+triangulo.calcularPerimetro());

        circulo.dibujar();
        rectangulo.dibujar();
        triangulo.dibujar();
    }
}
