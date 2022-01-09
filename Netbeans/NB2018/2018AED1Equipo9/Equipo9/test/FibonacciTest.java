/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import UT4.TA5.Fibonacci;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class FibonacciTest {
        
        public FibonacciTest() {
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
         * Test of fibonacciLineal method, of class Fibonacci.
         */
        @Test
        public void testFibonacciLineal() {
                System.out.println("fibonacciLineal");
                int k = 20;
                Fibonacci instance = new Fibonacci();
                ArrayList lista = new ArrayList();
                lista.add(0);lista.add(1);lista.add(1);lista.add(2);lista.add(3);
                lista.add(5);lista.add(8);lista.add(13);
                
                
                ArrayList expResult = lista;
                ArrayList result = instance.fibonacciLineal(20);
                assertEquals(expResult, result);
                
                
        }

        /**
         * Test of fibonacciBinario method, of class Fibonacci.
         */
        @Test
        public void testFibonacciBinario() {
                System.out.println("fibonacciBinario");
                int k = 15;
                Fibonacci instance = new Fibonacci();
                int expResult = 610;
                int result = instance.fibonacciBinario(15);
                assertEquals(expResult, result);
                
        }
        
}
