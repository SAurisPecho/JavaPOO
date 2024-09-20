package clase2.Plano;
import java.util.Scanner;

public class Plano {

    private static Punto[] puntos = new Punto[15]; 
    private static int contadorPuntos = 0;
    
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú");
            System.out.println("1. Crear un punto.\n2. Calcular la distancia desde el origen.\n3. Calcular la distancia entre dos puntos.\n4. Determinar si tres puntos están alineados.\n5. Salir");
            System.out.println("Elija la opcion deseada: ");
            int opcion = consola.nextInt();

            switch (opcion) {
                case 1 -> crearPunto();
                case 2 -> calcularDistanciaDesdeOrigen();
                case 3 -> calcularDistanciaEntreDosPuntos();
                case 4 -> tresPuntosAlineados();
                case 5 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    public static void crearPunto(){
        System.out.print("Ingrese la coordenada X, del punto: ");
        double x = consola.nextDouble();
        System.out.print("Ingrese la coordenada Y, del punto: ");
        double y = consola.nextDouble();
        puntos[contadorPuntos] = new Punto(x, y);
        contadorPuntos++;
        System.out.println("Punto creado con exito.");
    }

    public static void calcularDistanciaDesdeOrigen(){
        System.out.print("Seleccione el índice del punto (0 a " + (contadorPuntos - 1) + " ): ");
        int indice = consola.nextInt();
        if (indice >= 0 && indice < contadorPuntos) {
            double distancia = puntos[indice].distanciaDesdeOrigen();
            System.out.println("Distancia desde el origen (0, 0) es :"+distancia);
        } else {
            System.out.println("Indice no valido.");
        }
    }

    public static void calcularDistanciaEntreDosPuntos(){
        System.out.print("Seleccione el índice del primer punto (0 a " + (contadorPuntos - 1) + " ): ");
        int indice1 = consola.nextInt();
        System.out.print("Seleccione el índice del segundo punto (0 a " + (contadorPuntos - 1) + " ): ");
        int indice2 = consola.nextInt();

        if (indice1 >= 0 && indice1 < contadorPuntos && indice2 >= 0 && indice2 < contadorPuntos && indice1 != indice2){
            double distanciaPuntos = Punto.calcularDistancia(puntos[indice1], puntos[indice2]);
            System.out.println("La distancia entre los puntos es: "+distanciaPuntos);
        } else {
            System.out.println("Opcion invalida!");
        }
    }

    public static void tresPuntosAlineados(){
        System.out.print("Seleccione el índice del primer punto (0 a " + (contadorPuntos - 1) + " ): ");
        int indice1 = consola.nextInt();
        System.out.print("Seleccione el índice del segundo punto (0 a " + (contadorPuntos - 1) + " ): ");
        int indice2 = consola.nextInt();
        System.out.print("Seleccione el índice del tercer punto (0 a " + (contadorPuntos - 1) + " ): ");
        int indice3 = consola.nextInt();

        if (indice1 >= 0 && indice1 < contadorPuntos && indice2 >= 0 && indice2 < contadorPuntos && indice3 >= 0 && indice3 < contadorPuntos){
            boolean alineados = Punto.estanAlineados(puntos[indice1], puntos[indice2], puntos[indice3]);
            System.out.println("¿Los puntos estan alineados?: "+ alineados);
        } else {
            System.out.println("Indice no valido.");
        }
    }


}
