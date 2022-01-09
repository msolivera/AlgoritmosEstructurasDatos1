/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacionparcial3;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Meki
 */
public class TArbolBBTest {

 TArbolBB<Integer> arbolVacio, arbolSoloRaiz, arbol1, arbol2, arbol3, arbol4;

    public TArbolBBTest() {
        arbolVacio = new TArbolBB<>();
        arbolSoloRaiz = new TArbolBB<>();
        arbol1 = new TArbolBB<>();
        arbol2 = new TArbolBB<>();
        arbol3 = new TArbolBB<>();
        arbol4 = new TArbolBB<>();
    }

    /////////////////DELE/////////////////////////////
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
    
    
    /////////////////APA/////////////////////////////
    /**
     * Test of encontrarOptimo method, of class TArbolBinarioOptimo.
     */
    @Test
    public void testEncontrarOptimoConHCero() {
        System.out.println("encontrarOptimo");
        int cantElem = 0;
        int[] frecExito = {};
        int[] frecNoExito = {2};
        CalculadorMatricesOptimo instance = new CalculadorMatricesOptimo(cantElem);
        instance.encontrarOptimo(cantElem, frecExito, frecNoExito);
        assertEquals (instance.P[0][0], 2);
    }
    @Test
    public void testEncontrarOptimoConHUno() {
        System.out.println("encontrarOptimo");
        int cantElem = 1;
        String[] claves = {"","g"};
        int[] frecExito = {0,5};
        int[] frecNoExito = {2,6};
        CalculadorMatricesOptimo instance = new CalculadorMatricesOptimo(cantElem);
        TArbolBB miArbol = new TArbolBB();
        instance.encontrarOptimo(cantElem, frecExito, frecNoExito); 
        instance.armarArbolBinario(0, cantElem, claves , miArbol);
        System.out.println("costo arbol ---->"+miArbol.calcularCosto(frecNoExito, frecNoExito));
        System.out.println("costo arbol ---->" + miArbol.calcularCosto(frecExito, frecNoExito));
        assertEquals (instance.P[0][1],21);
        // R 0,1 tiene que ser 1
    }

     @Test
    public void testEncontrarOptimoConHDos() {
        System.out.println("encontrarOptimoConHDos");
        int cantElem = 2;
        String[] claves = {"","g","p"};
        int[] frecExito = {0,5,7};
        int[] frecNoExito = {2,6,9};
        CalculadorMatricesOptimo instance = new CalculadorMatricesOptimo(cantElem);
        TArbolBB miArbol = new TArbolBB();
        instance.encontrarOptimo(cantElem, frecExito, frecNoExito); 
        instance.armarArbolBinario(0, cantElem, claves , miArbol);
        System.out.println(miArbol.calcularCosto(frecExito, frecNoExito));
        assertEquals (instance.P[0][2],59);
        // R 0,1 tiene que ser 1
    }
    @Test
    public void testEncontrarOptimoConHTres() {
        System.out.println("encontrarOptimoConHDos");
        int cantElem = 3;
        String[] claves = {"","g","p","h"};
        int[] frecExito = {0,5,7,4};
        int[] frecNoExito = {2,6,9,1};
        CalculadorMatricesOptimo instance = new CalculadorMatricesOptimo(cantElem);
        TArbolBB miArbol = new TArbolBB();
        instance.encontrarOptimo(cantElem, frecExito, frecNoExito); 
        instance.armarArbolBinario(0, cantElem, claves , miArbol);
        System.out.println(miArbol.calcularCosto(frecExito, frecNoExito));
        assertEquals (instance.P[0][3],79);
        // R 0,1 tiene que ser 1
    }
    
    @Test
    public void testArmarArbolBinario() {
        System.out.println("armarArbolBinario");
        int[] freqExito = new int[]{0, 5, 3, 4, 2};
        int[] freqNoExito = new int[]{1, 3, 1, 3, 7};
        String[] lasClaves = new String[]{"", "GATO", "PERRO", "RATON", "ZORRO"};
        int cantElem = 4;
        CalculadorMatricesOptimo instance = new CalculadorMatricesOptimo(cantElem);
        instance.encontrarOptimo(cantElem, freqExito, freqNoExito);

        System.out.println("Matriz W:");
        Util.imprimirMatriz(instance.W);
        System.out.println("");
        System.out.println("Matriz P:");
        Util.imprimirMatriz(instance.P);
        System.out.println("");
        System.out.println("Matriz R:");
        Util.imprimirMatriz(instance.R);

        TArbolBB<String> elArbolBB = new TArbolBB<>();

        instance.armarArbolBinario(0, cantElem, lasClaves, elArbolBB);

        String pre = elArbolBB.preOrden();
        String preEsp = "RATON-GATO-PERRO-ZORRO";
        assertEquals(preEsp, pre);
    }

    
    
}
