/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANIEL
 */
public class DirectorTest {
    
    public DirectorTest() {
    }   

    /**
     * Test of getID method, of class Director.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable id = 10001;
        String nombre = "Lucas";
        Director instance = new Director(id, nombre) ;
        Comparable expResult = 10001;
        Comparable result = instance.getID();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getNombre method, of class Director.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Comparable id = 10001;
        String nombre = "Lucas";
        Director instance = new Director(id, nombre) ;
        Comparable expResult = "Lucas";
        String result = instance.getNombre();
        assertEquals(expResult, result);        
    }
    
}
