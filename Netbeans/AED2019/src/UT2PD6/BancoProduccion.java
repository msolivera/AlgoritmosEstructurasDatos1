/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD6;
import UT2PD6.packageAuxiliar.ICanal;
/**
 *
 * @author Meki
 */
public class BancoProduccion implements ICanal {
    
    private String nombre;
    private SeguroHipotecario[] productos;

    public BancoProduccion(){}
    
    @Override
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    
    @Override
    public SeguroHipotecario[] getProductos(){
     
        return productos;   
    }
    
    public void imprimirPrimero() {
        System.out.println(productos[1].getNombre());
    }
}
