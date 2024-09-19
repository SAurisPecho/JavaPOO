package Complementarios;
import java.time.LocalDate;

public class prediciendoEventos {
    public static void main(String[] args) {
        //Invasión de cigarras 
        LocalDate[] cigarras = fechasProximas(LocalDate.of(2021,1,1), 17, 4);
        System.out.println("Invasión de cigarras: ");
        for (LocalDate fecha : cigarras) {
            System.out.println(fecha);
        }
        //Cometa Halley
        System.out.println("Cometa Halley: ");
        LocalDate[] cometa = fechasProximas(LocalDate.of(1986, 1, 1), 76, 4);
        for (LocalDate fec : cometa) {
            System.out.println(fec);
        }

        // Tránsitos más recientes
        System.out.println("Tránsitos de Venus: ");
        LocalDate[] transitos = fechasProximosTransitos(LocalDate.of(2012, 6, 5), 4);
        for (LocalDate fec : transitos) {
            System.out.println(fec);
        }
    }

    public static LocalDate[] fechasProximas(LocalDate fechaUltimoEvento, int cicloAnios, int cantidadFechas) {
        LocalDate[] fechasProx = new LocalDate[cantidadFechas];
        for (int i = 0; i < cantidadFechas; i++) {
            fechasProx[i] = fechaUltimoEvento.plusYears(cicloAnios*(i+1));
        }
        return fechasProx;
    }

    public static LocalDate[] fechasProximosTransitos(LocalDate fechaUltimoTransito, int cantidadFechas) {
        // Ciclo en años del tránsito de Venus
        double[] ciclos = {105.5, 8, 121.5, 8};

        LocalDate[] fechasProximas = new LocalDate[cantidadFechas];
        LocalDate fechaActual = fechaUltimoTransito;

        for (int i = 0; i < cantidadFechas; i++) {
            double ciclo = ciclos[i % ciclos.length];
            
            int anios = (int) ciclo;
            int meses = (int) Math.round((ciclo - anios) * 12);

            // Sumar los años y meses del ciclo
            fechaActual = fechaActual.plusYears(anios).plusMonths(meses);
            fechasProximas[i] = fechaActual;
        }

        return fechasProximas;
    }
}
