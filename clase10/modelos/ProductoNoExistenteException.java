package clase10.modelos;

public class ProductoNoExistenteException extends Exception {
    public ProductoNoExistenteException (String mensaje) {
        super(mensaje);
    }
}
