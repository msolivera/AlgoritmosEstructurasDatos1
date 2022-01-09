/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4_ta2;

/**
 *
 * @author Meki
 */
public class TArbolBB<T> implements IArbolBB {

    private TElementoAB<T> raiz;
    /**
     * 
     */
    public TArbolBB() {
        raiz = null;
    }
    @Override
    public boolean insertar(TElementoAB unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }
    
    public int insertarContador(TElementoAB unElemento) {

        if (esVacio()) {
            raiz = unElemento;
            return 0;
        } else {
            return raiz.insertarContador(unElemento);
        }
    }
  
    
    
    /**
     * 
     * @param unaEtiqueta
     * @return 
     */
    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esVacio() {
        return (raiz == null);
    }


    
}
