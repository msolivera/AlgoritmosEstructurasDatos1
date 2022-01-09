/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

/**
 * Define las operaciones de las Clases que implementan IImagen.
 * @author DANIEL
 */
public interface IImagen {
    /**
     * Método que retorna el valor de un objeto Comparable ID, componente de un 
     * objeto que implementa la Interface IImagen.
     * @return ID de la Imagen.
     */
    public Comparable getID();

    /**
     * Método que retorna un objeto String de hexadecimales, conteniendo la 
     * información de un objeto Imagen.
     * @return  String  de hexadecimales con el contenido de la Imagen.
     */
    public String getContenido();
    
}
