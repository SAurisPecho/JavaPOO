package Complementario;

public class Libro {
    
    private String titulo;
    private String autor;
    private int paginas;

    public Libro () {}

    public Libro (String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        if (!titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println("Debe colocar el nombre del libro.");
        }
        
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        if (!autor.isEmpty()) {
            this.autor = autor;
        } else {
            System.out.println("Debe colocar el nombre del autor.");
        }  
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        if (paginas > 0) {
            this.paginas = paginas * 7;
        } else {
            System.out.println("Numero invalido.");
        }
        
    }

    public void imprimirDetalles(){
        System.out.println("Titulo: "+getTitulo());
        System.out.println("Autor: "+getAutor());
        System.out.println("Paginas: "+getPaginas());
    }
}
