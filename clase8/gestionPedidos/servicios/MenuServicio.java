package clase8.gestionPedidos.servicios;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

import clase8.gestionPedidos.enums.EstadoPedido;
import clase8.gestionPedidos.modelos.Pedido;

public class MenuServicio {
    private Scanner scanner;
    private PedidoServicio pedidoServicio;

    public MenuServicio(PedidoServicio pedidoServicio) {
        this.scanner = new Scanner(System.in);
        this.pedidoServicio = pedidoServicio;
    }

    public void mostrarMenu() {
        int opcion;
        boolean salir = false;
        do {
            System.out.println("Menu Pedidos");
            System.out.println("1. Crear un nuevo pedido");
            System.out.println("2. Actualizar el estado de un pedido");
            System.out.println("3. Buscar pedidos por estado");
            System.out.println("4. Mostrar la lista de pedidos");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> crearPedido();
                case 2 -> actualizarEstado();
                case 3 -> buscarPedidoPorEstado();
                case 4 -> mostrarListaProd();
                case 5 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                } 
                default -> System.out.println("Opcion no valida");
            }
        } while (!salir);
    }

    private void crearPedido() {
        System.out.print("Ingrese el numero del pedido: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese la lista de productos separado por comas: ");
        String[] listaProd = scanner.nextLine().split(",");

        pedidoServicio.crearNuevoPedido(numeroPedido, nombreCliente, Arrays.asList(listaProd));
        System.out.println("Pedido creado.");
    }
    
    private void actualizarEstado() {
        System.out.println("Ingrese el numero del pedido");
        int numPedido = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nuevo estado del pedido");
        EstadoPedido nuevEstado = EstadoPedido.valueOf(scanner.nextLine().toUpperCase());
        pedidoServicio.actualizarEstadoPedidoExistente(numPedido, nuevEstado);

        System.out.println("El estado del pedido fue actualizado con exito.");
    }
    
    private void buscarPedidoPorEstado() {
        System.out.println("Ingrese el estado del pedido a buscar: (PENDIENTE, ENTREGADO, ENVIADO)");
        EstadoPedido estado = EstadoPedido.valueOf(scanner.nextLine().toUpperCase());
        List<Pedido> pedidosEstado = pedidoServicio.buscarPedidosEstado(estado);

        if (pedidosEstado.isEmpty()) {
            System.out.println("No se encontraron pedidos con ese estado");
        } else {
            System.out.println("Pedidos en estado "+estado);
            for (Pedido pedido : pedidosEstado) {
                System.out.println(pedido);
            }
        }
    }

    private void mostrarListaProd() {
        List<Pedido> todosLosPedidos = pedidoServicio.obtenerListaPedidos();
        if (todosLosPedidos.isEmpty()) {
            System.out.println("No se encontro ningun pedido registrado");
        } else {
            System.out.println("Pedidos registrados: ");
            for (Pedido pedido : todosLosPedidos) {
                System.out.println(pedido);
            }
        }
    }
}
