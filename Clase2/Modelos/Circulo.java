package clase2.Modelos;
import java.util.Scanner;

public class Circulo {
    
    private double radio;
    private static int contadorCirculos = 0;

    public Circulo () {}

    public Circulo (double radio) {
        this.radio = radio;
        contadorCirculos++;
    }

    public void setRadio (double radio ) {
        if (radio > 0 ){
            this.radio = radio;
        } else {
            System.out.println("El radio debe ser positivo.");
        }
    }

    public double getRadio () {
        return radio;
    }

    public static int getContadorCirculos (){
        return contadorCirculos;
    }

    public double area (double radio) {
        return Math.PI*Math.pow(radio, 2);
    }

    public double perimetro (double radio) {
        return 2 * Math.PI *radio;
    }

    public void imprimirDatos () {
        System.out.println("Datos del Circulo:\nEl area del circulo es: "+ String.format("%.2f",area(radio)));
        System.out.println("El perimetro del circulo es: "+ String.format("%.2f",perimetro(radio)));
        System.out.println("El radio del circulo es: "+ radio);
    }

    public static Scanner consola = new Scanner(System.in);

    public static void MenuCirculo () {
        boolean salir = false;
        Circulo circulo = null;
        int opcion;

        while (!salir) {
            System.out.println("Menú Interactivo");
            System.out.println("1. Crear circulo\n2. Mostrar datos de circulo\n3. Mostrar el número total de circulos creados\n4. Salir");
            System.out.print("Elija una opción: ");
            opcion = consola.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Crear circulo: ");
                    System.out.print("Ingrese el radio del circulo: ");
                    double radio = consola.nextDouble();
                    if (radio > 0) {
                        circulo = new Circulo(radio);
                        System.out.println("Circulo creado con exito.");
                    } else {
                        System.out.println("El radio debe ser positivo.");
                    }
                }
                case 2 -> {
                    if (circulo != null) {
                        System.out.println("Mostrar datos de circulo: ");
                        circulo.imprimirDatos();
                    } else {
                        System.out.println("Aun no se ha creado un circulo.");
                    }
                }
                case 3 -> {
                    System.out.println("Mostrar el número total de circulos creados: ");
                    System.out.println("Número total de circulos creados: "+ Circulo.getContadorCirculos());
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
        MenuCirculo();
    }
}
