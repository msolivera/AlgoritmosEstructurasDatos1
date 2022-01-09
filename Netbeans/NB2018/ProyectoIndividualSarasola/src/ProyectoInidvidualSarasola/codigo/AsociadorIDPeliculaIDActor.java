/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface IAsociadorIDPelicula.
 * Tiene por atributos un objeto Comparable con la variable ID de un objeto 
 * Pelicula y un objeto Comparable con la variable ID de un objeto Actor.  
 * @author DANIEL
 * @param <Actor> Tipo Actor.
 */
public class AsociadorIDPeliculaIDActor<Actor> implements IAsociadorIDPelicula<Actor> {
    
    private Comparable IDPelicula;
    private Comparable IDActor;
    
    /**
     * Constructor de la Clase AsociadorIDPeliculaIDActor.
     * @param IDPelicula Comparable con el valor de la variable ID de un objeto 
     *                   Pelicula.
     * @param IDActor Comparable con el valor de la variable ID de un objeto 
     *                Actor.
     */
    public AsociadorIDPeliculaIDActor(Comparable IDPelicula, Comparable IDActor) {
        this.IDPelicula = IDPelicula;
        this.IDActor = IDActor;
    }

    @Override
    public Comparable getIDPelicula() {
        return this.IDPelicula;
    }

    @Override
    public Comparable getID() {
        return this.IDActor;
    }    
}
