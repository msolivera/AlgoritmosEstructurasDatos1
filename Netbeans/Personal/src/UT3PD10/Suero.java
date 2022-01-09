/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD10;

/**
 *
 * @author Meki
 */
public class Suero {
    
     private final int id;
    private final String nombre;
    
    public Suero(int id, String nombre) {

        this.id = id;
        this.nombre = nombre;
        
    }
    
    public int getId(){
        return this.id;
    }
    
    public String nombre(){
        return this.nombre;
    }
    
    public void imprimir(){
        System.out.println("id "+this.id+" nombre "+this.nombre);
    }
    
}
