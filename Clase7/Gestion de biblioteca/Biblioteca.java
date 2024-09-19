import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Libro> catalogo;
    private final ArrayList<Persona> personas;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public ArrayList<Libro> getCatalogo() {
        return catalogo;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void agregarLibros (Libro libro) {
        catalogo.add(libro);
        System.out.println("Libro: "+libro.getTitulo()+" , fue agregado al catalogo.");
        System.out.println();
    }

    public void agregarPersona (Persona persona) {
        personas.add(persona);
        System.out.println("Persona "+persona.getNombre()+" "+persona.getApellido());
        System.out.println();
    }

    public void prestarLibro(Persona persona, String libroTitulo) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(libroTitulo)) {
                if (!libro.isPrestado()) {
                    libro.prestar();
                    persona.prestarLibro(libro);
                    System.out.println("El libro: "+libroTitulo+" a sido prestado a "+persona.getNombre());
                    return;
                } else {
                    System.out.println("El libro: "+libroTitulo+" ya esta prestado");
                    return;
                }
            }
        }
        System.out.println("El libro "+libroTitulo+" no se encuentra en el catalogo");
    }

    public void devolverLibro(Persona persona, String libroTitulo) {
        for (Libro libro : persona.getLibrosPrestados()) {
            if (libro.getTitulo().equalsIgnoreCase(libroTitulo)) {
                libro.devolver();
                persona.devolverLibro(libro);
                System.out.println("El libro: "+libroTitulo+" a sido devuelto por "+persona.getNombre());
                return;
            }
        }
        System.out.println("El libro " + libroTitulo + " no esta prestado por " + persona.getNombre() + ".");
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catalogo esta vacio");
            System.out.println();
        } else {
            System.out.println("Biblioteca");
            for (Libro libro : catalogo) {
                System.out.println();
                libro.obtenerInformacion();
                System.out.println("*******************************************");
            }
        }
    }
    
    public void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas");
            System.out.println();
        } else {
            System.out.println("Registro de personas");
            for (Persona persona : personas) {
                System.out.println();
                System.out.println(persona.getNombre()+" "+persona.getApellido());
                System.out.println("*********************************************");
            }
        }
    }

    
}
