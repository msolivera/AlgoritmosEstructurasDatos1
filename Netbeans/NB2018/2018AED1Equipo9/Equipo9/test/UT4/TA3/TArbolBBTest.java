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
        IElementoAB unElemento = null;
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.insertar(unElemento);
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
        String expResult = "";
        String result = instance.inOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

    /**
     * Test of obtenerTamaño method, of class TArbolBB.
     */
    @Test
        public void testObtenerTamaño()
        {
                System.out.println("Obtener tamaño");
                TArbolBB instance = new TArbolBB();
                int expResult = 0;
                int result = instance.obtenerTamaño();
                assertEquals(expResult, result);
                
                IElementoAB unElemento = new TElementoAB("1");
                instance.insertar(unElemento);
                expResult = 1;
                result = instance.obtenerTamaño();
                assertEquals(expResult, result);
                
                IElementoAB unElemento2 = new TElementoAB("2");
                IElementoAB unElemento3 = new TElementoAB("3");
                IElementoAB unElemento4 = new TElementoAB("4");
                IElementoAB unElemento5 = new TElementoAB("5");
                instance.insertar(unElemento2);
                instance.insertar(unElemento3);
                instance.insertar(unElemento4);
                instance.insertar(unElemento5);
                expResult = 5;
                result = instance.obtenerTamaño();
                assertEquals(expResult, result);
                
        }

    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void testObtenerAltura() {
        System.out.println("obtenerAltura");
        TArbolBB instance = new TArbolBB();
     
        IElementoAB unElemento = new TElementoAB("1");
        instance.insertar(unElemento);
        int expResult = 0;
        int result = instance.obtenerAltura();
        
        assertEquals(expResult, result);
        
        IElementoAB unElemento2 = new TElementoAB("2");
        IElementoAB unElemento3 = new TElementoAB("3");
        IElementoAB unElemento4 = new TElementoAB("4");
        IElementoAB unElemento5 = new TElementoAB("5");
        instance.insertar(unElemento2);
        instance.insertar(unElemento3);
        instance.insertar(unElemento4);
        instance.insertar(unElemento5);
        expResult = 4;
        result = instance.obtenerAltura();
        
        assertEquals(expResult, result);
        
    }
    
}
