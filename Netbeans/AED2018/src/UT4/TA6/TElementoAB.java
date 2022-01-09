package UT4.TA6;
import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
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

    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public IElementoAB getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean insertar(IElementoAB unElemento) {
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
    public IElementoAB buscar(Comparable unaEtiqueta) {

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

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }
    
        @Override
        public String preOrden() 
        {
                String preO = "";
                preO += etiqueta;
                if(this.hijoIzq != null)
                {
                        preO += this.hijoIzq.preOrden();
                }
                if(this.hijoDer != null)
                {
                        preO += this.hijoDer.preOrden();
                }
                return preO;
        }

        @Override
        public String postOrden() 
        {
                String postO = "";
                if(this.hijoIzq != null)
                {
                        postO += this.hijoIzq.postOrden();
                }
                if(this.hijoDer != null)
                {
                        postO += this.hijoDer.postOrden();
                }
                postO += this.etiqueta;
                return postO;
        }

    @Override
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
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }

  
    @Override
    public IElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta)< 0){
            if (this.hijoIzq != null){
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
            
        }
        if (unaEtiqueta.compareTo(this.etiqueta)> 0){
            if (this.hijoDer != null){
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
            
        }
        return quitaElNodo();
    }
    public IElementoAB quitaElNodo(){
        if (this.hijoIzq == null){
            return this.hijoDer;
        }
        if (this.hijoDer == null){
            return this.hijoIzq;
        }
        IElementoAB elHijo = this.hijoIzq;
        IElementoAB elPadre = this;
        
        while (elHijo.getHijoDer() != null){
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        
        if (elPadre != this){
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(this.hijoIzq);
        }
        elHijo.setHijoDer(this.hijoDer);
        return elHijo;
    }

}
