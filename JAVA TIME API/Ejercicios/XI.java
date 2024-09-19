/*Dado un objeto LocalTime ingresado por el usuario, ajusta la hora al próximo valor exacto. */

import java.time.LocalTime;
import java.util.Scanner;

public class XI {
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese la hora en formato(HH:mm): ");
        String horaUsuario = consola.nextLine();

        LocalTime horaIngresada = LocalTime.parse(horaUsuario);
        LocalTime proximaHora = horaIngresada.plusHours(1).withMinute(0).withSecond(0);

        System.out.println("El próximo valor exacto es: "+proximaHora);
    }
}
