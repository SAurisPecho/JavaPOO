public class Animal {
    
    protected String nombre;
    protected Integer edad;

    public Animal() {
    }

    public Animal(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre () {
        return nombre;
    }

    public Integer getEdad () {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void comer() {
        System.out.println(nombre+" está comiendo.");
    }

    public void dormir() {
        System.out.println(nombre+" esta durmiendo.") ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((edad == null) ? 0 : edad.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (edad == null) {
            if (other.edad != null)
                return false;
        } else if (!edad.equals(other.edad))
            return false;
        return true;
    }

    
}

// Creamos una clase llamada "Animal". Esta clase debe incluir los atributos "nombre" y "edad", así como los métodos "comer()" y "dormir()".
// En este contexto, la clase "Animal" actúa como la superclase o clase padre.

