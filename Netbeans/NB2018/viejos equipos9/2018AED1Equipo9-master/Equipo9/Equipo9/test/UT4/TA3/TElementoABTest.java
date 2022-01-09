/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.TA3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TElementoABTest {
    
    public TElementoABTest() {
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
     * Test of getEtiqueta method, of class TElementoAB.
     */
    @Test
    public void testGetEtiqueta() {
        System.out.println("getEtiqueta");
        TElementoAB instance = null;
        Comparable expResult = null;
        Comparable result = instance.getEtiqueta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHijoIzq method, of class TElementoAB.
     */
    @Test
    public void testGetHijoIzq() {
        System.out.println("getHijoIzq");
        TElementoAB instance = null;
        IElementoAB expResult = null;
        IElementoAB result = instance.getHijoIzq();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHijoDer method, of class TElementoAB.
     */
    @Test
    public void testGetHijoDer() {
        System.out.println("getHijoDer");
        TElementoAB instance = null;
        IElementoAB expResult = null;
        IElementoAB result = instance.getHijoDer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class TElementoAB.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Comparable unaEtiqueta = null;
        TElementoAB instance = null;
        IElementoAB expResult = null;
        IElementoAB result = instance.buscar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHijoIzq method, of class TElementoAB.
     */
    @Test
    public void testSetHijoIzq() {
        System.out.println("setHijoIzq");
        IElementoAB elemento = null;
        TElementoAB instance = null;
        instance.setHijoIzq(elemento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHijoDer method, of class TElementoAB.
     */
    @Test
    public void testSetHijoDer() {
        System.out.println("setHijoDer");
        IElementoAB elemento = null;
        TElementoAB instance = null;
        instance.setHijoDer(elemento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class TElementoAB.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        IElementoAB elemento = null;
        TElementoAB instance = null;
        boolean expResult = false;
        boolean result = instance.insertar(elemento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preOrden method, of class TElementoAB.
     */
    @Test
    public void testPreOrden() {
        System.out.println("preOrden");
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.preOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrden method, of class TElementoAB.
     */
    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.inOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of postOrden method, of class TElementoAB.
     */
    @Test
    public void testPostOrden() {
        System.out.println("postOrden");
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.postOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class TElementoAB.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Comparable unaEtiqueta = null;
        TElementoAB instance = null;
        IElementoAB expResult = null;
        IElementoAB result = instance.eliminar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitaElNodo method, of class TElementoAB.
     */
    @Test
    public void testQuitaElNodo() {
        System.out.println("quitaElNodo");
        TElementoAB instance = null;
        IElementoAB expResult = null;
        IElementoAB result = instance.quitaElNodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimir method, of class TElementoAB.
     */
    @Test
    public void testImprimir() {
        System.out.println("imprimir");
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.imprimir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTamaño method, of class TElementoAB.
     */
    @Test
    public void testObtenerTamaño() {
        System.out.println("obtenerTama\u00f1o");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerTamaño();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAltura method, of class TElementoAB.
     */
    @Test
    public void testObtenerAltura() {
        System.out.println("obtenerAltura");
        TElementoAB instance = null;
        TArbolBB arbol = new TArbolBB();
        
        IElementoAB unElemento2 = new TElementoAB("2");
        IElementoAB unElemento3 = new TElementoAB("3");
        IElementoAB unElemento4 = new TElementoAB("4");
        IElementoAB unElemento5 = new TElementoAB("5");
        arbol.insertar(unElemento2);
        
        int result = unElemento2.obtenerAltura();
        
        int expResult = 0;
        
        
        assertEquals(expResult, result);
        
    }
    
}
