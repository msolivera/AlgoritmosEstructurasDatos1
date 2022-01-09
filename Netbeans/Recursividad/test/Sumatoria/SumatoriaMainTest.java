/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sumatoria;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Meki
 */
public class SumatoriaMainTest {
    
    public SumatoriaMainTest() {
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
     * Test of main method, of class SumatoriaMain.
     */
    @Ignore
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SumatoriaMain.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sumatoriaRecursiva method, of class SumatoriaMain.
     */
    @Test
    public void testSumatoriaRecursiva() {
        System.out.println("sumatoriaRecursiva");
        int numero = 9;
        int expResult = 45;
        int result = SumatoriaMain.sumatoriaRecursiva(numero);
        assertEquals(expResult, result);

    }
    
}
