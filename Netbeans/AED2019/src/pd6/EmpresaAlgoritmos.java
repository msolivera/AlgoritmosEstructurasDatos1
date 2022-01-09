/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd6;

/**
 *
 * @author Meki
 */
public class EmpresaAlgoritmos {
    
      public static void main(String[] args) {
          
          Empresa aed = new Empresa("aed");
          
          //PRUEBAS
          //aed.cargarInfo("src\\pd6\\sucursales.txt");
          //aed.imprimirSucursales();
          //System.out.println(aed.cantidadSucursales());
          //aed.buscarSucursal("Artigas");
          //System.out.println(aed.sinSucursales());
          //aed.imprimirSucursales();
          
          //PARTE1
          /*
          aed.cargarInfo("src\\pd6\\suc1.txt");
          System.out.println(aed.cantidadSucursales());
          aed.quitarSucursal("Chicago");
          aed.imprimirSucursales();
          System.out.println(aed.cantidadSucursales());
          */
          
          //PARTE2
          /*
          aed.cargarInfo("src\\pd6\\suc2.txt");
          aed.imprimirSucursales();
          aed.quitarSucursal("Shenzen");
          aed.quitarSucursal("Tokio");
          aed.imprimirSucursales();
          */
          
          //PARTE 3
          aed.cargarInfo("src\\pd6\\suc3.txt");
          System.out.println(aed.imprimirSeparador(";_"));
      }
    
}
