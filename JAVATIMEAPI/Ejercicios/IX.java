package Ejercicios;
/*Crea un objeto LocalTime representando la hora actual y obtén la cantidad de segundos que han pasado desde el inicio del día. */

import java.time.LocalTime;

public class IX {
    public static void main(String[] args) {
        LocalTime horaActual = LocalTime.now();
        long segundosDesdeInicioDía = horaActual.toSecondOfDay();
        System.out.println("Cantidad de segundos que han pasado desde el inicio del día: "+segundosDesdeInicioDía);
    }
}
