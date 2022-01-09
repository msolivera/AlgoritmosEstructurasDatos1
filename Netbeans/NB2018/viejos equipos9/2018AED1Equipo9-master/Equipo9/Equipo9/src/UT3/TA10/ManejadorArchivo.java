/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Equipo9
 */
public class ManejadorArchivo 
{
        /**
         * 
         * @param arch Ruta de acceso al archivo a leer
         * @return Lista con Nodos(Linea de archivo , numeroDeLinea)
     * @throws java.io.FileNotFoundException
         */
        public Lista leerArchivo(String arch) throws FileNotFoundException, IOException
        {
                Lista vector = new Lista();
                File archivo = new File (arch);
                FileReader fr = new FileReader (archivo);
                BufferedReader br = new BufferedReader (fr);
                String linea = br.readLine();
                int i = 0;
                while (linea != null)
                {
                        i++;
                        Nodo unNodo = new Nodo(linea,i);
                        vector.insertar(unNodo);
                        linea = br.readLine();
                }
                return vector;
        }
        
}
