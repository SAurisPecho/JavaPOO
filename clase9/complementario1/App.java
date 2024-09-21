package clase9.complementario1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Random ramdom = new Random();
        int numero = ramdom.nextInt(50)+ 1;
        int intentos = 0;
        boolean adivino = false;

        System.out.println("Juego Adivinador");
        System.out.println("Adivina el numero correcto entre 1 a 50:");


        while (!adivino) {
            System.out.print("Ingresa el numero:");
            try {
                int numeroIngresado = scanner.nextInt();
                intentos++;
                adivino = adivinarNumero(numeroIngresado, numero, intentos);
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un numero");
                scanner.next();
                intentos++; 
            }
        }
            
    }

    private static boolean adivinarNumero(int numeroIngresado, int numero, int intentos) {
        if (numeroIngresado > numero) {
            System.out.println("El numero ingresado es mayor que el numero a adivinar");
            return false;
        } else if (numeroIngresado < numero) {
            System.out.println("El numero ingresado es menor que el numero a adivinar.");
            return false;
        } else {
            System.out.println("Lo lograste!!!, adivinaste el numero en "+intentos+" intentos.");
            return true;
        }
    }
}
