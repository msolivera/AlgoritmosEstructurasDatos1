package UT4TA3;

/**
 *
 * @author Bruno
 */
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta = null;
    private T datos = null;
    private TElementoAB<T> hijoIzq, hijoDer = null;

    public TElementoAB() {
    }

    /**
     * Constructor asignando "e" a "etiqueta"
     *
     * @param e Comparable (etiqueta)
     */
    public TElementoAB(Comparable e) {
        etiqueta = e;
    }
    

    /**
     * Constructor asignando "e" a "etiqueta" y "d" a "datos"
     *
     * @param e Comparable (etiqueta)
     * @param d T (datos)
     */
    public TElementoAB(Comparable e, T d) {
        etiqueta = e;
        datos = d;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (etiqueta.compareTo(unaEtiqueta) == 0) {
            return this;
        }

        if (etiqueta.compareTo(unaEtiqueta) > 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else {
            if (hijoDer != null) {
                return hijoDer.buscar(unaEtiqueta);
            } else {
                return null;
            }
        }
    }

    /**
     * Busca unaEtiqueta en el arbol contando la cantidad de invocaciones que se
     * realizan.
     *
     * @param unaEtiqueta Comparable, etiqueta a buscar
     * @param cuenta int, cantidad de invocaciones
     * @return
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta, int cuenta) {
        cuenta++;
        if (etiqueta.compareTo(unaEtiqueta) == 0) {
            System.out.println("Invocaciones a 'buscar': " + cuenta + " (etiqueta: " + unaEtiqueta + ")");
            return this;
        }

        if (etiqueta.compareTo(unaEtiqueta) > 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta, cuenta);
            } else {
                System.out.println("Invocaciones a 'buscar': " + cuenta + " (etiqueta: " + unaEtiqueta + ")");
                return null;
            }
        } else {
            if (hijoDer != null) {
                return hijoDer.buscar(unaEtiqueta, cuenta);
            } else {
                System.out.println("Invocaciones a 'buscar': " + cuenta + " (etiqueta: " + unaEtiqueta + ")");
                return null;
            }
        }
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (etiqueta.compareTo(elemento.getEtiqueta()) == 0) {
            return false;
        } else if (etiqueta.compareTo(elemento.getEtiqueta()) > 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return hijoDer.insertar(elemento);
            }
        }
    }

    /**
     * Inserta un elemento TElementoAB, contando la cantidad de invocaciones al
     * metodo.
     *
     * @param elemento TElementoAB, Elemento a insertar
     * @param cuenta int, cantidad de invocaciones realizadas
     * @return
     */
    public boolean insertar(TElementoAB<T> elemento, int cuenta) {
        cuenta++;
        if (etiqueta.compareTo(elemento.getEtiqueta()) == 0) {
            return false;
        } else if (etiqueta.compareTo(elemento.getEtiqueta()) > 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                System.out.println("Invocaciones a 'insertar': " + cuenta + " (etiqueta: " + elemento.getEtiqueta() + ")");
                return true;
            } else {
                return hijoIzq.insertar(elemento, cuenta);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
                System.out.println("Invocaciones a 'insertar': " + cuenta + " (etiqueta: " + elemento.getEtiqueta() + ")");
                return true;
            } else {
                return hijoDer.insertar(elemento, cuenta);
            }
        }
    }

    @Override
    public String preOrden() {
        String tempStr = "";
        tempStr += etiqueta;
        if (hijoIzq != null) {
            tempStr += hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr += hijoDer.preOrden();
        }
        return tempStr;
    }

    @Override
    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr += etiqueta;
        if (hijoDer != null) {
            tempStr += hijoDer.inOrden();
        }
        return tempStr;
    }

    @Override
    public String postOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            tempStr += hijoDer.postOrden();
        }
        tempStr += etiqueta;
        return tempStr;
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int obtenerTamanio() {
        int resultado=1 ;
        if (this.hijoDer != null) {
            resultado += this.hijoDer.obtenerTamanio();
        } 
        if (this.hijoIzq != null) {
            resultado += this.hijoIzq.obtenerTamanio();
        } 
        return resultado;
    }
    
    @Override
     public int obtenerAltura(){
        int altIzq = 0;
        int altDer = 0;
        if (hijoIzq == null && hijoDer == null)
            return 0;
        if (hijoIzq != null)
            altIzq = hijoIzq.obtenerAltura();
        
        if (hijoDer != null)
            altIzq = hijoDer.obtenerAltura();
        
        return 1 + Math.max( altIzq, altDer);
    }

}
