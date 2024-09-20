package clase2.Modelos;
import java.util.Scanner;

public class App {
    
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("Menú");
            System.out.print("1. Rectángulo\n2. Triángulo\n3. Circulo\n4. Salir\nElije la figura que deseas crear: ");
            opcion = consola.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("Rectángulo");
                    Rectangulo.MenuRectangulo();
                }
                case 2 -> {
                    System.out.println("Triángulo");
                    Triangulo.MenuTriangulo();
                }
                case 3 -> {
                    System.out.println("Circulo");
                    Circulo.MenuCirculo();
                }
                case 4 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opcion invalida!");
            }
        }
    }
}
