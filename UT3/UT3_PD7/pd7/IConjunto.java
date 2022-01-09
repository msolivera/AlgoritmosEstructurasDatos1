/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd7;

/**
 *
 * @author Meki
 */
public interface IConjunto<T> extends ILista<T> {
    
    public IConjunto<T> union(IConjunto<T> otroConjunto); 
   
   public IConjunto<T> interseccion(IConjunto<T> otroConjunto); 
    
}
