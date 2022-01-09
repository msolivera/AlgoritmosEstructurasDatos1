/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Define las operaciones de las Clases que implementan IAsociadorIDPelicula.
 * @author DANIEL
 * @param <T> Tipo genérico.
 */
public interface IAsociadorIDPelicula<T> {

    /**
     * Método que retorna el ID de un objeto Pelicula.
     * @return ID de un objeto Pelicula.
     */
    public Comparable getIDPelicula();

    /**
     * Retorna el ID del Tipo recibido por parámetro.
     * @return ID del Tipo recibido por parámetro.
     */
    public Comparable getID();    
}
