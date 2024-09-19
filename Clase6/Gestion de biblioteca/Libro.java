import java.time.LocalDate;

public class Libro extends ItemBiblioteca implements Catalogable {

    @Override
    public double calcularMultas(LocalDate fechaDevolucion) {
        return 0;
    }

    @Override
    public void devolver() {
        
    }

    @Override
    public void prestar() {
        
    }

    @Override
    public void obtenerInformacion() {
        
    }
    
}