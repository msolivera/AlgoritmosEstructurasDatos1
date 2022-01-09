/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANIEL
 */
public class ProductorTest {
    
    public ProductorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getID method, of class Productor.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable id = 1002;
        String nombre = "Tom";
        Productor instance = new Productor(id, nombre) ;
        Comparable expResult = 1002;
        Comparable result = instance.getID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getNombre method, of class Productor.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Comparable id = 1002;
        String nombre = "Tom";
        Actor instance = new Actor(id, nombre) ;
        String expResult = "Tom";
        String result = instance.getNombre();
        assertEquals(expResult, result);        
    }
    
}
