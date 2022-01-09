package ta9;
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos 
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

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
    public void inOrden(Lista<T> unaLista) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public int obtenerAltura() {
         int alturaIzquierda = -1;
        int alturaDerecha = -1;
        if (this.hijoIzq != null) {
            alturaIzquierda = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            alturaDerecha = this.hijoDer.obtenerAltura();
        }
        if (alturaIzquierda > alturaDerecha) {
            return alturaIzquierda + 1;
        } else {
            return alturaDerecha + 1;
        }
    }

    @Override
    public int obtenerTamanio() {
        int subIzquierdo = 0;
        int subDerecho = 0;
        if (hijoIzq != null) {
            subIzquierdo += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null) {
            subDerecho += hijoDer.obtenerTamanio();
        }
        return subIzquierdo + subDerecho + 1;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (this.buscar(unaEtiqueta) != null) {
            if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
                return 0;
            } else {
                if (etiqueta.compareTo(this.etiqueta) < 0) {
                    if (hijoIzq != null) {
                        return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                    } else{
                        return 0;
                    }
                } else {
                    if (hijoDer != null) {
                        return 1 + hijoDer.obtenerNivel(unaEtiqueta);
                    }else{
                        return 0;
                    }
                }
            }
        }else{
            return 0;
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        } else if (hijoIzq == null && hijoDer != null) {
            return hijoDer.obtenerCantidadHojas();
        } else if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerCantidadHojas();
        } else {
            return hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
        }
    }
    
    @Override
   public TElementoAB eliminar(Comparable unaEtiqueta){
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }
    
    private TElementoAB quitaElNodo(){
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;
        while(elHijo.hijoDer != null){
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
    }
 
    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr = tempStr + "," + imprimir();
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }

        return tempStr;
    
    }    
    public String preOrden() {
        String tempStr = "";
        tempStr = tempStr + "," + imprimir();
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
        }
        return tempStr;
    }

    
    public String postOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.postOrden();
        }
        tempStr = tempStr + "," + imprimir();
        return tempStr;
    }

    String preOrdenConSeparador(String separador) {
        String tempStr = "";
        tempStr = tempStr + separador + imprimir();
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
        }
        return tempStr;
    }

   	
}
