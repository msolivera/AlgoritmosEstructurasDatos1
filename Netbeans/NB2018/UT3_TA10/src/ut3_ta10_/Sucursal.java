/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ut3_TA10_;

/**
 *
 * @author Sebaa
 */
public class Sucursal {
    
        private String nombre;
        
        public Sucursal(String unName)
        {
            this.nombre = unName;
        }
        
        public void imprimir(String separador)
        {
            System.out.println(nombre+separador);
        }
}
