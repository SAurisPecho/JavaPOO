import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*Escribe un programa que permita al usuario ingresar la fecha en un formato predeterminado por ti a través de 
la consola, y luego utilice esta información para crear un objeto LocalDate. */

public class IV {
    public static Scanner consola = new Scanner(System.in);
    public static void main(String[] args) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Formato de fecha a ingresar(dd/MM/yyyy): ");
            String fechaIngresada = consola.nextLine();

            LocalDate fecha = LocalDate.parse(fechaIngresada, formateador);

            System.out.println("Fecha ingresada: "+fecha);

        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha incorrecto. Por favor, ingrese la fecha en el formato dd/MM/yyyy");
        }
        
    }
}
