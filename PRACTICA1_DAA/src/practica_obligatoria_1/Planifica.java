/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_obligatoria_1;

/**
 *
 * @author d.hernandezp.2023
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Planifica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorIO gestor = new GestorIO();
        SelectorActividades selector = new SelectorActividades();
        List<Actividad> candidatos = null;

        System.out.println("=== SISTEMA DE PLANIFICACIÓN DE ACTIVIDADES ===");
        System.out.println("1. Leer actividades desde un fichero");
        System.out.println("2. Introducir actividades por teclado");
        System.out.print("Seleccione una opción: ");
        
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        try {
            // Manejo de Entrada
            if (opcion == 1) {
                System.out.print("Introduce el nombre del fichero de entrada (ej: datos.txt): ");
                String nombreEntrada = sc.nextLine();
                candidatos = gestor.leerDesdeFichero(nombreEntrada);
            } else {
                candidatos = gestor.leerDesdeTeclado();
            }

            // Ejecución del Algoritmo
            List<Actividad> seleccionadas = selector.seleccionar(candidatos);

            // Manejo de Salida
            System.out.println("\n¿Dónde desea ver el resultado?");
            System.out.println("1. Por pantalla");
            System.out.println("2. Guardar en un nuevo fichero");
            System.out.print("Seleccione una opción: ");
            
            int opcionSalida = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            if (opcionSalida == 2) {
                System.out.print("Introduce el nombre del nuevo fichero (ej: salida.txt): ");
                String nombreSalida = sc.nextLine();
                gestor.escribirEnFichero(nombreSalida, seleccionadas);
                System.out.println("Fichero guardado con éxito.");
            } else {
                gestor.escribirEnPantalla(seleccionadas);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: No se encontró el archivo.");
        } catch (IOException e) {
            System.err.println("Error: El archivo de salida ya existe o no se puede escribir.");
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
