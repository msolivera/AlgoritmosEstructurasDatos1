/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.TA2;

/**
 *
 * @author nicolasgonzalezmartinez
 */
class TElementoAB implements IElementoAB
{
        Comparable etiqueta;
        IElementoAB hijoIzq = null;
        IElementoAB hijoDer = null;
        
        public TElementoAB(Comparable etiqueta)
        {
                this.etiqueta = etiqueta;
                }
        /**
         * Obtiene el valor de la etiqueta del nodo.
         *
         * @return Etiqueta del nodo.
         */
        @Override
        public Comparable getEtiqueta()
        {
                return this.etiqueta;
        }

        /**
         * Obtiene el hijo izquierdo del nodo.
         *
         * @return Hijo Izquierdo del nodo.
         */
        @Override
        public IElementoAB getHijoIzq()
        {
                return this.hijoIzq;
        }

        /**
         * Obtiene el hijo derecho del nodo.
         *
         * @return Hijo derecho del nodo.
         */
        @Override
        public IElementoAB getHijoDer()
        {
                return this.hijoDer;
        }

        /**
         * Busca un elemento dentro del arbol con la etiqueta indicada.
         *
         * @param unaEtiqueta del nodo a buscar
         * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
         */
        @Override
        public IElementoAB buscar(Comparable unaEtiqueta)
        {
                if(this.etiqueta.compareTo(unaEtiqueta) == 0)
                {
                        return this;
                }
                else
                {
                        if(this.etiqueta.compareTo(unaEtiqueta) < 0)
                        {
                                if (this.hijoIzq != null) 
                                {
                                        return hijoIzq.buscar(unaEtiqueta);
                                }
                                else 
                                {
                                        return null;
                                }
                        }
                        else
                        {
                                if (this.hijoDer != null) 
                                {
                                        return hijoDer.buscar(unaEtiqueta);
                                }
                                else 
                                {
                                        return null;
                                }
                        }
                }
        }
        @Override
        public void setHijoIzq(IElementoAB elemento) 
        {
                this.hijoIzq = elemento;
        }

        @Override
        public void setHijoDer(IElementoAB elemento) 
        {
                this.hijoDer = elemento;
        }

        @Override
        public boolean insertar(IElementoAB elemento) 
        {
                if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
                        if (hijoIzq != null) {
                                System.out.println("compara");
                                return getHijoIzq().insertar(elemento);

                        } else {
                                hijoIzq = elemento;
                                return true;
                        }
                } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
                        if (hijoDer != null) {
                                return getHijoDer().insertar(elemento);
                        } else {
                                hijoDer = elemento;
                                return true;
                        }
                } else {

                        // ya existe un elemento con la misma etiqueta.-
                        return false;
                }
        }
        @Override
        public String preOrden() 
        {
                String preO = "";
                preO += etiqueta;
                if(this.hijoIzq != null)
                {
                        preO += this.hijoIzq.preOrden();
                }
                if(this.hijoDer != null)
                {
                        preO += this.hijoDer.preOrden();
                }
                return preO;
        }

        @Override
        public String inOrden() 
        {
                String inO = "";
                if(this.hijoIzq != null)
                {
                        inO += this.hijoIzq.inOrden();
                }
                inO += this.etiqueta;
                if(this.hijoDer != null)
                {
                        inO += this.hijoDer.inOrden();
                }
                return inO;
        }

        @Override
        public String postOrden() 
        {
                String postO = "";
                if(this.hijoIzq != null)
                {
                        postO += this.hijoIzq.postOrden();
                }
                if(this.hijoDer != null)
                {
                        postO += this.hijoDer.postOrden();
                }
                postO += this.etiqueta;
                return postO;
        }

        @Override
        public IElementoAB eliminar(Comparable unaEtiqueta) 
        {
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
        
        public IElementoAB quitaElNodo()
        {
                if (hijoIzq == null)    // solo tiene un hijo o es hoja
                {
                        return hijoDer;
                }

                if (hijoDer == null)    // solo tiene un hijo o es hoja
                {
                        return hijoIzq;
                }
                
                // tiene los dos hijos, buscamos el lexicograficamente anterior
                IElementoAB elHijo = hijoIzq;
                IElementoAB elPadre = this;

                while (elHijo.getHijoDer() != null) 
                {
                        elPadre = elHijo;
                        elHijo = elHijo.getHijoDer();
                }

                if (elPadre != this) 
                {
                        elPadre.setHijoDer(elHijo.getHijoIzq());
                        elHijo.setHijoIzq(hijoIzq);
                }

                elHijo.setHijoDer(hijoDer);
                setHijoIzq(null);  // para que no queden referencias y ayudar al collector
                setHijoDer(null);
                return elHijo;
        }
        
        public String imprimir()
        {
                return etiqueta.toString();
        }
}