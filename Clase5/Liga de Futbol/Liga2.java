import java.util.Scanner;
import java.util.ArrayList;

public class Liga2 {
    public static Scanner consola = new Scanner(System.in);
    public static ArrayList<Equipo> equipos = new ArrayList<>();
    public static ArrayList<Jugador> jugadores = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú");
            System.out.println("1. Crear jugador\n2. Crear equipo\n3. Asignar jugador a equipo\n4. Mostrar lista de jugadores\n5. Mostrar lista de equipos");
            System.out.println("6. Eliminar jugador\n7. Eliminar Equipo\n8. Seleccionar jugador\n9. Seleccionar equipo\n10. Salir");      
            System.out.print("Elija una opcion: ");
            int opcion = consola.nextInt();
            consola.nextLine();

            switch (opcion) {
                case 1 -> crearJugador();
                case 2 -> crearEquipo();
                case 3 -> asignarJugadorAEquipo();
                case 4 -> mostrarJugadores();
                case 5 -> mostrarEquipos();
                case 6 -> eliminarJugador();
                case 7 -> eliminarEquipo();
                case 8 -> seleccionarJugador();
                case 9 -> seleccionarEquipo();
                case 10 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opción inválida!");
            }
        }
    }

    private static void crearJugador() {
        System.out.println("Ingrese el nombre del jugador: ");
        String nombreJugador = consola.nextLine();
        if (equipos.isEmpty()) {
            jugadores.add(new Jugador(nombreJugador));
            System.out.println("Jugador creado sin equipo (no hay equipos disponibles).");
        } else {
            mostrarEquipos();
            System.out.print("Seleccione el número de equipo para asignar al jugador, o 0 para no asignar: ");
            int equipoOpcion = consola.nextInt();
            consola.nextLine();
            Jugador nuevo = new Jugador(nombreJugador);
            jugadores.add(nuevo);
            if (equipoOpcion > 0 && equipoOpcion <= equipos.size()) {
                Equipo equipoElegido = equipos.get(equipoOpcion-1);
                equipoElegido.addJugador(nuevo);
                System.out.println("Jugador creado: "+nuevo.getNombre() +", asignado al equipo: " + equipoElegido.getNombre() + ".");
            } else {
                System.out.println("Jugador creado sin equipo.");
            }
        }
    }

    private static void crearEquipo () {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = consola.nextLine();
        equipos.add(new Equipo(nombreEquipo));
        System.out.println("Equipo creado exitosamente.");
    }

    public static void asignarJugadorAEquipo () {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados.");
            return;
        } 
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos creados.");
            return;
        }
        
        mostrarJugadores();
        System.out.println("Elija entre uno de los jugadores: ");
        int jugadorNum = consola.nextInt();
        consola.nextLine();
        if (jugadorNum > 0 && jugadorNum <= jugadores.size()) {
            Jugador jugadorSeleccionado = jugadores.get(jugadorNum-1);
            
            mostrarEquipos();
            System.out.println("Elija entre uno de los equipos, para asignarle a el jugador");
            int equipoNumero = consola.nextInt();
            consola.nextLine();
            if (equipoNumero > 0 && equipoNumero <= equipos.size()) {
                Equipo equipoSeleccionado = equipos.get(equipoNumero-1);
                equipoSeleccionado.addJugador(jugadorSeleccionado);
                System.out.println("Jugador: "+jugadorSeleccionado.getNombre()+", se agrego al equipo: "+equipoSeleccionado.getNombre());
            } else {
                System.out.println("Opcion de equipo no valida");
            }
        } else {
            System.out.println("Opcion de jugador no valida");
        }
    }

    private static void mostrarJugadores () {
        if (jugadores.isEmpty()) {
            System.out.println("No se han creado jugadores.");
        } else {
            System.out.println("Lista de jugadores: ");
            for (int i = 0; i < jugadores.size(); i++) {
                Jugador jugador = jugadores.get(i);
                String nombreEquipo = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombre() : "Null";
                System.out.println((i+1)+". Jugador: "+jugador.getNombre()+", Equipo: "+nombreEquipo);
            }
        }
    }

    private static void mostrarEquipos () {
        if (equipos.isEmpty()) {
            System.out.println("No se han creado equipos.");
        } else {
            System.out.println("Lista de equipos: ");
            for (int i = 0; i < equipos.size(); i++) {
                if (equipos.get(i) == null) {
                    break;
                }
                System.out.println((i+1)+". "+equipos.get(i).getNombre());
            }
        }
    }

    private static void eliminarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay ningun jugador creado.");
            return;
        } else {
            mostrarJugadores();
            System.out.println("Seleccione la opcion del jugador a eliminar: ");
            int jugadoraEliminar = consola.nextInt();
            consola.nextLine();
            if (jugadoraEliminar > 0 && jugadoraEliminar <= jugadores.size()) {
                Jugador jugadorEliminado = jugadores.remove(jugadoraEliminar-1);
                if (jugadorEliminado.getEquipo() != null ) {
                    jugadorEliminado.getEquipo().getJugadores().remove(jugadorEliminado);
                }
                System.out.println("Jugador " + jugadorEliminado.getNombre() + " eliminado exitosamente.");
            } else {
                System.out.println("Opción inválida!");
            }
        }
    }

    private static void eliminarEquipo() {
        if (equipos.isEmpty()) {
            System.out.println("No hay ningun jugador creado.");
            return;
        } else {
            mostrarEquipos();
            System.out.println("Seleccione la opcion del equipo a eliminar: ");
            int equipoaEliminar = consola.nextInt();
            consola.nextLine();
            if (equipoaEliminar > 0 && equipoaEliminar <= equipos.size()) {
                Equipo equipoEliminado = equipos.remove(equipoaEliminar-1);
                for (Jugador jugador : equipoEliminado.getJugadores()) {
                    jugador.setEquipo(null);
                }
                System.out.println("Equipo: "+equipoEliminado.getNombre()+" eliminado exitosamente.");
            } else {
                System.out.println("Opción inválida.");   
            }
        }
    }

    private static void seleccionarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay ningun jugador creado.");
            return;
        } else {
            mostrarJugadores();
            System.out.print("Seleccione un jugador para ver/modificar: ");
            int opcionJugador = consola.nextInt();
            consola.nextLine();
            if (opcionJugador > 0 && opcionJugador <= jugadores.size()) {
                Jugador jugadorVer = jugadores.get(opcionJugador-1);
                boolean salidaVerMasJugador = false;
                while (!salidaVerMasJugador) {
                    System.out.println("Jugador Ver Más:");
                    System.out.println("1. Ver detalles\n2. Cambiar nombre\n3. Cambiar equipo\n4. Regresar al menú principal");
                    System.out.print("Elija una opcion: ");
                    int opcionVerMas = consola.nextInt();
                    consola.nextLine();
                    switch (opcionVerMas) {
                        case 1 -> verDetalles(jugadorVer);
                        case 2 -> cambiarNombre(jugadorVer);
                        case 3 -> cambiarEquipo(jugadorVer);
                        case 4 -> {
                            System.out.println("Saliendo de Ver Mas Jugador...");
                            salidaVerMasJugador = true;
                        }              
                        default -> System.out.println("Opción no válida.");
                    }
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private static void verDetalles(Jugador jugadorVer) {
        System.out.println("Nombre: " + jugadorVer.getNombre());
        System.out.println("Equipo: " + (jugadorVer.getEquipo() != null ? jugadorVer.getEquipo().getNombre() : "Sin equipo"));
    }

    private static void cambiarNombre(Jugador jugadorVer) {
        System.out.print("Ingrese el nuevo nombre del jugador: ");
        String nombre = consola.nextLine();
        jugadorVer.setNombre(nombre);
        System.out.println("Nombre actualizado correctamente.");
    }

    private static void cambiarEquipo(Jugador jugadorVer) {
        mostrarEquipos();
        System.out.println("Elija entre uno de los equipos, para asignarle a el jugador");
        int equipoNumero = consola.nextInt();
        consola.nextLine();
        if (equipoNumero > 0 && equipoNumero <= equipos.size()) {
            Equipo equipoSeleccionado = equipos.get(equipoNumero-1);
            equipoSeleccionado.addJugador(jugadorVer);
            System.out.println("Jugador: "+jugadorVer.getNombre()+", se agrego al equipo: "+equipoSeleccionado.getNombre());
        } else {
            System.out.println("Opcion de equipo no valida");
        }
    }

    private static void seleccionarEquipo() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay ningun equipo creado.");
            return;
        } else {
            mostrarEquipos();
            System.out.print("Seleccione un equipo para ver/modificar: ");
            int opcionEquipo = consola.nextInt();
            consola.nextLine();
            if (opcionEquipo > 0 && opcionEquipo <= equipos.size()) {
                Equipo equipoVer = equipos.get(opcionEquipo-1);
                boolean salidaVerMasEquipo = false;
                while (!salidaVerMasEquipo) {
                    System.out.println("Equipo Ver Más:");
                    System.out.println("1. Ver detalles\n2. Cambiar nombre\n3. Agregar jugador al equipo\n4. Mostrar jugadores del equipo.\n5. Meter gol\n6. Gritar gol\n7. Regresar al menú principal");
                    System.out.print("Elija una opcion: ");
                    int opcionVerMas = consola.nextInt();
                    consola.nextLine();
                    switch (opcionVerMas) {
                        case 1 -> verDetalls(equipoVer);
                        case 2 -> cambioNombre(equipoVer);
                        case 3 -> agregarJugador(equipoVer);
                        case 4 -> mostrarJugadoresEquipo(equipoVer);
                        case 5 -> meterGol();
                        case 6 -> gritarGol();
                        case 7 -> {
                            System.out.println("Saliendo de Ver Mas Jugador...");
                            salidaVerMasEquipo = true;
                        }              
                        default -> System.out.println("Opción no válida.");
                    }
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void verDetalls (Equipo equipoVer) {
        System.out.println("Equipo: " + equipoVer.getNombre());
        System.out.println("Número de jugadores: " + equipoVer.getJugadores().size());
    }

    public static void cambioNombre (Equipo equipoVer) {
        System.out.print("Ingrese el nuevo nombre del equipo: ");
        String nombre = consola.nextLine();
        equipoVer.setNombre(nombre);
        System.out.println("Nombre actualizado correctamente.");
    }

    public static void agregarJugador (Equipo equipoVer) {
        mostrarJugadores();
        System.out.println("Elija entre uno de los jugadores, para asignarle a el equipo");
        int jugadorNumero = consola.nextInt();
        consola.nextLine();
        if (jugadorNumero > 0 && jugadorNumero <= jugadores.size()) {
            Jugador jugadorSeleccionado = jugadores.get(jugadorNumero-1);
            jugadorSeleccionado.setEquipo(equipoVer);
            System.out.println("Equipo: "+equipoVer.getNombre()+", se agrego el jugador: "+jugadorSeleccionado.getNombre());
        } else {
            System.out.println("Opcion de jugador no valida");
        }
    }

    public static void mostrarJugadoresEquipo (Equipo equipoVer) {
        System.out.println("Lista de jugadores del equipo " + equipoVer.getNombre() + ":");
        if (equipoVer.getJugadores().isEmpty()) {
            System.out.println("Este equipo no tiene jugadores asignados.");
        } else {
            for (int i = 0; i < equipoVer.getJugadores().size(); i++) {
                Jugador jugador = equipoVer.getJugadores().get(i);
                String nombreEquipo = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombre() : "Null";
                System.out.println((i+1)+". Jugador: "+jugador.getNombre()+", Equipo: "+nombreEquipo);
            }
        }
    }

    public static void meterGol () {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados");
            return;
        }

        mostrarJugadores();
        System.out.println("Seleccione al jugador que anoto un gol: ");
        int jugadorGol = consola.nextInt();
        consola.nextLine();

        if (jugadorGol > 0 && jugadorGol <= jugadores.size()) {
            Jugador jugadorSeleccionado = jugadores.get(jugadorGol-1);
            jugadorSeleccionado.goles++;
            jugadorSeleccionado.gritarGol();
        } else {
            System.out.println("Opcion de jugador no valida.");
        }
    }

    public static void gritarGol () {
        if(jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados.");
            return;
        }
        
        mostrarJugadores();
        System.out.println("Seleccione el número del jugador que desee gritarle gol: ");
        int opcionJug = consola.nextInt();
        consola.nextLine();

        if(opcionJug > 0 && opcionJug <= jugadores.size()) {
            Jugador jugadorSeleccionado = jugadores.get(opcionJug-1);
            jugadorSeleccionado.gritarGol();
        } else {
            System.out.println("Opción elegida no valida.");
        }
    }

// Para esto deberás generar una clase “Jugador” y una “Equipo”. Para relacionar ambas clases vamos a utilizar una agregación, recomendamos que el jugador tenga un atributo del tipo “Equipo” para facilitar la resolución. Con esto, el menú deberá permitir realizar las siguientes acciones: 
// Crear jugador: Esta opción te permitirá crear un nuevo jugador. Deberás pedir al usuario el nombre del jugador y mostrar la lista de equipos disponibles para que elija uno, si no hay equipos creados entonces debería mostrar un mensaje que diga que no hay equipos disponibles y setear null.
// Crear equipo: Esta opción te permitirá crear un nuevo equipo. Deberás pedir al usuario el nombre del equipo.
// Asignar jugador a equipo: Con esta opción, podrás asignar un jugador existente a un equipo existente. Deberás permitir al usuario seleccionar de la lista de jugadores y equipos existentes.
// Mostrar lista de jugadores: Esta opción mostrará una lista de todos los jugadores creados, junto con el nombre del equipo al que están asignados, si corresponde.
// Mostrar lista de equipos: Esta opción mostrará una lista de todos los equipos creados.
// Salir: Esta opción termina la ejecución del programa.

//LIGA DE FUTBOL II
// Eliminar jugador:  Debe permitir seleccionar un jugador para ser eliminado de una lista (tipo array) total de jugadores. 
// Eliminar Equipo:  Debe permitir eliminar un equipo de una lista total de equipos.
// Seleccionar jugador: Con esta opción, podrás seleccionar un jugador específico para ver o modificar sus detalles. Esto debería llevar a un submenú con las siguientes opciones:
    // Ver detalles: Muestra el nombre del jugador y el equipo al que está asignado.
    // Cambiar nombre: Permite al usuario cambiar el nombre del jugador.
    // Cambiar equipo: Permite al usuario cambiar el equipo al que está asignado el jugador.
    // Regresar al menú principal.
// Seleccionar equipo: Al elegir esta opción, se debe mostrar la lista de equipos, seleccionar uno y luego mostrar el siguiente submenú con las siguientes opciones:
    // Ver detalles.
    // Cambiar nombre: Debes asegurarte que cambie el nombre de la instancia de equipo que pertenece a cada jugador también.
    // Agregar jugador al equipo: se debe mostrar la lista de jugadores para que el usuario elija a cual asignarle el equipo.
    // Mostrar jugadores del equipo.
    // Regresar al menú principal.

// Agregar la opción 'Gritar Gol' en la sección 'Seleccionar equipo' del menú, donde se imprimirá el grito de gol de 
// cada persona del equipo.

}
