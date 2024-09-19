import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*Desarrolla un programa que solicite al usuario ingresar una fecha en formato 'dd-MM-yyyy'. Luego, el programa debe generar un objeto LocalDate basado
en la información proporcionada. Posteriormente, resta 13 días, 10 meses y 1 año. a esta fecha. Por último, 
muestra al usuario la nueva fecha obtenida y el día de la semana correspondiente. */

public class VI {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Formato de fecha a ingresar(dd/MM/yyyy): ");
        String fechaCadena = consola.nextLine();
        LocalDate fecha = LocalDate.parse(fechaCadena, nuevoFormato);
        LocalDate nuevaFecha = fecha.minusDays(13).minusMonths(10).minusYears(1);
        DayOfWeek diaSemana = fecha.getDayOfWeek();

        System.out.println("La nueva fecha es: "+nuevaFecha+" , el dia de la semana es: "+ diaSemana);
    }

}
