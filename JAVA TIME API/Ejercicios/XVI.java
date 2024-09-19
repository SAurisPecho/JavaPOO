/* Solicita al usuario una fecha y hora y crea un ZonedDateTime para luego mostrarle que fecha y hora seria en todas 
las zonas horarias. */

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Set;

public class XVI {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese una fecha y hora (yyyy-MM-dd HH:mm:ss): ");
        String fechaHoraTexto = consola.nextLine();

        LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(fechaHora, ZoneId.systemDefault());

        Set<String> zonasHorarias = ZoneId.getAvailableZoneIds();
        System.out.println("Fecha y hora en todas las zonas horarias:");
        for (String zonaHoraria : zonasHorarias) {
            ZonedDateTime zonedDateTimeEnZona = zonedDateTime.withZoneSameInstant(ZoneId.of(zonaHoraria));
            System.out.println(zonaHoraria+" : "+zonedDateTimeEnZona.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }
}
