package UT5PD1;


public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (getRaiz() == null);
    }

    /**
     * @return the raiz
     */
    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
                if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
                if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public Lista<T> inorden() {
          Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }
    
        
    public int obtenerAltura(){
        if(raiz!=null){
            return this.getRaiz().obtenerAltura();
        }else{
            return -1;
        }
    }
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }
    
        public int obtenerTamanio() {
       if (esVacio())
           return 0;
       return this.getRaiz().obtenerTamanio();
    }
        
            public String postOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.postOrden();
        }
    }

                public String preOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }
}
