/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA4;

/**
 * Clase encargada de crear cada producto
 * @author nicolasgonzalezmartinez
 */
public class Producto {
        public String nombre;
        public char[] codigo;
        public float precio;
        public int stock;
        
        /**
         * Constructor de la clase producto (Inicializa las variables por defecto)
         */
        public Producto(String nombre, char[] codigo, float precio, int stock)
        {
                this.nombre = nombre;
                if(codigo.length <= 20)
                {
                        this.codigo = codigo;
                }
                else
                {
                        this.codigo = null;
                }
                this.precio = precio;
                this.stock = stock;
        }
        
}
