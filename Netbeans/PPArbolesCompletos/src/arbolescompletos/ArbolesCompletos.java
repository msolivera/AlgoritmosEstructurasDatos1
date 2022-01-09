/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolescompletos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Meki
 */
public class ArbolesCompletos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolBB miArbol = new TArbolBB();

        //LECTURA DEL ARCHIVO
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File("src\\arbolescompletos\\clavesPrueba.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                Comparable id = Integer.valueOf(lineas);

                TElementoAB<Integer> nodo = new TElementoAB(id, lineas);

                miArbol.insertar(nodo);

            }

            br.close();
            System.out.println("Archivo cargado con exito");
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }

        //Escritura de  archivo INORDEN
        
        /*
        LinkedList<Comparable> etiquetas = new LinkedList<>();
        etiquetas = miArbol.inorden();
        String[] lineasInorden = new String[etiquetas.size()];
        for (int i = 0; i < etiquetas.size(); i++) {
            lineasInorden[i] = etiquetas.get(i).toString();
        }
        FileWriter fw;
        try {
            fw = new FileWriter("src\\arbolescompletos\\inOrden.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (String linea : lineasInorden) {
                    bw.write(linea);
                    bw.newLine();

                }

            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }*/

        //Escritura de  archivo PREORDEN
        
        /*
        LinkedList<Comparable> etiquetasPre = new LinkedList<>();
        etiquetasPre = miArbol.preorden();
        String[] lineasPreOrden = new String[etiquetasPre.size()];
        for (int i = 0; i < etiquetasPre.size(); i++) {
            lineasPreOrden[i] = etiquetasPre.get(i).toString();
        }
        FileWriter fw2;
        try {
            fw2 = new FileWriter("src\\arbolescompletos\\preOrden.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw2)) {
                for (String linea : lineasPreOrden) {
                    bw.write(linea);
                    bw.newLine();

                }

            }
            fw2.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }*/

        //Escritura de  archivo POSTORDEN
        
        /*LinkedList<Comparable> etiquetasPost = new LinkedList<>();
        etiquetasPost = miArbol.postorden();
        String[] lineasPostOrden = new String[etiquetasPost.size()];
        for (int i = 0; i < etiquetasPost.size(); i++) {
            lineasPostOrden[i] = etiquetasPost.get(i).toString();
        }
        FileWriter fw3;
        try {
            fw3 = new FileWriter("src\\arbolescompletos\\postOrden.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw3)) {
                for (String linea : lineasPostOrden) {
                    bw.write(linea);
                    bw.newLine();

                }

            }
            fw3.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }*/
            
            
            
            System.out.println("INORDEN DE MI ARBOL");
            System.out.println(miArbol.inOrden());
            System.out.println("PREORDEN DE MI ARBOL");
            System.out.println(miArbol.preOrden());
            System.out.println("POSTORDEN DE MI ARBOL");
            System.out.println(miArbol.postOrden());           
            
            /**
             * c) Buscar las claves que se indican y emitir por consola si
             * existen o no en el árbol: 10635 , 4567, 12, 8978 
             */
                System.out.println(miArbol.buscar(10635));
                System.out.println(miArbol.buscar(4567));
                System.out.println(miArbol.buscar(12));
                System.out.println(miArbol.buscar(8978));
             /** 
             * d) La décima clave del listado en preorden es:
             * i. 412 
             * ii. 765 
             * iii. 797 
             * iv. 1778.
             */
                
        // ESCRITURA DE ARCHIVOS
                
        /*TArbolBB otroArbol = new TArbolBB();
        int[] contador = new int[0];
        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/arbolescompletos/clavesPrueba.txt");
        String[] codigos = ManejadorArchivosGenerico.leerArchivo("src/arbolescompletos/consultaPrueba.txt");
        String[] paraEscribirInsertar = new String[claves.length];
        for (int i = 0; i < claves.length; i++) {
            int contadorInsertar = otroArbol.insertarContadorArray(new TElementoAB(claves[i], contador))[0];
            paraEscribirInsertar[i] = claves[i] + "," + contadorInsertar;

        }
        ManejadorArchivosGenerico.escribirArchivo("src/arbolescompletos/altas.txt", paraEscribirInsertar);

        String[] paraEscribirBuscar = new String[codigos.length];
        for (int i = 0; i < codigos.length; i++) {
            int contadorBuscar = otroArbol.buscarContador(codigos[i]);
            paraEscribirBuscar[i] = codigos[i] + "," + contadorBuscar;
        }
        ManejadorArchivosGenerico.escribirArchivo("src/arbolescompletos/consultas.txt", paraEscribirBuscar);*/
        
        
        System.out.println("Altura de miArbol");
        System.out.println(miArbol.getAltura());
        System.out.println("Mi arbol es completo?");
        System.out.println(miArbol.esCompleto());
        
        System.out.println("Cantidad de hojas");
        System.out.println(miArbol.getCantidadHojas());
        
        System.out.println("Get Nivel raiz");
        System.out.println(miArbol.obtenerNivel(5354));
        System.out.println("Get Nivel 5365");
        System.out.println(miArbol.obtenerNivel(5365));
        System.out.println("Get Nivel de una etiqueta que no existe");
        System.out.println(miArbol.obtenerNivel(45551));
        System.out.println("tamaño de mi arbol");
        System.out.println(miArbol.getTamaño());
        
        System.out.println("Nodos internos de mi arbol");
        System.out.println(miArbol.getInternos());
        
        System.out.println("suma de las etiquetas");
        System.out.println(miArbol.sumarEtiquetas());
        
        
        System.out.println("buscanod algo que no existe");
        System.out.println(miArbol.buscarContador(23)); // no existe
        System.out.println("buscando raiz");
        System.out.println(miArbol.buscarContador(5354)); //raiz  
        System.out.println("buscando 10996");
        System.out.println(miArbol.buscarContador(10996));
        
        System.out.println(miArbol.getCantidadPorNivel(5));
        
    }
    
   

}
