package blabla;


import blabla.IArbolBB;
import blabla.IElementoAB;
import blabla.TElementoAB;
import java.util.ArrayList;
import java.util.LinkedList;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    /**
     * @return recorrida en postOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }
    
    public ArrayList<String> InternosYNivel(){
        if(!esVacio()){
            ArrayList<String> lista = new ArrayList();
            //return this.InternosYNivel(0,lista);
        }else{
            return null;
        }
    }

    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    public int cantNodosInternosCompletos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
            
        }
        return listaInorden;
    }
    
    public int obtenerTamaño() {
        if(this.raiz==null){return 0;}
        else{return this.raiz.obtenerTamaño();}
    }
    
    public int obtenerCantidadHojas() {
        if(this.raiz==null){return 0;}
        else{return this.raiz.obtenerCantidadHojas();}
    }
    
    public int calcularCosto(int[] frecExito, int[] frecNoExito){
        int[] contador = {1,0};
            if (raiz != null){
                return raiz.calcularCosto(frecExito,frecNoExito,1,contador);
            }
        return 0;
    }
    

}
