/*Diseña un juego de adivinanza de fechas, donde crearás una LocalDate aleatoria y le preguntarás al usuario cuál es. Solo podrás 
decirle si la fecha ingresada es antes o después de la fecha objetivo. Cuando adivine la fecha, el juego terminará y lo felicitarás 
por haberlo logrado */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class VIII {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaAleat = LocalDate.of(random.nextInt(2000)+1, random.nextInt(12)+1, random.nextInt(28)+1);

        System.out.println("Juego Adivina la Fecha");
        System.out.println("Se ha generado una fecha aleatoria. Intenta adivinarla.");
        System.out.println("Referencia: "+fechaAleat);

        boolean adivinanza = false;
        while (!adivinanza) {
            System.out.print("Ingrese la fecha(dd-MM-yyyy): ");
            String intento = consola.nextLine();

            LocalDate fechaIngresada = LocalDate.parse(intento, formato);
            int comparacion = fechaIngresada.compareTo(fechaAleat);

            if (comparacion == 0) {
                System.out.println("Felicidades lo lograste!");
                adivinanza = true;
            } else if (comparacion < 0) {
                System.out.println("La fecha ingresada es antes de la fecha correcta. Vuelve a intentarlo");
            } else {
                System.out.println("La fecha ingresada es despues de la fecha correcta. Vuelve a intentarlo");
            }
        }
    }
}