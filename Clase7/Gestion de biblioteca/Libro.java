import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Libro extends ItemBiblioteca implements Catalogable {
    private String titulo;
    private String autor;
    private int numeroDePaginas;
    private boolean prestado;
    private LocalDate fechaPrestamo;

    public Libro() {
    }

    public Libro(String titulo, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.prestado = false;
        this.fechaPrestamo = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public boolean isPrestado() {
        return prestado;
    }
    
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    @Override
    public double calcularMultas(LocalDate fechaDevolucion) {
        if (fechaDevolucion.isAfter(fechaPrestamo)) {
            long dias = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);
            double multaXdia = 2.5;
            return (dias * multaXdia);
        }
        return 0.0;
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            fechaPrestamo = null;
            System.out.println("Libro devuelto");
        } else {
            System.out.println("El libro no esta prestado");
        }
    }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            fechaPrestamo = LocalDate.now();
            System.out.println("Libro prestado el dia: "+fechaPrestamo);
        } else {
            System.out.println("El libro ya esta prestado");
        }
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Libro: "+titulo);
        System.out.println("Autor: "+autor);
        System.out.println("Numero de paginas: "+numeroDePaginas);
        System.out.println("Fue Prestado: " + (prestado == true ? "Si fue prestado" : "No fue prestado"));
        System.out.println("Fecha de Préstamo: " + (fechaPrestamo != null ? fechaPrestamo : "No prestado"));
        System.out.println("**********************************");
    }

    
    
}