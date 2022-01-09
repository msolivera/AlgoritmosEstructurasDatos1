/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
/**
 *
 * @author Micaela Olivera
 */
public class Libro implements IDatoPrincipal {

    private final Comparable ID;
    private final String nombre;
    private final int anio;
    private final float puntaje;
    private final int cantidadPuntajes;
    private final String isbn;

    /**
     * Constructor de la clase Libro
     *
     * @param ID Comparable con el valor que se asignara a la variable ID
     * @param nombre String con el valor que se le asignata a la variable nombre
     * @param anio int con el valor que se le asignata a la variable anio
     * @param puntaje float con el valor que se le asignata a la variable
     * puntaje
     * @param cantidadPuntajes int con el valor que se le asignata a la variable
     * cantidadPuntajes
     * @param isbn String con el valor que se le asignata a la variable isbn
     */
    public Libro(Comparable ID, String nombre, int anio, float puntaje, int cantidadPuntajes, String isbn) {
        this.ID = ID;
        this.nombre = nombre;
        this.cantidadPuntajes = cantidadPuntajes;
        this.isbn = isbn;
        this.puntaje = puntaje;
        this.anio = anio;
    }

    /**
     * Metodo que devuelve el Id de un libro
     *
     * @return Comparable correspondiente a la variable ID del Libro
     */
    @Override
    public Comparable getID() {
        return this.ID;
    }

    /**
     * Metodo que devuelve el nombre del libro
     *
     * @return String correspondiente a la variable nombre del Libro.
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo encargado de imprimir en pantalla la informacion del libro
     */
    @Override
    public void mostrarInfo() {

        System.out.println("INFORMACION DE LIBRO:");
        System.out.println("Id:" + this.ID);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Año de publicacion: " + this.anio);
        System.out.println("Puntaje: " + this.puntaje);
        System.out.println("Cantidad de puntajes: " + this.cantidadPuntajes);
        System.out.println("ISBN/ISBN13: " + this.isbn);
        System.out.println("-------------------------------------------------");

    }

    /**
     * Metodo que devuelve el año de un libro
     *
     * @return int correspondiente a la variable anio del Libro
     */
    public int getAnio() {

        return this.anio;
    }

    /**
     * Metrodo que devuelve el puntaje de un libro
     *
     * @return float correspondiente a la variable puntaje del Libro
     */
    public float getPuntaje() {

        return this.puntaje;
    }

    /**
     * Metodo que devuelve la cantidad de puntajes de un libro
     *
     * @return int correspondiente a la variable cantidadPuntajes de un Libro.
     */
    public int getCantidadPuntaje() {

        return this.cantidadPuntajes;
    }

    /**
     * Metodo que devuelve el ISBN/ISBN13 de un libro
     *
     * @return String correspondiente a la variable isbn del Libro.
     */
    public String getIsbn() {

        return this.isbn;
    }

}
