/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorarchivos;

/**
 *
 * @author Meki
 */
public class Main {
    
     public static void main(String[] args) {
        // TODO code application logic here
        
       String [] lineas = new String [10];
       lineas[0] = "Hola me llamo micaela";
       lineas[1] = "esto es una prueba de escritura de un archivo :O";
       lineas[2] = " desearia estar jugando world of warcraft";
       lineas[3] = " pero tengo que estar aca estudiando algoritmo :(";
       lineas[4] = " ya no se que mas escribir y me falta 5 lineas mas :O";
       lineas[5] = "123455667";
       lineas[6] = "ya faltan menoooooooooos";
       lineas[7] = " esta es la linea 7 que en verdad es la 8?";
       lineas[8] = " y esta la 8 que en realidad es la 9!!!!!!";
       lineas[9] = " fin de las lineas :D";
       
       ManejadorArchivosGenerico manejador = new ManejadorArchivosGenerico();
       //manejador.escribirArchivo("src/ManejadorArchivos/salida.txt", lineas);
       manejador.leerArchivo("src/ManejadorArchivos/salida.txt");
       manejador.imprimirLeerLineas("src/ManejadorArchivos/salida.txt");
       
    }
    
}
