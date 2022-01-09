package ta9;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaQueOrdena<T> extends Lista<T> implements IOrdenar{

    /**
     * Constructor que recibe el nodo primero
     * @param primero
     */
    public ListaQueOrdena(Nodo<T> primero) {
        super(primero);
    }
    
    /**
     * Constructor por defecto
     */
    public ListaQueOrdena() {
        super();
    }
    
    @Override
    public Lista<T> insercionDirecta() {
       ListaQueOrdena<T> nuevaLista = new ListaQueOrdena<>();
       
       if (this.esVacia())
           return nuevaLista;
       
       while (!this.esVacia())
           nuevaLista.insertarOrdenado(this.quitarPrimero());
       
       return nuevaLista;
    }

    @Override
    public Lista<T> seleccionDirecta() {
        ListaQueOrdena<T> nuevaLista = new ListaQueOrdena<>();
        
        if (this.esVacia())
            return nuevaLista;
        
        while (!this.esVacia())
            nuevaLista.insertar(this.quitarMenor());
        
        return nuevaLista;
    }

    public Nodo<T> quitarPrimero() {
        Nodo<T> nodoPrimero = this.getPrimero();
        
        if (this.esVacia())
            return null;
        
        this.setPrimero(this.getPrimero().getSiguiente());
        nodoPrimero.setSiguiente(null);
        
        // Retorno nodo
        return nodoPrimero;
    }
    
    public Nodo<T> quitarMenor() {
        Nodo<T> anterior, actual, menor, auxMenor;

        if (this.esVacia())
            return null;
            
        actual = this.getPrimero();
        menor = this.getPrimero();
        anterior = null;
        auxMenor = null;
        
        while (actual != null) {
            if (actual.compareTo(menor.getEtiqueta()) < 0) {
                menor = actual;
                auxMenor = anterior;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        
        if (auxMenor == null) {
            this.setPrimero(menor.getSiguiente());
        }
        else {
            auxMenor.setSiguiente(menor.getSiguiente());
        }
        menor.setSiguiente(null);
        
        // Retorno nodo menor
        return menor;
    }
    
    /**
     * Inserta de forma ordenada un nodo
     * @param nodo
     */
    public void insertarOrdenado(Nodo<T> nodo) {
        Nodo<T> actual;
        Nodo<T> siguiente;

        // Si la lista está vacía, lo defino como primero
        if (this.esVacia()) {
           this.primero = nodo;
        }
        else {
            // Valido que no exista ya el nodo
            if (this.buscar(nodo.getEtiqueta()) == null) {
                actual = this.getPrimero();
                siguiente = actual.getSiguiente();
                
                // Caso primer elemento ya es mayor
                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
                    // Lo agrego primero a la lista
                    nodo.setSiguiente(actual);
                    this.primero = nodo;
                }
                // Caso de un sólo elemento y es menor
                else if (siguiente == null) {
                    // Lo agrego como siguiente y último
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                }
                // Caso sólo dos elementos y estamos entre medio
                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                }
                else {
                    // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                    while(actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        // Llegué al final de la lista, lo inserto al final
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                        }
                        // Si actual es menor y el siguiente es mayor, encontré un hueco
                        else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                            // Se inserta nodo en el hueco encontrado y dejo de recorrer la lista
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(siguiente);
                            break;
                        }
                    }
                }
            }
        }
    }
}
