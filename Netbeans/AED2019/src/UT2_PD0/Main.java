/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_PD0;

/**
 *
 * @author Meki
 */
public class Main {
    
    
     public static void main(String[] args) {
         
         Perro leia = new Perro("Leia");
         leia.ladrar();   
         System.out.println(leia.responderA("rex"));
         leia.correr();
         
         System.out.println("-------------");
         
         Gato g4to = new Gato ("Firulais");
         g4to.maullar();
         System.out.println(g4to.responderA("firulais"));
         g4to.correr();
     }
}
