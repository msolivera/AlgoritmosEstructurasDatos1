/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA9;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                // TODO code application logic here
                Lista unaLista = new Lista();
                INodo nodo1 = new Nodo(1,1);
                INodo nodo2 = new Nodo(2,2);
                INodo nodo3 = new Nodo(3,7);
                INodo nodo4 = new Nodo(4,25);
                INodo nodo5 = new Nodo(5,0);
                INodo nodo6 = new Nodo(6,14);
                unaLista.insertarOrdenado(nodo1);
                unaLista.insertarOrdenado(nodo2);
                unaLista.insertarOrdenado(nodo3);
                unaLista.insertarOrdenado(nodo4);
                unaLista.insertarOrdenado(nodo5);
                unaLista.insertarOrdenado(nodo6);
                unaLista.imprimir();                
                unaLista.quitar(nodo3);
                System.out.println("............... Quitando nodo 3 .........");
                unaLista.imprimir();
                
                System.out.println("Obteniendo el nodo mayor: ");
                System.out.println(unaLista.obtenerMayor().getEtiqueta());
                
                System.out.println("Ordenando por Selección: ");
                Lista segunda = unaLista.ordenarPorSeleccion();
        }
        
}
