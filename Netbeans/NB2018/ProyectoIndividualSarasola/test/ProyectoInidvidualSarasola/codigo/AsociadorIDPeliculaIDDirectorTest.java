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
public class AsociadorIDPeliculaIDDirectorTest {
    
    public AsociadorIDPeliculaIDDirectorTest() {
    }

    /**
     * Test of getIDPelicula method, of class AsociadorIDPeliculaIDDirector.
     */
    @Test
    public void testGetIDPelicula() {
        System.out.println("getIDPelicula");
        Comparable idPelicula = 1005;
        Comparable idDirector = 1006;        
        AsociadorIDPeliculaIDDirector instance = new AsociadorIDPeliculaIDDirector(idPelicula, idDirector);
        Comparable expResult = 1005;
        Comparable result = instance.getIDPelicula();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getID method, of class AsociadorIDPeliculaIDDirector.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable idPelicula = 1005;
        Comparable idDirector = 1006;        
        AsociadorIDPeliculaIDDirector instance = new AsociadorIDPeliculaIDDirector(idPelicula, idDirector);
        Comparable expResult = 1006;
        Comparable result = instance.getID();
        assertEquals(expResult, result);        
    }
    
}
