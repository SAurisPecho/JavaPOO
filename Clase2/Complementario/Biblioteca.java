package clase2.Complementario;
import java.util.Scanner;

public class Biblioteca {

    private static Libro[] libros = new Libro[20];
    private static int contadorLibros = 0;
    
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú");
            System.out.println("1. Crear libro.\n2. Ver detalles de un libro.\n3. Ver todos los libros.\n4. Salir");
            System.out.print("Elija la opcion deseada: ");
            int opcion = consola.nextInt();

            switch (opcion) {
                case 1 -> crearLibro();
                case 2 -> detallesDeLibro();
                case 3 -> verTitulosLibros();
                case 4 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opcion invalida!");
            }
        }
    }

    public static void crearLibro () {
        if (contadorLibros < libros.length) {
            System.out.println("Crear libro: ");
            System.out.print("Ingrese el titulo del libro: ");
            String titulo = consola.nextLine();
            System.out.print("Ingrese el autor del libro: ");
            String autor = consola.nextLine();
            System.out.print("Ingrese el numero de paginas del libro: ");
            int paginas = consola.nextInt();
            
            if (!titulo.isEmpty() && !autor.isEmpty() && paginas > 0) {
            libros[contadorLibros] = new Libro(titulo, autor, paginas);
            contadorLibros++;
            System.out.println("Libro ingresado.");
            } else {
                System.out.println("Datos no validos!");
            }
        } else {
            System.out.println("No se pueden agregar mas libros.");
        }
    }

    public static void detallesDeLibro () {
        System.out.print("Ingrese el índice del libro (0 a " + (contadorLibros - 1) + " ): ");
        int indice = consola.nextInt();

        if (indice >= 0 && indice < contadorLibros) {
            libros[indice].imprimirDetalles();
        } else {
            System.out.println("Indice no valido!");
        }
    }

    public static void verTitulosLibros () {
        System.out.println("Lista de libros: ");
        for (int i = 0; i < contadorLibros; i++) {
            System.out.println((i+1)+"- "+libros[i].getTitulo());
        }
    }
}
