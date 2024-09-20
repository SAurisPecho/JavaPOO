package clase1;
import java.util.Scanner;

public class Auto {

    String marca;
    String modelo;
    Integer anio;
    
    public Auto () {
        this.marca = "Desconocido";
        this.modelo = "Desconocido";
        this.anio = 0;
        if (marca == "Desconocido" && modelo == "Desconocido" && anio == 0 ) {
            System.out.println("El auto no tiene datos asignados.");
        }
    }

    public Auto (String marca, String modelo, Integer anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public Auto (String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = 0;
    }
    
    public Auto (String marca) {
        this.marca = marca;
        this.modelo = "Desconocido";
        this.anio = 0;
    }

    public void imprimirDatos () {
        System.out.println("Marca: "+marca+", Modelo: "+modelo+", Año: "+anio);
    }

    public static void imprimirDatos (Auto auto) {
        System.out.println("Marca: "+auto.marca+", Modelo: "+auto.modelo+", Año: "+auto.anio);
    }
    
    public static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salida = false;
        Auto auto = null;

        while (!salida) {
            System.out.print("Menú\n1 .Crear Auto\n2 .Ver Auto\n3 .Salir\nElija una opción: ");
            int opcion = consola.nextInt();
            consola.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la marca del auto: ");
                    String marca = consola.nextLine();
                    System.out.println("Ingrese el modelo del auto: ");
                    String modelo = consola.nextLine();
                    System.out.println("Ingrese el año del auto: ");
                    int anio = consola.nextInt();
                    consola.nextLine();
                    auto = new Auto(marca, modelo, anio);
                    break;
                case 2:
                    if (auto != null) {
                        auto.imprimirDatos();
                    } else {
                        System.out.println("Aún no se ha creado un auto.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    salida = true;
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
        
    }
}