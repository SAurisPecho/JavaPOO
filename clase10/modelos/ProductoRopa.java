package clase10.modelos;

import clase10.interfaces.Comprable;

public class ProductoRopa extends Producto implements Comprable {
    private char talla;
    private String material;

    public ProductoRopa() {
    }
    
    public ProductoRopa(String nombre, double precio, int stock, String descripcion, char talla, String material) {
        super(nombre, precio, stock, descripcion);
        this.talla = talla;
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("El material no puede estar vacio");
        }
        this.material = material;
    }

    public char getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "ProductoRopa: "+super.toString()+
                "\ntalla: " + talla + 
                "\nmaterial: " + material + 
                "\n**********************************************************";
    }

    @Override
    public double calcularPrecio() {
        //DESCUENTO
        double precio = getPrecio();
        double descuento = 0.10;
        if (precio > 50.00) {
            precio -= (precio * descuento);
        }
        return precio;
    }
    
    
}
