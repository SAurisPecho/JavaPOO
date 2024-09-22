package clase10.modelos;

import java.util.ArrayList;
import java.util.List;

import clase10.interfaces.Comprable;

public class Carrito {
    private List<Comprable> listaProductos;

    public Carrito() {
        this.listaProductos = new ArrayList<>();
    }

    // El producto debe ser de una clase que implemente la interfaz comprable
    public void agregarProducto (Comprable producto, int cantidad) throws ProductoNoExistenteException, ReducirStockException {
        if (producto != null) {
            if (producto instanceof Producto) {
                Producto prod = (Producto) producto; 
                prod.reducirCantidad(cantidad);
                for (int i = 0; i < cantidad; i++) {
                    listaProductos.add(producto);
                    
                }
            } else {
            throw new ProductoNoExistenteException("Producto no existente");
            }
        }  else {
            throw new ProductoNoExistenteException("Producto no existente");
        }
    }

    public void verCarrito () {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos agregados al carrito");
        } else {
            for (int i = 0; i < listaProductos.size(); i++) {
                Comprable product = listaProductos.get(i);
                int unidades = 1;

                while (i+1 < listaProductos.size() && listaProductos.get(i+1).equals(product)) {
                    unidades++;
                    i++;
                }

                double precioUnitario = product.calcularPrecio();
                double total = precioUnitario * unidades;
                // Obtener el nombre del producto desde la instancia de Producto
                String nombreProducto = ((Producto) product).getNombre();

                System.out.println("Producto: "+ nombreProducto+" - "+unidades+" unidades x $"+precioUnitario+" (P.U.), Total: $"+total);
            }
            
        }
    }

    public double calcularPrecioTotal() {
        double total = 0;
        for (Comprable producto : listaProductos) {
            total += producto.calcularPrecio();
        }
        return total;
    }
    
    public boolean isEmpty() {
        return listaProductos.isEmpty();
    }

    public void vaciarCarrito () {
        listaProductos.clear();
    }
}
