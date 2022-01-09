package ta9;

/**
 * Implementación TDA Nodo
 * @author meki
 * @param <T>
 */
public class Nodo<T> implements INodo<T> {
    
    /** Etiqueta para comparar con otros nodos */
    private Comparable etiqueta;
    
    /** Dato del nodo */
    private T dato;
    
    /** Siguiente nodo */
    private Nodo<T> siguiente;

    /**
     * Constructor que recibe todos los datos el nodo
     * @param etiqueta
     * @param dato
     * @param siguiente 
     */
    public Nodo(Comparable etiqueta, T dato, Nodo<T> siguiente) {
        this.etiqueta = etiqueta;
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    /**
     * Constructor que recibe todos los datos salvo siguiente
     * @param etiqueta
     * @param dato
     */
    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Constructor que sólo recibe la etiqueta del nodo
     * @param etiqueta 
     */
    public Nodo(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.dato = null;
        this.siguiente = null;
    }

    /**
     * Constructor por defecto
     */
    public Nodo() {
        this.etiqueta = null;
        this.dato = null;
        this.siguiente = null;
    }
    
    /**
     * Retorna el dato del nodo
     * @return dato
     */
    @Override
    public T getDato() {
        return this.dato;
    }

    /**
     * Define el dato del nodo
     * @param dato 
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Define nodo siguiente
     * @param nodo
     */
    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    /**
     * Retorna nodo siguiente
     * @return nodo siguiente
     */
    @Override
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    /**
     * Imprime una representación del nodo
     */
    @Override
    public void imprimir() {
        // Imprime siguiendo este formato: [etiqueta], [dato string], (opcional: etiqueta del nodo siguiente)
        System.out.print(this.getEtiqueta() + ", " + this.getDato().toString() + (this.getSiguiente() != null ? ", " + this.getSiguiente().getEtiqueta() : ""));
    }

    /**
     * Imprime la etiqueta del nodo
     */
    @Override
    public void imprimirEtiqueta() {
        System.out.print(this.getEtiqueta());
    }

    /**
     * Determina si dos nodos son iguales
     * @param unNodo
     * @return booleano
     */
    public boolean equals(Nodo<T> unNodo) {
        //return (this.compareTo(unNodo.getEtiqueta()) == 0);
        return this.dato.equals(unNodo.getDato());
    }

    /**
     * Retorna la etiqueta comparable del nodo
     * @return etiqueta comparable
     */
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * Compara etiqueta de dos nodos
     * @param etiqueta
     * @return entero producto de la comparación
     */
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.getEtiqueta().compareTo(etiqueta);
    }
    
    /**
     * Retorna clon de este nodo
     * @return nodo
     */
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }
    
}