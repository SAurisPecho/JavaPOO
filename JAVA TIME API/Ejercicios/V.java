import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*Desarrolla un programa que solicite al usuario ingresar una fecha en formato 'dd-MM-yyyy'. Luego, el programa 
debe generar un objeto LocalDate basado en la información proporcionada. Posteriormente, añade 15 días, 2 meses
y 3 años a esta fecha. Por último, muestra al usuario la nueva fecha obtenida y el día de la semana correspondiente. */

public class V {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Formato de fecha a ingresar(dd/MM/yyyy): ");
            String fechaCadena = consola.nextLine();

            LocalDate fecha = LocalDate.parse(fechaCadena, nuevoFormato);
            LocalDate nuevaFecha = fecha.plusDays(15).plusMonths(2).plusYears(3);
            DayOfWeek diaNuevaFecha = nuevaFecha.getDayOfWeek();

            System.out.println("La nueva fecha es : "+nuevaFecha+" , el dia de la semana correspondiente es: "+diaNuevaFecha);

        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha incorrecto. Por favor, ingrese la fecha en el formato dd/MM/yyyy");
        }
    }
}
