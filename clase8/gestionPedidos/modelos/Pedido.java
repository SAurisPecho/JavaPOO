package clase8.gestionPedidos.modelos;
import java.util.List;
import java.util.ArrayList;
import clase8.gestionPedidos.enums.EstadoPedido;

public class Pedido {
    private int numeroDePedido;
    private String cliente;
    private List<String> listaDeProductos;
    private EstadoPedido estadoDelPedido;
    
    public Pedido(int numeroDePedido, String cliente) {
        this.numeroDePedido = numeroDePedido;
        this.cliente = cliente;
        this.listaDeProductos = new ArrayList<>();
        this.estadoDelPedido = EstadoPedido.PENDIENTE;
    }

    public Pedido() {
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(int numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<String> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(List<String> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    public EstadoPedido getEstadoDelPedido() {
        return estadoDelPedido;
    }

    public void setEstadoDelPedido(EstadoPedido estadoDelPedido) {
        this.estadoDelPedido = estadoDelPedido;
    }

    public void agregarProducto(String nuevoProducto) {
        listaDeProductos.add(nuevoProducto);
    }

    @Override
    public String toString() {
        return "Pedido ["+
                "\nnumeroDePedido= " + numeroDePedido + 
                "\ncliente= " + cliente + 
                "\nlistaDeProductos= "+ listaDeProductos + 
                "\nestadoDelPedido= " + estadoDelPedido + 
                "\n]";
    }

}
