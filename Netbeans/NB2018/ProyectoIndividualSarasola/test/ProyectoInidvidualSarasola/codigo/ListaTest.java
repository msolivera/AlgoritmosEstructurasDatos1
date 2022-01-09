/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANIEL
 */
public class ListaTest {
    
    public ListaTest() {
    }

    /**
     * Test of insertar method, of class Lista.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);
        instance.insertar(nodo);
        INodo result = instance.getPrimero();
        assertEquals(nodo, result);
    }

    /**
     * Test of buscar method, of class Lista.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);
        instance.insertar(nodo);
        INodo result = instance.buscar(nodo.getEtiqueta());
        assertEquals(nodo, result);
    }

    /**
     * Test of eliminar method, of class Lista.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);
        instance.insertar(nodo);
        instance.eliminar(etiqueta);
        boolean result = instance.esVacia();
        assertTrue(result);
    }

    /**
     * Test of cantElementos method, of class Lista.
     */
    @Test
    public void testCantElementos() {
        System.out.println("cantElementos");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);
        instance.insertar(nodo);
        String dato1 = "Dato1";
        Comparable etiqueta1 = 1012;
        INodo nodo1 = new Nodo(dato1, etiqueta1);
        instance.insertar(nodo1);
        String dato2 = "Dato2";
        Comparable etiqueta2 = 1013;
        INodo nodo2 = new Nodo(dato2, etiqueta2);
        instance.insertar(nodo2);
        int expResult = 3;
        int result = instance.cantElementos();        
        assertEquals(result, expResult);
    }

    /**
     * Test of esVacia method, of class Lista.
     */
    @Test
    public void testEsVacia() {
        System.out.println("esVacia");
        Lista instance = new Lista();
        boolean expResult = true;
        boolean result = instance.esVacia();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getPrimero method, of class Lista.
     */
    @Test
    public void testGetPrimero() {
        System.out.println("getPrimero");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);
        instance.insertar(nodo);
        String dato1 = "Dato1";
        Comparable etiqueta1 = 1012;
        INodo nodo1 = new Nodo(dato1, etiqueta1);
        instance.insertar(nodo1);
        String dato2 = "Dato2";
        Comparable etiqueta2 = 1013;
        INodo nodo2 = new Nodo(dato2, etiqueta2);
        instance.insertar(nodo2);        
        INodo expResult = nodo;
        INodo result = instance.getPrimero();
        assertEquals(expResult, result);        
    }

    /**
     * Test of insertarOrdenado method, of class Lista.
     */
    @Test
    public void testInsertarOrdenado() {
        System.out.println("insertarOrdenado");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);        
        String dato1 = "Dato1";
        Comparable etiqueta1 = 1012;
        INodo nodo1 = new Nodo(dato1, etiqueta1);        
        String dato2 = "Dato2";
        Comparable etiqueta2 = 1013;
        INodo nodo2 = new Nodo(dato2, etiqueta2);
        instance.insertarOrdenado(nodo2);
        instance.insertarOrdenado(nodo1);
        instance.insertarOrdenado(nodo);
        INodo expResult = nodo;
        INodo result = instance.getPrimero();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertarOrdenadoInverso method, of class Lista.
     */
    @Test
    public void testInsertarOrdenadoInverso() {
        System.out.println("insertarOrdenadoInverso");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);        
        String dato1 = "Dato1";
        Comparable etiqueta1 = 1012;
        INodo nodo1 = new Nodo(dato1, etiqueta1);        
        String dato2 = "Dato2";
        Comparable etiqueta2 = 1013;
        INodo nodo2 = new Nodo(dato2, etiqueta2);
        instance.insertarOrdenadoInverso(nodo);
        instance.insertarOrdenadoInverso(nodo1);
        instance.insertarOrdenadoInverso(nodo2);
        INodo expResult = nodo2;
        INodo result = instance.getPrimero();
        assertEquals(expResult, result);
    }

    /**
     * Test of ordenar method, of class Lista.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);        
        String dato1 = "Dato1";
        Comparable etiqueta1 = 1012;
        INodo nodo1 = new Nodo(dato1, etiqueta1);        
        String dato2 = "Dato2";
        Comparable etiqueta2 = 1013;
        INodo nodo2 = new Nodo(dato2, etiqueta2);
        instance.insertar(nodo2);
        instance.insertar(nodo1);
        instance.insertar(nodo);
        instance.ordenar();
        INodo expResult = nodo;
        INodo result = instance.getPrimero();
        assertEquals(expResult, result);
    }

    /**
     * Test of ordenarInverso method, of class Lista.
     */
    @Test
    public void testOrdenarInverso() {
        System.out.println("ordenarInverso");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);        
        String dato1 = "Dato1";
        Comparable etiqueta1 = 1012;
        INodo nodo1 = new Nodo(dato1, etiqueta1);        
        String dato2 = "Dato2";
        Comparable etiqueta2 = 1013;
        INodo nodo2 = new Nodo(dato2, etiqueta2);
        instance.insertar(nodo);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.ordenarInverso();
        INodo expResult = nodo2;
        INodo result = instance.getPrimero();
        assertEquals(expResult, result);
    }

    /**
     * Test of quitarPrimero method, of class Lista.
     */
    @Test
    public void testQuitarPrimero() {
        System.out.println("quitarPrimero");
        Lista instance = new Lista();
        String dato = "Dato";
        Comparable etiqueta = 1011;
        INodo nodo = new Nodo(dato, etiqueta);        
        String dato1 = "Dato1";
        Comparable etiqueta1 = 1012;
        INodo nodo1 = new Nodo(dato1, etiqueta1);        
        String dato2 = "Dato2";
        Comparable etiqueta2 = 1013;
        INodo nodo2 = new Nodo(dato2, etiqueta2);
        instance.insertar(nodo);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.quitarPrimero();
        INodo expResult = nodo1;
        INodo result = instance.getPrimero();
        assertEquals(expResult, result);
    }
    
}
