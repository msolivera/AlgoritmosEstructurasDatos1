/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANIEL
 */
public class ImagenTest {
    
    public ImagenTest() {
    }

    /**
     * Test of getID method, of class Imagen.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable id = 1009;
        String contenido = "Contenido";
        Imagen instance = new Imagen(id, contenido) ;
        Comparable expResult = 1009;
        Comparable result = instance.getID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getContenido method, of class Imagen.
     */
    @Test
    public void testGetContenido() {
        System.out.println("getContenido");
        Comparable id = 1009;
        String contenido = "Contenido";
        Imagen instance = new Imagen(id, contenido) ;
        String expResult = "Contenido";
        String result = instance.getContenido();
        assertEquals(expResult, result);        
    }
    
}
