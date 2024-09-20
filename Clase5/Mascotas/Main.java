package clase5.Mascotas;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Animal> listaAnimales = new ArrayList<>();

        // Crear un perro
        Perro perro = new Perro("Koda", 3, "Border collie", 15);
        perro.comer();
        perro.dormir();
        perro.ladrar();

        // Crear un gato
        Gato gato = new Gato("Paco", 2, "Anaranjado");
        gato.comer();
        gato.dormir();
        gato.maulla();

        // Metodos hashCode y equals
        Perro perro1 = new Perro("Mico", 4, "Golden Retriver",16);
        Perro perro4 = new Perro("Mico", 4, "Golden Retriver",16);
        Perro perro2 = new Perro("Miak", 4, "Golden Retriver",16);
        Perro perro3 = new Perro("Oreo", 6, "Pastor Alemán", 9);

        metodo(perro1, perro1);
        metodo(perro1, perro4);
        metodo(perro2, perro3);
        
        listaAnimales.add(perro);
        listaAnimales.add(gato);
        listaAnimales.add(perro1);
        listaAnimales.add(perro2);
        listaAnimales.add(perro3);
        listaAnimales.add(new Perro("Ramon", 2, "Border collie", 5));
        listaAnimales.add(new Perro("fluf", 1, "Pastor Alemán", 4));
        listaAnimales.add(new Gato("Milk", 3, "Amarillo"));
        listaAnimales.add(new Gato("Cato", 1, "Anaranjado"));
        listaAnimales.add(new Gato("Moli", 2, "Amarillo"));

        for (Animal animal : listaAnimales) {
            if (animal instanceof Perro p) {
                System.out.println("Es un perro");
                p.comer();
                p.ladrar();
                p.dormir();
            } else if (animal instanceof Gato g) {
                System.out.println("Es un gato");
                g.comer();
                g.maulla();                
                g.dormir();
            } else {
                System.out.println("Es un animal genérico");
                animal.comer();
            }
        }
    }

    public static void metodo (Perro perro1, Perro perro2) {
        System.out.println("perro1.equals(perro2): "+ perro1.equals(perro2));
    }
}

// Sobrescribe los métodos "comer()" y "dormir()" en las subclases "Perro" y "Gato" para que muestren comportamientos específicos de cada animal.
// Sobrescribe el método "equals()" y "hashCode()" únicamente en la clase "Perro". La clase "Gato" no requerirá esta sobrescritura.
// Recuerda invocar estos métodos desde el método main() para demostrar su funcionamiento.

// Crearás una lista de objetos de tipo "Animal" y agregarás varios objetos de las clases "Perro" y "Gato". La lista debe contener al menos diez objetos. Luego, deberás:
// Recorrer la lista de objetos utilizando el operador Instanceof para identificar si cada objeto corresponde a una clase "Perro" o "Gato", e imprimir los resultados.
// Una vez identificada la instancia del objeto, el programa debe ejecutar los métodos propios y comunes del objeto.