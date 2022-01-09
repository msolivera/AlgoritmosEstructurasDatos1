package arbolyt;

import arbolyt.NodoArbolBinario;

/**
 * Arbol binario de busqueda o BST
 *
 * @author DDR
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

    //Nodo principal
    private NodoArbolBinario<T> root;

    /**
     * Indica si el arbol esta vacio
     *
     * @return true si esta vacio
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Devuelve el nodo root
     *
     * @return nodo root
     */
    public NodoArbolBinario<T> getRoot() {
        return root;
    }

    /**
     * Indica si el nodo pasado es el root
     *
     * @param nodo
     * @return true si el nodo es el root
     */
    public boolean isRoot(NodoArbolBinario<T> nodo) {
        return root == nodo;
    }

    /**
     * Indica si es una hoja el nodo pasado como parametro
     *
     * @param nodo
     * @return true si es una hoja
     */
    public boolean isLeaf(NodoArbolBinario<T> nodo) {
        return nodo.getHijoIzq() == null && nodo.getHijoDer() == null;
    }

    /**
     * Indica si el nodo pasado como parametro tiene nodos hijos
     *
     * @param nodo
     * @return
     */
    public boolean isInternal(NodoArbolBinario<T> nodo) {
        return !isLeaf(nodo);
    }

    /**
     * Añade un nodo de forma recursiva
     *
     * @param origen
     * @param elemento
     * @return nodo añadido
     */
    public NodoArbolBinario<T> add(NodoArbolBinario<T> origen, T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el root es nulo, lo añade el primero
        if (root == null) {
            nodo = new NodoArbolBinario<>(elemento);
            root = nodo;
        } else if (origen == null) { //el parametro pasado es invalido
            System.out.println("El origen es nulo");
        } else {

            //Comparamos los elementos
            //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
            if (origen.getElemento().compareTo(elemento) > 0) {

                //Si tiene nodo izquierdo, hago la llamada recursiva
                if (origen.getHijoIzq() != null) {
                    nodo = add(origen.getHijoIzq(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setPadre(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setHijoIzq(nodo);
                }

            } else { //sino pasa a la derecha

                //Si tiene nodo derecho, hago la llamada recursiva
                if (origen.getHijoDer()!= null) {
                    nodo = add(origen.getHijoDer(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setPadre(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setHijoDer(nodo);
                }

            }

        }

        return nodo;

    }

    /**
     * Añade un nodo de forma iterativa
     *
     * @param elemento
     * @return nodo añadido
     */
    public NodoArbolBinario<T> add(T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el root es nulo, lo añade el primero
        if (root == null) {
            nodo = new NodoArbolBinario<>(elemento);
            root = nodo;
        } else {

            //Creo un nodo auxuliar
            NodoArbolBinario<T> aux = root;
            boolean insertado = false;
            //No salgo hasta que este insertado
            while (!insertado) {

                //Comparamos los elementos
                //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
                if (aux.getElemento().compareTo(elemento) > 0) {

                    //Si tiene nodo izquierdo, actualizo el aux
                    if (aux.getHijoIzq()!= null) {
                        aux = aux.getHijoIzq();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setPadre(aux);
                        aux.setHijoIzq(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                } else {

                    if (aux.getHijoDer() != null) {
                        aux = aux.getHijoDer();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setPadre(aux);
                        aux.setHijoDer(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                }

            }

        }

        return nodo;

    }

}
