package clase7.GestionBiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Revista extends ItemBiblioteca implements Catalogable {
    private int nroEdicion;
    private int cantidadEjemplares;
    private String nombreRevista;
    private LocalDate fechaPrestada;
    private static double multaXdia = 1.0;

    public Revista() {
    }

    public Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista) {
        this.nroEdicion = nroEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.nombreRevista = nombreRevista;
        this.fechaPrestada = LocalDate.now();
    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public LocalDate getfechaPrestada() {
        return fechaPrestada;
    }

    public void setfechaPrestada(LocalDate fechaPrestada) {
        this.fechaPrestada = fechaPrestada;
    }

    @Override
    public double calcularMultas(LocalDate fechaDevolucion) {
        if (fechaDevolucion.isAfter(fechaPrestada)) {
            long dias = ChronoUnit.DAYS.between(fechaPrestada, fechaDevolucion);
            return (multaXdia*dias);
        }
        return 0.0;
    }

    @Override
    public void devolver() {
        cantidadEjemplares++;
        System.out.println("Revista devuelta. Ejemplares ahora disponibles: "+cantidadEjemplares);
    }

    @Override
    public void prestar() {
        if(cantidadEjemplares > 0) {
            cantidadEjemplares--;
            System.out.println("Revista prestada. Ejemplares restantes: "+cantidadEjemplares);
        } else {
            System.out.println("No hay ejemplares disponibles");
        }
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Nombre de la revista: "+nombreRevista);
        System.out.println("Numero de edicion: "+nroEdicion);
        System.out.println("Cantidad de ejemplares: "+cantidadEjemplares);
        System.out.println("**********************************");
    }
    
}
