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
public class PeliculaTest {
    
    public PeliculaTest() {
    }

    /**
     * Test of getID method, of class Pelicula.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable id = 1010;
        String nombre = "Pelicula";
        int anio = 2016;
        double puntaje = 10.0;
        String resenia = "Resenia";
        String genero = "Genero";
        Pelicula instance;
        instance = new Pelicula(id, nombre,anio,puntaje,resenia,genero);
        Comparable expResult = 1010;
        Comparable result = instance.getID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getNombre method, of class Pelicula.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Comparable id = 1010;
        String nombre = "Pelicula";
        int anio = 2016;
        double puntaje = 10.0;
        String resenia = "Resenia";
        String genero = "Genero";
        Pelicula instance;
        instance = new Pelicula(id, nombre,anio,puntaje,resenia,genero);
        String expResult = "Pelicula";
        String result = instance.getNombre();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getAnio method, of class Pelicula.
     */
    @Test
    public void testGetAnio() {
        System.out.println("getAnio");
        Comparable id = 1010;
        String nombre = "Pelicula";
        int anio = 2016;
        double puntaje = 10.0;
        String resenia = "Resenia";
        String genero = "Genero";
        Pelicula instance;
        instance = new Pelicula(id, nombre,anio,puntaje,resenia,genero);
        int expResult = 2016;
        int result = instance.getAnio();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getPuntaje method, of class Pelicula.
     */
    @Test
    public void testGetPuntaje() {
        System.out.println("getPuntaje");
        Comparable id = 1010;
        String nombre = "Pelicula";
        int anio = 2016;
        double puntaje = 10.0;
        String resenia = "Resenia";
        String genero = "Genero";
        Pelicula instance;
        instance = new Pelicula(id, nombre,anio,puntaje,resenia,genero);
        double expResult = 10.0;
        double result = instance.getPuntaje();
        assertEquals(expResult, result, 0.0);       
    }

    /**
     * Test of getResenia method, of class Pelicula.
     */
    @Test
    public void testGetResenia() {
        System.out.println("getResenia");
        Comparable id = 1010;
        String nombre = "Pelicula";
        int anio = 2016;
        double puntaje = 10.0;
        String resenia = "Resenia";
        String genero = "Genero";
        Pelicula instance;
        instance = new Pelicula(id, nombre,anio,puntaje,resenia,genero);
        String expResult = "Resenia";
        String result = instance.getResenia();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getGenero method, of class Pelicula.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        Comparable id = 1010;
        String nombre = "Pelicula";
        int anio = 2016;
        double puntaje = 10.0;
        String resenia = "Resenia";
        String genero = "Genero";
        Pelicula instance;
        instance = new Pelicula(id, nombre,anio,puntaje,resenia,genero);
        String expResult = "Genero";
        String result = instance.getGenero();
        assertEquals(expResult, result);
    }
    
}
