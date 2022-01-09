/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1_PD1;

/**
 *
 * @author Meki
 */
public class Multsuma {
    
    public double multsuma (double a, double b, double c){
        
        double resultado = (a*b)+c;
        return resultado;
        
    }
    
     public static void main(String[] args) {
         Multsuma mult = new Multsuma();
         
         System.out.println("Resultado "+ mult.multsuma(1.0, 2.0, 3.0));
         System.out.println("Resultado "+ mult.multsuma(2.5, 2.0, 10.0));
         System.out.println("Resultado "+ mult.multsuma(1.3, 1.3, 4.5));
     }
    
}
