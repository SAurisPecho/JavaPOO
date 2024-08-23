package Modelos;
import java.util.Scanner;

public class Triangulo {
    
    private int base;
    private int altura;
    public static int contadorTriangulos;

    public Triangulo () {}

    public Triangulo (int base, int altura) {
        this.base = base;
        this.altura = altura;
        contadorTriangulos++;
    }

    public int getBase () {
        return base;
    }
    
    public void setBase (int base){
        if (base > 0 ){
            this.base = base;
        } else {
            System.out.println("La base debe ser positiva.");
        }
    }

    public int getAltura () {
        return altura;
    }

    public void setAltura(int altura) {
        if (altura > 0 ){
            this.altura = altura;
        } else {
            System.out.println("La altura debe ser positiva.");
        }
    } 

    public static int getContadorTriangulos() {
        return contadorTriangulos;
    }

    public int area (int base, int altura) {
        return (base*altura)/2;
    }

    public void imprimirDatos (){
        System.out.println("Datos del Triangulo:\nEl area del triangulo es: "+ area(base, altura));
        System.out.println("La base del triangulo es: "+ base);
        System.out.println("La altura del triangulo es: "+ altura);
    }

    public static Scanner consola = new Scanner(System.in);

    public static void MenuTriangulo () {
        boolean salir = false;
        Triangulo triangulo = null;
        int opcion;

        while (!salir) {
            System.out.println("Menú Interactivo");
            System.out.println("1. Crear triangulo\n2. Mostrar datos de triangulo\n3. Mostrar el número total de triangulos creados\n4. Salir");
            System.out.print("Elija una opción:");
            opcion = consola.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Crear triangulo: ");
                    System.out.print("Ingrese la base del triangulo: ");
                    int base = consola.nextInt();
                    System.out.print("Ingrese la altura del triangulo: ");
                    int altura = consola.nextInt();
                    if (base > 0 && altura >0) {
                        triangulo = new Triangulo(base, altura);
                        System.out.println("Triangulo creado con éxito.");
                    } else {
                        System.out.println("Las dimensiones deben ser positivas.");
                    }
                }
                case 2 -> {
                    if (triangulo != null) {
                        System.out.println("Mostrar datos de triangulo: ");
                        triangulo.imprimirDatos();
                    } else {
                        System.out.println("Aun no se ha creado un triangulo");
                    }
                }
                case 3 -> {
                    System.out.println("Mostrar el número total de triangulos creados: ");
                    System.out.println("Número total de rectángulos creados: "+Triangulo.getContadorTriangulos()); 
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
        MenuTriangulo();
    }
}
