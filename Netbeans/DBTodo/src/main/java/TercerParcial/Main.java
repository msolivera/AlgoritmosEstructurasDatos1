/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TercerParcial;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TArbolAVL arbol = new TArbolAVL();
        
        TElementoAVL a1 = new TElementoAVL(1,null);
        TElementoAVL a2 = new TElementoAVL(2,null);
        TElementoAVL a3 = new TElementoAVL(3,null);
        TElementoAVL a4 = new TElementoAVL(5,null);
        TElementoAVL a5 = new TElementoAVL(6,null);
        TElementoAVL a6 = new TElementoAVL(7,null);
        TElementoAVL a7 = new TElementoAVL(8,null);
        TElementoAVL a8 = new TElementoAVL(9,null);
        
        arbol.insertar(a1);
        arbol.insertar(a2);
        arbol.insertar(a3);
        arbol.insertar(a4);
        arbol.insertar(a5);
        arbol.insertar(a6);
        arbol.insertar(a7);
        arbol.insertar(a8);
        System.out.println(arbol.getRaiz().getEtiqueta()+" raiz");
        System.out.println(arbol.getRaiz().getHijoDer().getEtiqueta()+" der");
        System.out.println(arbol.getRaiz().getHijoIzq().getEtiqueta()+" izq");
        System.out.println();
        System.out.println(a2.getHijoIzq().getEtiqueta()+" izq");
        System.out.println(a2.getHijoDer().getEtiqueta()+" der");
        System.out.println();
        System.out.println(a6.getHijoIzq().getEtiqueta()+" izq");
        System.out.println(a6.getHijoDer().getEtiqueta()+" der");
        System.out.println();
        System.out.println(a7.getHijoDer().getEtiqueta()+" der");
        
        
    }
    
}
