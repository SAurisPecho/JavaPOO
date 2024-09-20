package clase8.diasDeSemana;
import clase8.diasDeSemana.enums.DiaSemana;

public class Semana {
    public static void main(String[] args) {
        DiaSemana[] diasSemana = generarDiaSemanas(10);

        for (DiaSemana d : diasSemana) {
            imprimirDiaLaboral(d);
        }
    }

    private static DiaSemana[] generarDiaSemanas (int numeroDias) {
        DiaSemana[] semana = new DiaSemana[numeroDias];
        for (int i = 0; i < numeroDias; i++) {
            semana[i] = DiaSemana.values() [(int) (Math.random() * DiaSemana.values().length)];
        }
        return semana;
    } 

    private static void imprimirDiaLaboral(DiaSemana diaSemana) {
        if (diaSemana.esDiaLaboral()) {
            System.out.println(diaSemana+" es dia laboral");
        } else {
            System.out.println(diaSemana+" no es dia laboral");
        }
    }
}
