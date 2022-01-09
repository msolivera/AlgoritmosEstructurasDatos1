/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd7;

/**
 *
 * @author Meki
 */
public class Conjunto<T> extends Lista<T> {

    //agregado por mi
    public Lista<T> union(Lista otroConjunto) {
        Lista<T> resultado = new Lista();
        Nodo<T> primero = this.getPrimero();
        Nodo<T> otroPrimero = otroConjunto.getPrimero();

        if ((primero == null) && (otroConjunto.getPrimero() == null)) {
            System.out.println("Conjuntos vacios");
        }
        if (primero != null) {
            while (primero.getSiguiente() != null) {

                resultado.insertar(primero.clonar());
                primero = primero.getSiguiente();

            }

            resultado.insertar(primero);
        }
        if (otroConjunto.getPrimero() != null) {

            while (otroPrimero.getSiguiente() != null) {

                if ((buscar(otroPrimero.getEtiqueta()) == null)) {
                    resultado.insertar(otroPrimero.clonar());

                }
                otroPrimero = otroPrimero.getSiguiente();
                

            }
            Nodo<T> aux = otroPrimero;
            if ((buscar(aux.getEtiqueta()) == null)) {
                    resultado.insertar(aux.clonar());

                }
            
        }
        return resultado;

    }

    //Agregado por mi
    public Lista<T> Interseccion(Lista otroConjunto) {

        Lista<T> resultado = new Lista();
        Nodo<T> primero = this.getPrimero();
        Nodo<T> otroPrimero = otroConjunto.getPrimero();

        if ((esVacia()) || (otroConjunto.esVacia())) {

            System.out.println("No se puede hacer interseccion de conjunto vacio");
            //return null;
        } else {
            if (primero != null) {
                while (primero.getSiguiente() != null) {
                    if ((otroConjunto.buscar(primero.getEtiqueta()) != null)) {
                        resultado.insertar(primero.clonar());

                    }

                    primero = primero.getSiguiente();

                }
                Nodo<T> aux = primero;
                if ((otroConjunto.buscar(aux.getEtiqueta()) != null)) {
                        resultado.insertar(aux.clonar());

                    } 
            }

            return resultado;
        }
        return resultado;
    }

}
