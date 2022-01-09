
package proyectoindividual.Codigo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;


public class TElementoAVL<T> extends TElementoAB<T> {
    
    private Comparable etiqueta;
    private TElementoAVL<T> hijoIzq;
    private TElementoAVL<T> hijoDer;
    private T datos;
    private Integer balance;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    public TElementoAVL(Comparable unaEtiqueta, T unosDatos) {
        super(unaEtiqueta,unosDatos);
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        balance = 0;
    }
    
    
    public TElementoAVL<T> insertar(TElementoAVL<T> unElemento) {
        if (unElemento.getEtiqueta() != null) {
            if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    hijoIzq = getHijoIzq().insertar(unElemento);
                } else {
                    hijoIzq = unElemento;
                }
            } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
                if (hijoDer != null) {
                    hijoDer = getHijoDer().insertar(unElemento);
                } else {
                    hijoDer = unElemento;
                }
            } else {
                return unElemento;
            }

            //Actualizamos el factor de balance del nodo.
            if (hijoIzq != null && hijoDer != null) {
                balance = hijoDer.obtenerAltura() - hijoIzq.obtenerAltura();
            } else {
                if (hijoIzq != null) {
                    balance = -hijoIzq.obtenerAltura();
                } else {
                    balance = hijoDer.obtenerAltura();
                }
            }

            if (hijoIzq != null) {
                if (balance < -1 /*&& esMenor(unElemento.getEtiqueta(), this.hijoIzq.getEtiqueta())*/) {
                    return rotacionDerecha(this);
                }
                if (balance < -1 /*&& esMayor(unElemento.getEtiqueta(), this.hijoIzq.getEtiqueta())*/) {
                    hijoDer = rotacionDerecha(this.hijoDer);
                    return rotacionIzquierda(this);
                }
            }

            if (hijoDer != null) {
                if (balance > 1 /*&& esMayor(unElemento.getEtiqueta(), this.hijoDer.getEtiqueta())*/) {
                    return rotacionIzquierda(this);
                }

                if (balance > 1 /*&& esMenor(unElemento.getEtiqueta(), this.hijoDer.getEtiqueta())*/) {
                    hijoIzq = rotacionIzquierda(this.hijoIzq);
                    return rotacionDerecha(this);
                }
            }
            return this;
        } else {
            return null;
        }
    }
    public int getBalance(){
        return this.balance;
    }
    public void setBalance(int nuevoBalance){
        this.balance = nuevoBalance;
    }
    public T getDatos() {
        return datos;
    }
    
    public TElementoAVL getHijoIzq(){
        return hijoIzq;
    }
 
    public TElementoAVL getHijoDer(){
        return hijoDer;
    }
    
    public void setHijoIzq(TElementoAVL elemento) {
        this.hijoIzq = elemento;

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
    
    public void setHijoDer(TElementoAVL elemento) {
        this.hijoDer = elemento;
    }
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    TElementoAVL<T> rotacionIzquierda(TElementoAVL<T> unNodo) {
        TElementoAVL<T> k1 = unNodo;
        TElementoAVL<T> k2 = k1.getHijoDer();

        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);

        return k2;
    }

    TElementoAVL<T> rotacionDerecha(TElementoAVL<T> unNodo) {
        TElementoAVL<T> k1 = unNodo;
        TElementoAVL<T> k2 = k1.getHijoIzq();

        k1.setHijoIzq(k2.getHijoDer());
        k2.setHijoDer(k1);

        return k2;
    }
    @Override
    public TElementoAVL<T> buscar(Comparable unaEtiqueta) {
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
    
    
    public int obtenerCantidadHojas() {
        int cantidadDeHojas = 0;
        if (hijoIzq != null && hijoDer != null) {
            cantidadDeHojas += hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
        } else {
            if (hijoIzq != null) {
                cantidadDeHojas += hijoIzq.obtenerCantidadHojas();
            } else {
                if (hijoDer != null) {
                    cantidadDeHojas += hijoDer.obtenerCantidadHojas();
                } else {
                    cantidadDeHojas += 1;
                }
            }
        }
        return cantidadDeHojas;
    }

   
    public int obtenerAltura() {
        int A = 0;
        int B = 0;
        if (hijoIzq != null) {
            A = hijoIzq.obtenerAltura();
        }
        if (hijoDer != null) {
            B = hijoDer.obtenerAltura();
        }
        return 1 + maximo(A, B);
    }

    
    public int obtenerTamanio() {
        int cantidad = 0;
        if (this.hijoIzq != null) {
            cantidad += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null) {
            cantidad += hijoDer.obtenerTamanio();
        }
        return cantidad + 1;
    }
    
    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivel = 0;
        if (this.buscar(unaEtiqueta) == null) {
            return -1;
        } else {
            if (this.etiqueta == unaEtiqueta) {
                return 0;
            } else {
                if (this.etiqueta.compareTo(unaEtiqueta) > 0) {      //etiqueta > unaEtiqueta
                    nivel += 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                } else {
                    nivel += 1 + hijoDer.obtenerNivel(unaEtiqueta);
                }
            }
            return nivel;
        }
    }
    public TElementoAVL<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private TElementoAVL<T> quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }

        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }

        //tiene los dos hijos, buscamos el lexicograficamente anterior
        TElementoAVL<T> elHijo = hijoIzq;
        TElementoAVL<T> elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null);  // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        return elHijo;
    }
	/*
    private boolean esMayor(Comparable unaEtiqueta, Comparable otraEtiqueta) {
        return (unaEtiqueta.compareTo(otraEtiqueta) > 0);
    }
    private boolean esMenor(Comparable unaEtiqueta, Comparable otraEtiqueta) {
        return (unaEtiqueta.compareTo(otraEtiqueta) < 0);
    }
*/
    private int maximo(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
    
}
