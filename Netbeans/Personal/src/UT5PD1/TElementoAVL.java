/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT5PD1;

/**
 *
 * @author Meki
 * @param <T>
 */
public class TElementoAVL<T> extends TElementoAB <T> implements IElementoAB<T> {
    
   
    private int balance = 0;
public TElementoAVL(Comparable unaEtiqueta, T unosDatos) {
        super(unaEtiqueta, unosDatos);
    }

    public TElementoAVL<T> getHijoIzq() {
        return (TElementoAVL<T>) super.getHijoIzq();
    }

    public TElementoAVL<T> getHijoDer() {
        return (TElementoAVL<T>) super.getHijoDer();
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void calcBalance() {
        int altIzq = 0;
        int altDer = 0;

        if (getHijoIzq() != null) {
            altIzq = 1 + getHijoIzq().obtenerAltura();
        }
        if (getHijoDer() != null) {
            altDer = 1 + getHijoDer().obtenerAltura();
        }
        balance = altDer - altIzq;
    }

    public boolean insertar(TElementoAVL<T> elemento) {
        boolean res;
        if (elemento.getEtiqueta().compareTo(getEtiqueta()) < 0) {
            if (getHijoIzq() != null) {
                res = getHijoIzq().insertar(elemento);
            } else {
                setHijoIzq(elemento);
                res = true;
            }
        } else if (elemento.getEtiqueta().compareTo(getEtiqueta()) > 0) {
            if (getHijoDer() != null) {
                res = getHijoDer().insertar(elemento);
            } else {
                setHijoDer(elemento);
                res = true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }

        if (!res) {
            return res;
        }

        balancearHijos();
        calcBalance();

        return res;
    }

    private void balancearHijos() {
        if (getHijoIzq() != null) {
            if (getHijoIzq().getBalance() < -1 || getHijoIzq().getBalance() > 1) {
                setHijoIzq(getHijoIzq().balancear());
            }
        }

        if (getHijoDer() != null) {
            if (getHijoDer().getBalance() < -1 || getHijoDer().getBalance() > 1) {
                setHijoDer(getHijoDer().balancear());
            }
        }
    }

    public TElementoAVL<T> balancear() {
        if (balance < -1) {
            if (getHijoIzq().getBalance() < 0) {
                //caso 1
                return rotacionLL(this);
            } else {
                //caso 2
                return rotacionLR(this);
            }
        } else if (balance > 1) {
            if (getHijoDer().getBalance() < 0) {
                //caso 3
                return rotacionRL(this);
            } else {
                //caso 4
                return rotacionRR(this);
            }
        }
        return this;
    }

    /*public TElementoAVL<T> eliminar(Comparable unaEtiqueta) {
        TElementoAVL res;
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (getHijoIzq() != null) {
                setHijoIzq(getHijoIzq().eliminar(unaEtiqueta));
            }
            res = this;
        } else if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (getHijoDer() != null) {
                setHijoDer(getHijoDer().eliminar(unaEtiqueta));

            }
            res = this;
        } else {
            res = (TElementoAVL) quitaElNodo();
        }
        balancearHijos();
        calcBalance();

        return res;
    }*/

    //Caso 1
    public TElementoAVL<T> rotacionLL(TElementoAVL<T> k2) {
        TElementoAVL<T> k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        k1.calcBalance();
        k2.calcBalance();
        return k1;
    }

    //Caso 2
    public TElementoAVL<T> rotacionLR(TElementoAVL<T> k3) {
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        TElementoAVL k2 = rotacionLL(k3);
        k2.calcBalance();
        k3.calcBalance();
        return k2;
    }

    //Caso 3
    public TElementoAVL<T> rotacionRL(TElementoAVL<T> k1) {
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        TElementoAVL k2 = rotacionRR(k1);
        k1.calcBalance();
        k2.calcBalance();
        return k2;
    }

    //Caso 4
    public TElementoAVL<T> rotacionRR(TElementoAVL<T> k1) {
        TElementoAVL<T> k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        k1.calcBalance();
        k2.calcBalance();
        return k2;
    }


     
    
}
