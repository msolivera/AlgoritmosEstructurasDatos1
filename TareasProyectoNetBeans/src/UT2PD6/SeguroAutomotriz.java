/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD6;
import UT2PD6.packageAuxiliar.Producto;

/**
 *
 * @author Meki
 */
public class SeguroAutomotriz extends Producto{
  
    
    private String condicionesDeAsegurabilidad;  
    
    public SeguroAutomotriz (String nombre){
        super(nombre);
    }
    
    public String getCondicionesDeAsegurabilidad(){
        return this.condicionesDeAsegurabilidad;
    }
    
    public void setCondicionesDeAsegurabilidad(String nuevaCondicion) {
        this.condicionesDeAsegurabilidad= nuevaCondicion;
    }
}
