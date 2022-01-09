/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolescompletos;

import java.util.LinkedList;

/**
 *
 * @author Meki
 */
class TElementoAB<T> implements IElementoAB {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;

    public TElementoAB(Comparable unaEtiqueta, T dato) {
        etiqueta = unaEtiqueta;
        datos = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    @Override
    public boolean insertar(TElementoAB elemento) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(elemento);
            } else {
                hijoIzq = elemento;
                return true;
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(elemento);
            } else {
                hijoDer = elemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    @Override
    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr = tempStr + "~" + imprimir();
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }

        return tempStr;
    }

    @Override
    public String preOrden() {
        String tempStr = "";
        tempStr = tempStr + "~" + imprimir();
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
        }
        return tempStr;
    }

    @Override
    public String postOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.postOrden();
        }
        tempStr = tempStr + "~" + imprimir();
        return tempStr;
    }

    public void preOrden(LinkedList<Comparable> unaLista) {
        unaLista.add(this.getEtiqueta());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }

    }

    public void postOrden(LinkedList<Comparable> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());

    }

    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public Object getDatos() {
        return this.datos;
    }

    /**
     * imprime etiqueta del elemento
     *
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    /**
     * *
     * Metodo que inserta un nuevo elemento al arbol y devuelve un contador con
     * el numero de veces que se llamo al metodo recursivamente
     *
     * @param elemento
     * @return contador
     */
    public int insertarContador(TElementoAB elemento) {
        // verifico si la etiqueta del elemento a insertar es menor a la etiqueta del elemento

        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertarContador(elemento) + 1;

            } else {
                hijoIzq = elemento;
                return 1;
            }
            // verifico si la etiqueta del elemento a insertar es mayor a la etiqueta del elemento
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertarContador(elemento) + 1;

            } else {
                hijoDer = elemento;
                return 1;
            }
        } else {
            return 1;
        }
    }
    //insertar con contador usando array

    public int[] insertarContadorArray(TElementoAB elemento, int[] contador) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            contador[0]++;
            if (hijoIzq != null) {
                return getHijoIzq().insertarContadorArray(elemento, contador);

            } else {
                hijoIzq = elemento;
                return contador;
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            contador[0]++;
            if (hijoDer != null) {
                return getHijoDer().insertarContadorArray(elemento, contador);

            } else {
                hijoDer = elemento;
                return contador;
            }
        } else {
            contador[0] = contador[0] * -1;
            return contador;
        }
    }

    public int[] buscarContador(Comparable unaEtiqueta, int[] contador) {
        contador[0]++;
        int comparador = unaEtiqueta.compareTo(this.etiqueta);
        if (comparador == 0) {
            return contador;
        } else {
            if (comparador < 0) {
                if (this.hijoIzq != null) {

                    return this.hijoIzq.buscarContador(unaEtiqueta, contador);
                } else {
                    contador[0] = -contador[0];
                    return contador;
                }
            } else {
                if (this.hijoDer != null) {
                    return this.hijoDer.buscarContador(unaEtiqueta, contador);
                } else {
                    contador[0] = -contador[0];
                    return contador;
                }
            }
        }
    }

    /**
     * devuelve la altura del elemento
     *
     * @return
     */
    public int getAltura() {
        int alturaIzquierda = -1;
        int alturaDerecha = -1;
        if (this.hijoIzq != null) {
            alturaIzquierda = this.hijoIzq.getAltura();
        }
        if (this.hijoDer != null) {
            alturaDerecha = this.hijoDer.getAltura();
        }
        if (alturaIzquierda > alturaDerecha) {
            return alturaIzquierda + 1;
        } else {
            return alturaDerecha + 1;
        }
    }

    /**
     * devuelve true si el elemento es completo (tiene dos hijos)
     *
     * @return
     */
    public boolean esCompleto() {
        if ((hijoIzq != null && hijoDer == null) || (hijoIzq == null && hijoDer != null)) {
            return false;
        }
        if (hijoIzq != null) {
            return hijoIzq.esCompleto();

        }
        if (hijoDer != null) {
            return hijoDer.esCompleto();
        }
        return true;
    }

    /**
     * devuelve la cantidad de elementos externos (hojas)
     *
     * @return
     */
    public int getCantidadHojas() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        } else if (hijoIzq == null && hijoDer != null) {
            return hijoDer.getCantidadHojas();
        } else if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.getCantidadHojas();
        } else {
            return hijoIzq.getCantidadHojas() + hijoDer.getCantidadHojas();

        }
    }

    /**
     * devuelve el nivel de un elemento deseado(si exite)
     *
     * @param etiqueta
     * @return
     */
    public int obtenerNivel(Comparable unaEtiqueta) {
         int nivel;

        nivel = 0;
        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {
            return 0;
        } else {
            if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
                if (this.getHijoIzq() != null) {
                    nivel = 1 + this.getHijoIzq().obtenerNivel(unaEtiqueta);
                }
            } else {
                if (this.getHijoDer() != null) {
                    nivel = 1 + this.getHijoDer().obtenerNivel(unaEtiqueta);
                }
            }
        }

        // Caso que estoy parado en una hoja y aún no encontré
        if (nivel == 0) {
            nivel = -1;
        }

        return nivel;

    }


    /**
     * devuelve el tamaño del elemento (cantidad de elementos totales)
     *
     * @return
     */
    public int getTamaño() {
        int subIzquierdo = 0;
        int subDerecho = 0;
        if (hijoIzq != null) {
            subIzquierdo += hijoIzq.getTamaño();
        }
        if (hijoDer != null) {
            subDerecho += hijoDer.getTamaño();
        }
        return subIzquierdo + subDerecho + 1;
    }

    /**
     * devuelve true su el elemento es una hoja
     *
     * @return
     */
    public boolean esHoja() {
        return hijoIzq == null && hijoDer == null;
    }

    /**
     * devuelve cantidad de elementos internos del elemento
     *
     * @return
     */
    public int getInternos() {
        if (esHoja()) {
            return 0;
        } else {
            if (hijoIzq != null && hijoDer == null) {
                return 1 + hijoIzq.getInternos();

            } else if (hijoIzq == null && hijoDer != null) {
                return 1 + hijoDer.getInternos();

            } else {
                return hijoIzq.getInternos() + hijoDer.getInternos()+1;

            }
        }
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        //si esta en el subarbol izquierdo
        if (this.etiqueta.compareTo(unaEtiqueta)<0){
            if (hijoIzq != null){
                //actualiza el hijo, con el mismo u otro valor 
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            //al padre le devuelve el mismo hijo 
            return this;
        }
        // si esta, está en el subárbol derecho
        else if (this.etiqueta.compareTo(unaEtiqueta)>0){
            if (hijoDer != null){
                //actualiza el hijo, con el mismo u otro valor 
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            //al padre le devuelve el mismo hijo
            return this; 
        }
        return quitaElNodo();
        
    }

    public int getCantidadPorNivel(int nivelActual, int nivelDeseado) {
        int contador = 0;
        if (nivelActual == nivelDeseado) {
            contador++;
        }
        if (nivelActual < nivelDeseado) {
            if (hijoIzq != null) {
                contador += hijoIzq.getCantidadPorNivel(nivelActual + 1, nivelDeseado);
            }
            if (hijoDer != null) {
                contador += hijoDer.getCantidadPorNivel(nivelActual + 1, nivelDeseado);
            }
        }
        return contador;
    }
    
    
    public int sumarEtiquetas() {
        
        if (hijoIzq == null && hijoDer == null) {
            return Integer.valueOf(etiqueta.toString());
        } else if (hijoIzq == null && hijoDer != null) {
            return Integer.valueOf(etiqueta.toString()) + hijoDer.sumarEtiquetas();
        } else if (hijoIzq != null && hijoDer == null) {
            return Integer.valueOf(etiqueta.toString()) + hijoIzq.sumarEtiquetas();
        } else {
            return hijoIzq.sumarEtiquetas() + hijoDer.sumarEtiquetas() + Integer.valueOf(etiqueta.toString());

        }

    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        } else if (hijoDer == null) {
            return hijoIzq;
        }
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;
        // va al subárbol izquierdo 
        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
            // elHijo es el mas a la derecha del subárbol izquierdo 
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        // elHijo quedara en lugar de this 
        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null);  // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        return elHijo;
    }
    
}
