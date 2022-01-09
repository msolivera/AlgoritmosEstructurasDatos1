/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT5PD1;

/**
 *
 * @author Meki
 * @param <T>
 */
public class TArbolAVL<T> extends TArbolBB<T> implements IArbolBB<T> {
 
    @Override
    public TElementoAVL<T> getRaiz() {
       // return this.getRaiz();
           return (TElementoAVL<T>) super.getRaiz();
    }
    public boolean insertar(TElementoAVL<T> nodo) {
        if (getRaiz() == null) {
            setRaiz(nodo);
            return true;
        }

        TElementoAVL<T> raiz = getRaiz();
        boolean res = raiz.insertar(nodo);
        
        if (raiz.getBalance() < -1 || raiz.getBalance() > 1) {
            setRaiz(raiz.balancear());
        }
        raiz = getRaiz();
        raiz.calcBalance();

        return res;
    }

    public void eliminar(Comparable etiqueta) {
        TElementoAVL raiz = getRaiz();
        if (raiz != null) {
            int tamañoOriginal = obtenerTamanio();
            setRaiz(raiz.eliminar(etiqueta));
            raiz = getRaiz();
            boolean res = tamañoOriginal > obtenerTamanio();
            if (res) {
                raiz.calcBalance();
                if (raiz.getBalance() < -1 || raiz.getBalance() > 1) {
                    setRaiz(raiz.balancear());
                }
                getRaiz().calcBalance();
            }
        }
    }

}
