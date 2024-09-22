package clase10;

import clase10.modelos.Cliente;
import clase10.modelos.Producto;
import clase10.modelos.ProductoElectronico;
import clase10.modelos.ProductoRopa;
import clase10.servicios.MenuServicio;

public class Main {
    public static void main(String[] args) {
        Producto[] productosAlmacen = {
            new ProductoElectronico("SmartWatch", 450, 8, "tercera generacion", "Apple", 24),
            new ProductoRopa ("Polo", 35, 10, "Rosado", 'M', "Algodon"),
            new ProductoElectronico("Laptop", 1119, 12, "8GB RAM", "Lenovo", 12),
            new ProductoRopa("Pantalon", 75, 12, "Beige", 'L', "Jeans"),
        };

        Cliente cliente = new Cliente("Math");
        MenuServicio.mostrarMenu(cliente, productosAlmacen);
    }
}