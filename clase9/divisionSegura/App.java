package clase9.divisionSegura;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            obtenerNumeros();
        } catch (ArithmeticException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void obtenerNumeros(){
        System.out.println("Division Segura");
        System.out.print("Ingrese el primer numero(dividendo): ");
        int dividendo = scanner.nextInt();
        int divisor = obtenerNumerador();

        operacionDivision(dividendo, divisor);
    }

    public static int obtenerNumerador() throws ArithmeticException {
        System.out.print("Ingrese el segundo numero(divisor): ");
        int divisor = scanner.nextInt();
        if (divisor == 0) {
            throw new ArithmeticException ("No es posible dividir por cero");
        }
        return divisor;
    }

    public static void operacionDivision(int dividendo, int divisor) {
        double division = (double) dividendo / divisor;
        System.out.println("El resultado de la division es: "+division);
    }
}