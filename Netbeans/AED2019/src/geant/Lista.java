package geant;



public class Lista<T> implements ILista<T> {

    protected Nodo<T> primero;

    public Lista() {
        primero = null;
    }


    @Override
    public void insertar(Nodo<T> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
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

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
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
            Nodo<T> temp = primero;
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

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
    
    public Nodo quitarMasChico() {
        Nodo masChico = this.primero;
        Nodo actual = this.primero;
        Nodo aux = this.primero;

        if (esVacia()) {
            return null;
        } else {
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getEtiqueta().compareTo(masChico.getEtiqueta()) < 0) {
                    masChico = actual.getSiguiente();
                    aux = actual;
                    actual = actual.getSiguiente();
                } else {
                    actual = actual.getSiguiente();
                }
            }
            aux.setSiguiente(masChico.getSiguiente());
            masChico.setSiguiente(null);
            return masChico;
        }

    }

    public void insertarPrimero(Nodo<T> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            unNodo.setSiguiente(primero);
            primero = unNodo;
        }
    }
public void insertarOrdenado(Nodo<T> nodo){
     Nodo<T> actual;
        Nodo<T> siguiente;

        // Si la lista est?? vac??a, lo defino como primero
        if (this.esVacia()) {
           primero = nodo;
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
                    primero = nodo;
                }
                // Caso de un s??lo elemento y es menor
                else if (siguiente == null) {
                    // Lo agrego como siguiente y ??ltimo
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                }
                // Caso s??lo dos elementos y estamos entre medio
                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                }
                else {
                    // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                    while(actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        // Llegu?? al final de la lista, lo inserto al final
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                            break;
                        }
                        // Si actual es menor y el siguiente es mayor, encontr?? un hueco
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

    
    


