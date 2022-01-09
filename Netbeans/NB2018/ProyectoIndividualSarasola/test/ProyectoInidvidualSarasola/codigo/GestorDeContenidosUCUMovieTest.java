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
public class GestorDeContenidosUCUMovieTest {
    
    public GestorDeContenidosUCUMovieTest() {
    }

    /**
     * Test of obtenerPeliculas method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerPeliculas() {
        System.out.println("obtenerPeliculas");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        Pelicula  pelicula;
        pelicula = new Pelicula(209112,"Batman",2016,5.8,"Plot.",
                                    "Action-Adventure-Fantasy-Science Fiction");
        INodo<Pelicula> nodo = new Nodo<>(pelicula, pelicula.getID());
        ILista<Pelicula> expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<Pelicula> result = instance.obtenerPeliculas();
        assertEquals(expResult.getPrimero().getDato().getID(), 
                                        result.getPrimero().getDato().getID());        
    }

    /**
     * Test of obtenerActores method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerActores() {
        System.out.println("obtenerActores");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        Actor  actor;
        actor = new Actor(209112, "James Cromwell");
        INodo<Actor> nodo = new Nodo<>(actor, actor.getID());
        ILista<Actor> expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<Actor> result = instance.obtenerActores();
        assertEquals(expResult.getPrimero().getDato().getID(), 
                                         result.getPrimero().getDato().getID());
    }

    /**
     * Test of obtenerDirectores method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerDirectores() {
        System.out.println("obtenerDirectores");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        Director  director;
        director = new Director(209112, "Byron Howard");
        INodo<Director> nodo = new Nodo<>(director, director.getID());
        ILista<Director> expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<Director> result = instance.obtenerDirectores();
        assertEquals(expResult.getPrimero().getDato().getID(), result.getPrimero().getDato().getID());
    }

    /**
     * Test of obtenerProductores method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerProductores() {
        System.out.println("obtenerProductores");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        Productor  productor;
        productor = new Productor(209112, "Walt Disney Pictures");
        INodo<Productor> nodo = new Nodo<>(productor, productor.getID());
        ILista<Productor> expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<Productor> result = instance.obtenerProductores();
        assertEquals(expResult.getPrimero().getDato().getID(), 
                                         result.getPrimero().getDato().getID());
    }

    /**
     * Test of obtenerPeliculasActores method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerPeliculasActores() {
       System.out.println("obtenerPeliculasActores");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        AsociadorIDPeliculaIDActor  peliActor;
        peliActor = new AsociadorIDPeliculaIDActor(209112,209112);
        INodo<AsociadorIDPeliculaIDActor> nodo;
        nodo = new Nodo<>(peliActor, peliActor.getID());
        ILista<AsociadorIDPeliculaIDActor> expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<AsociadorIDPeliculaIDActor> result;
        result = instance.obtenerPeliculasActores();
        assertEquals(expResult.getPrimero().getDato().getID(), 
                                        result.getPrimero().getDato().getID());
    }

    /**
     * Test of obtenerPeliculasDirectores method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerPeliculasDirectores() {
        System.out.println("obtenerPeliculasDirectores");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        AsociadorIDPeliculaIDDirector  peliDirector;
        peliDirector = new AsociadorIDPeliculaIDDirector(209112,209112);
        INodo<AsociadorIDPeliculaIDDirector> nodo;
        nodo = new Nodo<>(peliDirector, peliDirector.getID());
        ILista<AsociadorIDPeliculaIDDirector> expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<AsociadorIDPeliculaIDDirector> result;
        result = instance.obtenerPeliculasDirectores();
        assertEquals(expResult.getPrimero().getDato().getID(), 
                                         result.getPrimero().getDato().getID());
    }

    /**
     * Test of obtenerPeliculasProductores method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerPeliculasProductores() {
        System.out.println("obtenerPeliculasProductores");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        AsociadorIDPeliculaIDProductor  peliProductor;
        peliProductor = new AsociadorIDPeliculaIDProductor (209112,209112);
        INodo<AsociadorIDPeliculaIDProductor > nodo;
        nodo = new Nodo<>(peliProductor, peliProductor.getID());
        ILista<AsociadorIDPeliculaIDProductor > expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<AsociadorIDPeliculaIDProductor > result;
        result = instance.obtenerPeliculasProductores();
        assertEquals(expResult.getPrimero().getDato().getID(), 
                                         result.getPrimero().getDato().getID());
    }

    /**
     * Test of obtenerImagenes method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerImagenes() {
        System.out.println("obtenerImagenes");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        Imagen  imagen;
        imagen = new Imagen (209112,"DATO");
        INodo<Imagen > nodo = new Nodo<>(imagen, imagen.getID());
        ILista<Imagen> expResult = new Lista<>();
        expResult.insertar(nodo);
        ILista<Imagen> result = instance.obtenerImagenes();
        assertEquals(expResult.getPrimero().getDato().getID(), 
                                         result.getPrimero().getDato().getID());
    }

    /**
     * Test of obtenerAnioPeliculaMasAntigua method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testObtenerAnioPeliculaMasAntigua() {
        System.out.println("obtenerAnioPeliculaMasAntigua");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        int result = instance.obtenerAnioPeliculaMasAntigua();
        int expResult = 2016;
        assertEquals(expResult, result);
    }

    /**
     * Test of cargarDatos method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testCargarDatos() {
        System.out.println("cargarDatos");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.obtenerActores().getPrimero().getDato().getNombre();
        String expectedResult = "James Cromwell";
        assertEquals(expectedResult, result);
    }

    /**
     * Test of infoPelicula method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testInfoPelicula() {
        System.out.println("infoPelicula");        
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");
        
        System.out.println(instance.infoPelicula("Batman"));
        String result = instance.infoPelicula("Batman");
        String expectedResult = "Nombre: Batman\n" + "Puntuación: 5.8\n" +
        "Id Película: 209112\n" + "Año: 2016\n" + "Género: Action\n" +
            "Reseña: Plot.\n" + "Elenco> \n\t" + "James Cromwell"+"\n\t"+"\n"+
               "Director> \n\t" + "Byron Howard\n\t" + "\n"+ "Productores> \n\t" 
                + "Walt Disney Pictures"+"\n\t";
        assertEquals(expectedResult, result);
    }

    /**
     * Test of imagenPelicula method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testImagenPelicula() {
        System.out.println("imagenPelicula");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result = instance.imagenPelicula("Batman");
        String expResult = "src/ProyectoInidvidualSarasola/ArchivoImagenes/"+ 
                                    "209112" + ".png";
        assertEquals(expResult, result);
    }

    /**
     * Test of nombreActor method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testNombreActor() {
       System.out.println("nombreActor");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result = instance.nombreActor("209112");
        String expResult = "James Cromwell";
        assertEquals(expResult, result);
    }

    /**
     * Test of nombreDirector method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testNombreDirector() {
        System.out.println("nombreDirector");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result = instance.nombreDirector("209112");
        String expResult = "Byron Howard";
        assertEquals(expResult, result);
    }

    /**
     * Test of nombreProductor method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testNombreProductor() {
        System.out.println("nombreProductor");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result = instance.nombreProductor("209112");
        String expResult = "Walt Disney Pictures";
        assertEquals(expResult, result);
    }

    /**
     * Test of generosEnListaPeliculas method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testGenerosEnListaPeliculas() {
         System.out.println("generosEnListaPeliculas");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.generosEnListaPeliculas().getPrimero().getDato();
        String expResult = "Action";
        assertEquals(expResult, result);
    }

    /**
     * Test of peliculasDeDirector method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testPeliculasDeDirector() {
        System.out.println("peliculasDeDirector");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.peliculasDeDirector("Byron Howard").
                                             getPrimero().getDato().getNombre();
        String expResult = "Batman";
        assertEquals(expResult, result);
    }

    /**
     * Test of peliculasDeActor method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testPeliculasDeActor() {
         System.out.println("peliculasDeActor");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.peliculasDeActor("James Cromwell").
                                             getPrimero().getDato().getNombre();
        String expResult = "Batman";
        assertEquals(expResult, result);
    }

    /**
     * Test of peliculasPorAnio method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testPeliculasPorAnio() {
        System.out.println("peliculasPorAnio");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.peliculasPorAnio(2016,2016).getPrimero().
                                                          getDato().getNombre();
        String expResult = "Batman";
        assertEquals(expResult, result);
    }

    /**
     * Test of peliculasPorPuntaje method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testPeliculasPorPuntaje() {
        System.out.println("peliculasPorPuntaje");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.peliculasPorPuntaje(4.0,6.0).getPrimero().
                                                          getDato().getNombre();
        String expResult = "Batman";
        assertEquals(expResult, result);
    }

    /**
     * Test of peliculasPorGenero method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testPeliculasPorGenero() {
        System.out.println("peliculasPorGenero");        
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.peliculasPorGenero("Action").getPrimero().
                                                          getDato().getNombre();
        String expResult = "Batman";
        assertEquals(expResult, result);
    }

    /**
     * Test of peliculasPorTodosLosFiltros method, of class GestorDeContenidosUCUMovie.
     */
    @Test
    public void testPeliculasPorTodosLosFiltros() {
        System.out.println("peliculasPorTodosLosFiltros");
        GestorDeContenidosUCUMovie instance = new GestorDeContenidosUCUMovie();
        instance.cargarDatos
        ("src/ProyectoInidvidualSarasola/archivos/Test-Peliculas.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Actores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Directores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Productores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasActores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasDirectores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-PeliculasProductores.txt",
         "src/ProyectoInidvidualSarasola/archivos/Test-Imagenes.txt");        
        String result;
        result = instance.peliculasPorTodosLosFiltros("Byron Howard",
                "James Cromwell",2016,2016,4.0,6.0,"Action").getPrimero().
                                                          getDato().getNombre();
        String expResult = "Batman";
        assertEquals(expResult, result);
    }
    
}
