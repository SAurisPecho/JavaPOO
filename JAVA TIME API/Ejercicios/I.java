import java.time.LocalDate;
/*Crea un programa que genere un objeto LocalDate representando la fecha actual.*/

public class I {
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();

        System.out.println("Hoy es: "+hoy);
    }
}