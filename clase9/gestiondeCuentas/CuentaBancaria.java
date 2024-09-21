package clase9.gestiondeCuentas;

public class CuentaBancaria {
    private double saldoInicial;
    

    public CuentaBancaria(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public CuentaBancaria() {
        this.saldoInicial = 0;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
    
    public void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldoInicial) {
            throw new SaldoInsuficienteException("Saldo insuficiente para la cantidad solicitada");
        } else {
            double nuevoSaldo = saldoInicial - cantidad;
            saldoInicial = nuevoSaldo;
            System.out.println("Retiro exitoso. Saldo restante: "+saldoInicial);
        }
    }





    


}
