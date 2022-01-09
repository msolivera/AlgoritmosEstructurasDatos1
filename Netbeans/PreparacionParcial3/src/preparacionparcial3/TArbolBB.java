package preparacionparcial3;




import java.util.LinkedList;

public class TArbolBB<T> implements IArbolBB<T> {

    protected IElementoAB<T> raiz;

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
    public boolean insertar(IElementoAB<T> unElemento) {
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
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
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
    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

     @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }
    
    
     @Override
    public LinkedList<Comparable> preorden() {
        LinkedList<Comparable> listaPreorden = new LinkedList<>();
        if (!esVacio()) {
            raiz.preOrden(listaPreorden);
        }
        return listaPreorden;
    }
    
    
    
   @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }
    
    @Override
    public LinkedList<Comparable> postorden() {
        LinkedList<Comparable> listaPosorden = new LinkedList<>();
        if (!esVacio()) {
            raiz.postOrden(listaPosorden);
        }
        return listaPosorden;
    }
    
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public IElementoAB getRaiz()
    {
    
        return this.raiz;
    }   
    
        public void setRaiz(IElementoAB<T> raizNueva){
        raiz = raizNueva;
    }
        
    public boolean esCompleto(){
        if (esVacio()){
            return false;
        }
        else{
            return raiz.esCompleto();
        }
    }
    public int obtenerCantidadHojas(){
        if (esVacio()) {
            return 0;
        }
        else{
            return raiz.obtenerCantidadHojas();
        }
    }
    public int obtenerNivel (Comparable unaEtiqueta){
        if (esVacio()){
            return 0;
        }
        else{
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }
    public int obtenerAltura(){
        
        if(raiz != null){
           return raiz.obtenerAltura();
        }
        return 0;
    }
    public int obtenerTamaño() {
        if(raiz != null){
           return raiz.obtenerTamaño();
        }
        return 0;
    }

/**
* Determina si este árbol BB es AVL
* @return verdadero si es árbol AVL
*/
    public boolean esArbolAvl() {
        if (this.raiz == null) {
            return true;
        }

        //return this.raiz.esArbolAvl();
        Integer esAvl = this.raiz.esArbolAvlSinAltura();

        // Retorno verdadero si fue distinto de nulo
        // y falso si es nulo
        return (esAvl != null);
    }
    
    
        public int nivelClave(Comparable unaClave) {
    if (raiz == null)
        return -1;

    return raiz.nivelClave(unaClave);
}
        
            public long calcularCosto(int[] FrecExito, int[] FrecNoExito) {
           if(raiz==null){
            return 0;
        }else{
            int[] contadorExito = new int[1];
            contadorExito[0] = 0;
            int[] contadorNoExito = new int[1];
            contadorNoExito[0] = 0;
            return raiz.calcularCosto(FrecExito, FrecNoExito, contadorExito, contadorNoExito, 1);
        }
    
    }
       @Override         
     public Lista<T>  listaInOrden() {
        Lista<T> listaInorden = new Lista<>();
        if (!esVacio()) {
            
            raiz.listaInorden(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public  Lista<T>  listaPreOrden() {
         Lista<T> listaPreOrden = new Lista<>();
        if (!esVacio()) {
            
            raiz.listaPreOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    @Override
    public  Lista<T> listaPostOrden() {
        Lista<T> listaPostOrden = new Lista<>();
        if (!esVacio()) {
        
            raiz.listaPostOrden(listaPostOrden);
        }
        return listaPostOrden;

    }     

    public float longTrayIntMedia() {
        if (raiz == null) {
            return 0;
        }
        int cantElementos = obtenerTamaño();
        return raiz.longTrayInt(1) / cantElementos;
    }

    public int[] sumaDeALturas() {
        if (raiz != null) {
            return raiz.sumaDeAlturas();
        }
        return null;
    }
    
}
