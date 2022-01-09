/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD6.packageAuxiliar;

/**
 * Clase producto
 * @author Meki
 */
public class Producto {

    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String otroNombre) {
        this.nombre = otroNombre;
    }

}
