package clase8.colores;
import clase8.colores.enums.Color;

public class Application {
    public static void main(String[] args) {
        pruebasColores("#fsrf55");
        pruebasColores("#nngg45");
        pruebasColores("#FF0000");
        pruebasColores("#FFFF00");
        pruebasColores("#0000FF");
    }

    private static void pruebasColores (String valorHexadecimal) {
        Color color = ConvertidorColor.convertirHexadecimal(valorHexadecimal);
        if (color != null) {
            System.out.println("El valor hexadecimal: "+valorHexadecimal+" es el color "+color);
        } else {
            System.out.println("No es un color primario");
        }
    }
}
