/*Escribe un programa que tome dos fechas en formato de texto, las convierta a LocalDate y use ChronoUnit para calcular la cantidad
de años, meses y días entre las dos fechas. */

import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class XVIII {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese la primera fecha (yyyy-MM-dd):");
        String fechaTexto1 = consola.nextLine();
        System.out.println("Ingrese la segunda fecha (yyyy-MM-dd):");
        String fechaTexto2 = consola.nextLine();

        LocalDate fecha1 = LocalDate.parse(fechaTexto1);
        LocalDate fecha2 = LocalDate.parse(fechaTexto2);

        long anios = ChronoUnit.YEARS.between(fecha1, fecha2);
        long meses = ChronoUnit.MONTHS.between(fecha1, fecha2);
        long dias = ChronoUnit.DAYS.between(fecha1, fecha2);

        System.out.println("La cantidad de años entre ambas fechas es: "+anios);
        System.out.println("La cantidad de meses entre ambas fechas es: "+meses);
        System.out.println("La cantidad de dias entre ambas fechas es: "+dias);
    }
}
