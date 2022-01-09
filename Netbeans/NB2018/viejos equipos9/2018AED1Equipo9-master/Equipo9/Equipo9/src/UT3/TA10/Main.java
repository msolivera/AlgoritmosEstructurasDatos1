/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA10;

import java.io.IOException;
/**
 *
 * @author Equipo9
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) throws IOException {
                // TODO code application logic here
                ManejadorArchivo manejador = new ManejadorArchivo();
                Lista lista = manejador.leerArchivo("src/UT3/TA10/suc1.txt");
                Tienda unaTienda = new Tienda();
                INodo primero = lista.getPrimero();
                while(primero != null)
                {
                        Sucursal unaSucursal = new Sucursal((Comparable) primero.getDato());
                        unaTienda.agregarSucursal(unaSucursal);
                        primero = primero.getSiguiente();
                }
                
                
                System.out.println("Cantidad de sucursales: ");
                System.out.println(unaTienda.cantidadSucursales());
                System.out.println(".................Listar sucursales .................");
                
                unaTienda.listarSucursales();
        }
        
}
