import java.time.LocalTime;
import java.util.Scanner;

/*Dada una cantidad de segundos ingresada por el usuario, conviértela en un objeto LocalTime y muéstrala por consola. */

public class XII {
    protected static Scanner consola = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Ingrese una cantidad de segundos: ");
        int segundos = consola.nextInt();

        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segundosRestantes = segundos % 60;

        LocalTime tiempo = LocalTime.of(horas, minutos, segundosRestantes);
        System.out.println("El tiempo equivalente es: " + tiempo);
        System.out.println("Horas: "+horas+"\nMinutos: "+minutos+"\nSegundos: "+segundosRestantes);
    }
}
