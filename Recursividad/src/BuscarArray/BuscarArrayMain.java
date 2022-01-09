/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuscarArray;

/**
 *
 * @author Meki
 */
public class BuscarArrayMain {
    
    public static void main(String[] args) { 
    int [] array = new int[5];
         array[0] = 1;
         array[1] = 2;
         array[2] = 3;
         array[3] = 4;
         array[4] = 5;
         
         int aBuscar = 3;
         int encontrado = buscarRecursivo(array, aBuscar, 0);
         System.out.println(encontrado);
    }
    public static int buscarRecursivo (int[] array, int aBuscar, int indice){
  
        if (indice == array.length) {
            return -1;
        } else if (array[indice] == aBuscar) { //caso base

            return indice;

        } else {
            return buscarRecursivo(array, aBuscar, indice + 1);
        }

    }
    
}
