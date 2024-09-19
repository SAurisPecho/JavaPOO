/* Crea un método que, dado un LocalDateTime, devuelva un ZonedDateTime que represente el mismo instante en
 la zona horaria de Tokio (Asia/Tokyo). */

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class XV {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTimeTokio = obtenerZoneDateTime();

        imprimirZonedDateTime("La fecha y hora en Tokio es: ", zonedDateTimeTokio);
    }

    public static ZonedDateTime obtenerZoneDateTime() {
        return ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
    }

    public static void imprimirZonedDateTime(String mensaje, ZonedDateTime zonedDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedDateTime = zonedDateTime.format(formatter);
        System.out.println(mensaje + formattedDateTime);
    }
}
