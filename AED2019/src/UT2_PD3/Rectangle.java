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
public class Rectangle {
    
        public int width;
        public int height;
        
        public Rectangle(){};
        
        public int area (){
            
            return this.width * this.height;
            
        }
    
     public static void main(String[] args) {         
         Rectangle myRect = new Rectangle() ;         
         myRect.width = 40;         
         myRect.height = 50;         
         System.out.println("myRect's area is " + myRect.area());
     
     } 
    
    
}
