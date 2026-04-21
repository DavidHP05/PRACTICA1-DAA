/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BuscarTornillo;

import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class BuscarTornillo {
    public boolean Buscar(int x, int y , ArrayList<int[]> camino, int[][] edificio) {
        if (x < 0 || y < 0 || x >= edificio.length || y >= edificio[0].length) {
        return false;
        }
        if(edificio[x][y]== -1 || edificio[x][y]== 2){
            return false;
        }
        camino.add(new int[]{x, y});
        if (edificio[x][y]== 1) {
            return true;
        }
       
        edificio[x][y]=2;
        if(Buscar(x+1,y,camino,edificio)||
                Buscar(x-1,y,camino,edificio)||
                Buscar(x,y+1,camino,edificio)||
                 Buscar(x,y-1,camino,edificio)){
            return true;
        }
        camino.remove(camino.size() - 1);
        //edificio[x][y]=-1;
        return false ;
        }
    public static void main(String[] args) {
    BuscarTornillo bt = new BuscarTornillo();

    int[][] edificio = {
        {0, 0, -1, 0},
        {-1, 0, -1, 0},
        {0, 0, 0, 0},
        {0, -1, 1, -1} // el tornillo está en (3,2)
    };

    ArrayList<int[]> camino = new ArrayList<>();

    boolean encontrado = bt.Buscar(0, 0, camino, edificio);

    if (encontrado) {
        System.out.println("Tornillo encontrado!");
        System.out.println("Camino seguido:");
        for (int[] paso : camino) {
            System.out.println("(" + paso[0] + ", " + paso[1] + ")");
        }
    } else {
        System.out.println("No se encontró el tornillo.");
    }
}
    
}