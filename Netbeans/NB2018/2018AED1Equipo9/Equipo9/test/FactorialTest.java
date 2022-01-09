/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import UT4.TA5.Factorial;
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
public class FactorialTest {
        
        public FactorialTest() {
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
         * Test of factorial method, of class Factorial.
         */
        @Test
        public void testFactorial() {
                System.out.println("factorial");
                int n = 0;
                int expResult = 1;
                int result = Factorial.factorial(n);
                assertEquals(expResult, result);
                
                n = 3;
                expResult = 6;
                result = Factorial.factorial(3);
                assertEquals(expResult, result);
                
                n = 5;
                expResult = 120;
                result = Factorial.factorial(5);
                assertEquals(expResult, result);
        }

        /**
         * Test of factorialIterativo method, of class Factorial.
         */
        @Test
        public void testFactorialIterativo() {
                System.out.println("factorialIterativo");
                int n = 0;
                int expResult = 0;
                int result = Factorial.factorialIterativo(n);
                assertEquals(expResult, result);

                n = 3;
                expResult = 6;
                result = Factorial.factorialIterativo(3);
                assertEquals(expResult, result);

                n = 5;
                expResult = 120;
                result = Factorial.factorialIterativo(5);
                assertEquals(expResult, result);
        }
        
}
