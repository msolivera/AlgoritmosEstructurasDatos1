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
public class Actor implements IActor{
    
    private final int ID;
    private final String NOMBRE;

    public Actor(int ID, String nombre) {
        this.ID = ID;
        this.NOMBRE = nombre;
    }
    
    
    @Override
    public int getID() {
        return this.ID;        
    }

    @Override
    public String getNombre() {
        return this.NOMBRE;
    }
    
    
}
