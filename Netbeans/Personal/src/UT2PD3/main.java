/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD3;

/**
 *
 * @author Meki
 */
public class main {
    
        public static void main(String[] args) {
     
            IdentifyMyParts a = new IdentifyMyParts(); 
            IdentifyMyParts b = new IdentifyMyParts(); 
            a.y = 5; 
            b.y = 6; 
            a.x = 1; 
            b.x = 2; 
            System.out.println("a.y = " + a.y); 
            System.out.println("b.y = " + b.y); 
            System.out.println("a.x = " + a.x); 
            System.out.println("b.x = " + b.x); 
            System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x); 
            
            /*
            EJERCICIO 4
            */
            String[] students = new String[10]; 
            String studentName = "Peter Parker"; 
            students[0] = studentName; 
            studentName = null; //candidato a ser eliminado por el garbage collector
            
            /*
            EJERCICIO 4 PARTE 2
            */
            NumberHolder number = new NumberHolder(516, 25);
            number.imprimir();
            
    }
}
