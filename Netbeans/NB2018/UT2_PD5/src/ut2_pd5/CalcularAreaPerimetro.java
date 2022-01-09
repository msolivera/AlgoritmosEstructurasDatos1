/*
Haz un programa similar al de la parte anterior que devuelva el área y perímetro de una circunferencia a partir del radio de la misma.
 */
package ut2_pd5;
import java.math.*;

/**
 *
 * @author Meki
 */
public class CalcularAreaPerimetro {
    
    public double calcularPerimetro (int r){
            
       double resultado =  2*Math.PI*r;
       
       return resultado;
                    
    }
    
    
    public double calcularArea (int r){
        double resultado = Math.PI*r*r;
        
        return resultado;
    }
}
