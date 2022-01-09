/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuscarArray;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meki
 */
public class BuscarArrayMainTest {
    
    public BuscarArrayMainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BuscarArrayMain.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BuscarArrayMain.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarRecursivo method, of class BuscarArrayMain.
     */
    @Test
    public void testBuscarRecursivo() {
        System.out.println("buscarRecursivo");
        int[] array = null;
        int aBuscar = 0;
        int indice = 0;
        int expResult = 0;
        int result = BuscarArrayMain.buscarRecursivo(array, aBuscar, indice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
