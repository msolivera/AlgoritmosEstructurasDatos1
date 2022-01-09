package UT5PD1;


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
        hijoIzq = null;
        hijoDer = null;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
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
    public boolean insertar(TElementoAB<T> elemento) {
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
    public void inOrden(Lista<T> unaLista) {
        // Hijo izquierdo
        if (this.getHijoIzq() != null){
            this.getHijoIzq().inOrden(unaLista);
        }
        // Inserto este elemento
        Nodo unNodo = new Nodo(this.etiqueta, this.datos);
        unaLista.insertar(unNodo);
        // Hijo derecho
        if (this.getHijoDer() != null){
            this.getHijoDer().inOrden(unaLista);
        }
    }
        
    public int obtenerAltura()
    {
        int a = -1;
        int b = -1;
        if (this.hijoIzq != null) {
            a = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            b = this.hijoDer.obtenerAltura();
        }
        return Integer.max(a, b) + 1;

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
    
        public int obtenerTamanio() {
        int resultado = 0;
        if (hijoIzq != null){
            resultado += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null){
            resultado += hijoDer.obtenerTamanio();
        }
        return resultado +1;

    }
        
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
}
