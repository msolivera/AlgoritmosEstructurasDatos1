/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_PD3;

/**
 *
 * @author Meki
 */
public class IdentifyMyParts {
    
    public static int x = 7; //variable de clase
    public int y = 3;  //variable de instancia
    
    
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
    
    
    }
    
}
