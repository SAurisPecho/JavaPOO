import java.time.LocalDate;
import java.util.Scanner;

/*Implementa un programa que solicite al usuario ingresar por separado el día, el mes y el año, para luego 
convertir esta información en un objeto LocalDate. */

public class III {
    public static Scanner consola = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Fecha\nIngrese el dia: ");
        int dia = consola.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = consola.nextInt();
        System.out.println("Ingrese el año: ");
        int anio = consola.nextInt();

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        System.out.println("Fecha: "+fecha);
    }
}
