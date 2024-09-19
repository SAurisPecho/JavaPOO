import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Revista revista1 = new Revista(1, 8, "Revista Actualidad");
        Revista revista2 = new Revista(2, 10, "Revista Historia");
        Revista revista3 = new Revista(3, 6, "Revista Ecomundo");
        Revista[] revistas = {revista1, revista2, revista3};


        Pelicula pelicula1 = new Pelicula("La vida es bella", "Drama");
        Pelicula pelicula2 = new Pelicula("7 almas", "Drama");
        Pelicula pelicula3 = new Pelicula("Lucy", "Ciencia ficción");
        Pelicula[] peliculas = {pelicula1, pelicula2, pelicula3};

        //METODOS REVISTA
        revista1.obtenerInformacion();
        LocalDate fechaDevolucionRevista = LocalDate.of(2024, 9, 18);
        double multaRevista = revista1.calcularMultas(fechaDevolucionRevista);
        System.out.println("Multa por atraso de entrega Revista: $"+multaRevista);
        System.out.println("************************************************");

        //METODOS PELICULA
        pelicula1.prestar();
        LocalDate fechaDevolucionPelicula = LocalDate.of(2024, 10, 18);
        double multaPelicula = pelicula1.calcularMultas(fechaDevolucionPelicula);
        System.out.println("Multa por atraso de entrega Pelicula: $"+multaPelicula);
        pelicula1.obtenerInformacion();
        pelicula1.devolver();
        System.out.println("************************************************");

        LocalDate fechaDevolucionRevista2 = LocalDate.of(2024, 11, 17);
        LocalDate fechaDevolucionPelicula2 = LocalDate.of(2024, 11, 30);

        //Probar metodos para el array revistas
        for (Revista revista : revistas) {
            System.out.println("Informacion de la revista");
            revista.obtenerInformacion();
            System.out.println();
            revista.prestar();
            System.out.println();
            double multaRevistas = revista.calcularMultas(fechaDevolucionRevista2);
            System.out.println("Multa por atraso de entrega Revista: $"+multaRevistas);
            System.out.println();
            revista.devolver();
            System.out.println("**************************************************");
        }

        //Probar metodos para el array peliculas
        for (Pelicula pelicula : peliculas) {
            System.out.println("Informacion de la pelicula");
            pelicula.obtenerInformacion();
            System.out.println();
            pelicula.prestar();
            System.out.println();
            double multapeliculas = pelicula.calcularMultas(fechaDevolucionPelicula2);
            System.out.println("Multa por atraso de entrega Revista: $"+multapeliculas);
            System.out.println();
            pelicula.devolver();
            System.out.println("**************************************************");
        }

    }
}
