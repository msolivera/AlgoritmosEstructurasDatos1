/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoindividual.Codigo;

/**
 * @author Micaela Olivera
 */
public class Autor implements IDatoPrincipal {

    private final Comparable ID;
    private final String nombre;

    /**
     * Constructor de la Clase Autor.
     *
     * @param ID Comparable con el valor que se le asignará a la varible ID.
     * @param nombre String con el valor que se le asignará a la varible nombre.
     */
    public Autor(Comparable ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve el Id de un Autor
     *
     * @return rComparable correspondiente  al atributo ID del objeto Autor.
     */
    @Override
    public Comparable getID() {
        return this.ID;
    }

    /**
     * Metodo que devuelve el nombre de un Autor
     *
     * @return String correspondiente  al atributo nombre del objeto Autor.
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo generico que muestra la informacion detallada de un objeto Autor.
     */
    @Override
    public void mostrarInfo() {
        System.out.println("INFORMACION DE AUTOR:");
        System.out.println("Id:" + this.ID);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("-------------------------------------------------");
    }
}
