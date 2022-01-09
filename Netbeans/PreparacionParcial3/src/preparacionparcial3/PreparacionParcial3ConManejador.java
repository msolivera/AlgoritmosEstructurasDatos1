/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacionparcial3;

/**
 *
 * @author Meki
 */
public class PreparacionParcial3ConManejador {
    
     public static void main(String[] args) {
       
      
       String[] FE = ManejadorArchivosGenerico.leerArchivo("src\\preparacionparcial3\\palabras.txt");
       String[] FNE = ManejadorArchivosGenerico.leerArchivo("src\\preparacionparcial3\\nopalabras.txt");
       int cantElem = FE.length;
       
       int [] frecConEx = new int[cantElem+1];
       int [] frecSinEx = new int[cantElem+1];
       String [] claves = new String[cantElem+1];
       
       int i = 1;
       for (String l : FE){
           String [] datos = l.split(" ");
           claves [i] = datos[0];
           frecConEx[i] = Integer.parseInt(datos[1]);
           i++;
           
       }
       int s = 0;
       for (String j : FNE){
           frecSinEx[s] = Integer.parseInt(j);
           s++;
           
       }
         CalculadorMatricesOptimo a = new CalculadorMatricesOptimo(cantElem);
       a.encontrarOptimo(cantElem, frecConEx, frecSinEx);
       TArbolBB miArbol = new TArbolBB();
       a.armarArbolBinario(0,cantElem, claves, miArbol);
       
       System.out.println(miArbol.inOrden());
        System.out.println(miArbol.calcularCosto(frecConEx, frecSinEx));
       
       // invocar a nivelClave, con el parámetro indicado en el pizarrón         
        String laClave1 = "return";
        String laClave2 = "strict";

        // indicar si la clave está o no en el árbol y cuál sería el nivel correspondiente, 
        // invocando al método alArbol.nivelClave
        System.out.println("return");
        System.out.println(miArbol.nivelClave(laClave1));
        System.out.println("strict");
        System.out.println(miArbol.nivelClave(laClave2));
       
        
        /////////////////////////ESCRIBIR
        Lista<String> preorden =  miArbol.listaPreOrden();
        String[] preordenArray = new String[cantElem];
        Nodo<String> actual = preorden.getPrimero();
         i = 0;
        while (actual != null){
            String etiqueta = actual.getEtiqueta().toString();
            preordenArray[i] = etiqueta;
            i++;
            actual = actual.getSiguiente();
        }
        Lista<String> postorden =  miArbol.listaPostOrden();
        String[] postordenArray = new String[cantElem];
        Nodo<String> actual2 = postorden.getPrimero();
        i = 0;
        while (actual2 != null){
            String etiqueta = actual2.getEtiqueta().toString();
            postordenArray[i] = etiqueta;
            i++;
            actual2 = actual2.getSiguiente();
        }
        
        Lista<String> inorden =  miArbol.listaInOrden();
        String[] inordenArray = new String[cantElem];
        Nodo<String> actual3= inorden.getPrimero();
        i = 0;
        while (actual3 != null){
            String etiqueta = actual3.getEtiqueta().toString();
            inordenArray[i] = etiqueta;
            i++;
            actual3 = actual3.getSiguiente();
        }        
        
        ManejadorArchivosGenerico.escribirArchivo("src\\preparacionparcial3\\preordenManejador.txt", preordenArray);
        ManejadorArchivosGenerico.escribirArchivo("src\\preparacionparcial3\\postordenManejador.txt", postordenArray);
        ManejadorArchivosGenerico.escribirArchivo("src\\preparacionparcial3\\inordenManejador.txt", inordenArray);

       
     }
    
}
