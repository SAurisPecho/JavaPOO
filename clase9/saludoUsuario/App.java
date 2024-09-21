package clase9.saludoUsuario;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        saludarUsuario();
    }



    private static void saludarUsuario() {
        Scanner scanner = new Scanner(System.in);
        try {
            String nombre = solicitarNombreUsuario(scanner);
            System.out.println("Hola " + nombre + ", espero que estés teniendo un bonito día.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ocurrio un error: El nombre debe tener mas de 2 caracteres "+e.getMessage());
        } finally {
            System.out.println("Cerrando scanner...");
            scanner.close();
        }
    }



    private static String solicitarNombreUsuario(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Saludo usuario");
        System.out.println("Ingrese un nombre: (con mas de 2 caracteres)");
        String nombre = scanner.nextLine();

        if (nombre.length() < 3) {
            throw new IllegalArgumentException();
        }
        
        return nombre;
    }
}