package parcial2015;

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
    public void insertar(Nodo<T> unNodo) {
        if (esVacia()) //Si la lista está vacia se inserta al principio
        {
            setPrimero(unNodo);
        } else //Si no está vacia exite al menos un nodo entonces
        {
            if (getPrimero().getEtiqueta().compareTo(unNodo.getEtiqueta()) > 0) 
                // Si el nodo existente es mayor que el que se desea insertar, 
                //el unico existente pasa a ser siguiente del que se inserta
            {

                //INodo aux = primero;
                //primero = unNodo;
                //primero.setSiguiente(unNodo);
                unNodo.setSiguiente(primero);
                primero = unNodo;
            } else //Existen dos o mas nodos*/
            {
                Nodo<T> aux = primero;
                while (aux.getSiguiente() != null && aux.getSiguiente().getEtiqueta().compareTo(unNodo.getEtiqueta()) < 0) {
                    aux = aux.getSiguiente();
                }
                //if (aux.getEtiqueta().compareTo(unNodo.getEtiqueta()) != 0) //Si el nodo que se desea insertar no existe aún:
                //{
                    if (aux.getSiguiente() == null) //El nodo a insertar se inserta al final
                    {
                        aux.setSiguiente(unNodo);
                    } else //El nodo a insertar está entre dos nodos
                    {
                        Nodo<T> temporal = aux.getSiguiente();
                        aux.setSiguiente(unNodo);
                        unNodo.setSiguiente(temporal);
                    }

                //}
            }
        }
    }
    
    public void insertarOrdenado(Nodo<T> unNodo){
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
    
    public void invertir()
    {
        Lista retorno = new Lista();
        
        while (primero != null)
        {
           retorno.insertar(this.quitarPrimero());
           
        }
        primero = retorno.getPrimero();
    }
    public ListaOrdenada mezclarCon_VarianteDos(ListaOrdenada otraLista) 
     {
        Lista aux = new Lista();
        aux.setPrimero(super.getPrimero());
        ListaOrdenada resultado = new ListaOrdenada();
        aux.invertir();
        otraLista.invertir();
        
        while (! aux.esVacia() || !otraLista.esVacia())
        {
            if (aux.esVacia())
            {
                resultado.insertar(otraLista.getPrimero());
                otraLista.setPrimero(null);
            } else if (otraLista.esVacia())
                {
                    resultado.insertar(aux.getPrimero());
                    aux.setPrimero(null);
                } else 
                    {   
                        if (aux.getPrimero().getEtiqueta().compareTo(otraLista.getPrimero().getEtiqueta()) > 0)
                        {
                            resultado.insertar(aux.quitarPrimero());
                        } else if (aux.getPrimero().getEtiqueta().compareTo(otraLista.getPrimero().getEtiqueta()) < 0)
                               {
                                   resultado.insertar(otraLista.quitarPrimero());
                               } else 
                                    {
                                        aux.quitarPrimero();
                                        resultado.insertar(otraLista.quitarPrimero());
                                    }
                    }
        }
        
        
        
        
        
        return resultado; //O(n)
     }
    
    
    public ListaOrdenada mezclarCon(ListaOrdenada otraLista) {
        Lista aux = new Lista();
        aux.setPrimero(super.getPrimero());
        ListaOrdenada resultado = new ListaOrdenada();
        
        while (! aux.esVacia() || !otraLista.esVacia())
        {
            if (aux.esVacia())
            {
                resultado.insertar(otraLista.getPrimero());
                otraLista.setPrimero(null);
            } else if (otraLista.esVacia())
                {
                    resultado.insertar(aux.getPrimero());
                    aux.setPrimero(null);
                } else 
                    {   
                        if (aux.getPrimero().getEtiqueta().compareTo(otraLista.getPrimero().getEtiqueta()) < 0)
                        {
                            resultado.insertar(aux.quitarPrimero());
                        } else if (aux.getPrimero().getEtiqueta().compareTo(otraLista.getPrimero().getEtiqueta()) > 0)
                               {
                                   resultado.insertar(otraLista.quitarPrimero());
                               } else 
                                    {
                                        aux.quitarPrimero();
                                        resultado.insertar(otraLista.quitarPrimero());
                                    }
                    }
        }
        
        return resultado; 
    }
    
    
    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp1 = aux;
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;

    }
/////////////////////////////////////FUNCIONA
    public void eliminarDuplicado()  {
        Nodo<T> aux = this.primero;
        ListaOrdenada lista = new ListaOrdenada();
        while (aux!=null)
        {
            if ( lista.buscar(aux.getEtiqueta())==null)
            {
                Nodo<T> nuevo = new Nodo(aux.getEtiqueta(), aux.getDato());
                lista.insertar(nuevo);
            }
            aux = aux.getSiguiente();
            
        }
        this.primero = lista.primero;
    }

    
    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = getPrimero();
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            Nodo aux = getPrimero();
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return getPrimero() == null;
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = getPrimero();
            while (temp != null) {
                temp.imprimirEtiqueta();
                aux += temp.getEtiqueta() + " ";
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux;
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = getPrimero();
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }
    
    @Override
    public Nodo<T> quitarPrimero() {
        if (esVacia()) {
            System.out.println("Lista vacia");
            return null;
        } else {
            Nodo<T> aux = primero;
            
                primero = aux.getSiguiente();
                aux = null;
            
            
        }
        return null;
        
    }
    ///////////
    public ListaOrdenada mezclarOrdenado(ListaOrdenada otraLista) {
        Nodo<T> aux = otraLista.primero;
        Nodo<T> aux2 = this.primero;
        ListaOrdenada resultados = new ListaOrdenada();
        
            while (aux != null) {
                Nodo temp = aux;
                temp.setSiguiente(null);
                resultados.insertarOrdenado(temp);
                aux = aux.getSiguiente();
                
            }
            
             while (aux2 != null) {
                 
                Nodo temp2 = aux2;
                temp2.setSiguiente(null);
                resultados.insertarOrdenado(temp2);
                aux2 = aux2.getSiguiente();
                
            }
        
        this.setPrimero(resultados.primero);     
        return resultados;
    }
}