/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface IParticipante.
 * @author DANIEL
 */
public class Productor implements IParticipante {

    private final Comparable ID;
    private String nombre;

    /**
     * Constructor de la Clase Productor.
    * @param ID Comparable con el valor que se le asignará a la varible ID.
    * @param nombre String con el valor que se le asignará a la varible nombre.
    */
    public Productor(Comparable ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }   

    @Override
    public Comparable getID() {
        return this.ID;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
    
}
