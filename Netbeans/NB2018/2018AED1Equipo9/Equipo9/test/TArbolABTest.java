/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import UT4.TA3.TElementoAB;
import UT4.TA3.IElementoAB;
import UT4.TA3.TArbolBB;
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
public class TArbolABTest {
        
        public TArbolABTest() {
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
         * Test of insertar method, of class TArbolBB.
         */
        @Test
        public void testInsertar() {
                System.out.println("insertar");
                IElementoAB unElemento = new TElementoAB("1");
                IElementoAB unElemento2 = new TElementoAB("2");
                
                TArbolBB instance = new TArbolBB();
                boolean expResult = true;
                boolean result = instance.insertar(unElemento);
                assertEquals(expResult, result);
                
                result = instance.insertar(unElemento2);
                assertEquals(expResult, result);
        }

        /**
         * Test of esVacio method, of class TArbolBB.
         */
        @Test
        public void testEsVacio() {
                System.out.println("esVacio");
                TArbolBB instance = new TArbolBB();
                boolean expResult = true;
                boolean result = instance.esVacio();
                assertEquals(expResult, result);
                IElementoAB unElemento = new TElementoAB("1");
                instance.insertar(unElemento);
                expResult = false;
                result = instance.esVacio();
                assertEquals(expResult, result);
                
        }

        /**
         * Test of buscar method, of class TArbolBB.
         */
        @Test
        public void testBuscar() {
                System.out.println("buscar");
                Comparable unaEtiqueta = null;
                TArbolBB instance = new TArbolBB();
                IElementoAB expResult = null;
                IElementoAB result = instance.buscar(unaEtiqueta);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of preOrden method, of class TArbolBB.
         */
        @Test
        public void testPreOrden() {
                System.out.println("preOrden");
                TArbolBB instance = new TArbolBB();
                String expResult = "";
                String result = instance.preOrden();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of inOrden method, of class TArbolBB.
         */
        @Test
        public void testInOrden() {
                System.out.println("inOrden");
                TArbolBB instance = new TArbolBB();
                IElementoAB unElemento = new TElementoAB("1");
                IElementoAB unElemento2 = new TElementoAB("2");
                IElementoAB unElemento3 = new TElementoAB("3");
                IElementoAB unElemento4 = new TElementoAB("4");
                instance.insertar(unElemento);
                instance.insertar(unElemento2);
                instance.insertar(unElemento3);
                instance.insertar(unElemento4);
                String expResult = "1234";
                String result = instance.inOrden();
                assertEquals(expResult, result);
                
        }

        /**
         * Test of postOrden method, of class TArbolBB.
         */
        @Test
        public void testPostOrden() {
                System.out.println("postOrden");
                TArbolBB instance = new TArbolBB();
                String expResult = "";
                String result = instance.postOrden();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of eliminar method, of class TArbolBB.
         */
        @Test
        public void testEliminar() {
                System.out.println("eliminar");
                Comparable unaEtiqueta = null;
                TArbolBB instance = new TArbolBB();
                instance.eliminar(unaEtiqueta);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }
        
}
