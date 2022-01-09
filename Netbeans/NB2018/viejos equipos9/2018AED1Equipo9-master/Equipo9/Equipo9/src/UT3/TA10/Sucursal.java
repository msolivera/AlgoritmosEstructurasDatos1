/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA10;

/**
 *
 * @author Equipo9
 */
public class Sucursal 
{
        Comparable etiqueta;
        
        public Sucursal()
        {
                this.etiqueta = null;
        }
        public Sucursal(Comparable etiqueta)
        {
                this.etiqueta = etiqueta;
        }
        /**
         * Este metodo imprime por pantalla la etiqueta de la sucursal
         */
        public void info()
        {
                System.out.println("Nombre sucursal: " + (String)this.etiqueta);
        }
        
        
        
        
}
