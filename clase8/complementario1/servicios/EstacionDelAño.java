package clase8.complementario1.servicios;

import clase8.complementario1.enums.Estacion;
import clase8.complementario1.enums.Mes;

public class EstacionDelAño {
    
    public static Estacion obtenerEstacion(Mes mes) {
        return switch (mes) {
            case DICIEMBRE, ENERO, FEBRERO -> Estacion.VERANO;
            case MARZO, ABRIL, MAYO -> Estacion.OTOÑO;
            case JUNIO, JULIO, AGOSTO -> Estacion.INVIERNO;
            case SEPTIEMBRE, OCTUBRE, NOVIEMBRE -> Estacion.PRIMAVERA;
        };
    }

    public static void imprimirEstaciones() {
        System.out.println("VERANO: DICIEMBRE, ENERO, FEBRERO");
        System.out.println("OTOÑO: MARZO, ABRIL, MAYO");
        System.out.println("INVIERNO: JUNIO, JULIO, AGOSTO");
        System.out.println("PRIMAVERA: SEPTIEMBRE, OCTUBRE, NOVIEMBRE");
    }

    public static void imprimirEstacion (Mes mes) {
        Estacion estacion = obtenerEstacion(mes);
        System.out.println("El mes "+mes.name()+" pertenece a "+estacion.name());
    }
}
