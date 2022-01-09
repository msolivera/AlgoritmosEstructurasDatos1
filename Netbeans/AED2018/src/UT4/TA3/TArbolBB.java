/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.TA3;
import java.lang.Math;
import UT4.TA2.*;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class TArbolBB implements IArbolBB
{
        IElementoAB raiz;
        public TArbolBB()
                {
                        raiz = null;
                }
        
        public boolean insertar(IElementoAB unElemento) 
        {
                if (esVacio()) 
                {
                        raiz = unElemento;
                        return true;
                }
                else 
                {
                        return raiz.insertar(unElemento);
                }

        }

        public boolean esVacio() {
                return (raiz == null);
        }

        /**
         * Busca un elemento dentro del árbol.
         *
         *
         * @param unaEtiqueta Etiqueta identificadora del elemento a buscar. .
         * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
         */
        @Override
        public IElementoAB buscar(Comparable unaEtiqueta)
        {
                if (esVacio()) 
                {
                        return null;
                } else 
                {
                        return raiz.buscar(unaEtiqueta);
                }
        }

        /**
         * Imprime en PreOrden los elementos del árbol, separados por guiones.
         *
         * @return String conteniendo el preorden separado por guiones.
         */
        @Override
        public String preOrden()
        {
                if(raiz == null)
                {
                        return "Arbol Vacio";
                }
                else
                {
                        return raiz.preOrden();
                }
        }

        /**
         * Imprime en InOrden los elementos del árbol, separados por guiones.
         *
         * @return String conteniendo el preorden separado por guiones.
         */
        @Override
        public String inOrden()
        {
                if(raiz == null)
                        {
                                return "Arbol Vacio";
                        }
                else
                {
                        return raiz.inOrden();
                }
        }

        /**
         * Imprime en PostOrden los elementos del árbol, separados por guiones.
         *
         * @return String conteniendo el preorden separado por guiones.
         */
        @Override
        public String postOrden()
        {
                if(raiz == null)
                {
                        return "Arbol vacio";
                }
                else
                {
                        return raiz.postOrden();
                }
        }

        /**
         * Elimina un elemento dada una etiqueta.
         *
         * @param unaEtiqueta
         */
        @Override
        public void eliminar(Comparable unaEtiqueta)
        {
                if(!this.esVacio())
                {
                        this.raiz = this.raiz.eliminar(unaEtiqueta);
                }
        }

        
        /*
        @Override
        public boolean insertar(Object unElemento) 
        {
                if(this.esVacio())
                {
                        raiz = (IElementoAB) unElemento;
                        return true;
                }
                else
                {
                        return this.raiz.insertar((TElementoAB) unElemento);
                }
        }
        */

        /**
         * Devuelve el tamaño del árbol
         * @return número entero (tamaño del árbol)
         */
        @Override
        public int obtenerTamaño() 
        {
                if(this.raiz != null)
                {
                        return this.raiz.obtenerTamaño();
                }
                else
                {
                        return 0;
                }
        }

        @Override
        public int obtenerAltura() 
        {
            int a = -1;
            int b = -1;
            
            if (this.raiz.getHijoIzq()!= null){
                a = this.raiz.getHijoIzq().obtenerAltura();
            }
            if (this.raiz.getHijoDer() != null){
                b = this.raiz.getHijoDer().obtenerAltura();
            }
            return (Math.max(a, b)+1);
        }
        
      
        
        
}
