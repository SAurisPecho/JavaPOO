package clase8.colores;
import clase8.colores.enums.Color;

public class ConvertidorColor {
    public static Color convertirHexadecimal(String valorHexadecimal) {
        for (Color color : Color.values()) {
            if (color.getValorHexadecimal().equalsIgnoreCase(valorHexadecimal)) {
                return color;
            }
        }
        return null;
    }
}
