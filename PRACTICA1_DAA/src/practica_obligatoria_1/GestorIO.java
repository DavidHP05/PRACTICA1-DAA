/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_obligatoria_1;

/**
 *
 * @author d.hernandezp.2023
 */
import java.io.*;
import java.util.*;

/** Esta clase se encarga de leer datos en teclado, leer datos en fichero,
 exportar datos en pantalla o exportar datos en otro fichero*/


public class GestorIO {

    public List<Actividad> leerDesdeFichero(String nombreFichero) throws FileNotFoundException {
        File archivo = new File(nombreFichero);
        if (!archivo.exists()) {
            throw new FileNotFoundException("El fichero de entrada no existe.");
        }

        /** Se usa el Scanner para ir añadiendo las actividades (cada fila) al
        Array List */
        
        List<Actividad> actividades = new ArrayList<>();
        try (Scanner sc = new Scanner(archivo)) {
            if (sc.hasNextInt()) { //el sc.hasNextInt() sirve para verificar que el siguiente dato es efectivamente un número
                int n = sc.nextInt(); // Leer número de actividades
                for (int i = 0; i < n; i++) { // Bucle de lectura de actividades
                    int inicio = sc.nextInt();
                    int fin = sc.nextInt();
                    actividades.add(new Actividad(i, inicio, fin)); // se añade el objeto actividad al arraylist actividades
                }
            }
        }
        return actividades;
    }

    public List<Actividad> leerDesdeTeclado() { //Mismo funcionamiento que el anterior pero desde teclado
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de tareas: ");
        int n = sc.nextInt();
        List<Actividad> actividades = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Tarea " + i + " (inicio fin): ");
            int inicio = sc.nextInt();
            int fin = sc.nextInt();
            actividades.add(new Actividad(i, inicio, fin));
        }
        return actividades;
    }

    public void escribirEnFichero(String nombreFichero, List<Actividad> seleccionadas) throws IOException {
        File archivo = new File(nombreFichero);
        if (archivo.exists()) {
            throw new IOException("El fichero de salida ya existe.");
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.print("Las tareas selccionadas son: " );
            for (Actividad a : seleccionadas) {
                pw.print(a.getId() + " ,");
            }
        }
    }

    public void escribirEnPantalla(List<Actividad> seleccionadas) {
        System.out.print("Tareas seleccionadas: ");
        for (Actividad a : seleccionadas) {
            System.out.print(a.getId() + " "); 
        }
        System.out.println();
    }
}
