package Plano;

public class Punto {
    
    private double x;
    private double y;

    public Punto (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double distanciaDesdeOrigen (){
        return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }

    public static double calcularDistancia (Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2)+Math.pow(p2.getY()-p1.getY(), 2));
    }

    public static boolean estanAlineados (Punto p1, Punto p2, Punto p3) {
        double determinante =   p1.getX()*(p2.getY() - p3.getY()) + 
                                p2.getX()*(p3.getY() - p1.getY()) +
                                p3.getX()*(p1.getY() - p2.getY());
        return determinante == 0;
    }
    
}
