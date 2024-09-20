package Ejercicios;
/*Escribe un programa que calcule la diferencia en segundos entre dos objetos LocalTime. */

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class XIII {
    public static void main(String[] args) {
        LocalTime horaUno = LocalTime.of(1, 5, 40);
        LocalTime horaDos = LocalTime.of(1, 29, 17);

        long diferencia = ChronoUnit.SECONDS.between(horaUno, horaDos);
        System.out.println("La diferencia en segundos entre ambos tiempos es: "+diferencia+" segundos.");
    }
}
