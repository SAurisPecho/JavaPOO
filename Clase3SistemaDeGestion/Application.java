package Clase3SistemaDeGestion;
import Clase3SistemaDeGestion.modelos.Empleado;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static ArrayList<Empleado> lista = new ArrayList<>();
    private static ArrayList<Empleado> filtracion = new ArrayList<>();

    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú");
            System.out.println("1. Mostrar todos los empleados\n2. Crear empleado\n3. Filtrar empleados\n4. Ordenar empleados\n5. Incrementar salario\n6. Limpiar filtros\n7. Salir");
            System.out.print("Elija una opcion: ");
            int opcion = consola.nextInt();
            consola.nextLine();

            switch (opcion) {
                case 1 -> Empleado.mostrarEmpleados(lista);
                case 2 -> Empleado.crearEmpleado(lista);
                case 3 -> Empleado.filtrarEmpleados(lista);
                case 4 -> Empleado.ordenarEmpleados(lista);
                case 5 -> Empleado.incrementarSalario(lista);
                case 6 -> Empleado.limpiarFiltros(filtracion);
                case 7 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opción invalida!");
            }
        }
    }
}
