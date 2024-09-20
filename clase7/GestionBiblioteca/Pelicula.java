package clase7.GestionBiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pelicula extends ItemBiblioteca implements Catalogable {
    private String titulo;
    private String genero;
    private boolean prestada;
    private LocalDate fechaPrestamo;
    private static double multaXdia = 1.5;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.prestada = false;
        this.fechaPrestamo = LocalDate.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isPrestada() {
        return prestada;
    }

    public void setPrestada(boolean prestada) {
        this.prestada = prestada;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public double calcularMultas(LocalDate fechaDevolucion) {
        if (fechaDevolucion.isAfter(fechaPrestamo)) {
            long dias = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);
            return (dias * multaXdia);
        }

        return 0.0;
    }

    @Override
    public void devolver() {
        if (prestada) {
            prestada = false;
            fechaPrestamo = null;
            System.out.println("Pelicula devuelta");
        } else {
            System.out.println("La pelicula no esta prestada");
        }
    }

    @Override
    public void prestar() {
        if (!prestada) {
            prestada = true;
            fechaPrestamo = LocalDate.now();
            System.out.println("Pelicula prestada el dia: "+fechaPrestamo);
        } else {
            System.out.println("La pelicula ya esta prestada");
        }
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Titulo : "+titulo);
        System.out.println("Genero : "+genero);
        System.out.println("fecha de Prestamo: "+fechaPrestamo != null ? fechaPrestamo : "No prestada");
        System.out.println("**********************************");
    }
    
}
