package Modelos;
import java.util.Scanner;

public class Rectangulo {

    private int ancho;
    private int alto;
    private static int contadorRectangulos = 0;

    public Rectangulo() {}

    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        contadorRectangulos++;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        if (alto > 0 ){
            this.alto = alto;
        } else {
            System.out.println("El alto debe ser positivo.");
        }
    }

    public void setAncho (int anch) {
        if (anch > 0 ){
            this.ancho = anch;
        } else {
            System.out.println("El ancho debe ser positivo.");
        }
    }

    public static int area(int ancho, int alto){
        return ancho * alto;
    }

    public static int perimetro(int ancho, int alto){
        return 2*(ancho+alto);
    }

    public static int getcontadorRectangulos(){
        return contadorRectangulos;
    }

    public void imprimirAreaPerimetro(){
        System.out.println("El area del rectangulo es: "+area(ancho, alto));
        System.out.println("El perimetro del rectangulo es: "+perimetro(ancho, alto));
    }

    public static Scanner consola = new Scanner(System.in);

    public static void MenuRectangulo () {
        boolean salir = false;
        Rectangulo rectangulo = null;
        int opcion; 

        while (!salir){
            System.out.println("Menú Interactivo");
            System.out.println("1. Crear rectangulo\n2. Calcular área y perímetro de un rectángulo\n3. Mostrar el número total de rectángulos creados\n4. Salir");
            System.out.print("Elija una opción:");
            opcion = consola.nextInt();
            
            switch (opcion) {
                case 1 ->{
                    System.out.println("Crear Rectangulo: ");
                    System.out.print("Ingrese la altura del rectangulo: ");
                    int alt = consola.nextInt();
                    System.out.print("Ingrese el ancho del rectangulo: ");
                    int anch = consola.nextInt();
                    if (alt > 0 && anch > 0) {
                        rectangulo = new Rectangulo(alt, anch);
                        System.out.println("Rectángulo creado con éxito.");
                    } else {
                        System.out.println("Las dimensiones deben ser positivas.");
                    }
                }
                case 2 -> {
                    if (rectangulo != null) {
                        System.out.println("Calcular área y perímetro de un rectángulo: ");
                        rectangulo.imprimirAreaPerimetro();
                    } else {
                        System.out.println("Aun no se ha creado un rectangulo.");
                    }
                }
                case 3 -> {
                    System.out.println("Número total de rectángulos creados: "+Rectangulo.getcontadorRectangulos()); 
                }
                case 4 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opcion invalida!");
            }
        }
    }

    public static void main(String[] args) {
        MenuRectangulo();
    }
}
