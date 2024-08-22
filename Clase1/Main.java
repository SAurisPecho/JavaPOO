public class Main {
    public static void main(String[] args) {
        Persona num1 = new Persona();
        num1.nombre = "Amanda";
        num1.edad = 24;
        num1.imprimirDatos();
        Persona carla = new Persona();
        carla.nombre = "Carla";
        carla.edad = 22;
        carla.imprimirDatos();

        System.out.println("Auto 1");
        Auto auto1 = new Auto("Toyota", "Corolla", 2020); 
        auto1.imprimirDatos();
        System.out.println("Auto 2");
        Auto auto2 = new Auto("Honda", "Civic");
        auto2.imprimirDatos();
        System.out.println("Auto 3");
        Auto auto3 = new Auto("Ford");
        auto3.imprimirDatos();
        System.out.println("Auto 4");
        Auto auto4 = new Auto();
        Auto.imprimirDatos(auto4);
    }
}