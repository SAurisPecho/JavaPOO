package clase9.gestiondeCuentas;

public class App {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria(500);

        try {
            cuentaBancaria.retirar(100);
            cuentaBancaria.retirar(450);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
