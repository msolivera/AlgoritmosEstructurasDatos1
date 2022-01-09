/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigoInicial;

/**
 *
 * @author DANIEL
 */
public class PeliculasActores implements IPeliculasActores{
    private final int ID_PELICULA;
    private final int ID_ACTOR;

    public PeliculasActores(int ID_PELICULA, int ID_ACTOR) {
        this.ID_PELICULA = ID_PELICULA;
        this.ID_ACTOR = ID_ACTOR;
    }    

    @Override
    public int getIdPelicula() {
        return this.ID_PELICULA;
    }

    @Override
    public int getIdActor() {
        return this.ID_ACTOR;
    }
    
    
}
