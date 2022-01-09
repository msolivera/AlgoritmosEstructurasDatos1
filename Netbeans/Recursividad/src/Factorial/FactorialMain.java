/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorial;

/**
 *
 * @author Meki
 */
public class FactorialMain {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 5;
        int resultado = factorialRecursivo (n);
        System.out.println("Factorial de "+n+" es: "+resultado);
    }
    
    public static int factorialRecursivo (int numero){
       
        int resultado;
        if(numero ==1){ //caso base
            return 1;
        }
        else{
            
            resultado = numero * factorialRecursivo(numero -1);
            
        }
        return resultado;
       
    }
    
}
