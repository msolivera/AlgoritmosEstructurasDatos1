package UT4TA4;

/**
 *
 * @author Bruno
 */
public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz = null;

    public TArbolBB() {
    }

    /**
     * Constructor asignado r a la raiz.
     *
     * @param r TElementoAB (raiz)
     */
    public TArbolBB(TElementoAB<T> r) {
        raiz = r;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * Si "c" = true, inserta unElemento en el arbol contando la cantidad de
     * invocaciones que se realizan.
     *
     * @param unElemento TElementoAB, elemento a insertar
     * @param c boolean, contar o no contar
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento, boolean c) {
        int cuenta = 1;
        if (raiz == null) {
            raiz = unElemento;
            System.out.println("Invocaciones a 'insertar': " + cuenta + " (etiqueta: " + unElemento.getEtiqueta() + ")");
            return true;
        } else {
            return raiz.insertar(unElemento, cuenta);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     *
     * Si "c" = true, busca unaEtiqueta en el arbol contando la cantidad de
     * invocaciones que se realizan.
     *
     * @param unaEtiqueta Comparable, etiqueta a buscar
     * @param c boolean, contar o no contar
     * @return
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta, boolean c) {
        int cuenta = 1;
        if (raiz == null) {
            System.out.println("Invocaciones a 'buscar': " + cuenta + " (etiqueta: " + unaEtiqueta + ")");
            return null;
        } else {
            return raiz.buscar(unaEtiqueta, cuenta);
        }
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "Arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "Arbol vacio";
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "Arbol vacio";
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerAltura() {
        if (raiz != null) {
            return raiz.obtenerAltura();
        } else {
            return -1;
        }
    }

    @Override
    public int obtenerTamanio() {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.obtenerTamanio();
        }
    }

    @Override
    public int cantidadHojas() {
        if(this.raiz == null)
            return 0;
        else
            return raiz.cantidadHojas();
    }

    @Override
    public int nivel(Comparable unaEtiqueta) {
        if (raiz == null) {
            return -1;
        } else {
            return raiz.nivel(unaEtiqueta);
        }
    }

}
