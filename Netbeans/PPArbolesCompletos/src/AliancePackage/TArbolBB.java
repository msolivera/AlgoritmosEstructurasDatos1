package AliancePackage;



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
        if(esVacio()){
            return 0;
        }
        else{
            return raiz.obtenerAltura();
        }
    }

    @Override
    public int obtenerTamanio() {
        if(esVacio()){
            return 0;
        }
        else{
            return raiz.obtenerTamanio();
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if(esVacio()){
            return 0;
        }
        else{
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        if(esVacio()){
            return 0;
        }
        else{
            return raiz.obtenerCantidadHojas();
        }
    }
    
    public Comparable getMayorClave(){
        if(esVacio()){
            return -1;
        }
        else{
            return raiz.getMayorClave();
        }
    }
    
    public Comparable getMenorClave(){
        if(esVacio()){
            return -1;
        }
        else{
            return raiz.getMenorClave();
        }
    }
    
    public Comparable anteriorAClave(Comparable clave){
        if(esVacio()){
            return -1;
        }
        else{
            return raiz.anteriorAClave(clave);
        }
    }
    
    public int cantidadNodosPorNivel(int nivelBuscado){
        if(raiz == null){
            return 0;
        }
        else
            return raiz.cantidadNodosPorNivel(0,nivelBuscado);
    }
    
    public String listadoHojas(){
        if(raiz == null){
            return "Vacio";
        }
        else
            return raiz.listadoHojas(0);
    }
     public Boolean esArbolBusqueda(){
        if(raiz == null){
            return false;
        }
        else
            return raiz.esArbolBusqueda();
    }

    public String preOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }

}
