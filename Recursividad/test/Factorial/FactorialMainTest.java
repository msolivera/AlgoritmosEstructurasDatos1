/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorial;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Meki
 */
public class FactorialMainTest {
    
    public FactorialMainTest() {
    }

    /**
     * Test of main method, of class FactorialMain.
     */
    @Ignore
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FactorialMain.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of factorialRecursivo method, of class FactorialMain.
     */
    @Test
    public void testFactorialRecursivo() {
        System.out.println("factorialRecursivo");
        int numero = 9;
        int expResult = 362880;
        int result = FactorialMain.factorialRecursivo(numero);
        assertEquals(expResult, result);
        System.out.println("Resultado = "+ result);
    }

}
