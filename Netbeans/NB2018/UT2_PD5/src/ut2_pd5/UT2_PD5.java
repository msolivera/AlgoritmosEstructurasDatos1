/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd5;

import java.io.IOException;

/**
 *
 * @author Meki
 */
public class UT2_PD5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        /*EntradaDeDatos entrada = new EntradaDeDatos();
        entrada.cargarArchivo("src/ut2_pd5/entrada.txt");
        CalcularAreaPerimetro c = new CalcularAreaPerimetro();
        System.out.println(c.calcularPerimetro(2));
        System.out.println(c.calcularArea(5));
        Tablero t = new Tablero (7,7);
        t.dibujar();*/
        
        Celular2 celular = new Celular2();
        celular.Decodificador("src/ut2_pd5/entrada1.txt","src/ut2_pd5/salidaCel.txt");
        
        
        
    }
    
}
