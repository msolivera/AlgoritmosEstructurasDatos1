/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd6;

import packageAuxiliar.Producto;

/**
 *
 * @author Meki
 */
public class SeguroHipotecario extends Producto {
    
    private String declaracionJurada;
    
    public SeguroHipotecario (String nombre){
        super (nombre);
        
    }
    
    public String getDeclaracionJurada(){
        return this.declaracionJurada;
    }
    
    public void setDeclaracionJurada (  String nuevaDeclaracion){
        
        this.declaracionJurada = nuevaDeclaracion;
    }
}
