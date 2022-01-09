/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuscarArray;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Meki
 */
public class BuscarArrayMainTest {
    
    public BuscarArrayMainTest() {
    }

    /**
     * Test of main method, of class BuscarArrayMain.
     */
    @Ignore
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
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        int aBuscar = 3;
        int indice = 0;
        int expResult = 2;
        int result = BuscarArrayMain.buscarRecursivo(array, aBuscar, indice);
        assertEquals(expResult, result);
    }
    
}
