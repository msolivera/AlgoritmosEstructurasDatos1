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
public class ActorTest {
    
    public ActorTest() {
    }

    /**
     * Test of getID method, of class Actor.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable id = 1000;
        String nombre = "Steven";
        Actor instance = new Actor(id, nombre) ;
        Comparable expResult = 1000;
        Comparable result = instance.getID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNombre method, of class Actor.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Comparable id = 1000;
        String nombre = "Steven";
        Actor instance = new Actor(id, nombre) ;
        String expResult = "Steven";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        
    }
    
}
