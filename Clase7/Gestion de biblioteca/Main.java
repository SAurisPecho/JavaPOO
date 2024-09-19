import java.util.Scanner;

public class Main {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibros(new Libro("La Teoría de la Relatividad", "Cristhian Daniel Gaona", 824));
        biblioteca.agregarLibros(new Libro("El Efecto Compuesto", "Darren Hardy", 189));

        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu Biblioteca");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar catálogo de libros");
            System.out.println("3. Mostrar personas registradas");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Agregar persona");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");
            int opcion = consola.nextInt();
            consola.nextLine();
            
            switch (opcion) {
                case 1 -> agregacionLibro(biblioteca);
                case 2 -> biblioteca.mostrarCatalogo();
                case 3 -> biblioteca.mostrarPersonas();
                case 4 -> prestarLibro(biblioteca);
                case 5 -> devolverLibro(biblioteca);
                case 6 -> agregacionPersona(biblioteca);
                case 7 -> {
                    System.out.println("Saliendo...");
                    continuar = false;
                }
                default -> System.out.println("Opcion invalida!");
            }
        }
    }

    public static void agregacionPersona(Biblioteca biblioteca) {
        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = consola.nextLine();
        System.out.print("Ingrese el apellido de la persona: ");
        String apellido = consola.nextLine();
        Persona nuevaPersona = new Persona(nombre, apellido);

        biblioteca.agregarPersona(nuevaPersona);
        System.out.println("Se agrego una nueva persona");
    }

    public static void agregacionLibro(Biblioteca biblioteca) {
        System.out.print("Ingrese el titulo de libro: ");
        String titulo = consola.nextLine();
        System.out.print("Ingrese el autor de libro: ");
        String autor = consola.nextLine();
        System.out.print("Ingrese el numero de paginas de libro: ");
        int numPaginas = consola.nextInt();
        Libro nuevoLibro = new Libro(titulo, autor, numPaginas);

        biblioteca.agregarLibros(nuevoLibro);
        System.out.println("Se agrego el libro correctamente.");
    }

    public static void prestarLibro(Biblioteca biblioteca) {
        System.out.print("Ingrese el nombre de la persona: ");
        String nombrePersona = consola.nextLine();
        System.out.print("Ingrese el titulo del libro a prestar: ");
        String tituloLibro = consola.nextLine();
        Persona personaPrestamo = buscarPersona(biblioteca, nombrePersona);
        if (personaPrestamo != null) {
            biblioteca.prestarLibro(personaPrestamo, tituloLibro);
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    public static void devolverLibro(Biblioteca biblioteca) {
        System.out.print("Ingrese el nombre de la persona: ");
        String nombrePersona = consola.nextLine();
        System.out.print("Ingrese el titulo del libro a devolver: ");
        String tituloLibro = consola.nextLine();
        Persona personaDevolucion = buscarPersona(biblioteca, nombrePersona);
        if (personaDevolucion != null) {
            biblioteca.devolverLibro(personaDevolucion, tituloLibro);
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    public static Persona buscarPersona (Biblioteca biblioteca, String nombre) {
        for (Persona persona : biblioteca.getPersonas()) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }
}
