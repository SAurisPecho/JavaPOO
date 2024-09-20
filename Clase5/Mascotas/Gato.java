package clase5.Mascotas;
public class Gato extends Animal {
    
    private String color;
    
    public Gato() {
        super();
    }
    
    public Gato(String nombre, Integer edad, String color) {
        super(nombre, edad);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void maulla() {
        System.out.println(nombre+" está maullando, es un : "+getClass().getSimpleName());
    }

    
    @Override
    public void comer() {
        System.out.println("El gato "+nombre+" está comiendo comida para gatos."); ;
    }

    @Override
    public void dormir() {
        System.out.println("El gato "+nombre+" está durmiendo encima del sofá");
    }
}

// Crear dos clases que hereden de la clase "Animal": La clase "Perro" y la clase "Gato". Cada una de estas subclases debe poseer 
// sus propios atributos y métodos únicos. Por ejemplo, la clase "Perro" podría incluir el atributo "raza" y el método "ladrar()".