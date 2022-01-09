/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Meki
 */
public class TesteadorPreparados {

    public final Lista<Suero> listaSueros;
    public final Lista<Farmaco> listaFarmacos;
    public final Lista<Integer> listaBlanca;
    public final Lista<DuplaNegra> listaNegra;
    

    public TesteadorPreparados() {
        this.listaSueros = new Lista<>();
        this.listaFarmacos = new Lista<>();
        this.listaNegra = new Lista<>();
        this.listaBlanca = new Lista<>();

    }

    public void cargarSueros(String nombreArchivo) {
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ;
                contenido = lineas.split(",");
                for (int i = 0; i < contenido.length; i++) {
                    //quitan las comillas de cada dato
                    contenido[i] = contenido[i].replaceAll("\"", "");
                }
                int id = Integer.valueOf(contenido[0]);
                String nombre = contenido[1];

                Suero suero = new Suero(id, nombre);
                Nodo<Suero> nodo = new Nodo(suero.getId(), suero);
                this.listaSueros.insertar(nodo);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
    }
    
    public void cargarFarmacos (String nombreArchivo){
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ;
                contenido = lineas.split(",");
                for (int i = 0; i < contenido.length; i++) {
                    //quitan las comillas de cada dato
                    contenido[i] = contenido[i].replaceAll("\"", "");
                }
                int id = Integer.valueOf(contenido[0]);
                String nombre = contenido[1];

                Farmaco farmaco = new Farmaco(id, nombre);
                Nodo<Farmaco> nodo = new Nodo(farmaco.getId(), farmaco);
                this.listaFarmacos.insertar(nodo);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
    }
    
    public void cargarListaNegra (String nombreArchivo){
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ;
                contenido = lineas.split(",");
                for (int i = 0; i < contenido.length; i++) {
                    //quitan las comillas de cada dato
                    contenido[i] = contenido[i].replaceAll("\"", "");
                }
                int idFarmaco = Integer.valueOf(contenido[0]);
                int idSuero = Integer.valueOf(contenido[1]);

                DuplaNegra dupla = new DuplaNegra(idFarmaco, idSuero);
                Nodo<DuplaNegra> nodo = new Nodo(String.valueOf(idFarmaco).concat("+").concat(String.valueOf(idSuero)), dupla);
                this.listaNegra.insertar(nodo);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
    }
    
    public void cargarListaBlanca(String nombreArchivo){
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ;
                contenido = lineas.split(",");
                for (int i = 0; i < contenido.length; i++) {
                    //quitan las comillas de cada dato
                    contenido[i] = contenido[i].replaceAll("\"", "");
                }
                int idFarmaco = Integer.valueOf(contenido[0]);
                Nodo<Integer> nodo = new Nodo(idFarmaco,null);
                this.listaBlanca.insertar(nodo);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
        
    }
    
    public void imprimirSueros() {
        Nodo<Suero> suero = this.listaSueros.getPrimero();
        while (suero != null) {
            suero.getDato().imprimir();
            suero = suero.getSiguiente();
        }
    }
    
    public void imprimirFarmacos() {
        Nodo<Farmaco> farmaco = this.listaFarmacos.getPrimero();
        while (farmaco != null) {
            farmaco.getDato().imprimir();
            farmaco = farmaco.getSiguiente();
        }
    }
        
    public void imprimirDupla(){
             Nodo<DuplaNegra> dupla = this.listaNegra.getPrimero();
        while (dupla != null) {
            dupla.getDato().imprimir();
            dupla = dupla.getSiguiente();
        }
            
        }
    
    public void preparadoViable(int identificadorSuero, Lista<Integer> farmacos) {

        Nodo<Integer> nodo = farmacos.getPrimero();
        boolean negro =false;
        while (nodo != null) {
            Nodo<DuplaNegra> dupla = this.listaNegra.getPrimero();
            while (dupla != null) {
                if (dupla.getDato().getIdFarmaco() == Integer.valueOf(nodo.getEtiqueta().toString())) {
                    if (dupla.getDato().getIdSuero() == identificadorSuero) {
                        System.out.println("NO VIABLE");
                        Nodo<Suero> suero = this.listaSueros.buscar(identificadorSuero).clonar();
                        suero.getDato().imprimir();
                        dupla.getDato().imprimir();
                        negro = true;
                        break;

                    }
                }
                dupla = dupla.getSiguiente();
            }
            nodo = nodo.getSiguiente();
        }
        if (this.listaBlanca.buscar(identificadorSuero) == null) {
            System.out.println("no se encuentra suero no se recomienda el preparado: NO VIABLE");
        }
        if (this.listaBlanca.buscar(identificadorSuero)!= null && (negro == false)){
            System.out.println("VIABLE");
        }
            

    }
}
