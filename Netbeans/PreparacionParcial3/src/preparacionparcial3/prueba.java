/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacionparcial3;

/**
 *
 * @author Meki
 */
public class prueba {
         public static void main(String[] args) {
             
         System.out.println("armarArbolBinario");     
        int[] freqExito = new int[]{0,5,3,4,2};
        int[] freqNoExito = new int[]{1,3,1,3,7};
        String[] lasClaves = new String[]{"","GATO","PERRO","RATON","ZORRO"};
        int cantElem = 4;
        CalculadorMatricesOptimo instance = new CalculadorMatricesOptimo(cantElem);
        instance.encontrarOptimo(cantElem, freqExito, freqNoExito);
        
             System.out.println("Matriz W:");
             Util.imprimirMatriz(instance.W);
             System.out.println("");
             System.out.println("Matriz P:");
             Util.imprimirMatriz(instance.P);
             System.out.println("");
             System.out.println("Matriz R:");
             Util.imprimirMatriz(instance.R);
        
        TArbolBB<String> elArbolBB = new TArbolBB<>();
        
        instance.armarArbolBinario(0, cantElem, lasClaves, elArbolBB);
        
        String pre = elArbolBB.preOrden();
             System.out.println(pre);
                   
         }
    
}
