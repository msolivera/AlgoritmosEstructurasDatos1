package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface ILista y permite crear una lista enlazada
 * simple de objetos INodo<E>
 * @author Profesor Ocampo
 * @author DANIEL
 * @param <E> Tipo genérico.
 */
public class Lista<E> implements ILista<E> {

    private INodo<E> primero;

    /**
     * Constructor por defecto de la clase Lista<E>.
     */
    public Lista() {
        primero = null;
    }

    /**
     * Sobrecarga del constructor de la clase Lista<E>.
     * @param unNodo INodo que será insertado en el primer lugar de la lista.
     */
    public Lista(INodo<E> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public void insertar(INodo<E> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            INodo<E> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    @Override
    public INodo<E> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo<E> aux = primero;
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
        INodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo<E> temp1 = aux;
            INodo<E> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }
    
    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;
    }
    
    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
    
    @Override
    public INodo<E> getPrimero() {
        return primero;
    }
    
    @Override
    public boolean insertarOrdenado(INodo<E> unNodo){        
        INodo<E> auxiliar = primero;        
        /*Si la lista se encuentra vacia, entonces inserta el Nodo al principio.
        */
        if (esVacia() == true){
            primero = unNodo;
            unNodo.setSiguiente(null);
            return true;
        }else{
            INodo<E> siguiente = primero.getSiguiente();
            while (auxiliar!= null){
                if (unNodo.compareTo(auxiliar.getEtiqueta())<=0){
                    unNodo.setSiguiente(primero);
                    primero = unNodo;
                    return true;
                }else if(unNodo.compareTo(auxiliar.getEtiqueta())> 0 && 
                                                auxiliar.getSiguiente()== null){
                    /*Si el elemento es mayor al ultimo elemento de la lista, se
                     *insertara al final.
                    */
                    auxiliar.setSiguiente(unNodo);
                    unNodo.setSiguiente(null);
                    return true;                   
                }else{
                    /*Si el elemento se encuentra en el medio de la lista.
                    */
                    if (unNodo.compareTo(auxiliar.getEtiqueta())> 0 && 
                                  unNodo.compareTo(siguiente.getEtiqueta())<=0){
                        auxiliar.setSiguiente(unNodo);
                        unNodo.setSiguiente(siguiente);
                        return true;
                    }                    
                }           
                auxiliar = auxiliar.getSiguiente();
                siguiente = siguiente.getSiguiente();
            }           
        }
        return false;
    }
    
    @Override
    public boolean insertarOrdenadoInverso(INodo<E> unNodo){        
        INodo<E> auxiliar = primero;        
        /*Si la lista se encuentra vacia, entonces inserta el Nodo al principio.
        */
        if (esVacia() == true){
            primero = unNodo;
            unNodo.setSiguiente(null);
            return true;
        }else{
            INodo<E> siguiente = primero.getSiguiente();
            while (auxiliar!= null){
                if (unNodo.compareTo(auxiliar.getEtiqueta())>=0){
                    unNodo.setSiguiente(primero);
                    primero = unNodo;
                    return true;
                }else if(unNodo.compareTo(auxiliar.getEtiqueta())< 0 && 
                                                auxiliar.getSiguiente()== null){
                    /*Si el elemento es mayor al ultimo elemento de la lista, 
                     *se insertara al final.
                    */
                    auxiliar.setSiguiente(unNodo);
                    unNodo.setSiguiente(null);
                    return true;                   
                }else{
                    /*Si el elemento se encuentra en el medio de la lista.
                    */
                    if (unNodo.compareTo(auxiliar.getEtiqueta())< 0 && 
                                  unNodo.compareTo(siguiente.getEtiqueta())>=0){
                        auxiliar.setSiguiente(unNodo);
                        unNodo.setSiguiente(siguiente);
                        return true;
                    }                    
                }           
                auxiliar = auxiliar.getSiguiente();
                siguiente = siguiente.getSiguiente();
            }           
        }
        return false;
    }
    
    
    @Override
    public void ordenar() {
        //Creo una lista nueva
        Lista<E> lista = new Lista<>();
        
        /*Recorro la lista actual e inserto sus elementos de forma ordenada en
        * la nueva lista.       
        */              
        while (esVacia() != true) {
            INodo<E> nuevoElemento = primero;
            eliminar(primero.getEtiqueta());            
            lista.insertarOrdenado(nuevoElemento);      
        }      
        /*
        * Cargo los elementos de la nueva lista en la lista original.
        */
         while (lista.esVacia() != true) {
            INodo<E> nuevoElemento1 = lista.getPrimero();
            lista.eliminar(lista.getPrimero().getEtiqueta());            
            this.insertarOrdenado(nuevoElemento1);     
        }       
    }
    
    @Override
    public void ordenarInverso() {
        //Creo una lista nueva
        Lista<E> lista = new Lista<>();
        
        /*Recorro la lista actual e inserto sus elementos de forma ordenada en
        * la nueva lista.       
        */              
        while (esVacia() != true) {
            INodo<E> nuevoElemento = primero;
            eliminar(primero.getEtiqueta());            
            lista.insertarOrdenadoInverso(nuevoElemento);      
        }      
        /*
        * Cargo los elementos de la nueva lista en la lista original.
        */
         while (lista.esVacia() != true) {
            INodo<E> nuevoElemento1 = lista.getPrimero();
            lista.eliminar(lista.getPrimero().getEtiqueta());            
            this.insertarOrdenadoInverso(nuevoElemento1);     
        }       
    }
    
    @Override
    public INodo<E> quitarPrimero() {
        INodo tempNodo = getPrimero();
        if (tempNodo != null){
            this.primero = tempNodo.getSiguiente();
            tempNodo.setSiguiente(null);
        }
        return tempNodo;
    }
}
