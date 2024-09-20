package Ejercicios;
import java.time.LocalDate;
import java.util.Scanner;

/*Dado un objeto LocalDate ingresado por el usuario, tu tarea es verificar si el año correspondiente 
es un año bisiesto o no. */

public class VII {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        int dia, mes, anio;
        LocalDate fechaIngresada = null;

        do {
            System.out.println("Ingrese el dia 1 - 31: ");
            dia = consola.nextInt();
        } while (dia >31 || dia < 1);

        do {
            System.out.println("Ingrese el mes 1 - 12: ");
            mes = consola.nextInt();
        } while (mes >12 || dia < 1);

        do {
            System.out.println("Ingrese el año (YYYY): ");
            anio = consola.nextInt();
        } while (anio < 0);

        try {
            fechaIngresada = LocalDate.of(anio, mes, dia);
        } catch (Exception e) {
            System.out.println("Fecha ingresada no válida.");        
        }

        if (fechaIngresada.isLeapYear()) {
            System.out.println("El año: "+anio+", es un año bisiesto");
        } else {
            System.out.println("El año: "+anio+", no es un año bisiesto");
        }
    }
}
