/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_obligatoria_1;

/**
 *
 * @author d.hernandezp.2023
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// En esta clase se define el algoritmo
public class SelectorActividades { 

    public List<Actividad> seleccionar(List<Actividad> candidatos) {
        if (candidatos == null || candidatos.isEmpty()) {
            return new ArrayList<>();
        }

        // 1. Ordenar actividades por tiempo de finalización (usando el Comparable)
        Collections.sort(candidatos);

        List<Actividad> seleccionadas = new ArrayList<>();
        
        // 2. Seleccionar la primera actividad (la que termina antes)
        Actividad ultimaSeleccionada = candidatos.get(0);
        seleccionadas.add(ultimaSeleccionada);

        // 3. Buscar actividades compatibles
        for (int i = 1; i < candidatos.size(); i++) {
            Actividad actual = candidatos.get(i);
            
            // Si el inicio es mayor o igual al fin de la última seleccionada
            if (actual.getInicio() >= ultimaSeleccionada.getFin()) {
                seleccionadas.add(actual);
                ultimaSeleccionada = actual;
            }
        }

        return seleccionadas;
    }
}
