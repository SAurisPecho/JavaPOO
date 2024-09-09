public class Jugador extends Persona {

    public int goles = 0;
    
    public Jugador () {}

    public Jugador(String nombre, Integer edad, Equipo equipo) {
        super(nombre,edad,equipo);
    }

    public Jugador (String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = null;
        this.goles = 0;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.edad = 0;
        this.equipo = null;
        this.goles = 0;
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

    @Override
    public void gritarGol() {
        System.out.println(nombre+" metio gol!!!");
    }

}

// Luego, se procede a:
// Incluir en la clase padre 'Persona' todos los atributos comunes como 'nombre', 'edad' y 'Equipo', así como un método 'gritarGol()',
// el cual imprimirá el grito de gol de cada persona y deberá ser sobrescrito por las distintas subclases.
// Realizar modificaciones en el código para que la clase 'Jugador' también sea una subclase de 'Persona', permitiendo así 
// la creación tanto de 'Jugador' como de 'Entrenador'.
// Agregar la opción 'Gritar Gol' en la sección 'Seleccionar equipo' del menú, donde se imprimirá el grito de gol de cada persona del equipo.