/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4.ta3;

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
    @Ignore
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
     * Test of insertarContando method, of class TArbolBB.
     */
   @Ignore
    public void testInsertarContando() {
        System.out.println("insertarContando");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.insertarContando(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class TArbolBB.
     */
    @Ignore
    public void testBuscar() {
        System.out.println("buscar");
        Comparable unaEtiqueta = null;
        TArbolBB instance = new TArbolBB();
        TElementoAB expResult = null;
        TElementoAB result = instance.buscar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrden method, of class TArbolBB.
     */
    @Ignore
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
   @Ignore
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
    @Ignore
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
    @Ignore
    public void testInorden() {
        System.out.println("inorden");
        TArbolBB instance = new TArbolBB();
        Lista expResult = null;
        Lista result = instance.inorden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Ignore
    public void testObtenerAltura() {
        System.out.println("obtenerAltura");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTamanio method, of class TArbolBB.
     */
    @Test
    public void testObtenerAlturaArbolVacio() {
        TArbolBB instance = new TArbolBB();
        int result = instance.obtenerAltura();
        assertEquals(0, result);
   }

    @Test
    public void testObtenerAlturaArbolConUnNodo() {
        TArbolBB instance = new TArbolBB();
        TElementoAB elemento = new TElementoAB(1, 0);
        instance.insertar(elemento);
        int result = instance.obtenerAltura();
        assertEquals(0, result);
    }

    @Test
    public void testObtenerAlturaArbolNElementos() {
        TArbolBB instance = new TArbolBB();
        TElementoAB elemento1 = new TElementoAB(1, 0);
        TElementoAB elemento2 = new TElementoAB(2, 0);
        TElementoAB elemento3 = new TElementoAB(3, 0);
        instance.insertar(elemento1);
        instance.insertar(elemento2);
        instance.insertar(elemento3);
        int result = instance.obtenerAltura();
        int expected = instance.obtenerTamanio() / 2;
        assertTrue(expected <= result);
    }


    /**
     * Test of obtenerTamanio method, of class TArbolBB.
     */
    @Test
    public void testObtenerTamanio() {
        System.out.println("obtenerTamanio");
        TArbolBB instance = new TArbolBB();
        TElementoAB elemento1 = new TElementoAB(1,"1");
        TElementoAB elemento2 = new TElementoAB(4,"4");
        TElementoAB elemento3 = new TElementoAB(6,"6");
        TElementoAB elemento4 = new TElementoAB(2,"2");
        instance.insertar(elemento1);
        instance.insertar(elemento2);
        instance.insertar(elemento3);
        instance.insertar(elemento4);

        int expResult = 4;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testObtenerTamanioVacio() {
        System.out.println("obtenerTamanio de arbol vacio");
        TArbolBB instance = new TArbolBB();

        int expResult = 0;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);

    }
    
        @Test
    public void testObtenerTamanioContando() {
        System.out.println("obtenerTamanio contanto");
        TArbolBB instance = new TArbolBB();
        TElementoAB elemento1 = new TElementoAB(1,"1");
        TElementoAB elemento2 = new TElementoAB(4,"4");
        TElementoAB elemento3 = new TElementoAB(6,"6");
        TElementoAB elemento4 = new TElementoAB(2,"2");
        TElementoAB elemento5 = new TElementoAB(8,"2");
        TElementoAB elemento6 = new TElementoAB(10,"2");
        TElementoAB elemento7 = new TElementoAB(3,"2");
        TElementoAB elemento8 = new TElementoAB(3,"2");
        instance.insertarContando(elemento1);
        instance.insertarContando(elemento2);
        instance.insertarContando(elemento3);
        instance.insertarContando(elemento4);
        instance.insertarContando(elemento5);
        instance.insertarContando(elemento6);
        instance.insertarContando(elemento7);
        instance.insertarContando(elemento8);
        
        int expResult = 7;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);

    }

    /**
     * Test of obtenerCantidadHojas method, of class TArbolBB.
     */
    @Ignore
    public void testObtenerCantidadHojas() {
        System.out.println("obtenerCantidadHojas");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerCantidadHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
