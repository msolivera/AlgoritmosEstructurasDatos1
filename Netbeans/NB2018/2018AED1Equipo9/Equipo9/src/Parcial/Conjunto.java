package Parcial;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends Lista<T> implements iConjunto {


    public Conjunto complemento(Conjunto universal) 
    {
            Conjunto conjunto = new Conjunto();
            Nodo nodo = this.getPrimero();
            Nodo uni = universal.getPrimero();
            if (!esVacia()){
                    while (uni != null)
                    {
                            if (this.buscar(uni.getEtiqueta())== null){
                                    if(conjunto.buscar(uni.getEtiqueta()) == null)
                                    {
                                        conjunto.insertar(uni);
                                    }
                                    
                            }
                            else
                            {
                                    uni = uni.getSiguiente();
                            }
                            uni = uni.getSiguiente();
                    }
            }
            return conjunto;
    }

  @Override
    public void insertar (Nodo<T> unNodo) {
            if (esVacia()) {
            setPrimero(unNodo);
        } else {
            Nodo<T> aux = getPrimero();
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

// RECORDAR QUE EN LOS CONJUNTOS NO PUEDE HABER ELEMENTOS DUPLICADOS


    
    
   
}
