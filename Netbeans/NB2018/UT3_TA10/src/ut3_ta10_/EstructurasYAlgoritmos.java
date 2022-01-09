/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ut3_TA10_;

import java.util.LinkedList;

/**
 *
 * @author Sebaa
 */
public class EstructurasYAlgoritmos {
    LinkedList sucursales;
    
    public EstructurasYAlgoritmos()
    {
        sucursales = new LinkedList();
    }
    
    public void agregarSucursal(String sucursal)
    {
        sucursales.add(sucursal);
    }
    
    public boolean buscarSucursal(String nameCity)
    {
        for(int i = 0; i < sucursales.size();i++)
        {
            if (sucursales.get(i).equals(nameCity))
            {
                return true;
            }
        }
        return false;
    }
    
    public void quitar(String sucursal)
    {
        sucursales.remove(sucursal);
    }
    
    public void listarSucursales()
    {
        for(int i = 0; i < sucursales.size();i++)
        {
            System.out.println(sucursales.get(i).toString());
        }
    }
    public void imprimir(String separador)
    {
        for(int i = 0; i < sucursales.size();i++)
        {
            System.out.print(sucursales.get(i).toString()+separador);
        }
    }
    
    public int cantidadSucursales()
    {
        return sucursales.size();
    }
    
    public boolean esVacia()
    {
        return sucursales.isEmpty();
    }
    
    public void cargarSistema(String ruta)
    {
        String[] datos = ManejadorArchivos.leerArchivo(ruta);
        for(int i = 0; i < datos.length;i++)
        {
            agregarSucursal(datos[i]);
        }
    }
}
