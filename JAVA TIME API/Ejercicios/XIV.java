/* Dado un objeto LocalTime que has ingresado, crea un nuevo LocalTime que represente exactamente la mitad del tiempo transcurrido 
entre la hora dada y la medianoche. */

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class XIV {
    public static void main(String[] args) {
        LocalTime hora = LocalTime.of(11, 14, 39);
        long segundosDesdeMediaNoche = ChronoUnit.SECONDS.between(LocalTime.MIDNIGHT, hora);
        long mitadSegundos = segundosDesdeMediaNoche / 2;
        LocalTime mitadTiempo = LocalTime.MIDNIGHT.plusSeconds(mitadSegundos);
        System.out.println("La mitad del tiempo transcurrido entre la medianoche y "+hora+" es: "+mitadTiempo);
    }
}
