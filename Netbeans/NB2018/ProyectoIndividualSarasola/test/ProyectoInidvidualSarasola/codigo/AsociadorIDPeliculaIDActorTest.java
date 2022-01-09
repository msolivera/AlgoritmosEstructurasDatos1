/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANIEL
 */
public class AsociadorIDPeliculaIDActorTest {
    
    public AsociadorIDPeliculaIDActorTest() {
    }  

    /**
     * Test of getIDPelicula method, of class AsociadorIDPeliculaIDActor.
     */
    @Test
    public void testGetIDPelicula() {
        System.out.println("getIDPelicula");
        Comparable idPelicula = 1003;
        Comparable idActor = 1004;        
        AsociadorIDPeliculaIDActor instance = new AsociadorIDPeliculaIDActor(idPelicula, idActor) ;
        Comparable expResult = 1003;
        Comparable result = instance.getIDPelicula();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getID method, of class AsociadorIDPeliculaIDActor.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Comparable idPelicula = 1003;
        Comparable idActor = 1004;        
        AsociadorIDPeliculaIDActor instance = new AsociadorIDPeliculaIDActor(idPelicula, idActor) ;
        Comparable expResult = 1004;
        Comparable result = instance.getID();
        assertEquals(expResult, result);        
    }
    
}
