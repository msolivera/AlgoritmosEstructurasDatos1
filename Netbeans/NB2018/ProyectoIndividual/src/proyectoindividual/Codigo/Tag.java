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
public class Tag implements IDatoPrincipal {

    private final Comparable ID;
    private final String nombre;

    /**
     * Constructor de la Clase Tag.
     *
     * @param ID Comparable con el valor que se le asignará a la varible ID.
     * @param nombre String con el valor que se le asignará a la varible nombre.
     */
    public Tag(Comparable ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve el Id de un Tag
     *
     * @return Comparable correspondiente al atributo ID del objeto Tag.
     */
    @Override
    public Comparable getID() {
        return this.ID;
    }

    /**
     * Metodo que devuelve el nombre de un Tag
     *
     * @return String correspondiente al atributo nombre del objeto Tag.
     */

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("INFORMACION DE GENERO:");
        System.out.println("Id:" + this.ID);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("-------------------------------------------------");
    }

}
