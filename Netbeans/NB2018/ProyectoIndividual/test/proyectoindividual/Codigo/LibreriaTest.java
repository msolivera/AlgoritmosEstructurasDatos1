/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoindividual.Codigo;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meki
 */
public class LibreriaTest {
    
    public LibreriaTest() {
    }


 
    /**
     * Test of cargarAutores method, of class Libreria.
     */
    @Test
    public void testCargarAutores() {
        System.out.println("cargarAutores");
        String archivoAutores = "";
        Libreria instance = new Libreria();
        instance.cargarAutores(archivoAutores);
 
    }

    /**
     * Test of cargarTags method, of class Libreria.
     */
    @Test
    public void testCargarTags() {
        System.out.println("cargarTags");
        String archivoTags = "";
        Libreria instance = new Libreria();
        instance.cargarTags(archivoTags);

    }

    /**
     * Test of cargarLibros method, of class Libreria.
     */
    @Test
    public void testCargarLibros() {
        System.out.println("cargarLibros");
        String archivosLibros = "";
        Libreria instance = new Libreria();
        instance.cargarLibros(archivosLibros);

    }

    /**
     * Test of buscarFechaNombre method, of class Libreria.
     */
    @Test
    public void testBuscarFechaNombre() {
        System.out.println("buscarFechaNombre");
        int fecha = 0;
        String nombre = "";
        Libreria instance = new Libreria();
        instance.buscarFechaNombre(fecha, nombre);

    }

    /**
     * Test of mostrarPorFecha method, of class Libreria.
     */
    @Test
    public void testMostrarPorFecha() {
        System.out.println("mostrarPorFecha");
        int anio = 0;
        Libreria instance = new Libreria();
        instance.mostrarPorFecha(anio);
 
    }

    /**
     * Test of mostrarPorIsbn method, of class Libreria.
     */
    @Test
    public void testMostrarPorIsbn() {
        System.out.println("mostrarPorIsbn");
        String isbn = "";
        Libreria instance = new Libreria();
        instance.mostrarPorIsbn(isbn); 
    }

    /**
     * Test of mostrarPorAutor method, of class Libreria.
     */
    @Test
    public void testMostrarPorAutor() {
        System.out.println("mostrarPorAutor");
        String nombreAutor = "";
        Libreria instance = new Libreria();
        instance.mostrarPorAutor(nombreAutor);
    }

    /**
     * Test of mostrarPorGenero method, of class Libreria.
     */
    @Test
    public void testMostrarPorGenero() {
        System.out.println("mostrarPorGenero");
        String genero = "";
        Libreria instance = new Libreria();
        instance.mostrarPorGenero(genero);

    }

    /**
     * Test of verTags method, of class Libreria.
     */
    @Test
    public void testVerTags() {
        System.out.println("verTags");
        Libreria instance = new Libreria();
        instance.verTags();

    }

    /**
     * Test of verLibros method, of class Libreria.
     */
    @Test
    public void testVerLibros() {
        System.out.println("verLibros");
        Libreria instance = new Libreria();
        instance.verLibros();

    }

    /**
     * Test of verAutores method, of class Libreria.
     */
    @Test
    public void testVerAutores() {
        System.out.println("verAutores");
        Libreria instance = new Libreria();
        instance.verAutores();

    }

    /**
     * Test of buscarAutor method, of class Libreria.
     */
    @Test
    public void testBuscarAutor() {
        System.out.println("buscarAutor");
        String nombre = "";
        Libreria instance = new Libreria();
        instance.buscarAutor(nombre);

    }

    /**
     * Test of buscarLibro method, of class Libreria.
     */
    @Test
    public void testBuscarLibro() {
        System.out.println("buscarLibro");
        String nombre = "";
        Libreria instance = new Libreria();
        instance.buscarLibro(nombre);

    }

    /**
     * Test of eliminarLibroAutor method, of class Libreria.
     */
    @Test
    public void testEliminarLibroAutor() {
        System.out.println("eliminarLibroAutor");
        String autor = "";
        Libreria instance = new Libreria();
        instance.eliminarLibroAutor(autor);
    }

    /**
     * Test of mostrarAutoresDeLibro method, of class Libreria.
     */
    @Test
    public void testMostrarAutoresDeLibro() {
        System.out.println("mostrarAutoresDeLibro");
        String nombre = "";
        Libreria instance = new Libreria();
        instance.mostrarAutoresDeLibro(nombre);
 
    }

    /**
     * Test of mostrarGenerosDeLibro method, of class Libreria.
     */
    @Test
    public void testMostrarGenerosDeLibro() {
        System.out.println("mostrarGenerosDeLibro");
        String nombre = "";
        Libreria instance = new Libreria();
        instance.mostrarGenerosDeLibro(nombre);

    }
    
}
