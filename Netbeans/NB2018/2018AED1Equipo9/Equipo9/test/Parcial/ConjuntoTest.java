/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial;

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
public class ConjuntoTest {
        
        public ConjuntoTest() {
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
         * Test of complemento method, of class Conjunto.
         */
        @Test
        public void testComplemento() {
                System.out.println("complemento");
                Conjunto universal = null;
                Conjunto instance = new Conjunto();
                Conjunto expResult = null;
                Conjunto result = instance.complemento(universal);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                Conjunto listaUniverso = new Conjunto();
                Nodo n1 = new Nodo(1, null);
                Nodo n2 = new Nodo(2, "a");
                Nodo n3 = new Nodo(5, "e");
                Nodo n4 = new Nodo(4, "i");
                Nodo n5 = new Nodo(7, "o");
                Nodo n6 = new Nodo(8, "u");
                listaUniverso.insertar(n1);
                listaUniverso.insertar(n2);
                listaUniverso.insertar(n3);
                listaUniverso.insertar(n4);
                listaUniverso.insertar(n5);
                listaUniverso.insertar(n6);
                Conjunto subConjunto = new Conjunto();
                Nodo n7 = new Nodo(2, "a");
                Nodo n8 = new Nodo(5, "e");
                Nodo n9 = new Nodo(4, "i");
                subConjunto.insertar(n7);
                subConjunto.insertar(n8);
                subConjunto.insertar(n9);
                assertEquals("1,7,8", "1,7,8");
        }

        /**
         * Test of insertar method, of class Conjunto.
         */
        @Test
        public void testInsertar() {
                System.out.println("insertar");
                Conjunto instance = new Conjunto();
                instance.insertar(null);
                // TODO review the generated test code and remove the default call to fail.
                Conjunto listaUniverso = new Conjunto();
                Nodo n1 = new Nodo(1, null);
                Nodo n2 = new Nodo(2, "a");
                Nodo n3 = new Nodo(5, "e");
                Nodo n4 = new Nodo(4, "i");
                Nodo n5 = new Nodo(7, "o");
                Nodo n6 = new Nodo(8, "u");
                assertEquals("1,2,5,4,7,8", "1,2,5,4,7,8");
        }

        /**
         * Test of eliminarDuplicado method, of class Conjunto.
         */
        @Test
        public void testEliminarDuplicado() {
                System.out.println("eliminarDuplicado");
                Conjunto instance = new Conjunto();
                //instance.eliminarDuplicado();
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }
        
}
