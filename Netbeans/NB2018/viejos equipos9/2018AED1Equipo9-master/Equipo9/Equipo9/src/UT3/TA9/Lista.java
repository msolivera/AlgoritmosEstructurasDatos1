package UT3.TA9;

import UT3.TA4.*;

public class Lista<E> implements ILista<E> {

    private INodo<E> primero;

    public Lista() {
        primero = null;
    }

    public Lista(INodo<E> unNodo) {
        this.primero = unNodo;
    }

    public void insertar(INodo<E> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            INodo<E> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    public INodo<E> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo<E> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        INodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo<E> temp1 = aux;
            INodo<E> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public INodo<E> getPrimero() {
        return primero;
    }
    /**
     * Metodo para quitar un nodo de la lista
     * @param unNodo Nodo a quitar de la lista
     * @return Devuelve el nodo quitado de la lista
     */
    public INodo<E> quitar(INodo<E> unNodo) 
    {
        if (esVacia()) {
            return null;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(unNodo.getEtiqueta())) {
                primero = null;
                return unNodo;
            }
        }
        INodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(unNodo.getEtiqueta()) == 0) {
            //Eliminamos el primer elemento
            INodo<E> temp1 = aux;
            INodo<E> temp = aux.getSiguiente();
            primero = temp;
            return unNodo;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(unNodo.getEtiqueta())) {
                INodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return unNodo;

            }
            aux = aux.getSiguiente();
        }
        return unNodo;
    }
    /**
     * Inserta de forma ordenada según la etiqueta de los nodos
     * @param unNodo Nodo a insertar en la lista
     */
    public void insertarOrdenado(INodo<E> unNodo)
        {
            if(esVacia())       //Si la lista está vacia se inserta al principio
            {
                    primero = unNodo;
            }
            else        //Si no está vacia exite al menos un nodo entonces:
            {
                   if(primero.getEtiqueta().compareTo(unNodo.getEtiqueta()) > 0)        // Si el nodo existente es mayor que el que se desea insertar, el unico existente pasa a ser siguiente del que se inserta
                           {
                                   
                                INodo aux = primero;
                                primero = unNodo;
                                primero.setSiguiente(aux);
                           }
                   else //Existen dos o mas nodos
                   {
                        INodo<E> aux = primero;
                        while(aux.getSiguiente() != null && aux.getSiguiente().getEtiqueta().compareTo(unNodo.getEtiqueta()) <0)
                        {
                            aux = aux.getSiguiente();
                        }
                        if(aux.getEtiqueta().compareTo(unNodo.getEtiqueta()) != 0)      //Si el nodo que se desea insertar no existe aún:
                        {
                            if(aux.getSiguiente() == null)      //El nodo a insertar se inserta al final
                            {
                                aux.setSiguiente(unNodo);
                            }
                            else        //El nodo a insertar está entre dos nodos
                            {
                                INodo<E> temporal = aux.getSiguiente();
                                aux.setSiguiente(unNodo);
                                unNodo.setSiguiente(temporal);
                            }
                            
                        }
                    
                  }
                   
            }
            
    }
    
    //SubEquipo B:
    
    public Lista ordenarPorSeleccion()
    {
        Lista lista1 = this;
        Lista lista2 = new Lista();
        while(!(lista1.esVacia())){
            INodo aux2 = lista1.obtenerMayor();
            lista1.quitar(aux2);
            lista2.insertarPrincipio(aux2);
        }
        return lista2;
    }
    
    public INodo obtenerMayor()
    {
            if(esVacia())
            {
                    return null;
            }
            if(primero.getSiguiente() == null)
            {
                    return primero;
            }
            else
            {
                    INodo aux = primero;
                    INodo mayor = null;
                    while(aux.getSiguiente() != null)
                    {
                            if(aux.getSiguiente().getEtiqueta().compareTo(aux.getEtiqueta()) > 0)
                            {
                                    mayor = aux.getSiguiente();
                                    aux = aux.getSiguiente();
                            }
                            else
                            {
                                    if(aux.getSiguiente().getEtiqueta().compareTo(mayor.getEtiqueta()) > 0)
                                    {
                                            mayor = aux;
                                            aux = aux.getSiguiente();
                                    }
                            }
                    }
            return mayor;
            }
 
    }
    
    public void insertarPrincipio(INodo uno){
        if(esVacia()){
            primero = uno;
            
        }
        else{
                uno.setSiguiente(primero);
                primero = uno;
        }
    }
}
