/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface IPelicula.
 * @author DANIEL
 */
public class Pelicula implements IPelicula {
    
    private final Comparable ID;
    private String nombre;
    private int anio;
    private double puntaje;
    private String resenia;
    private String genero;

    /**
     * Constructor de la Clase Pelicula.
     * @param ID Comoarable recibido por parámetro.
     * @param nombre String recibido por parámetro.
     * @param anio int recibido por parámetro.
     * @param puntaje double recibido por parámetro.
     * @param resenia String recibido por parámetro.
     * @param genero String recibido por parámetro.
     */
    public Pelicula(Comparable ID, String nombre, int anio, double puntaje, String resenia, String genero) {
        this.ID = ID;
        this.nombre = nombre;
        this.anio = anio;
        this.puntaje = puntaje;
        this.resenia = resenia;
        this.genero = genero;
    }

    
    @Override
    public Comparable getID() {
        return this.ID;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getAnio() {
        return this.anio;
    }

    @Override
    public double getPuntaje() {
        return this.puntaje;
    }

    @Override
    public String getResenia() {
        return this.resenia;
    }

    @Override
    public String getGenero() {
        return this.genero;
    }
    
}
