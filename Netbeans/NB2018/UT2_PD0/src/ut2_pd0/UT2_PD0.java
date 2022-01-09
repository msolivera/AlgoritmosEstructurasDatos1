/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd0;


/**
 *
 * @author Meki
 */
public class UT2_PD0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gato gato = new Gato("gato");
        Perro perro = new Perro("Rex");
        
        perro.caminar();
        perro.ladrar();
        gato.respondeA("gatito");
        
    }
    
}
