/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4PD5;

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

    //PARTE 1
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
        tempStr = tempStr + imprimir() + "~";
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }
        return tempStr;
    }

    @Override
    public String preOrden() {
        String tempStr = "";
        tempStr = tempStr + imprimir() + "~";
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
        tempStr = tempStr + imprimir() + "~";
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

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String imprimir() {
        return (etiqueta.toString());
    }

    //PARTE 2
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

    //PARTE 3
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

    //PARTE 4
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
    
    public Comparable getMenor() {

        Comparable menor = this.etiqueta;
        if (hijoIzq != null) {
            return hijoIzq.getMenor();
        }
        return menor;

    }
    
    public Comparable getMayor() {

        Comparable mayor = this.etiqueta;
        if (hijoDer != null) {
            return hijoDer.getMayor();
        }
        return mayor;
    }
    
    public boolean esCompleto(){
        if ((hijoIzq!=null && hijoDer== null) || (hijoIzq == null && hijoDer != null)){
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
    
        public boolean esDeBusqueda(){
        if (hijoIzq != null) {
            if (getEtiqueta().compareTo(hijoIzq.getEtiqueta()) > 0) {
                return hijoIzq.esDeBusqueda();
            } else {
                return false;
            }
        }
        if(hijoDer != null){
            if(getEtiqueta().compareTo(hijoDer.getEtiqueta())<0){
                return hijoDer.esDeBusqueda();
            }
            else{
                return false;
            }
        }
       return true;
    }
    
        /*public boolean esArbolBusqueda(){
        boolean resultado = true;
        if (hijoIzq != null) {
            if (getEtiqueta().compareTo(hijoIzq.getEtiqueta()) > 0) {
                resultado = hijoIzq.esArbolBusqueda();
            } else {
                return false;
            }
        }
        if(hijoDer != null){
            if(getEtiqueta().compareTo(hijoDer.getEtiqueta())<0){
                resultado = hijoDer.esArbolBusqueda();
            }
            else{
                return false;
            }
        }
        return resultado;
    }*/
        
    public String listadoNodos(int nivel){
        String resultado = this.getEtiqueta().toString() +","+ nivel+" ";
        if(hijoIzq != null){
            resultado += hijoIzq.listadoNodos(nivel+1);
        }
        if(hijoDer != null){
            resultado += hijoDer.listadoNodos(nivel+1);
        }
        return resultado;
    }
 
    public String listadoHojas(int nivel) {
        String resultado = "hh";
        if (hijoIzq == null && hijoDer == null) {
            resultado = this.getEtiqueta().toString() + "," + nivel + " ";
        }else if (hijoIzq != null && hijoDer == null) {
            hijoIzq.listadoNodos(nivel + 1);
        }else if (hijoDer != null && hijoIzq == null) {
            hijoDer.listadoNodos(nivel + 1);
        }else{
            hijoIzq.listadoNodos(nivel + 1);
            hijoDer.listadoNodos(nivel + 1);
        }
        return resultado;
    }

    
    public LinkedList<String> listadoNodosInor(LinkedList<String> unaLista, int nivel) {
        if (hijoIzq != null) {
            hijoIzq.listadoNodosInor(unaLista, nivel + 1);
        }
        unaLista.add(this.etiqueta.toString() + "," + nivel);

        if (hijoDer != null) {
            hijoDer.listadoNodosInor(unaLista, nivel + 1);
        }
        return unaLista;
    }


}
