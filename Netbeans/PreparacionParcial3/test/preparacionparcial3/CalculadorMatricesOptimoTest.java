/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacionparcial3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Meki
 */
public class CalculadorMatricesOptimoTest {
    
    public CalculadorMatricesOptimoTest() {
    }

    @Test
    public void testEncontrarOptimo1() {
        //Desde un caso conocido verificamos que la raiz sea la esperada.
        int[] fe = new int[4];
        int[] fne = new int[4];
        fe[1] = 8;
        fe[2] = 5;
        fe[3] = 1;
        fne[0] = 3;
        fne[1] = 1;
        fne[2] = 4;
        fne[3] = 1;
        
        int raizEsperada = 1;
        
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(3);
        calc.encontrarOptimo(3, fe, fne);
        int raizArbol = calc.R[0][3];
        
        assertEquals(raizEsperada, raizArbol);
    }
    @Test
    public void testEncontrarOptimo2() {
        //Desde un caso conocido verificamos que el costo sea el esperado.
        int[] fe = new int[4];
        int[] fne = new int[4];
        fe[1] = 8;
        fe[2] = 5;
        fe[3] = 1;
        fne[0] = 3;
        fne[1] = 1;
        fne[2] = 4;
        fne[3] = 1;
        
        int costoEsperado = 50;
        
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(3);
        calc.encontrarOptimo(3, fe, fne);
        int costoArbol = calc.P[0][3];
        
        assertEquals(costoEsperado, costoArbol);
    }
    
    @Test
    public void testArmarArbolBinario() {
        //Desde un caso conocido verificamos que el arbol final contenga todos los nodos.
        String[] claves = new String[4];
        int[] fe = new int[4];
        int[] fne = new int[4];
        claves[1] = "Cartel";
        claves[2] = "Telefono";
        claves[3] = "Unicornio";
        fe[1] = 8;
        fe[2] = 5;
        fe[3] = 1;
        fne[0] = 3;
        fne[1] = 1;
        fne[2] = 4;
        fne[3] = 1;
        
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(3);
        calc.encontrarOptimo(3, fe, fne);
        TArbolBB arbol = new TArbolBB();
        calc.armarArbolBinario(0, 3, claves, arbol);
        int nEsperado = 3;
        int nArbol = arbol.postorden().size();
        assertEquals(nEsperado, nArbol);
    }
    
    @Test
    public void testCalcularCosto(){
        //Desde un caso conocido verificamos que el costo del arbol sea el esperado.
        String[] claves = new String[4];
        int[] fe = new int[4];
        int[] fne = new int[4];
        claves[1] = "Cartel";
        claves[2] = "Telefono";
        claves[3] = "Unicornio";
        fe[1] = 8;
        fe[2] = 5;
        fe[3] = 1;
        fne[0] = 3;
        fne[1] = 1;
        fne[2] = 4;
        fne[3] = 1;
        
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(3);
        calc.encontrarOptimo(3, fe, fne);
        TArbolBB arbol = new TArbolBB();
        calc.armarArbolBinario(0, 3, claves, arbol);
        
        int costoEsperado = 50;
        long costoArbol = arbol.calcularCosto(fe, fne);
        
        assertEquals(costoEsperado, costoArbol);
    }
    
    
    @Test
    public void testCalcularCostoVacio(){
        //Creamos un arbol vacio y su costo debe ser el del nodo no encontrado
        String[] claves = new String[1];
        int[] fe = new int[1];
        int[] fne = new int[1];
        fne[0] = 2;
        
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(0);
        calc.encontrarOptimo(0, fe, fne);
        TArbolBB arbol = new TArbolBB();
        calc.armarArbolBinario(0, 0, claves, arbol);
        
        int costoEsperado = 0;
        long costoArbol = arbol.calcularCosto(fe, fne);
        
        assertEquals(costoEsperado, costoArbol);
    }
    
    @Test
    public void testLongTrayIntMedia(){
        //Data una ltim conocida comprobamos su valor
        String[] claves = new String[4];
        int[] fe = new int[4];
        int[] fne = new int[4];
        claves[1] = "Cartel";
        claves[2] = "Telefono";
        claves[3] = "Unicornio";
        fe[1] = 8;
        fe[2] = 5;
        fe[3] = 1;
        fne[0] = 3;
        fne[1] = 1;
        fne[2] = 4;
        fne[3] = 1;
        
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(3);
        calc.encontrarOptimo(3, fe, fne);
        TArbolBB arbol = new TArbolBB();
        calc.armarArbolBinario(0, 3, claves, arbol);
        
        
        double longEsperada = 2.0;
        double longReal = arbol.longTrayIntMedia();
        
        assertTrue(longEsperada == longReal);
    }
    
}
