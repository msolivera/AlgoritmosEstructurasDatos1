package primerparcial;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaOrdenada<T> extends Lista<T> {

    private Nodo<T> primero;

    public ListaOrdenada() {
        primero = null;
    }

    public ListaOrdenada(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public void insertar(Nodo<T> unNodo){
        Nodo<T> aux1;
        Nodo<T> aux2;
        if (esVacia()){
            setPrimero(unNodo);
        }else{
            aux1 = primero;
            while(aux1!=null){
                aux2 = aux1.getSiguiente();
                //el nodo va al comienzo
                if(unNodo.getEtiqueta().compareTo(aux1.getEtiqueta()) <= 0){
                    unNodo.setSiguiente(primero);
                    primero = unNodo;
                    break;
                }else{
                    //el nodo va al final
                    if(unNodo.getEtiqueta().compareTo(aux1.getEtiqueta()) > 0 && aux2==null){
                        aux1.setSiguiente(unNodo);
                        unNodo.setSiguiente(null);
                        break;
                    }else{
                        //el nodo va al medio
                        if(aux1.getEtiqueta().compareTo(unNodo.getEtiqueta())<0 && aux2.getEtiqueta().compareTo(unNodo.getEtiqueta()) >=0){
                            aux1.setSiguiente(unNodo);
                            unNodo.setSiguiente(aux2);
                            break;
                        }else{
                            aux1 = aux1.getSiguiente();
                        }
                    }
                }
            }
        }
    }


    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    @Override
    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    

    

   
    
}