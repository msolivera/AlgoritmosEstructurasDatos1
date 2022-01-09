/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd6;
import packageAuxiliar.ICanal;

/**
 *
 * @author Meki
 */
public class BancoNacion implements ICanal {
    
    private String nombre;
    private SeguroAutomotriz[] productos;
    
    public BancoNacion(){
        
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public SeguroAutomotriz[] getProductos(){
     
        return productos;   
    }
    public void imprimirProductos() {
        for (int i = 0; i <= productos.length; i++) {
            System.out.println(productos[i].getNombre());
        }
    }
}
