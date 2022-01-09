/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface IAsociadorIDPelicula.
 * Tiene por atributos un objeto Comparable con la variable ID de un objeto 
 * Pelicula y un objeto Comparable con la variable ID de un objeto Productor. 
 * @author DANIEL
 * @param <Productor> Tipo Productor.
 */
public class AsociadorIDPeliculaIDProductor<Productor> implements IAsociadorIDPelicula<Productor> {
    
    private Comparable IDPelicula;
    private Comparable IDProductor;

    /**
     * Constructor de la Clase AsociadorIDPeliculaIDProductor.
     * @param IDPelicula Comparable con el valor de la variable ID de un objeto 
     *                   Pelicula.
     * @param IDProductor Comparable con el valor de la variable ID de un objeto 
     *                    Productor.
     */
    public AsociadorIDPeliculaIDProductor(Comparable IDPelicula, Comparable IDProductor) {
        this.IDPelicula = IDPelicula;
        this.IDProductor = IDProductor;
    }   

    @Override
    public Comparable getIDPelicula() {
        return this.IDPelicula;
    }

    @Override
    public Comparable getID() {
        return this.IDProductor;
    }    
}
