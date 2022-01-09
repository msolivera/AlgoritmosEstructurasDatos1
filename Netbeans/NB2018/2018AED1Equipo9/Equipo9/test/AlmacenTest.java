/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import UT4.TA9.Almacen;
import UT4.TA9.IProducto;
import UT4.TA9.Producto;
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
public class AlmacenTest {
        
        public AlmacenTest() {
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
         * Test of insertarProducto method, of class Almacen.
         */
        @Test
        public void testInsertarProducto() {
                System.out.println("insertarProducto");
                Producto unProducto = null;
                Almacen instance = null;
                instance.insertarProducto(unProducto);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of imprimirProductos method, of class Almacen.
         */
        @Test
        public void testImprimirProductos() {
                System.out.println("imprimirProductos");
                Almacen instance = null;
                String expResult = "";
                String result = instance.imprimirProductos();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of agregarStock method, of class Almacen.
         */
        @Test
        public void testAgregarStock() {
                System.out.println("agregarStock");
                Comparable clave = null;
                Integer cantidad = null;
                Almacen instance = null;
                Boolean expResult = null;
                Boolean result = instance.agregarStock(clave, cantidad);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of restarStock method, of class Almacen.
         */
        @Test
        public void testRestarStock() {
                System.out.println("restarStock");
                Comparable clave = null;
                Integer cantidad = null;
                Almacen instance = null;
                Integer expResult = null;
                Integer result = instance.restarStock(clave, cantidad);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of buscarPorCodigo method, of class Almacen.
         */
        @Test
        public void testBuscarPorCodigo() {
                System.out.println("buscarPorCodigo");
                Comparable clave = null;
                Almacen instance = null;
                IProducto expResult = null;
                IProducto result = instance.buscarPorCodigo(clave);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of eliminarProducto method, of class Almacen.
         */
        @Test
        public void testEliminarProducto() {
                System.out.println("eliminarProducto");
                Comparable clave = null;
                Almacen instance = null;
                boolean expResult = false;
                boolean result = instance.eliminarProducto(clave);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of vender method, of class Almacen.
         */
        @Test
        public void testVender() {
                System.out.println("vender");
                Comparable clave = null;
                int cantidad = 0;
                Almacen instance = null;
                instance.vender(clave, cantidad);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }
        
}
