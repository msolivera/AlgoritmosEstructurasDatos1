/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolyt;

/**
 *
 * @author Meki
 */
public class NodoArbolBinario<T extends Comparable<T>> {
    
     private T elemento;
    private NodoArbolBinario<T> padre;
    private NodoArbolBinario<T> hijoIzq;
    private NodoArbolBinario<T> hijoDer;

    public NodoArbolBinario(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbolBinario(T elemento, NodoArbolBinario<T> padre) {
        this.elemento = elemento;
        this.padre = padre;
    }

    public NodoArbolBinario(T elemento, NodoArbolBinario<T> hijoIzq, NodoArbolBinario<T> hijoDer) {
        this.elemento = elemento;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    public NodoArbolBinario(T elemento, NodoArbolBinario<T> padre, NodoArbolBinario<T> hijoIzq, NodoArbolBinario<T> hijoDer) {
        this.elemento = elemento;
        this.padre = padre;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }
    

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbolBinario<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoArbolBinario<T> padre) {
        this.padre = padre;
    }

    public NodoArbolBinario<T> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoArbolBinario<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoArbolBinario<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoArbolBinario<T> hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    
}
