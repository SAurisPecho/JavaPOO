import java.util.ArrayList;

public class Equipo {

    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo() {}

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("Debe ingresar un nombre para el equipo.");
        } else {
            this.nombre = nombre;
        }
    }    

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
        jugador.setEquipo(this);
    }

}
