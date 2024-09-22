package clase10.modelos;

public class Cliente {
    private String nombre;
    private Carrito carrito;

    public Cliente() {
        this.carrito = new Carrito();
    }

    public Cliente(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
        this.carrito = new Carrito();
    }

    public String getNombre() {
        return nombre;
    }

    public Carrito getCarrito() {
            return carrito;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + 
                "\ncarrito=" + carrito.toString();
    }
    
}