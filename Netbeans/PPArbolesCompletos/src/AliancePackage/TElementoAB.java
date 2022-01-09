package AliancePackage;


public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
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
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

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
        String resultado = "";
        if (hijoIzq != null) {
            resultado += hijoIzq.inOrden();
        }
        resultado += getEtiqueta().toString() + " ";
        if (hijoDer != null) {
            resultado += hijoDer.inOrden();
        }
        return resultado;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public int obtenerAltura() {
        int alturaIzq  = 0;
        int alturaDer = 0;
        if(hijoIzq != null){
            alturaIzq = hijoIzq.obtenerAltura();
        }
        if(hijoDer != null){
            alturaDer = hijoDer.obtenerAltura();
        }
        if(hijoIzq==null && hijoDer == null){
            return 0;
        }
        return Integer.max(alturaIzq+1, alturaDer+1);
    }

    @Override
    public int obtenerTamanio() {
        int contador = 1;
        if(hijoIzq != null){
            contador += hijoIzq.obtenerTamanio();
        }
        if(hijoDer != null){
            contador += hijoDer.obtenerTamanio();
        }
        return contador;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivel = 0;
        if (unaEtiqueta.equals(etiqueta)) {
            return 0;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                nivel += getHijoIzq().obtenerNivel(unaEtiqueta)+1;
            } 
        } else if (hijoDer != null) {
            nivel += getHijoDer().obtenerNivel(unaEtiqueta)+1;
        } 
        return nivel;
    }

    @Override
    public int obtenerCantidadHojas() {
        int contador = 0;
        if(hijoIzq != null){
            contador += hijoIzq.obtenerCantidadHojas();
        }
        if(hijoDer != null){
            contador += hijoDer.obtenerCantidadHojas();
        }
        if(hijoIzq == null && hijoDer == null){
            return 1;
        }
        return contador;
    }
    
    public Comparable getMayorClave(){
        Comparable mayorClave = this.getEtiqueta();
        if(hijoDer != null){
            mayorClave = hijoDer.getMayorClave();
        }
        return mayorClave;
    }
    public Comparable getMenorClave(){
        Comparable menorClave = this.getEtiqueta();
        if(hijoIzq != null){
            menorClave = hijoIzq.getMenorClave();
        }
        return menorClave;
    }
    /*
    recorro el arbol comenzando por la raiz.
    ->Si el elemento es igual a la raiz, entro recursivamente al hijo izquierdo
    ->Si la raiz es mas grande que el elemento que busco, y su hijo izquierdo es mas chico. 
            me quedo con el hijo izquierdo como anterior inmediato.
            Si su hijo izquierdo no es mas chico, entro recursivamente al hijo izquierdo.
    ->Si la raiz no es mas grande, me fijo si su hijo derecho es mas grande. si lo es, me quedo con la raiz.
            Sino entro recursivamente al hijo derecho.
    ->si la raiz ya no tiene hojas, devuelvo la raiz.
    */
    public Comparable anteriorAClave(Comparable clave){
        
        Comparable claveAnterior = this.getEtiqueta();
        
        if(this.getEtiqueta().equals(clave) ){ //si es igual el elemento que busco que la clave
            if(hijoIzq != null){//si tiene hijo izquierdo entro recursivo
                claveAnterior = hijoIzq.anteriorAClave(clave);
            }  
        }
        
        else if(this.getEtiqueta().compareTo(clave) > 0 ){//si la raiz es mas grande que la clave
            if(hijoIzq != null){
                if(hijoIzq.getEtiqueta().compareTo(clave) < 0){//Si el hijo Izq es mas chico que la clave
                    claveAnterior = hijoIzq.getEtiqueta();
                }
                else if(hijoIzq.getEtiqueta().compareTo(clave) == 0){
                    claveAnterior = this.getEtiqueta();
                }
                else{
                    claveAnterior = hijoIzq.anteriorAClave(clave);
                }
            } 
        }
        
        else if(this.getEtiqueta().compareTo(clave) < 0){ //Si la raiz es mas chica que la clave
            if(hijoDer != null){
                if(hijoDer.getEtiqueta().compareTo(clave) > 0){//si el hijoDer es mas grande que la clave
                    claveAnterior = hijoDer.getEtiqueta();
                }
                else if(hijoDer.getEtiqueta().compareTo(clave) == 0){
                    claveAnterior = this.getEtiqueta();
                }
                else{
                    claveAnterior = hijoDer.anteriorAClave(clave);
                }
            }
        }
        return claveAnterior;
    }
    
    public int cantidadNodosPorNivel(int nivelActual, int nivelBuscado){
       int contador = 0;
       if (nivelActual == nivelBuscado){
           contador++;
       }
       if (nivelActual < nivelBuscado) {
           if (hijoIzq != null) {
               contador += hijoIzq.cantidadNodosPorNivel(nivelActual + 1, nivelBuscado);
           }
           if (hijoDer != null) {
               contador += hijoDer.cantidadNodosPorNivel(nivelActual + 1, nivelBuscado);
           }
       }
       return contador;
   }
    
    public String listadoHojas(int nivel){
        String resultado = this.getEtiqueta().toString() +","+ nivel+" ";
        if(hijoIzq != null){
            resultado += hijoIzq.listadoHojas(nivel+1);
        }
        if(hijoDer != null){
            resultado += hijoDer.listadoHojas(nivel+1);
        }
        return resultado;
    }
    
    public boolean esArbolBusqueda(){
        boolean resultado = true;
        if (hijoIzq != null) {
            if (getEtiqueta().compareTo(hijoIzq.getEtiqueta()) > 0) {
                resultado = hijoIzq.esArbolBusqueda();
            } else {
                return false;
            }
        }
        if(hijoDer != null){
            if(getEtiqueta().compareTo(hijoDer.getEtiqueta())<0){
                resultado = hijoDer.esArbolBusqueda();
            }
            else{
                return false;
            }
        }
        return resultado;
    }
    
    public String preOrden() {
        String tempStr = "";
        tempStr = tempStr + "~" + imprimir();
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
        }
        return tempStr;
    }

}
