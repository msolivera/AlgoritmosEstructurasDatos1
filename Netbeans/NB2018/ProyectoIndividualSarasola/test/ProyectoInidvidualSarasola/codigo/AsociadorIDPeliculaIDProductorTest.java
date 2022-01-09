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
public class AsociadorIDPeliculaIDProductorTest {
    
    public AsociadorIDPeliculaIDProductorTest() {
    }

    /**
     * Test of getIDPelicula method, of class AsociadorIDPeliculaIDProductor.
     */
    @Test
    public void testGetIDPelicula() {
        System.out.println("getIDPelicula");
        Comparable idPelicula = 1007;
        Comparable idProductor = 1008;        
        AsociadorIDPeliculaIDDirector instance = new AsociadorIDPeliculaIDDirector(idPelicula, idProductor);
        Comparable expResult = 1007;
        Comparable result = instance.getIDPelicula();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getID method, of class AsociadorIDPeliculaIDProductor.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable idPelicula = 1007;
        Comparable idProductor = 1008;        
        AsociadorIDPeliculaIDDirector instance = new AsociadorIDPeliculaIDDirector(idPelicula, idProductor);
        Comparable expResult = 1008;
        Comparable result = instance.getID();
        assertEquals(expResult, result);       
    }
    
}
