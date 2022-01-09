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
public class Zumbido {
    
    public static void desconcentar (String dirigible){
        
        System.out.println(dirigible);
        
        sipo ("ping", -5);
    }
    
    public static void sipo (String membrillo , int flag){
        if (flag<0){
            System.out.println(membrillo + "sup");
        }else{
            System.out.println("ik");
                desconcentar (membrillo);
                
                System.out.println("muaa-ja-ja-ja");
        }
    }
    public static void main (String[] args) {   sipo ("traqueteo", 13);   } 
    
}
 
