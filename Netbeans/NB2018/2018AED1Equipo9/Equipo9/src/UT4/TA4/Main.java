/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.TA4;

/**
 *
 * @author Equipo9
 */
public class Main {

        public static void main(String[] args) 
        {
                TArbolBB arbol = new TArbolBB();
                IElementoAB unElemento = new TElementoAB("1");
                arbol.insertar(unElemento);
                String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/UT4/TA2/consultas.txt");
                String[] auxiliar = new String[lineas.length];
                int i = 0;
                for(String linea : lineas)
                {
                       IElementoAB elemento = arbol.buscar(linea);
                       if(elemento != null)
                       {
                               auxiliar[i] = elemento.getEtiqueta().toString();
                               System.out.println(elemento.getEtiqueta().toString());
                       }
                       i+=1;
                }
        }
        
}
