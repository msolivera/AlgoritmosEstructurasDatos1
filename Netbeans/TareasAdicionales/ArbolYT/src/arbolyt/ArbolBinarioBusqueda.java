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
public class ArbolBinarioBusqueda<T extends Comparable<T>> {

    private NodoArbolBinario<T> raiz;

    public boolean esVacio() {
        return raiz == null;
    }

    public NodoArbolBinario<T> getRaiz() {
        return raiz;
    }

    public boolean esRaiz(NodoArbolBinario<T> nodo) {
        return raiz == nodo;
    }

    public boolean esHoja(NodoArbolBinario<T> nodo) { //para que sea hoja los dos hijos tienen que ser nulos

        return nodo.getHijoDer() == null && nodo.getHijoIzq() == null;

    }

    public boolean esPadre(NodoArbolBinario<T> nodo) {

        return !esHoja(nodo);

    }

    //recursivo
    public void insertar(NodoArbolBinario<T> actual, T elemento) {

        if (raiz == null) {
            raiz = new NodoArbolBinario<>(elemento);
        } else if (actual == null) {
            System.out.println("actual es nulo");
        } else {
            if (actual.getElemento().compareTo(elemento) > 0) {

                if (actual.getHijoIzq() != null) {

                    insertar(actual.getHijoIzq(), elemento);
                } else {
                    NodoArbolBinario<T> nodo = new NodoArbolBinario<>(elemento);
                    nodo.setPadre(actual);
                    actual.setHijoIzq(nodo);

                }

            } else {

                if (actual.getElemento().compareTo(elemento) > 0) {

                    if (actual.getHijoDer() != null) {

                        insertar(actual.getHijoDer(), elemento);
                    } else {
                        NodoArbolBinario<T> nodo = new NodoArbolBinario<>(elemento);
                        nodo.setPadre(actual);
                        actual.setHijoDer(nodo);

                    }

                }

            }
        }

    }
}
