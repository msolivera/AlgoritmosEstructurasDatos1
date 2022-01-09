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
public class NodoTest {
    
    public NodoTest() {
    }

    /**
     * Test of getDato method, of class Nodo.
     */
    @Test
    public void testGetDato() {
        System.out.println("getDato");
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        Object expResult = "Dato";
        Object result = instance.getDato();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setDato method, of class Nodo.
     */
    @Test
    public void testSetDato() {
        System.out.println("setDato");
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        String dato1 = "Dato1";
        instance.setDato(dato1);
        Object expResult = "Dato1";
        Object result = instance.getDato();
        assertEquals(expResult, result);       
    }

    /**
     * Test of getEtiqueta method, of class Nodo.
     */
    @Test
    public void testGetEtiqueta() {
        System.out.println("getEtiqueta");
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        Comparable expResult = 1011;
        Comparable result = instance.getEtiqueta();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setSiguiente method, of class Nodo.
     */
    @Test
    public void testSetSiguiente() {
        System.out.println("setSiguiente");        
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        System.out.println("getEtiqueta");
        String dato1 = "Dato";
        Comparable etiqueta1 = 1011;
        Nodo instance1 = new Nodo(dato1, etiqueta1);
        instance.setSiguiente(instance1);
        Nodo expResult = instance1;
        INodo result = instance.getSiguiente();
        assertEquals(expResult, result);       
        
    }

    /**
     * Test of getSiguiente method, of class Nodo.
     */
    @Test
    public void testGetSiguiente() {
        System.out.println("getSiguiente");
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        System.out.println("getEtiqueta");
        String dato1 = "Dato";
        Comparable etiqueta1 = 1011;
        Nodo instance1 = new Nodo(dato1, etiqueta1);
        instance.setSiguiente(instance1);
        Nodo expResult = instance1;
        INodo result = instance.getSiguiente();
        assertEquals(expResult, result); 
    }

    
    /**
     * Test of clonar method, of class Nodo.
     */
    @Test
    public void testClonar() {
        System.out.println("clonar");        
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        System.out.println("getEtiqueta");        
        INodo instance1 = instance.clonar();        
        boolean expResult = instance.equals(instance1);        
        assertTrue(expResult);
    }

    /**
     * Test of equals method, of class Nodo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        System.out.println("getEtiqueta");
        String dato1 = "Dato";
        Comparable etiqueta1 = 1011;
        Nodo instance1 = new Nodo(dato1, etiqueta1);        
        boolean expResult = instance.equals(instance1);
        assertTrue(expResult);
    }

    /**
     * Test of compareTo method, of class Nodo.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        String dato = "Dato";
        Comparable etiqueta = 1011;
        Nodo instance = new Nodo(dato, etiqueta);
        System.out.println("getEtiqueta");
        String dato1 = "Dato";
        Comparable etiqueta1 = 1011;
        Nodo instance1 = new Nodo(dato1, etiqueta1);        
        boolean expResult = instance.compareTo(instance1.getEtiqueta()) == 0;
        assertTrue(expResult);
    }
    
}
