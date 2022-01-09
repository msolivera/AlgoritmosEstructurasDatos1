
package proyectoindividual.Codigo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;


public class TArbolAVL<T> extends TArbolBB<T>{
    
    private TElementoAVL<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    
    public TArbolAVL() {
        raiz = null;
    }
    
    public TElementoAVL<T> getRaiz(){
        return raiz;
    }    
         
    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar (IElementoAB<T> unElemento){
        TElementoAVL<T> nuevoElemento = new TElementoAVL<T>(unElemento.getEtiqueta(),unElemento.getDatos());
        if (insertar(nuevoElemento)!= null){
            return true;
        }
        return false;
    }
    public TElementoAVL<T> insertar(TElementoAVL<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return raiz;
        } else {
            this.raiz = this.raiz.insertar(unElemento);
            return raiz;
        }
    }
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }
    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAVL<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }
    /**
     * @return recorrida en InOrden del arbol
     */
    @Override
    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = new LinkedList<>();
        if (!esVacio()) {
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }
    /**
     * @return True si el arbol esta vacio
     */
    @Override
    public boolean esVacio() {
        return (raiz == null);
    }
    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    public int obtenerNivel(Comparable unaEtiqueta) {
        if (this.esVacio()) {
            return -1;
        } else {
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }
    @Override
    public int obtenerCantidadHojas() {
        if (this.esVacio()) {
            return 0;
        } else {
            return raiz.obtenerCantidadHojas();
        }
    }
    
    public int obtenerTamanio() {
        if (esVacio()) {
            return 1;
        } else {
            return raiz.obtenerTamanio();
        }
    }

    
    
    
}
