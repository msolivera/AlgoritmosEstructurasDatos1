/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import UT4.TA6.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Equipo9
 */
public class TArbolBBTest {
        
        public TArbolBBTest() {
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
                TArbolBB instance = new TArbolBB();
                boolean expResult = false;
                boolean result = instance.insertar(null);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
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
         * Test of inOrden method, of class TArbolBB.
         */
        @Test
        public void testInOrden() {
                System.out.println("inOrden");
                TArbolBB instance = new TArbolBB();
                String expResult = "";
                String result = instance.inOrden();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of esVacio method, of class TArbolBB.
         */
        @Test
        public void testEsVacio() {
                System.out.println("esVacio");
                TArbolBB instance = new TArbolBB();
                boolean expResult = false;
                boolean result = instance.esVacio();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of vaciar method, of class TArbolBB.
         */
        @Test
        public void testVaciar() {
                System.out.println("vaciar");
                TArbolBB instance = new TArbolBB();
                boolean expResult = false;
                boolean result = instance.vaciar();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of inorden method, of class TArbolBB.
         */
        @Test
        public void testInorden() {
                System.out.println("inorden");
                TArbolBB instance = new TArbolBB();
                LinkedList<Comparable> expResult = null;
                LinkedList<Comparable> result = instance.inorden();
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
                TElementoAB elemento = new TElementoAB(12,12);
                TElementoAB elemento1 = new TElementoAB(25,25);
                TElementoAB elemento2 = new TElementoAB(14,14);
                TElementoAB elemento3 = new TElementoAB(1,1);
                TElementoAB elemento4 = new TElementoAB(33,33);
                TElementoAB elemento5 = new TElementoAB(88,88);
                TElementoAB elemento6 = new TElementoAB(45,45);
                TElementoAB elemento7 = new TElementoAB(2,2);
                TElementoAB elemento8 = new TElementoAB(7,7);
                TElementoAB elemento9 = new TElementoAB(66,66);
                TElementoAB elemento10 = new TElementoAB(5,5);
                TElementoAB elemento11 = new TElementoAB(99,99);
                instance.insertar(elemento);
                instance.insertar(elemento1);
                instance.insertar(elemento2);
                instance.insertar(elemento3);
                instance.insertar(elemento4);
                instance.insertar(elemento5);
                instance.insertar(elemento6);
                instance.insertar(elemento7);
                instance.insertar(elemento8);
                instance.insertar(elemento9);
                instance.insertar(elemento10);
                instance.insertar(elemento11);
                String expResult = "1-2-5-7-12-14-25-33-45-66-88-99";
                String result = instance.inOrden();
                assertEquals(expResult, result);
                instance.inOrden();
                instance.eliminar(99);
                instance.eliminar(15);
                instance.eliminar(2);
                instance.eliminar(12);
                instance.eliminar(77);
                instance.eliminar(33);
                instance.inorden();
                instance.preOrden();
                instance.postOrden();
                expResult = "1-5-7-14-25-45-66-88";
                result = instance.inOrden();
                assertEquals(expResult, result);
        }
        
}
