package clase5.Mascotas;
public class Perro extends Animal {
    
    private String raza;
    private Integer peso;

    public Perro() {
        super();
    }

    public Perro(String nombre, Integer edad, String raza, Integer peso) {
        super(nombre, edad);
        this.raza = raza;
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getpeso() {
        return peso;
    }

    public void setpeso(Integer peso) {
        this.peso = peso;
    }
    
    public void ladrar() {
        System.out.println(nombre+" esta ladrando, es un: "+getClass().getSimpleName());
    }
    
    @Override
    public void comer() {
       System.out.println(nombre+" está comiendo croquetas"); ;
    }

    @Override
    public void dormir() {
        System.out.println("El perro "+nombre+" está durmiendo en su cama.");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1 * super.hashCode();
        result = prime * result + ((raza == null) ? 0 : raza.hashCode());
        result = prime * result + ((peso == null) ? 0 : peso.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Perro other = (Perro) obj;
        if (raza == null) {
            if (other.raza != null)
                return false;
        } else if (!raza.equals(other.raza))
            return false;
        if (peso == null) {
            if (other.peso != null)
                return false;
        } else if (!peso.equals(other.peso))
            return false;
        return true;
    }   
}

// Crear dos clases que hereden de la clase "Animal": La clase "Perro" y la clase "Gato". Cada una de estas subclases debe poseer 
// sus propios atributos y métodos únicos. Por ejemplo, la clase "Perro" podría incluir el atributo "raza" y el método "ladrar()".