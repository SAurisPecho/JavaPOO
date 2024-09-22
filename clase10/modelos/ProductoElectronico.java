package clase10.modelos;

import clase10.interfaces.Comprable;

public class ProductoElectronico extends Producto implements Comprable{
    private String marca;
    private int garantia;

    public ProductoElectronico() {
    }
    public ProductoElectronico(String nombre, double precio, int stock, String descripcion, String marca, int garantia) {
        super(nombre, precio, stock, descripcion);
        this.marca = marca;
        this.garantia = garantia;
    }

    public String getMarca() {
        return marca;
    }
    
    public int getGarantia() {
        return garantia;
    }
    @Override
    public String toString() {
        return "ProductoElectronico: "+super.toString()+
                "\nmarca: " + marca + 
                "\ngarantia: " + garantia + 
                "\n**********************************************************";
    }

    @Override
    public double calcularPrecio() {
        //DESCUENTO
        double precio = getPrecio();
        double descuento = 0.10;
        if (precio > 100.00) {
            precio -= (precio * descuento);
        }
        return precio;
    }
}