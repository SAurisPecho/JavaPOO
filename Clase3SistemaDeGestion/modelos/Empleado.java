package clase3SistemaDeGestion.modelos;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    
    //ATRIBUTOS
    private String nombre;
    private int edad;
    private double salario;
    private String departamento;

    //CONSTRUCTORES
    public Empleado() {}

    public Empleado (String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre no puede estar vacio.");
        }   
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 17) {
            this.edad = edad;
        } else {
            System.out.println("Edad no valida.");
        } 
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        } else {
            System.out.println("Dato no valido.");
        }
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (!departamento.isEmpty()) {
            this.departamento = departamento;
        } else {
            System.out.println("Dato no valido!");
        }
    }

     //METODOS

    public static Scanner consola = new Scanner(System.in);

    public static void crearEmpleado(ArrayList<Empleado> lista) {
        System.out.print("Ingrese el nombre del nuevo empleado: ");
        String nombre = consola.nextLine();

        if (buscarNombre(lista, nombre) != null) {
            System.out.println("Error: Ya existe un empleado con ese nombre.");
            return;
        }

        System.out.print("Ingrese la edad del empleado: ");
        int edad = consola.nextInt();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = consola.nextDouble();
        consola.nextLine(); 
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = consola.nextLine();

        lista.add(new Empleado(nombre, edad, salario, departamento));
        System.out.println("Empleado creado exitosamente.");
    }
    
    public static void mostrarEmpleados (ArrayList<Empleado> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay empleados para mostrar");
        } else {
            System.out.println("_________________________________________________________________________");
            System.out.println("|__N°__|_______Nombre________|__Edad__|__Salario____|____Departamento____|");
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) == null) {
                    break;
                }
                //Numero de empleado
                if (i < lista.size()) {
                    System.out.print("|__"+(i+1)+" __|");
                } else {
                    System.out.print("|_"+(i+1)+" _|");
                }
                //Nombre
                int longitudNombre = lista.get(i).getNombre().length();
                int longitudEncabezado = "_______Nombre________".length();
                if (longitudNombre < longitudEncabezado) {
                    System.out.print(lista.get(i).getNombre()+" ");
                    for (int j = 0; j < longitudEncabezado-longitudNombre-1; j++) {
                        System.out.print("_");
                    }
                    System.out.print("|");
                } else {
                    System.out.print(lista.get(i).getNombre().substring(0, longitudEncabezado)+"|");
                }
                //Edad
                if (lista.get(i).getEdad() < 10) {
                    System.out.print("__0"+lista.get(i).getEdad()+"__|");
                } else {
                    System.out.print("__"+lista.get(i).getEdad()+" ___|");
                }
                //Salario
                String salario = String.valueOf(lista.get(i).getSalario());
                int longitudSalario = salario.length();
                int longitudEncabezadoSalario = "__Salario__".length();
                if (longitudSalario < longitudEncabezadoSalario) {
                    System.out.print("_$"+lista.get(i).getSalario()+" ");
                    for (int in = 0; in < longitudEncabezadoSalario-longitudSalario-1; in++) {
                        System.out.print("_");
                    }
                    System.out.print("|");
                } else {
                    System.out.print(lista.get(i).getSalario()+"|");
                }
                //Departamento
                int longitudDep = lista.get(i).getDepartamento().length();
                int longitudEncabezadoDep = "____Departamento____".length();
                if (longitudDep < longitudEncabezadoDep) {
                    System.out.print(lista.get(i).getDepartamento()+" ");
                    for (int j = 0; j < longitudEncabezadoDep-longitudDep-1; j++) {
                        System.out.print("_");
                    }
                    System.out.print("|");
                } else {
                    System.out.println(lista.get(i).getDepartamento()+"|");
                }
                System.out.println();
            }
            System.out.println("|________________________________________________________________________|");
        }
    }

    public static void filtrarEmpleados (ArrayList<Empleado> lista) {
        ArrayList<Empleado> empleadosFiltro = new ArrayList<>();
        empleadosFiltro.clear();

        System.out.print("Ingrese el atributo por el que desea filtrar (nombre, edad, salario, departamento): ");
        String filtro = consola.nextLine();

        switch (filtro.toLowerCase()) {
            case "nombre"-> {
                System.out.print("Ingrese el nombre a filtrar: ");
                String nombre = consola.nextLine();
                for (Empleado e : lista) {
                    if (e == null) {
                        break;
                    }
                    if (e.getNombre().equalsIgnoreCase(nombre)) {
                        empleadosFiltro.add(e);
                    }
                }
            }
            case "edad"-> {
                System.out.println("Ingrese la edad minima: ");
                int minEdad = consola.nextInt();
                System.out.println("Ingrese la edad maxima: ");
                int maxEdad = consola.nextInt();
                if (minEdad > 17 ) {
                    for (Empleado e : lista) {
                        if (e.getEdad() >= minEdad && e.getEdad() <= maxEdad) {
                            empleadosFiltro.add(e);
                        }
                    }
                }
            }
            case "salario"-> {
                System.out.print("Ingrese el salario minimo: ");
                int minSalario = consola.nextInt();
                System.out.print("Ingrese el salario maximo: ");
                int maxSalario = consola.nextInt();
                for (Empleado e : lista) {
                    if (e.getSalario() >= minSalario && e.getSalario() <= maxSalario) {
                        empleadosFiltro.add(e);
                    }
                }
            }
            case "departamento"-> {
                System.out.print("Ingrese el departamento a filtrar: ");
                String departamento = consola.nextLine();
                for (Empleado e : lista) {
                    if (e.getDepartamento().equalsIgnoreCase(departamento)) {
                        empleadosFiltro.add(e);
                    }
                }
            }
            default -> System.out.println("Opcion no valida!");
        }

        if (empleadosFiltro.isEmpty()) {
            System.out.println("No se encontraron empleados que coincidan con el filtro.");
        } else {
            mostrarEmpleados(empleadosFiltro);
        }
    }

    public static void ordenarEmpleados (ArrayList<Empleado> lista) {
        System.out.println("Ordenar\n(1) nombre\n(2)edad\n(3)salario\n(4)departamento\n:Ingrese el atributo por el que desea ordenar: ");
        int opcion = consola.nextInt();

        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {           //recorre la lista segun n
            for (int j = 0; j < n - i - 1; j++) {       //comparar cada par elementos no ordenados
                if (comparar(lista.get(j), lista.get(j+1), opcion) > 0) {    //compara si el primer elemento es mayor al segundo segun el atributo, si es mayor se intercambia de posicion
                    Empleado temp = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, temp);
                }
            }
        }
        mostrarEmpleados(lista);
    }

    public static int comparar (Empleado e1, Empleado e2, int opcion) {
        return switch (opcion) {
            case 1 -> e1.getNombre().compareToIgnoreCase(e2.getNombre());               //Nombre
            case 2 -> Integer.compare(e1.getEdad(), e2.getEdad());                      //Edad
            case 3 -> Double.compare(e1.getSalario(), e2.getSalario());                 //Salario
            case 4 -> e1.getDepartamento().compareToIgnoreCase(e2.getDepartamento());   //Departamento
            default -> 0;
        } ;
    }

    public static Empleado buscarNombre (ArrayList<Empleado> lista, String nombre ) {
        for (Empleado e : lista) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public static void incrementarSalario (ArrayList<Empleado> lista) {
        System.out.print("Ingrese el nombre del empleado al que desea incrementar el salario: ");
        String nombre = consola.nextLine();
        Empleado e = Empleado.buscarNombre(lista, nombre);
        if (e != null) {
            System.out.print("Ingrese el porcentaje de aumento salarial: ");
            double porcentaje = consola.nextDouble();
            double aumentoSalarial = e.getSalario()* (1 + porcentaje/100);
            e.setSalario(aumentoSalarial);
            System.out.println("Salario incrementado exitosamente.");
            imprimirEmpleado(e);
        } else {
            System.out.println("Empleado no encontrado.");
        }
        
    }

    public static void imprimirEmpleado (Empleado e) {
        System.out.println("________________________________________________________________");
        System.out.println("|_______Nombre________|__Edad__|__Salario__|____Departamento____|");
        System.out.printf("%-26s %-5s %-10s %-20s\n",e.getNombre(), e.getEdad(), e.getSalario(), e.getDepartamento());
    }

    public static void limpiarFiltros (ArrayList<Empleado> filtracion) {
        filtracion.clear();
        System.out.println("Filtros limpiados. Ahora se muestran todos los empleados.");
    }
}
