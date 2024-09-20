package clase8.gestionPedidos;

import clase8.gestionPedidos.servicios.MenuServicio;
import clase8.gestionPedidos.servicios.PedidoServicio;

public class App {
    public static void main(String[] args) {
        PedidoServicio pedidoServicio = new PedidoServicio();
        MenuServicio menu = new MenuServicio(pedidoServicio);
        menu.mostrarMenu();
    }
}
