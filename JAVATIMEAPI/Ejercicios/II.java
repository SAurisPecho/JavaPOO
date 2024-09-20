package Ejercicios;
import java.time.LocalDate;
/*Desarrolla un programa que genere un objeto LocalDate representando una fecha específica, como tu cumpleaños. */

public class II {
    public static void main(String[] args) {
        LocalDate cumpleaños = LocalDate.of(2003, 11, 17);

        System.out.println("Cumpleaños: "+cumpleaños);
    }
}
