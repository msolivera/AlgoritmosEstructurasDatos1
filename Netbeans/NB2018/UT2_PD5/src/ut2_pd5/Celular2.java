/*
Parte a)
El teclado T9 de los celulares mapea los dígitos a letras. Generalmente se encuentran
agrupados de la siguiente forma: ABC(2), DEF(3), GHI(4), JKL(5), MNO(6), PQRS(7), TUV(8),
WXYZ(9), “espacio”(0), “.”(1).
Escribe un programa Java que lea un archivo “entrada.txt” y escriba en un archivo “salida.txt”
los dígitos correspondientes al texto. Puedes asumir que el texto de entrada no tiene ningún
otro caracter más que los nombrados anteriormente. Considera letras mayúsculas y
minúsculas.
Parte b)
Escribe un programa Java que lea de un archivo “entrada.txt” (entrada1.txt), invierta la entrada, pase a
dígitos el texto invertido y escriba la salida en “salida.txt”. (salidaCel.txt)
 */
package ut2_pd5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Meki
 */
public class Celular2 {

    public Celular2 (){
    
    }
    
    /**
     * Funcion que invierte una cadena de caracteres
     * @param texto: cadena de caracteres a invertir
     * @return cadena convertida
     */

        public String Convertidor (String texto)
            
    {
        String fn = "";
        
        
        for (int i= texto.length()-1 ; i>=0 ;i--)
        {
           fn += texto.charAt(i);
           
        }
        return fn;
        
    }
    
    
   /**
    * 
    * @param nombreCompletoArchivo nombre del archivo de entrada que se va a leer
    * @param nombreArchivoSalida nombre del archivo en el que se va a escribir
    * @throws FileNotFoundException 
    * @throws IOException 
    */
    public void Decodificador (String nombreCompletoArchivo, String nombreArchivoSalida) throws FileNotFoundException, IOException
    {   
        // se inicializan las clases necesarias para leer y escribir archivos
        FileWriter fw;
        FileReader fr;
        fr = new FileReader(nombreCompletoArchivo);
        BufferedReader br = new BufferedReader(fr);
        
        //se lee cada linea y se crea la variable var
        String lineaActual = br.readLine();
        String var = "";
        
        //mientras no se terminen las lineas un nuevo aux toma el valor de cada linea invertida y luego se pasa a mayuscula
        while (lineaActual != null) {        
            String aux2 = Convertidor(lineaActual);
            //System.out.println(aux2);
            String aux = aux2.toUpperCase();
            
            //para cada caracter se hace la decodificacion a numeros
            for (int i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) == 'A' || aux.charAt(i) == 'B' || aux.charAt(i) == 'C') {
                    var += 2;

                } else if (aux.charAt(i) == 'D' || aux.charAt(i) == 'F' || aux.charAt(i) == 'E') {
                    var += 3;

                } else if (aux.charAt(i) == 'G' || aux.charAt(i) == 'H' || aux.charAt(i) == 'I') {
                    var += 4;

                } else if (aux.charAt(i) == 'J' || aux.charAt(i) == 'K' || aux.charAt(i) == 'L') {
                    var += 5;

                } else if (aux.charAt(i) == 'M' || aux.charAt(i) == 'N' || aux.charAt(i) == 'O') {
                    var += 6;

                } else if (aux.charAt(i) == 'P' || aux.charAt(i) == 'Q' || aux.charAt(i) == 'R' || aux.charAt(i) == 'S') {
                    var += 7;

                } else if (aux.charAt(i) == 'T' || aux.charAt(i) == 'U' || aux.charAt(i) == 'V') {
                    var += 8;

                } else if (aux.charAt(i) == 'W' || aux.charAt(i) == 'X' || aux.charAt(i) == 'Y' || aux.charAt(i) == 'Z') {
                    var += 9;

                } else if (aux.charAt(i) == ' ') {
                    var += 0;

                } else if (aux.charAt(i) == '.') {
                    var += 1;

                }
                
            }
            //se lee la nueva linea
            lineaActual = br.readLine();
        }
        
        // cerramos el archivo de lectura
        br.close();
        fr.close();
        
        //inicializamos file writer asi podemos escribit
        fw = new FileWriter(nombreArchivoSalida, true);
        BufferedWriter bw = new BufferedWriter(fw);
        //escribimos la variable final
        bw.write(var);
        bw.close();
        fw.close();
        
        
    }

}
