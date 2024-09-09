public class Persona {
    
    protected String nombre;
    protected Integer edad;
    protected Equipo equipo;

    public Persona() { }

    public Persona(String nombre, Integer edad, Equipo equipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    public void gritarGol() {
        System.out.println("Gol de: "+nombre+" !");
    } 
}

// Partiendo del ejercicio de la liga de fútbol, se propone la creación de la superclase 'Persona'. Posteriormente, 
// se debe generar la subclase 'Entrenador', la cual hereda de 'Persona'.

