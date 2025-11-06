package controlversiones_gersonagustin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> estudiantes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int totalEstudiantes = 0;
    
    public static void main(String[] args) {
        mostrarMenu();
    }
    
    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Ver estudiantes");
            System.out.println("3. Buscar estudiante"); 
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
            case 1:
            agregarEstudiante();
            break;
            case 2:
            verEstudiantes();
            break;
            case 3:  // NUEVA OPCIÓN DE BÚSQUEDA
            buscarEstudiante();
            break;
            case 4:
            System.out.println("¡Hasta luego! Gracias por usar el sistema."); //CAMBIO MENSAJE DESPEDIDA
            break;
            default:
            System.out.println("Opcion invalida");

            }
        } while(opcion != 4); 
    }
    
public static void agregarEstudiante() {
    System.out.print("Ingrese nombre del estudiante: ");
    String nombre = scanner.nextLine();
    
    // VALIDACIONES AGREGADAS
    if (nombre.trim().isEmpty()) {
        System.out.println("Error: El nombre no puede estar vacio");
        return;
    }
    
    if (estudiantes.contains(nombre)) {
        System.out.println("Error: El estudiante ya existe");
        return;
    }
    
    estudiantes.add(nombre);
    totalEstudiantes++; // CONTADOR AGREGADO
    System.out.println("Estudiante agregado: " + nombre);
    System.out.println("Total de estudiantes: " + totalEstudiantes);
}
    
    
    public static void verEstudiantes() {
        System.out.println("\n=== LISTA DE ESTUDIANTES ===");
        if (estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes registrados.");
        } else {
        System.out.println("Lista completa:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + estudiantes.get(i));
        }
        mostrarEstadisticas();  // LLAMADA A ESTADISTICAS - NUEVO
    }
}
    
    public static void buscarEstudiante() {
    System.out.print("Ingrese nombre a buscar: ");
    String nombreBuscado = scanner.nextLine();
    
    System.out.println("\n=== RESULTADOS DE BUSQUEDA ===");
    boolean encontrado = false;
    
    for (int i = 0; i < estudiantes.size(); i++) {
        String estudiante = estudiantes.get(i);
        if (estudiante.toLowerCase().contains(nombreBuscado.toLowerCase())) {
            System.out.println("Encontrado: " + estudiante + " (posicion " + (i + 1) + ")");
            encontrado = true;
        }
    }
    
    if (!encontrado) {
        System.out.println("No se encontraron estudiantes con: '" + nombreBuscado + "'");
    }
}
    public static void mostrarEstadisticas() {
    System.out.println("\n=== ESTADISTICAS ===");
    System.out.println("• Total de estudiantes: " + totalEstudiantes);
    System.out.println("• Capacidad utilizada: " + estudiantes.size() + " registros");
    
    if (!estudiantes.isEmpty()) {
        System.out.println("• Primer estudiante: " + estudiantes.get(0));
        System.out.println("• Ultimo estudiante: " + estudiantes.get(estudiantes.size() - 1));
    }
}
}