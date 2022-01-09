package elevenBasicArbolBB;

import elevenBasicLista.Lista;
import elevenBasicLista.Nodo;

public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    /**
     * @return recorrida en preOrden del subArbol que cuelga del elemento actual
     */
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @return recorrida en postOrden del subArbol que cuelga del elemento
     * actual
     */
    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    public T getDatos() {
        return datos;
    }

    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }

        if (hijoDer == null) {
            return hijoIzq;
        }

        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        return elHijo;
    }
    
   
    /**
     * devuelve el tamaño del elemento (cantidad de elementos totales)
     *
     * @return
     */
    public int obtenerTamanio() {
        int subIzquierdo = 0;
        int subDerecho = 0;
        if (hijoIzq != null) {
            subIzquierdo += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null) {
            subDerecho += hijoDer.obtenerTamanio();
        }
        return subIzquierdo + subDerecho + 1;
    }
 
    
 
    @Override
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.insertarPrimero(new Nodo<T>(this.etiqueta,this.getDatos()));
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }
    @Override
      public void preOrden(Lista<T> unaLista) {
        unaLista.insertarPrimero(new Nodo<T>(this.etiqueta,this.getDatos()));
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }

    }

    
    @Override
    public void postOrden(Lista<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.insertarPrimero(new Nodo<T>(this.etiqueta,this.getDatos()));
    }

    @Override
    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
         int suma = 0;
        if(hijoIzq!=null){
            suma = hijoIzq.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel + 1);
        }else{
            suma += (nivel+1)*FrecNoExito[indiceFNE[0]];
            indiceFNE[0]++;
        }
        indiceFE[0]++;
        suma += FrecExito[indiceFE[0]]*nivel;
        if(hijoDer!=null){
            suma += hijoDer.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel + 1);
        }else{
            suma += (nivel+1)*FrecNoExito[indiceFNE[0]];
            indiceFNE[0]++;
        }
        return suma;
    
    }    public boolean esHoja() {
        return hijoIzq == null && hijoDer == null;
    }

    
    @Override
public int nivelClave(Comparable unaClave) {
    int nivel = 0;

    if (unaClave.compareTo(etiqueta) < 0) {
        if (hijoIzq != null)
            nivel = 1 + hijoIzq.nivelClave(unaClave);
        else
            // Caso base #1: No encontré nodo, voy a restar a la vuelta
            return -2;
    } else if (unaClave.compareTo(etiqueta) > 0) {
        if (hijoDer != null)
            nivel = 1 + hijoDer.nivelClave(unaClave);
        else
            // Caso base #1: No encontré nodo, voy a restar a la vuelta
            return -2;
    } else {
        // Caso base #2: Encontré nodo, voy a sumar a la vuelta
        return 1;
    }

    // Determino qué hacer a la vuelta
    if (nivel <= 0)
        // Empiezo a restar -2, así mato los +1 y resto 1 más
        return (nivel - 2);
    else
        // Retorno el nivel positivo acumulado
        return nivel;

}
    
}
