/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoindividual.Codigo;

/**
 *
 * @author Micaela Olivera
 */
public interface IDatoPrincipal {

    /**
     * Método que retorna un objeto Comparable con el valor de la variable ID
     * del objeto que implementa IDatoPrincipal.
     *
     * @return ID del DatoPrincipal.
     */
    public Comparable getID();

    /**
     * Método que retorna un String con el valor de la variable nombre del
     * objeto que implementa IDatoPrincipal.
     *
     * @return String con el valor de la variable nombre del objeto que
     * implementa IDatoPrincipal.
     */
    public String getNombre();

    /**
     * Metodo que imprimira en pantalla la informacion detallada del objeto que
     * implementa IDatoPrincipal.
     */
    public void mostrarInfo();
}
