/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD11;

/**
 *
 * @author Meki
 */
public class Ordenador {
    
    public Ordenador (){
        
    }
    
    /**
     *
     * @param listaDesordenada
     * @return
     */
    public Lista<Integer> ordenaParesImpares(Integer[] listaDesordenada) {
        Lista<Integer> resultados = new Lista<>();
        Lista<Integer> resultadosImperesOrdenados = new Lista<>();
        Lista<Integer> resultadosParesOrdenados = new Lista<>();

        for (int i = 0; i < listaDesordenada.length; i++) {
            if (listaDesordenada[i] % 2 == 0) {
                Nodo<Integer> aInsertar = new Nodo(listaDesordenada[i], null);
                // Si la lista está vacía, lo defino como primero
                if (resultadosParesOrdenados.esVacia()) {
                    resultadosParesOrdenados.setPrimero(aInsertar);
                } else {
                    Nodo<Integer> actual = resultadosParesOrdenados.getPrimero();
                    Nodo<Integer> siguiente = actual.getSiguiente();
                    // Caso primer elemento ya es mayor
                    if (actual.compareTo(aInsertar.getEtiqueta()) > 0) {
                        // Lo agrego primero a la lista
                        aInsertar.setSiguiente(actual);
                        resultadosParesOrdenados.setPrimero(aInsertar);
                    } // Caso de un sólo elemento y es menor
                    else if (siguiente == null) {
                        // Lo agrego como siguiente y último
                        actual.setSiguiente(aInsertar);
                        aInsertar.setSiguiente(null);
                    } // Caso sólo dos elementos y estamos entre medio
                    else if (actual.compareTo(aInsertar.getEtiqueta()) < 0 && siguiente.compareTo(aInsertar.getEtiqueta()) > 0) {
                        actual.setSiguiente(aInsertar);
                        aInsertar.setSiguiente(siguiente);
                    } else {
                        // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                        while (actual.getSiguiente() != null) {
                            actual = actual.getSiguiente();
                            siguiente = actual.getSiguiente();
                            // Llegué al final de la lista, lo inserto al final
                            if (siguiente == null) {
                                actual.setSiguiente(aInsertar);
                                aInsertar.setSiguiente(null);
                            } // Si actual es menor y el siguiente es mayor, encontré un hueco
                            else if (actual.compareTo(aInsertar.getEtiqueta()) < 0 && siguiente.compareTo(aInsertar.getEtiqueta()) > 0) {
                                // Se inserta nodo en el hueco encontrado y dejo de recorrer la lista
                                actual.setSiguiente(aInsertar);
                                aInsertar.setSiguiente(siguiente);
                                // break;
                            }
                        }
                    }

                }
            } else {
                Nodo<Integer> aInsertar = new Nodo(listaDesordenada[i], null);

                if (resultadosImperesOrdenados.esVacia()) {
                    resultadosImperesOrdenados.setPrimero(aInsertar);

                } else {
                    Nodo<Integer> actual = resultadosImperesOrdenados.getPrimero();
                    Nodo<Integer> siguiente = actual.getSiguiente();
                    // Caso primer elemento ya es mayor
                    if (actual.compareTo(aInsertar.getEtiqueta()) > 0) {
                        // Lo agrego primero a la lista
                        aInsertar.setSiguiente(actual);
                        resultadosParesOrdenados.setPrimero(aInsertar);
                    } // Caso de un sólo elemento y es menor
                    else if (siguiente == null) {
                        // Lo agrego como siguiente y último
                        actual.setSiguiente(aInsertar);
                        aInsertar.setSiguiente(null);
                    } // Caso sólo dos elementos y estamos entre medio
                    else if (actual.compareTo(aInsertar.getEtiqueta()) < 0 && siguiente.compareTo(aInsertar.getEtiqueta()) > 0) {
                        actual.setSiguiente(aInsertar);
                        aInsertar.setSiguiente(siguiente);
                    } else {
                        // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                        while (actual.getSiguiente() != null) {
                            actual = actual.getSiguiente();
                            siguiente = actual.getSiguiente();
                            // Llegué al final de la lista, lo inserto al final
                            if (siguiente == null) {
                                actual.setSiguiente(aInsertar);
                                aInsertar.setSiguiente(null);
                            } // Si actual es menor y el siguiente es mayor, encontré un hueco
                            else if (actual.compareTo(aInsertar.getEtiqueta()) < 0 && siguiente.compareTo(aInsertar.getEtiqueta()) > 0) {
                                // Se inserta nodo en el hueco encontrado y dejo de recorrer la lista
                                actual.setSiguiente(aInsertar);
                                aInsertar.setSiguiente(siguiente);
                                // break;
                            }
                        }
                    }

                }
            }
        }
        Nodo<Integer> impares = resultadosImperesOrdenados.getPrimero();
        while (impares != null) {
            resultados.insertar(impares.clonar());
            impares = impares.getSiguiente();
        }
        Nodo<Integer> pares = resultadosParesOrdenados.getPrimero();
        while (pares != null) {
            resultados.insertar(pares.clonar());
            pares = pares.getSiguiente();
        }
        return resultados;
    }

    
    
    
        public Lista<Integer> ordenaPares(Integer[] listaDesordenada) {
        Lista<Integer> resultados = new Lista<>();
        Lista<Integer> resultadosImperesOrdenados = new Lista<>();
        Lista<Integer> resultadosParesOrdenados = new Lista<>();

        for (int i = 0; i < listaDesordenada.length; i++) {
            if (listaDesordenada[i] % 2 == 0) {
                Nodo<Integer> aInsertar = new Nodo(listaDesordenada[i], null);
                resultadosParesOrdenados.insertarOrdenado(aInsertar);
            }
            else if(listaDesordenada[i] % 2 != 0){
                 Nodo<Integer> aInsertar = new Nodo(listaDesordenada[i], null);
                resultadosImperesOrdenados.insertarOrdenado(aInsertar);
            }
        }
        Nodo<Integer> impares = resultadosImperesOrdenados.getPrimero();
        while (impares != null){
            resultados.insertar(impares.clonar());
            impares = impares.getSiguiente();
        }
        Nodo <Integer> pares = resultadosParesOrdenados.getPrimero();
        while (pares != null){
            resultados.insertar(pares.clonar());
            pares = pares.getSiguiente();
        }
        return resultados;
        }
}
