package clase4.LigaFutbol1;

public class Jugador {

    private String nombre;
    private Equipo equipo;
    
    public Jugador () {}

    public Jugador(String nombre, Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.equipo = null;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("Debe ingresar un nombre para el jugador.");
        } else {
            this.nombre = nombre;
        }
    }
    
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}