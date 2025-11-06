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
            System.out.println("\n=== SISTEMA DE REGISTRO DE ESTUDIANTES ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Ver estudiantes");
            System.out.println("3. Salir");
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
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        } while(opcion != 3);
    }
    
public static void agregarEstudiante() {
    System.out.print("Ingrese nombre del estudiante: ");
    String nombre = scanner.nextLine();
    
    // VALIDACIONES AGREGADAS
    if (nombre.trim().isEmpty()) {
        System.out.println("❌ Error: El nombre no puede estar vacio");
        return;
    }
    
    if (estudiantes.contains(nombre)) {
        System.out.println("❌ Error: El estudiante ya existe");
        return;
    }
    
    estudiantes.add(nombre);
    totalEstudiantes++; // CONTADOR AGREGADO
    System.out.println("✅ Estudiante agregado: " + nombre);
    System.out.println("📊 Total de estudiantes: " + totalEstudiantes);
}
    
    
    public static void verEstudiantes() {
        System.out.println("\n=== LISTA DE ESTUDIANTES ===");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println((i + 1) + ". " + estudiantes.get(i));
            }
        }
    }
}