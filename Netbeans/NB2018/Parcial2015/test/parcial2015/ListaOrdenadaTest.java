/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2015;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meki
 */
public class ListaOrdenadaTest {
    
    public ListaOrdenadaTest() {
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
     * Test of insertar method, of class ListaOrdenada.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ListaOrdenada instance = new ListaOrdenada();
        instance.insertar(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarOrdenado method, of class ListaOrdenada.
     */
    @Test
    public void testInsertarOrdenado() {
        System.out.println("insertarOrdenado");
        ListaOrdenada instance = new ListaOrdenada();
        instance.insertarOrdenado(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mezclarCon method, of class ListaOrdenada.
     */
    @Test
    public void testMezclarCon() {
        System.out.println("mezclarCon");
        ListaOrdenada otraLista = null;
        ListaOrdenada instance = new ListaOrdenada();
        ListaOrdenada expResult = null;
        ListaOrdenada result = instance.mezclarCon(otraLista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class ListaOrdenada.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Comparable clave = null;
        ListaOrdenada instance = new ListaOrdenada();
        boolean expResult = false;
        boolean result = instance.eliminar(clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarDuplicado method, of class ListaOrdenada.
     */
    @Test
    public void testEliminarDuplicado() {
        System.out.println("eliminarDuplicado");
        ListaOrdenada instance = new ListaOrdenada();
        instance.eliminarDuplicado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ListaOrdenada.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Comparable clave = null;
        ListaOrdenada instance = new ListaOrdenada();
        Nodo expResult = null;
        Nodo result = instance.buscar(clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantElementos method, of class ListaOrdenada.
     */
    @Test
    public void testCantElementos() {
        System.out.println("cantElementos");
        ListaOrdenada instance = new ListaOrdenada();
        int expResult = 0;
        int result = instance.cantElementos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esVacia method, of class ListaOrdenada.
     */
    @Test
    public void testEsVacia() {
        System.out.println("esVacia");
        ListaOrdenada instance = new ListaOrdenada();
        boolean expResult = false;
        boolean result = instance.esVacia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimero method, of class ListaOrdenada.
     */
    @Test
    public void testGetPrimero() {
        System.out.println("getPrimero");
        ListaOrdenada instance = new ListaOrdenada();
        Nodo expResult = null;
        Nodo result = instance.getPrimero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrimero method, of class ListaOrdenada.
     */
    @Test
    public void testSetPrimero() {
        System.out.println("setPrimero");
        ListaOrdenada instance = new ListaOrdenada();
        instance.setPrimero(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimir method, of class ListaOrdenada.
     */
    @Test
    public void testImprimir_0args() {
        System.out.println("imprimir");
        ListaOrdenada instance = new ListaOrdenada();
        String expResult = "";
        String result = instance.imprimir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimir method, of class ListaOrdenada.
     */
    @Test
    public void testImprimir_String() {
        System.out.println("imprimir");
        String separador = "";
        ListaOrdenada instance = new ListaOrdenada();
        String expResult = "";
        String result = instance.imprimir(separador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarPrimero method, of class ListaOrdenada.
     */
    @Test
    public void testQuitarPrimero() {
        System.out.println("quitarPrimero");
        ListaOrdenada instance = new ListaOrdenada();
        Nodo expResult = null;
        Nodo result = instance.quitarPrimero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
