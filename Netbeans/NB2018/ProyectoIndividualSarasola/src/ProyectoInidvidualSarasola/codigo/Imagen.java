/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface IImagen.
 * @author DANIEL
 */
public class Imagen implements IImagen {
    private final Comparable ID;
    private String contenido;

     /**
     * Constructor de la Clase Imagen.
     * @param ID Comparable  con el valor de la variable ID para el objeto 
     *           Imagen.
     * @param contenido String de hexadecimales, conteniendo la información de 
     *                  un objeto Imagen.
     */
    public Imagen(Comparable ID, String contenido) {
        this.ID = ID;
        this.contenido = contenido;
    }    

    @Override
    public Comparable getID() {
        return this.ID;
    }

    @Override
    public String getContenido() {
        return this.contenido;
    }
    
}
