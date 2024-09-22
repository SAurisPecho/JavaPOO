package clase10.servicios;

import java.util.Scanner;

import clase10.interfaces.Comprable;
import clase10.modelos.Cliente;
import clase10.modelos.Producto;
import clase10.modelos.ProductoNoExistenteException;
import clase10.modelos.ReducirStockException;

public class MenuServicio {
    public static Scanner scanner = new Scanner(System.in);

    public MenuServicio () {
    }

    public static void mostrarMenu (Cliente cliente, Producto[] productos) {
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("Menu:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver el carrito");
            System.out.println("3. Realizar la compra");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                     agregarProductoAlCarrito(cliente, productos);
                    break;
                case 2:
                    cliente.getCarrito().verCarrito();
                    break;
                case 3:
                    realizarCompra(cliente);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }


    private static void realizarCompra(Cliente cliente) {
        System.out.println("Resumen de la compra:");
        cliente.getCarrito().verCarrito();
        System.out.println("¿Desea realizar la compra? (1: Sí, 2: No)");
        int confirmacion = scanner.nextInt();
        if (confirmacion == 1) {
            cliente.getCarrito().vaciarCarrito();
            System.out.println("Compra realizada con éxito.");
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    private static void agregarProductoAlCarrito(Cliente cliente, Producto [] productos) {
        System.out.println("Elija los productos para agregar al carrito: ");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i+1)+ ". "+productos[i]);
        }

        int productoSeleccionado = scanner.nextInt() - 1;
        if (productoSeleccionado < 0 || productoSeleccionado >= productos.length) {
            System.out.println("Opcion invalida");
            return;
        }

        Producto productoElegido = productos[productoSeleccionado];
        if (productoElegido instanceof Comprable) {
            Comprable productoComprable = (Comprable) productoElegido;
            System.out.println("Ingrese la cantidad a agregar: ");
            int cantidad = scanner.nextInt();
            try {
                cliente.getCarrito().agregarProducto(productoComprable, cantidad);
                
            } catch (ProductoNoExistenteException | ReducirStockException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
