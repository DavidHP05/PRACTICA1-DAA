/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_obligatoria_1;

/**
 *
 * @author d.hernandezp.2023
 */


/** En esta clase se definen los atributos, los métodos básicos
y se implementa el CompareTo para poder ordenar las actividades por tiempo de
* finalización en orden ascendente */

public class Actividad implements Comparable<Actividad> {
    private final int id;
    private final int inicio;
    private final int fin;

    public Actividad(int id, int inicio, int fin) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getId() {return id;}
    public int getInicio() {return inicio;}
    public int getFin() {return fin;}

    @Override
    public int compareTo(Actividad otra) {
        // Criterio voraz: ordenar por tiempo de finalización
        return Integer.compare(this.fin, otra.fin);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
