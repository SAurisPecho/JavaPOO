import java.util.Scanner;

public class Rectangulo {
    
    double ancho;
    double alto;
    static int contadorRectangulos = 0;

    public Rectangulo (double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
        contadorRectangulos++;
    }

    public double area(){
        return ancho * alto;
    }

    public double perimetro(){
        return 2*(ancho + alto);
    }

    public void imprimirArea(){
        System.out.println("El area del rectangulo es: "+area());
    }

    public void imprimirPerimetro(){
        System.out.println("El perimetro del rectangulo es: "+perimetro());
    }

    public static int numeroRectangulos (){
        return contadorRectangulos;
    }

    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        Rectangulo[] array = new Rectangulo[12];
        int opcion; 

        do {
            System.out.println("Menú Interactivo");
            System.out.println("1. Crear rectangulo\n2. Calcular área de un rectángulo\n3. Calcular perímetro de un rectángulo\n4. Ver número total de rectángulos creados\n5. Salir");
            System.out.print("Elija una opción:");
            opcion = consola.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el ancho del rectangulo: ");
                    double ancho = consola.nextDouble();
                    System.out.println("Ingrese el alto del rectangulo: ");
                    double alto = consola.nextDouble();
                    if (ancho > 0 && alto > 0) {
                        Rectangulo nuevo = new Rectangulo(ancho, alto);
                        array[Rectangulo.numeroRectangulos()-1] = nuevo;
                        System.out.println("Rectangulo creado");
                    } else {
                        System.out.println("Las dimensiones deben ser positivas.");
                    }   
                }
                case 2 -> {
                    System.out.println("Ingrese el índice del rectángulo: ");
                    int indice = consola.nextInt();
                    if (indice > -1 && indice < Rectangulo.numeroRectangulos()) {
                       System.out.println("Area del rectangulo: "+array[indice].area());
                    } 
                }
                case 3 -> {
                    System.out.println("Ingrese el índice del rectángulo: ");
                    int indice = consola.nextInt();
                    if (indice > -1 && indice < Rectangulo.numeroRectangulos()) {
                       System.out.println("Perimetro del rectangulo: "+array[indice].perimetro());
                    }
                }
                case 4 -> {
                    System.out.println("Rectangulos");
                    System.out.println("Numero total de rectangulos creados: \n"+Rectangulo.numeroRectangulos());
                }
                case 5 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 5);
    }
}