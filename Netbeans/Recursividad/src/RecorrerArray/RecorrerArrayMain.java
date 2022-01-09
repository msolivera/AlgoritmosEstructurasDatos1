/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecorrerArray;

/**
 *
 * @author Meki
 */
public class RecorrerArrayMain {
    
     public static void main(String[] args) {
         int [] array = new int[5];
         array[0] = 1;
         array[1] = 2;
         array[2] = 3;
         array[3] = 4;
         array[4] = 5;
         
         recorrerArrayRecursivo(array, 0);
     }
     
    public static void recorrerArrayRecursivo(int[] array, int indice) {

        if (indice == array.length - 1) {
            System.out.println(array[indice]);
        } else {

            System.out.println(array[indice]);
            recorrerArrayRecursivo(array, indice + 1);

        }

    }
    
}
