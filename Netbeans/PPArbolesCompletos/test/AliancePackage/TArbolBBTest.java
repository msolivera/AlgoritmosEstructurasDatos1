/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AliancePackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franco.gai
 */
public class TArbolBBTest {
    
    private static TArbolBB<Integer> arbol;
    private static TElementoAB elem1;
    private static TElementoAB elem2;
    private static TElementoAB elem3;
    private static TElementoAB elem4;
    private static TElementoAB elem5;
    private static TElementoAB elem6;
    
    public TArbolBBTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        arbol = new TArbolBB<>();
        elem1 = new TElementoAB(1, 1);
        elem2 = new TElementoAB(2, 2);
        elem3 = new TElementoAB(3, 3);
        elem4 = new TElementoAB(4, 4);
        elem5 = new TElementoAB(5, 5);
        elem6= new TElementoAB(6, 6);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        arbol = new TArbolBB<>();
        elem1 = new TElementoAB(1, 1);
        elem2 = new TElementoAB(2, 2);
        elem3 = new TElementoAB(3, 3);
        elem4 = new TElementoAB(4, 4);
        elem5 = new TElementoAB(5, 5);
        elem6= new TElementoAB(6, 6);
    }
    
  
    /**
     * Test of obtenerCantidadHojas method, of class TArbolBB.
     */
    @Test
    public void testObtenerCantidadHojas() {
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        assertEquals(2, arbol.obtenerCantidadHojas()); 
    }
    @Test
    public void testObtenerCantidadHojasListaDerecha() {
        arbol.insertar(elem1);
        arbol.insertar(elem2);
        arbol.insertar(elem3);
        assertEquals(1, arbol.obtenerCantidadHojas()); 
    }
    
    @Test
    public void testObtenerNivel(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        assertEquals(1, arbol.obtenerNivel(3));
    }
    
    @Test
    public void testObtenerAltura(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        assertEquals(1, arbol.obtenerAltura());
    }
    @Test
    public void testObtenerAlturaListaDer(){
        arbol.insertar(elem1);
        arbol.insertar(elem2);
        arbol.insertar(elem3);
        assertEquals(2, arbol.obtenerAltura());
    }
     @Test
    public void testObtenerAlturaListaIzq(){
        arbol.insertar(elem3);
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        assertEquals(2, arbol.obtenerAltura());
    }
     @Test
    public void testObtenerAltura2(){
        arbol.insertar(elem5);
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem4);
        arbol.insertar(elem6);
        assertEquals(2, arbol.obtenerAltura());
    }
    @Test
    public void testObtenerAltura3(){
        arbol.insertar(elem5);
        arbol.insertar(elem4);
        arbol.insertar(elem3);
        arbol.insertar(elem2);
        arbol.insertar(elem6);
        assertEquals(3, arbol.obtenerAltura());
    }
    @Test
    public void testObtenerTamanio(){
        arbol.insertar(elem5);
        arbol.insertar(elem4);
        arbol.insertar(elem6);
        assertEquals(3, arbol.obtenerTamanio());
    }
    public void testObtenerTamanio1(){
        arbol.insertar(elem5);
        assertEquals(1, arbol.obtenerTamanio());
    }
    public void testObtenerTamanio5(){
        arbol.insertar(elem5);
        arbol.insertar(elem4);
        arbol.insertar(elem3);
        arbol.insertar(elem2);
        arbol.insertar(elem6);
        assertEquals(5, arbol.obtenerTamanio());
    }
    @Test
     public void testGetMayorClave(){
        arbol.insertar(elem5);
        arbol.insertar(elem4);
        arbol.insertar(elem3);
        arbol.insertar(elem2);
        arbol.insertar(elem6);
        assertEquals(6, arbol.getMayorClave());
     }
     @Test
     public void testGetMayorClaveUnica(){
        arbol.insertar(elem5);
        assertEquals(5, arbol.getMayorClave());
     }
     @Test
     public void testGetMenorClave(){
        arbol.insertar(elem5);
        arbol.insertar(elem4);
        arbol.insertar(elem3);
        arbol.insertar(elem2);
        arbol.insertar(elem6);
        assertEquals(2, arbol.getMenorClave());
     }
     @Test
     public void testGetMenorClaveUnica(){
        arbol.insertar(elem5);
        assertEquals(5, arbol.getMenorClave());
     }
     
     @Test
     public void testAnteriorAClave(){
        arbol.insertar(elem5);
        assertEquals(5, arbol.anteriorAClave(5));
     }
     
     @Test
     public void testAnteriorAClaveNivelDosDerecho(){
        arbol.insertar(elem5);
        arbol.insertar(elem4);
        arbol.insertar(elem6);
        assertEquals(5, arbol.anteriorAClave(6));
     }
      @Test
     public void testAnteriorAClaveNivelDosIzquierdo(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem4);
        assertEquals(2, arbol.anteriorAClave(1));
     }
      @Test
     public void testAnteriorAClaveNivelTresIzquierdo(){
        arbol.insertar(elem5);
        arbol.insertar(elem6);
        arbol.insertar(elem4);
        arbol.insertar(elem2);
        assertEquals(4, arbol.anteriorAClave(2));
     }
      @Test
     public void testAnteriorAClaveNivelTres(){
        arbol.insertar(elem6);
        arbol.insertar(elem4);
        arbol.insertar(elem5);
        arbol.insertar(elem2);
        assertEquals(4, arbol.anteriorAClave(2));
     }
      @Test
     public void testAnteriorAClaveListaDer(){
        arbol.insertar(elem6);
        arbol.insertar(elem5);
        arbol.insertar(elem4);
        arbol.insertar(elem3);
        assertEquals(5, arbol.anteriorAClave(4));
     }
    @Test
    public void testCantidadNodosPorNivel(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        assertEquals(arbol.cantidadNodosPorNivel(0), 1);
    }
    @Test
    public void testCantidadNodosPorNivelDos(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        assertEquals(arbol.cantidadNodosPorNivel(1), 2);
    }
     @Test
    public void testCantidadNodosPorNivelTres(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        arbol.insertar(elem4);
        arbol.insertar(elem5);
        assertEquals(arbol.cantidadNodosPorNivel(3), 1);
    } 
    @Test
    public void testListadoHojas(){
        arbol.insertar(elem2);
        assertEquals( "2,0 ",arbol.listadoHojas());
    }
     @Test
    public void testListadoHojasMultiples(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        assertEquals( "2,0 1,1 3,1 ",arbol.listadoHojas());
    }
      @Test
    public void testListadoHojasMultiples2(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        arbol.insertar(elem4);
        assertEquals( "2,0 1,1 3,1 4,2 ",arbol.listadoHojas());
    }
    @Test
     public void testEsArbolBusqueda(){
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
        arbol.insertar(elem4);
         assertTrue(arbol.esArbolBusqueda());
    }
    
    
     
}
