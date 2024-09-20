package clase8.complementario1.servicios;

import java.util.Scanner;

import clase8.complementario1.enums.Estacion;
import clase8.complementario1.enums.Mes;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public static void mostrarMenu() {
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("Menu Opciones");
            System.out.println("1. Meses y estaciones correspondientes");
            System.out.println("2. Ingresar un número de mes para obtener la estación del año");
            System.out.println("3. Salir (Ingrese el numero 0 para salir)");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> EstacionDelAño.imprimirEstaciones();
                case 2 -> {
                    System.out.println("Escriba un numero de 1-12, segun el mes que corresponda: ");
                    int mesOpcion = scanner.nextInt();
                    if (mesOpcion >= 1 && mesOpcion <= 12) {
                        Mes mes = Mes.obtenerMesPorNumero(mesOpcion);
                        Estacion estacion = EstacionDelAño.obtenerEstacion(mes);
                        System.out.println("El mes " + mes + " pertenece a la estación: " + estacion);
                    } else {
                        System.out.println("Número de mes no válido. Intenta de nuevo.");
                    }
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
    }

}
