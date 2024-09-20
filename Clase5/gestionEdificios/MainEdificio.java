package clase5.gestionEdificios;

import java.util.ArrayList;

public class MainEdificio {
    public static void main(String[] args) {
        ArrayList<Edificio> edificios = new ArrayList<>();

        Polideportivo pol1 = new Polideportivo(20, 25, 40, "Polideportivo1", "Techado");
        Polideportivo pol2 = new Polideportivo(15, 20, 35, "Polideportivo2", "Abierto");

        EdificioDeOficinas ofi1 = new EdificioDeOficinas(35, 10, 50, 8, 15, 12);
        EdificioDeOficinas ofi2 = new EdificioDeOficinas(25, 11, 60, 10, 10, 6);

        edificios.add(pol1);
        edificios.add(pol2);
        edificios.add(ofi1);
        edificios.add(ofi2);

        int techados = 0;
        int abiertos = 0; 

        for (Edificio edificio : edificios) {
            System.out.println("Superficie: "+ edificio.calcularSuperficie());
            System.out.println("Volumen: "+ edificio.calcularVolumen());

            if (edificio instanceof Polideportivo p) {
                if (p.getTipoInstalacion().equalsIgnoreCase("Techado")) {
                    techados++;
                } else if (p.getTipoInstalacion().equalsIgnoreCase("Abierto")) {
                    abiertos++;
                }
            } else if (edificio instanceof EdificioDeOficinas o) {
                System.out.println("Capacidad de Personas: "+ o.cantPersonas());
            }
            System.out.println();
        }
        System.out.println("Polideportivos techados: "+ techados);
        System.out.println("Polideportivos abiertos: "+ abiertos);
    }
}