/*
Escribe un programa que lea de un archivo “entrada.txt” y genere la siguiente salida:
El entero leído es: 12
El número de punto flotante es: 33.44
La cadena leída es “Peter”
¡Hola Peter! La suma de 12 y 33.44 es 45.44.
La división entera de 33.44 y 12 es 2 y su resto es 9.44.
 */
package ut2_pd5;
import java.io.*;
import java.io.IOException;

/**
 *
 * @author Meki
 */
public class EntradaDeDatos {
    
    public float sumar (int a , float b){
        return a + b;
    }
    
     public void dividirEntero (float a , int b){
        
        int b2 = (int)Math.round(a);
        int cociente =  b2 / b;
        
        float resto = b2%b;
        
        System.out.println("La division entera entre " + a + "y" + b + " es: Division entrera:" + cociente+" y el resto es:" + resto);
    }
    
     public void cargarArchivo(String ruta) throws IOException
        {
                ManejadorDeArchivos file = new ManejadorDeArchivos();
                Lista lineas = file.leerArchivo(ruta);
                INodo unNodo = lineas.getPrimero();
                
                while(unNodo != null)
                {
                        System.out.println("El entero leído es:"+ unNodo.getDato());
                        
                        String variable = unNodo.getDato().toString();
                        
                        unNodo = unNodo.getSiguiente();
                        System.out.println("El float leído es:"+ unNodo.getDato());
                        
                        String variable2 = unNodo.getDato().toString();
                        unNodo = unNodo.getSiguiente();
                        System.out.println("La cadena leída es:"+ unNodo.getDato());
                        
                        String variable3 = unNodo.getDato().toString();
                        unNodo = unNodo.getSiguiente();
                       
                        System.out.println("Hola " + variable3);
                        
                        System.out.println("La suma entre " + variable + "y" + variable2 + " es:" +  sumar(Integer.parseInt(variable) , Float.parseFloat(variable2)));
                        dividirEntero( Float.parseFloat(variable2),Integer.parseInt(variable));
                }
                
                
        }
    
}
