/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigoInicial;

//import aed1.obligatorio2016.catedra.*;

/**
 *
 * @author Josse
 */
public interface IAEDMovieAdapter {
    void cargarDatos();
    public Pelicula[] obtenerPeliculas();
    public Actor[] obtenerActores();
    public PeliculasActores[] obtenerPeliculasActores();
    public String getInfoPelicula(String nombrePelicula);
    public String getNombreActor(String idActor);
}
