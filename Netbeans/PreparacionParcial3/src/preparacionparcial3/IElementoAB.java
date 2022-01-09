package preparacionparcial3;




import java.util.LinkedList;

public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public IElementoAB getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public IElementoAB getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(IElementoAB elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(IElementoAB elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB buscar(Comparable unaEtiqueta);

 

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(IElementoAB elemento);
    
    
  
    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();
    public String preOrden();
    public String postOrden();

     /**
     * pone las etiquetas del recorrido en inorden en una linkedlist.
     *
     * @param unaLista
     */
    public void inOrden(LinkedList<Comparable> unaLista);
    public void preOrden(LinkedList<Comparable> unaLista);
    public void postOrden(LinkedList<Comparable> unaLista);
    

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos();
   
    /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta
     * @return 
     */
    public IElementoAB<T> eliminar(Comparable unaEtiqueta);

    public boolean esCompleto();

    public int obtenerCantidadHojas();

    public int obtenerNivel(Comparable unaEtiqueta);

    public int obtenerAltura();

    public int obtenerTamaño();
	
    public Integer esArbolAvlSinAltura() ;
    
    
    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel);
    public int nivelClave(Comparable unaClave);
   
    public void listaPreOrden(Lista<T> unaLista);

    public void listaInorden(Lista<T> unaLista);

    public void listaPostOrden(Lista<T> unaLista);

    public int longTrayInt(int nivel);
       
   public int[] sumaDeAlturas();
}
