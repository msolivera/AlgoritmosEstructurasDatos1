/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_lecturas;

/**
 *
 * @author Meki
 */
public class UT3_lecturas {
    
    
      /*
        RECORRER UNA LISTA ENCADENADA
    */
    public static void imprimirLista (Nodo lista) {
        Nodo nodo = lista;
        while (nodo != null) {
            System.out.print (nodo);
            nodo = nodo.prox;
        }
        System.out.println ();
    }
    
    public static void imprimirListaBien (Nodo lista) {
        System.out.print("(");
        Nodo nodo = lista;
        while (nodo != null) {
            System.out.print (nodo);
            nodo = nodo.prox;
            if (nodo != null) {
                System.out.print(",");
            }
        }
        System.out.print(")");
        System.out.println();
    }
    
    public static void imprimirListaFor (Nodo lista) {
        System.out.print("(");
        for (Nodo nodo = lista; nodo != null; nodo = nodo.prox) {
            System.out.print (nodo);
            if (nodo.prox != null) {
                System.out.print(",");
            }
        }
        System.out.print(")");
        System.out.println();
    }
    
    public static void imprimirInverso (Nodo lista) {
        if (lista == null) return;
        Nodo cabeza = lista;
        Nodo cola = lista.prox;
        imprimirInverso (cola);
        System.out.print (cabeza);
    }

    
    public static void main(String[] args) {
        
        Nodo nodo1 = new Nodo (new Integer(1), null);
        Nodo nodo2 = new Nodo (new Integer(2), null);
        Nodo nodo3 = new Nodo (new Integer(3), null);
        
        // Creo lista enlazada
        nodo1.prox = nodo2;
        nodo2.prox = nodo3;
        nodo3.prox = null;
        
        // Pruebas de cola
        Cola cola = new Cola();
        cola.agregar(nodo1);
        cola.agregar(nodo2);
        
        imprimirInverso((Nodo)cola.quitar());
        
       
        
    }
}
