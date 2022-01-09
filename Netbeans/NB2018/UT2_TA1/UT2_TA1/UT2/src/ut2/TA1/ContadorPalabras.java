/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2.TA1;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase Encargada de contar palabras tanto de cadenas, como de archivos de texto
 * @author nicolasgonzalezmartinez
 */
public class ContadorPalabras {
        
        /**
         *Metodo que cuenta las palabras de una cadena
         * @param frase Cadena a analizar la cantidad de palabras
         * @return Cantidad de palabras en la cadena
         */
        public int contarPalabras(String frase)
        {
                
                int cantPalabras = 0;
                boolean nuevaPalabra = false;
        
                //si la frase comienza con una letra o bien algun caracter distinto a un separador
                //inicializamos una nueva palabra porque es palabra candidata
                if(frase.isEmpty() || Character.isLetter(frase.charAt(0)) || frase.charAt(0) != ' ')
                {
                        nuevaPalabra = true;
                }
                
                for (int i = 0; i < frase.length(); i++) 
                {
                        //cuento una nueva palabra siempre y cuando el caracter sea una letra
                        // y ademas sea palabra candidata para contar
                        if (Character.isLetter(frase.charAt(i)) && nuevaPalabra) 
                        {
                                //sumo la plabara
                                cantPalabras++;
                                //y pongo a nueva palabra en false para que no siga contando en el resto de sus letras
                                nuevaPalabra = false;
                        } 
                        else if (frase.charAt(i) == ' ' && !nuevaPalabra)
                        {
                                //va a haber una nueva palabra siempre y cuando aparezca algun separador ' '
                                //basta con que un separador haya aparecido 
                                nuevaPalabra = true;
                        }
                }
        
        return cantPalabras;
        }
        
        /**
         * Metodo que crea una lista con todas las lineas de un archivo
         * @param arch Ruta en la que se encuentra el archivo
         * @return Lista con todas las lineas en el archivo
         * @throws FileNotFoundException Excepción que se lanza si la ruta no es valida
         * @throws IOException 
         */
        public String[] obtenerLineas(String arch) throws FileNotFoundException,IOException
        {
                String[] vector = new String[1000];
                int i = 0;
                //Lectura de archivo
                File archivo = new File (arch);
                FileReader fr = new FileReader (archivo);
                BufferedReader br = new BufferedReader (fr);

                String linea = br.readLine();
        
                while (linea != null) //Mientras exista una linea siguiente, se guarda en el vector
                {
                        vector[i] = linea;
                        i++;
                        linea = br.readLine();
                }
                if(linea == null)       // Agrega las lineas vacias
                {
                        vector[i]= "";
                        i++;
                        linea = br.readLine();
                }
                return vector;
        }
        
        /**
         * Metodo que cuenta la cantidad de palabras totales en una lista de cadenas
         * @param lineasArchivo Lista de String´s
         * @return Cantidad de palabras en toda la lista de String´s
         */
        public int cantPalabras(String[] lineasArchivo)
        {
                int contador = 0;       //Contador de palabras en el texto
                for(String str : lineasArchivo) //Recorre toda la lista que contiene cada linea del archivo
                {
                        if(str != null)
                        {
                          contador += this.contarPalabras(str); //Invoca al metodo de clase para contar las palabras en la linea y las suma al contador.      
                        }
                        
                }
                return contador;
                
        }
        
        public int cantidadLineas(String[] lineasArchivo)
        {
                int x = 0;
                for(String str : lineasArchivo)
                {
                        if(str != null)
                        {
                            x++;
                        }
                }
                return x;
        }
        
}

