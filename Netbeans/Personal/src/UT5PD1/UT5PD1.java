/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT5PD1;

/**
 *
 * @author Meki
 */
public class UT5PD1 {
        public static void main(String[] args) {
            
            TArbolBB<Integer> arbolComun = new TArbolBB<>();
            TArbolAVL<Integer> arbolPro = new TArbolAVL<>();

            TElementoAB<Integer> nodo1 = new TElementoAB(10,1);
            TElementoAB<Integer> nodo2 = new TElementoAB(5,5);
            TElementoAB<Integer> nodo3 = new TElementoAB(13,13);
            TElementoAB<Integer> nodo4 = new TElementoAB(1,1);
            TElementoAB<Integer> nodo5 = new TElementoAB(6,6);
            TElementoAB<Integer> nodo6 = new TElementoAB(17,17);
            TElementoAB<Integer> nodo7 = new TElementoAB(16,16);
            System.out.println("Insertando en arbol bb");
            arbolComun.insertar(nodo1);
            arbolComun.insertar(nodo2);
            arbolComun.insertar(nodo3);
            arbolComun.insertar(nodo4);
            arbolComun.insertar(nodo5);
            arbolComun.insertar(nodo6);
            arbolComun.insertar(nodo7);
            System.out.println("post del arbol bb");
            System.out.println(arbolComun.preOrden());
            
            System.out.println("insertando en avl");
            
            TElementoAVL<Integer> nodoA = new TElementoAVL(10,1);
            TElementoAVL<Integer> nodoB = new TElementoAVL(5,5);
            TElementoAVL<Integer> nodoC = new TElementoAVL(13,13);
            TElementoAVL<Integer> nodoD = new TElementoAVL(1,1);
            TElementoAVL<Integer> nodoE = new TElementoAVL(6,6);
            TElementoAVL<Integer> nodoF = new TElementoAVL(17,17);
            TElementoAVL<Integer> nodoG = new TElementoAVL(16,16);
             arbolPro.insertar(nodoA);
            arbolPro.insertar(nodoB);
            arbolPro.insertar(nodoC);
            arbolPro.insertar(nodoD);
            arbolPro.insertar(nodoE);
            arbolPro.insertar(nodoF);
            arbolPro.insertar(nodoG);
            System.out.println("post del avl");
            System.out.println(arbolPro.preOrden());
            
            
        }
}
