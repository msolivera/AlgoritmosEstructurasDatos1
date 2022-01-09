/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface IAsociadorIDPelicula.
 * Tiene por atributos un objeto Comparable con la variable ID de un objeto 
 * Pelicula y un objeto Comparable con la variable ID de un objeto Director.
 * @author DANIEL
 * @param <Director> Tipo Director.
 */
public class AsociadorIDPeliculaIDDirector<Director> implements IAsociadorIDPelicula<Director> {
    
    private Comparable IDPelicula;
    private Comparable IDDirector;
    
    /**
     * Constructor de la Clase AsociadorIDPeliculaIDDirector.
     * @param IDPelicula Comparable con el valor de la variable ID de un objeto 
     *                   Pelicula.
     * @param IDDirector Comparable con el valor de la variable ID de un objeto 
     *                   Director.
     */
    public AsociadorIDPeliculaIDDirector(Comparable IDPelicula, Comparable IDDirector) {
        this.IDPelicula = IDPelicula;
        this.IDDirector = IDDirector;
    }    
    
    @Override
    public Comparable getIDPelicula() {
        return this.IDPelicula;
    }

    @Override
    public Comparable getID() {
        return this.IDDirector;
    }    
}
