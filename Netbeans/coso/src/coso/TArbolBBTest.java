/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ernesto
 */
public class TArbolBBTest {

    TArbolBB<Integer> arbolVacio, arbolSoloRaiz, arbol1, arbol2, arbol3, arbol4, arbol5, arbolPalabras;
    String nodosPreOrden, nodosInOrden, nodosPostOrden;
    CalculadorMatricesOptimo calculadorMatrices;

    // para testear CalcularCosto
    int[] frecExito = {0, 5, 3, 4, 2};
    int[] frecNoExito = {1, 3, 1, 3, 7};
    String[] claves = {null, "gato", "perro", "raton", "zorro"};
    int cantElementos;

    public TArbolBBTest() {
        arbolVacio = new TArbolBB<>();
        arbolSoloRaiz = new TArbolBB<>();
        arbol1 = new TArbolBB<>();
        arbol2 = new TArbolBB<>();
        arbol3 = new TArbolBB<>();
        arbol4 = new TArbolBB<>();
        arbol5 = new TArbolBB<>();
        arbolPalabras = new TArbolBB<>();

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        arbolSoloRaiz.insertar(new TElementoAB<>(5, null));
        // --
        // Encuentro nivel dos
        arbol1.insertar(new TElementoAB<>(5, null));
        arbol1.insertar(new TElementoAB<>(6, null));
        // No encuentro nivel dos
        arbol2.insertar(new TElementoAB<>(5, null));
        arbol2.insertar(new TElementoAB<>(6, null));
        // Encuentro nivel tres
        arbol3.insertar(new TElementoAB<>(5, null));
        arbol3.insertar(new TElementoAB<>(6, null));
        arbol3.insertar(new TElementoAB<>(7, null));
        // No encuentro nivel tres
        arbol4.insertar(new TElementoAB<>(5, null));
        arbol4.insertar(new TElementoAB<>(6, null));
        arbol4.insertar(new TElementoAB<>(7, null));
        arbol4.insertar(new TElementoAB<>(4, null));

        /*
            Árbol para probar preorden, inorden, postorden
        
                  10
                /    \
               5      20
              / \     / \
             3   7   15  25

            *** Inorden ***
            3 - 5 - 7 - 10 - 15 - 20 - 25
        
            *** Preorden ***
            10 - 5 - 3 - 7 - 20 - 15 - 25
        
            *** Postorden ***
            3 - 7 - 5 - 15 - 25 - 20 - 10
        
         */
        arbol5.insertar(new TElementoAB<>(10, null));
        arbol5.insertar(new TElementoAB<>(20, null));
        arbol5.insertar(new TElementoAB<>(5, null));
        arbol5.insertar(new TElementoAB<>(25, null));
        arbol5.insertar(new TElementoAB<>(7, null));
        arbol5.insertar(new TElementoAB<>(15, null));
        arbol5.insertar(new TElementoAB<>(3, null));

        // para testear CalcularCosto
        cantElementos = 4;
        calculadorMatrices = new CalculadorMatricesOptimo(cantElementos);
        calculadorMatrices.encontrarOptimo(cantElementos, frecExito, frecNoExito);
        calculadorMatrices.armarArbolBinario(0, cantElementos, claves, arbolPalabras);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNivelClave_vacio() {
        assertEquals(arbolVacio.nivelClave(99), -1);
    }

    @Test
    public void testNivelClave_soloRaiz() {
        assertEquals(arbolSoloRaiz.nivelClave(5), 1);
    }

    @Test
    public void testNivelClave_soloRaizNoEncuentro() {
        assertEquals(arbolSoloRaiz.nivelClave(99), -2);
    }

    @Test
    public void testNivelClave_encuentroNivelDos() {
        assertEquals(arbol1.nivelClave(6), 2);
    }

    @Test
    public void testNivelClave_noEncuentroNivelDos() {
        assertEquals(arbol2.nivelClave(4), -2);
    }

    @Test
    public void testNivelClave_encuentroNivelTres() {
        assertEquals(arbol3.nivelClave(7), 3);
    }

    @Test
    public void testNivelClave_noEncuentroNivelTres() {
        assertEquals(arbol4.nivelClave(3), -3);
    }

    @Test
    public void testNivelClave_arbol5() {
        System.out.println("*** Busco claves en el árbol ***");
        
        System.out.println("                  10\n" +
"                /    \\\n" +
"               5      20\n" +
"              / \\     / \\\n" +
"             3   7   15  25\n");
        
        System.out.println("Busco la clave 10, y me da: " + arbol5.nivelClave(10));
        System.out.println("Busco la clave 20, y me da: " + arbol5.nivelClave(20));
        System.out.println("Busco la clave 25, y me da: " + arbol5.nivelClave(25));
        assertEquals(arbol5.nivelClave(10), 1);
        assertEquals(arbol5.nivelClave(20), 2);
        assertEquals(arbol5.nivelClave(25), 3);
    }

    @Test
    public void test_inOrden() {
        System.out.println("*** Test Inorden ***");
        nodosInOrden = "";
        Lista arbolinorden = arbol5.inOrden();
        INodo aux = arbolinorden.getPrimero();
        while (aux != null) {
            nodosInOrden = nodosInOrden + aux.getEtiqueta();
            aux = aux.getSiguiente();
            if (aux != null) {
                nodosInOrden = nodosInOrden + " - ";
            }
        }
        System.out.println(nodosInOrden);
        assertEquals("3 - 5 - 7 - 10 - 15 - 20 - 25", nodosInOrden);
    }

    @Test
    public void test_preOrden() {
        System.out.println("*** Test Preorden ***");
        nodosPreOrden = "";
        Lista arbolpreorden = arbol5.preOrden();
        INodo aux = arbolpreorden.getPrimero();
        while (aux != null) {
            nodosPreOrden = nodosPreOrden + aux.getEtiqueta();
            aux = aux.getSiguiente();
            if (aux != null) {
                nodosPreOrden = nodosPreOrden + " - ";
            }
        }
        System.out.println(nodosPreOrden);
        assertEquals("10 - 5 - 3 - 7 - 20 - 15 - 25", nodosPreOrden);
    }

    @Test
    public void test_postOrden() {
        System.out.println("*** Test Postorden ***");
        nodosPostOrden = "";
        Lista arbolpostorden = arbol5.postOrden();
        INodo aux = arbolpostorden.getPrimero();
        while (aux != null) {
            nodosPostOrden = nodosPostOrden + aux.getEtiqueta();
            aux = aux.getSiguiente();
            if (aux != null) {
                nodosPostOrden = nodosPostOrden + " - ";
            }
        }
        System.out.println(nodosPostOrden);
        assertEquals("3 - 7 - 5 - 15 - 25 - 20 - 10", nodosPostOrden);
    }

    @Test
    public void testCalcularCosto() {
        System.out.println("*** CalcularCosto ***");

        long costoFinal = arbolPalabras.calcularCosto(frecExito, frecNoExito);
        System.out.println("Costo óptimo del árbol usando calcularCosto: " + costoFinal);
        assertEquals(costoFinal, 76);

    }

    @Test
    public void test_trayectoriaInterMedia1() {
        System.out.println("*** Trayectoria Interna Media - árbol palabras ***");
        float resultado = arbolPalabras.trayectInterMediaMejorado();
        System.out.println("Resultado: " + resultado);
        assertEquals(2.0, resultado, 0.0);
    }

    @Test
    public void test_trayectoriaInterMedia2() {
        System.out.println("*** Trayectoria Interna Media - árbol números ***");
        float resultado = arbol5.trayectInterMediaMejorado();
        System.out.println("Resultado: " + resultado);
        assertEquals(2.4285714626312256, resultado, 0.0);
    }
}
