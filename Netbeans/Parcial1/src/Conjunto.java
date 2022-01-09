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
//public class Conjunto<T> extends Lista<T> implements IConjunto {
// MEJOR: 
public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {
   
    /**
     * Metodo que agrega los nodos de los dos conjuntos,
     * o de uno solo si el otro es vacio (sin duplicar)
     * en un nuevo conjunto y lo devuelve.
     * @param otroConjunto
     * @return conjunto de resultados.
     */
    @Override
    public Conjunto union(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo<T> primero = this.getPrimero();
        Nodo<T> otroPrimero = otroConjunto.getPrimero();

        //si alguno de los dos conjuntos son vacios se imprime el mensaje
        if ((primero == null) && (otroConjunto.getPrimero() == null)) {
            System.out.println("Conjuntos vacios");
        }
        //corroboro que el primer conjunto no este vacio
        if (primero != null) {
            while (primero.getSiguiente() != null) {
                //inserto cada nodo en la nueva lista
                resultado.insertar(primero.clonar());
                primero = primero.getSiguiente();

            }

            resultado.insertar(primero);
        }
        //corroboro si el conjunto esta vacio
        if (otroConjunto.getPrimero() != null) {

            while (otroPrimero.getSiguiente() != null) {
                //busco la etiqueta para evitar duplicados
                if ((buscar(otroPrimero.getEtiqueta()) == null)) {
                    //inserto
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
    /**
     * Metodo que inserta en un conjunto a quellos nodos cuya etiqueta
     * aparece en los dos conjuntos iniciales.
     * @param otroConjunto
     * @return conjuntos de resultados
     */
    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
       Conjunto resultado = new Conjunto();
        Nodo<T> primero = this.getPrimero();
        
        //si alguno de los conjuntos es vacio no se puede hacer interseccion
        if ((esVacia()) || (otroConjunto.esVacia())) {

            System.out.println("No se puede hacer interseccion de conjunto vacio");
        } else {
            if (primero != null) {
                //recorro la lista
                while (primero.getSiguiente() != null) {
                    //verifico que exista la etiqueta del nodo en la lista recibida por parametros
                    if ((otroConjunto.buscar(primero.getEtiqueta()) != null)) {
                        //si la etiqueta esta en ambos conjuntos inserto
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
