/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.TA9;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class TArbolProductos extends TArbolBB<Producto>
{
        private int valorTotal = 0;
        @Override
        public IElementoAB<Producto> getRaiz() 
        {
                return super.getRaiz();
        }
        /**
         * Metodo encargado de recorrer todo el árbol y calcular la valoración total de todo el árbol
         * @return Valor total de todo el árbol
         */
        public int valorar()
        {
                if(this.getRaiz() != null)
                {
                        if (this.getRaiz().getHijoIzq() != null) {
                                valorTotal += (this.getRaiz().getDatos().getPrecio() * this.getRaiz().getDatos().getStock());
                        }
                        
                        valorTotal += this.getRaiz().getDatos().getPrecio() * this.getRaiz().getDatos().getStock();
                        
                        if(this.getRaiz().getHijoDer() != null)
                        {
                                valorTotal += (this.getRaiz().getDatos().getPrecio() + this.getRaiz().getDatos().getStock());
                        }
                }
                return valorTotal;
                
        }
}
