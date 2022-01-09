/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ut3_pd3;
import java.awt.Rectangle;


/**
 *
 * @author Meki
 */
public class SomethingIsWrong {
       
    Rectangle myRect = new Rectangle();
    int width;
    int height;
    
    public SomethingIsWrong(){
    
    
    myRect.width= 40 ;
    myRect.height = 50;}
    
    public void area(){
        
        int resultado = myRect.width*myRect.height;
        System.out.println("myRect's area is " + resultado);
    }
    
}
