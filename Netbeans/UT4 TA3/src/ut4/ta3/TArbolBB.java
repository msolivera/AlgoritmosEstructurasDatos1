package ut4.ta3;

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
     * @param unElemento
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    public int insertarContando(TElementoAB<T> unElemento){
        if (esVacio()){
           raiz = unElemento;
           return 0;
        }else{
            return raiz.insertarContando(unElemento);
        }
    }
    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public Lista<T> inorden() {
        Lista <T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public int obtenerAltura() {
               if (raiz != null){
            return raiz.obtenerAltura();
        }
        else{
            return 0;
        }
    }

    @Override
    public int obtenerTamanio() {
                if (!esVacio()) {
            return raiz.obtenerTamanio();
        } else {
            return 0;
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (!esVacio()) {
            return raiz.obtenerNivel(unaEtiqueta);
        } else {
            return 0;
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        if (!esVacio()) {
            return raiz.obtenerCantidadHojas();
        } else {
            return 0;
        }
    }


}
