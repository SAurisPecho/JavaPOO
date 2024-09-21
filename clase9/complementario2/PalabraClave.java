package clase9.complementario2;

import java.util.Scanner;

public class PalabraClave {
    private String clave;
    public static Scanner scanner = new Scanner(System.in);

    public void ingresarPalabraClave() {
        boolean claveCorrecta = false;

        while (!claveCorrecta) {
            try {
                System.out.print("Ingrese una palabra clave: ");
                clave = scanner.nextLine();
                validarCaracteres(clave);
                validarNumeros(clave);
                validarLetraZ(clave);

                System.out.println("La palabra clave es valida para ser utilizada");
                claveCorrecta = true;
            } catch (LongitudNoValidaException | CantidadNumerosException | LetraZnoExistenteException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }

    private void validarCaracteres(String clave) throws LongitudNoValidaException {
        if (clave.length() < 8) {
            throw new LongitudNoValidaException("Error: La clave debe tener al menos 8 caracteres.");
        }
    }
    
    private void validarNumeros(String clave) throws CantidadNumerosException {
        int contadorNum = 0;
        for (char c : clave.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorNum++;
            }
        }
        if (contadorNum != 4) {
            throw new CantidadNumerosException("Error: La clave debe contener exactamente 4 números.");
        }
    }

    private void validarLetraZ(String clave) throws LetraZnoExistenteException {
        if (!clave.contains("z")) {
            throw new LetraZnoExistenteException("Error: La clave debe contener la letra 'z'.");
        }
    }

    public class LongitudNoValidaException extends Exception {
        public LongitudNoValidaException (String mensaje) {
            super(mensaje);
        }
    }

    public class CantidadNumerosException extends Exception {
        public CantidadNumerosException (String mensaje) {
            super(mensaje);
        }
    }

    public class LetraZnoExistenteException extends Exception {
        public LetraZnoExistenteException (String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        PalabraClave palabraClave = new PalabraClave();
        palabraClave.ingresarPalabraClave();
    }
}
