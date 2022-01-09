/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD11;

/**
 *
 * @author Meki
 */
public class main {
        public static void main(String args[]) throws Exception {
            Ordenador ordena = new Ordenador();
           
            Integer[] lista = new Integer[15];
            lista[0] = 4;
            lista[1] = 2;
            lista[2] = 4;
            lista[3] = 17;
            lista[4] = 12;
            lista[5] = 3;
            lista[6] = 10;
            lista[7] = 5;
            lista[8] = 6;
            lista[9] = 6;
            lista[10] = 1;
            lista[11] = 9;
            lista[12] = 11;
            lista[13] = 18;
            lista[14] = 21;
            
            ordena.ordenaParesImpares(lista);
            String nodo = ordena.ordenaParesImpares(lista).imprimir();
            //ordena.ordenaPares(lista);
            //String nodos = ordena.ordenaPares(lista).imprimir();
        }
}
