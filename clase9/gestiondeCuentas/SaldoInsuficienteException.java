package clase9.gestiondeCuentas;

public class SaldoInsuficienteException extends Exception {
    
    public SaldoInsuficienteException (String mensaje) {
        super(mensaje);
    }
}
