package preparacionparcial3;




import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {

    protected Comparable etiqueta;
    protected IElementoAB hijoIzq;
    protected IElementoAB hijoDer;
    protected T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */ 
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public IElementoAB getHijoDer() {
        return hijoDer;
    }
    

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean insertar(IElementoAB unElemento) {
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
    public IElementoAB buscar(Comparable unaEtiqueta) {

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

    @Override
    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    
    @Override
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

     public void preOrden(LinkedList<Comparable> unaLista) {
        unaLista.add(this.getEtiqueta());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
    }
    
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
    
    @Override
    public void postOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());
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
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }

    
  

   @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
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
    public IElementoAB quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }

        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
// tiene los dos hijos, buscamos el lexicograficamente anterior
        IElementoAB elHijo = hijoIzq;
        IElementoAB elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null);  // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        return elHijo;
    }
    
    @Override
    public boolean esCompleto(){
        if ((hijoIzq!=null && hijoDer== null) || (hijoIzq == null && hijoDer != null)){
            return false;            
        }
        if (hijoIzq != null) {
            return hijoIzq.esCompleto();

        }
        if (hijoDer != null) {
            return hijoDer.esCompleto();
        }
        return true;
    }
    @Override
    public int obtenerCantidadHojas(){
        if (hijoIzq == null && hijoDer == null){
            return 1;
        }
        else if (hijoIzq == null && hijoDer != null){
            return hijoDer.obtenerCantidadHojas();
        }
        else if (hijoIzq != null && hijoDer == null){
            return hijoIzq.obtenerCantidadHojas();
        }
        else{
            return hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
        }
    }
    @Override
    public int obtenerNivel(Comparable unaEtiqueta){
        if (this.etiqueta.compareTo(unaEtiqueta) == 0){
            return 0;
        }
        else if (unaEtiqueta.compareTo(this.etiqueta) < 0){
            if (hijoIzq != null){
                return 1+ hijoIzq.obtenerNivel(unaEtiqueta);
            }
            else{
                return 0;
            }
        }
        else if (hijoDer != null){
            return 1+ hijoDer.obtenerNivel(unaEtiqueta);
        }
        else{
            return 0;                   
        }
            
    }
    @Override
    public int obtenerAltura() {
        int T1 = -1;
        int T2 = -1;
        if(this.hijoIzq != null){            
            T1 = this.hijoIzq.obtenerAltura();
        }
        if(this.hijoDer != null){
            T2 = this.hijoDer.obtenerAltura();
        }
        if(T1 > T2 ){
            return T1 + 1;            
        }else{
            return T2 + 1;
        }       
    }
    @Override
    public int obtenerTama??o() {
        int T1 = 0;
        int T2 = 0;
        if(hijoIzq != null)
        {
            T1 += hijoIzq.obtenerTama??o();
        }
        if(hijoDer != null)
        {
            T2 += hijoDer.obtenerTama??o();
        }
        return T1 + T2 + 1;
    }
    
    
    /**
* Determina si los sub??rboles son AVL en base
* a las diferencias de altura
* @return null si no es AVL
*/
    @Override
    public Integer esArbolAvlSinAltura() {
    Integer alturaIzq, alturaDer; // Integer para poder retornar null
    
    alturaIzq = alturaDer = -1;
    if (this.getHijoIzq() != null)
        alturaIzq = this.getHijoIzq().esArbolAvlSinAltura();
    
    if (this.getHijoDer() != null)
        alturaDer = this.getHijoDer().esArbolAvlSinAltura();
    
    // Si en retorno ya vengo con "error" (no es AVL)
    // sigo retornando el error.
    if (alturaIzq == null || alturaDer == null) {
        return null;
    }
    else {
        // Determino si la diferencia est?? OK
        if (Math.abs(alturaDer - alturaIzq) > 1)
            // Retorno nulo para agarrar en la vuelta
            return null;
        else
            // Sigo retornando la altura
            return Math.max(alturaIzq + 1, alturaDer + 1);
    }
}
    
public int nivelClave(Comparable unaClave) {
    int nivel = 0;

    if (unaClave.compareTo(etiqueta) < 0) {
        if (hijoIzq != null)
            nivel = 1 + hijoIzq.nivelClave(unaClave);
        else
            // Caso base #1: No encontr?? nodo, voy a restar a la vuelta
            return -2;
    } else if (unaClave.compareTo(etiqueta) > 0) {
        if (hijoDer != null)
            nivel = 1 + hijoDer.nivelClave(unaClave);
        else
            // Caso base #1: No encontr?? nodo, voy a restar a la vuelta
            return -2;
    } else {
        // Caso base #2: Encontr?? nodo, voy a sumar a la vuelta
        return 1;
    }

    // Determino qu?? hacer a la vuelta
    if (nivel <= 0)
        // Empiezo a restar -2, as?? mato los +1 y resto 1 m??s
        return (nivel - 2);
    else
        // Retorno el nivel positivo acumulado
        return nivel;

}


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
    public void listaInorden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.listaInorden(unaLista);

        }
        unaLista.insertar(new Nodo<T>(this.etiqueta,this.getDatos()));
        if (hijoDer != null) {
            hijoDer.listaInorden(unaLista);
        }

    }

    @Override
      public void listaPreOrden(Lista<T> unaLista) {
        unaLista.insertar(new Nodo<T>(this.etiqueta,this.getDatos()));
        if (hijoIzq != null) {
            hijoIzq.listaPreOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.listaPreOrden(unaLista);
        }

    }


    @Override
    public void listaPostOrden(Lista<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.listaPostOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.listaPostOrden(unaLista);
        }
        unaLista.insertar(new Nodo<T>(this.etiqueta,this.getDatos()));
    }
    
    
    
        public TElementoAB<T> clonar() {
        return new TElementoAB<>(this.etiqueta, this.datos);
    }

        public int longTrayInt(int nivel){
        int longitud = nivel;
        if(hijoIzq != null){
            longitud += hijoIzq.longTrayInt(nivel+1);
        }
        if(hijoDer != null){
            longitud += hijoDer.longTrayInt(nivel+1);
        }
        return longitud;
    }    

    public int[] sumaDeAlturas() {
        int[] alturas = {0, 0};
        int[] hNodos = {0, 0};
        int[] hArbol = {0, 0};

        if (hijoIzq != null) {
            alturas[1] += 1;
            hArbol[0] += 1;
        }

        hArbol[0] += 1;
        hArbol[1] += 1;
        alturas[1] += 1;

        if (hijoDer != null) {
            alturas[1] += 1;
            hArbol[1] += 1;
            hijoDer.sumaDeAlturas();
        }

        if (hArbol[0] > hArbol[1]) {
            alturas[0] += hArbol[0];
        } else {
            alturas[0] += hArbol[1];
        }

        return alturas;
    }
        
}
    