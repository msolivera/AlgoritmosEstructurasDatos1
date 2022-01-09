/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Define las operaciones de las Clases que implementan IParticipante.
 * @author DANIEL
 */
public interface IParticipante {

    /**
     * Método que retorna un objeto Comparable con el valor de la variable ID 
     * del objeto que implementa IParticipante.
     * @return ID del Participante.
     */
    public Comparable getID();

    /**
     *  Método que retorna un String con el valor de la variable nombre del 
     * objeto que implementa IParticipante.
     * @return String con el valor de la variable nombre del objeto que 
     *         implementa IParticipante.
     */
    public String getNombre();
    
}
