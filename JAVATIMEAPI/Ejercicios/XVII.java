package Ejercicios;
/*Crea un método que reciba por parámetro la fecha de nacimiento de una persona como LocalDate y que calcule su
 edad en años. */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.Period;

public class XVII {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese una fecha de nacimiento(yyyy-MM-dd): ");
        String fechaNac = consola.nextLine();

        LocalDate fechaNacimiento = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        int edad = calcularEdadAnios(fechaNacimiento);
        System.out.println("La edad es: "+edad);
    }

    public static int calcularEdadAnios(LocalDate fechaNacimiento) {
        LocalDate actualidad = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, actualidad);
        int anios = periodo.getYears();
        return anios;
    }
}
