package clase8.gestionPedidos.servicios;
import clase8.gestionPedidos.enums.EstadoPedido;
import clase8.gestionPedidos.modelos.Pedido;
import java.util.List;
import java.util.ArrayList;

public class PedidoServicio {
    private List<Pedido> listaPedidos;

    public PedidoServicio() {
        this.listaPedidos = new ArrayList<>();
    }

    public void crearNuevoPedido (int numeroDePedido, String cliente, List<String> listaDeProductos) {
        Pedido nuevoPedido = new Pedido(numeroDePedido, cliente);
        nuevoPedido.getListaDeProductos().addAll(listaDeProductos);
        listaPedidos.add(nuevoPedido);
    }

    public void actualizarEstadoPedidoExistente (int numeroDePedido,EstadoPedido nuevoEstado) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getNumeroDePedido() == numeroDePedido) {
                pedido.setEstadoDelPedido(nuevoEstado);
                return;
            }
        }
        System.out.println("No se encontro el pedido buscado");
    }

    public List<Pedido> buscarPedidosEstado (EstadoPedido estadoPedido) {
        List<Pedido> pedidosPorEstado = new ArrayList<>();
        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstadoDelPedido() == estadoPedido) {
                pedidosPorEstado.add(pedido);
            }
        }
        return pedidosPorEstado;
    }

    public List<Pedido> obtenerListaPedidos () {
        return listaPedidos;
    }
}
