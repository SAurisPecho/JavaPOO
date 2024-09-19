/*Crea un objeto LocalTime que represente una hora específica. Después, utiliza ese objeto para calcular cuántas horas, minutos y 
segundos faltan hasta la medianoche. */

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class X {
    public static void main(String[] args) {
        LocalTime horaSegundos = LocalTime.now();
        LocalTime mediaNoche = LocalTime.of(23, 59, 59);

        long horasRestantes = ChronoUnit.HOURS.between(horaSegundos, mediaNoche);
        long minutosRestantes = ChronoUnit.MINUTES.between(horaSegundos, mediaNoche);
        long segundosRestantes = ChronoUnit.SECONDS.between(horaSegundos, mediaNoche);
        
        System.out.println("Horas restantes: "+horasRestantes+", Minutos restantes: "+minutosRestantes+", Segundos restantes: "+segundosRestantes);
    }
}
