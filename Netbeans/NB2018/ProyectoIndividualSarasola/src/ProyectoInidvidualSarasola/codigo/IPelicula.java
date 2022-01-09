/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Define las operaciones de las Clases que implementan IPelicula.
 * @author DANIEL
 */
public interface IPelicula {

    /**
     * Retorna el ID de la Película.
     * @return ID de la Película.
     */
    public Comparable getID();

    /**
     * Retorna el nombre de la Película.
     * @return un String con el nombre de la película.
     */
    public String getNombre();

    /**
     * Retorna el año de la película.
     * @return un int con el año de la película.
     */
    public int getAnio();

    /**
     * Retorna el puntaje de la película.
     * @return un double con el puntaje de la película.
     */
    public double getPuntaje();

    /**
     * Retorna un texto que contiene una resaña de la película.
     * @return un String con la reseña de la película.
     */
    public String getResenia();

    /**
     * Retorna el/los géneros de la película.
     * @return un String con el/los géneros de la película.
     */
    public String getGenero();
    
}
