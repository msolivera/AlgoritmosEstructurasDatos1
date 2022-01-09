/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA10;


import java.util.LinkedList;
/**
 * Clase encargada de crear y administrar la tienda
 * @author Equipo9
 */
public class Tienda {
        LinkedList listaSucursales = new LinkedList();
        Comparable etiqueta;
        /**
         * Constructor de la tienda
         */
        public Tienda()
        {
                 etiqueta = null;
        }
        
        public Tienda(Comparable etiqueta)
        {
                this.etiqueta = etiqueta;
        }
        
        public void agregarSucursal(Sucursal unaSucursal)
        {
                listaSucursales.add(unaSucursal);
        }
        
        public Sucursal buscarSucursal(Sucursal unaSucursal)
        {
                for (int i = 0; i < listaSucursales.size() -1; i++) 
                {
                        if(listaSucursales.get(i) == unaSucursal)
                        {
                                return (Sucursal) listaSucursales.get(i);                                       
                        }
                }
                return null;
        }
        
        public void quitarSucursal(Sucursal unaSucursal)
        {
                listaSucursales.remove(unaSucursal);
        }
        
        public void listarSucursales()
        {
                for (int i = 0; i < listaSucursales.size() -1 ; i++) 
                {
                        if(listaSucursales.get(i) != null)
                        {
                                Sucursal sucursal = (Sucursal) listaSucursales.get(i);
                                sucursal.info();
                        }
                }
        }
        
        public int cantidadSucursales()
        {
                return listaSucursales.size();
        }
        
        public boolean esVacio()
        {
                return listaSucursales.isEmpty();
        }
}
