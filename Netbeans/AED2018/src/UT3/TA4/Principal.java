/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA4;

import java.io.IOException;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class Principal {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) throws IOException {
                // TODO code application logic here
                Tienda Geant = new Tienda();
                char[] codigo1 = {'1'};
                Producto helado = new Producto("Helado Crufi",codigo1,100,15);
                Geant.incorporarProducto(helado);
                char[] codigo2 = {'2'};
                Producto pan = new Producto("Pan Bimbo",codigo2,80,13);
                Geant.incorporarProducto(pan);
                Geant.agregarStock(pan,2);
                
                Geant.cargarArchivo("src/UT3/TA4/altasPrueba.txt");
                Geant.cargarArchivo("src/UT3/TA4/altas.txt");
                Geant.eliminarArchivo("src/UT3/TA4/elimPrueba.txt");
                Geant.eliminarArchivo("src/UT3/TA4/elim.txt");
                //Geant.venderArchivo("src/UT3/TA4/ventasPrueba.txt");
                Geant.venderArchivo("src/UT3/TA4/ventas.txt");
                
                Geant.imprimir();
                
                
                
                              
                
        }
        
}
