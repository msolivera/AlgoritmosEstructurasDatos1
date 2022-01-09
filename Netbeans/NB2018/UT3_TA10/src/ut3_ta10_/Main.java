/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ut3_TA10_;

/**
 *
 * @author Sebaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EstructurasYAlgoritmos e = new EstructurasYAlgoritmos();
       e.cargarSistema("src/ut3_ta10_/suc1.txt");
       System.out.println(e.cantidadSucursales()+""); 
        e.quitar("Chicago");
        e.listarSucursales();
         e.cargarSistema("src/ut3_ta10_/suc2.txt");
        e.quitar("Shenzen");
        e.quitar("Tokio");
        e.listarSucursales();
         e.cargarSistema("src/ut3_ta10_/suc3.txt");
         e.imprimir(";_");
    }
    
}
