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
public class Pelicula implements IPelicula{
    private final int ID;
    private final String NOMBRE;
    private final int ANIO;

    public Pelicula(int ID, String NOMBRE, int ANIO) {
        this.ID = ID;
        this.NOMBRE = NOMBRE;
        this.ANIO = ANIO;
    }    
    

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public String getNombre() {
        return this.NOMBRE;
    }

    @Override
    public int getAnio() {
        return this.ANIO;
    }
    
    
}
