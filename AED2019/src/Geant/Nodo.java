package geant;

public class Nodo implements INodo{
    
    private final Comparable etiqueta;
    
    private IProducto dato;
    
    private INodo siguiente;
    
    public Nodo(Object Dato, Comparable Etiqueta, INodo Siguiente) {
        this.dato = (IProducto) Dato;
        this.etiqueta  = Etiqueta;
        this.siguiente = Siguiente;
    }

    @Override
    public Object getDato() {
        return this.dato;
    }

    @Override
    public void setDato(Object Dato) {
        this.dato = (IProducto) Dato;
    }

    @Override
    public void setSiguiente(INodo Nodo) {
        this.siguiente = Nodo;
    }

    @Override
    public INodo getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void imprimir() {
        System.out.println(this.dato.getNombre());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    @Override
    public boolean equals(INodo unNodo) {
        return this.etiqueta.equals(unNodo.getEtiqueta());
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public int compareTo(Comparable Etiqueta) {
        return this.etiqueta.compareTo(Etiqueta);   
    }
}
