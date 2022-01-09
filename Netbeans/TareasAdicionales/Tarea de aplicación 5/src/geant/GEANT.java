package geant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GEANT {
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
        
        Almacen almacen = new Almacen();
        
        //CARGAMOS PRODUCTOS EN LA LISTA DEL ALMACEN
        FileReader frCarga = new FileReader("..//Tarea de aplicación 5//src//geant//altas.txt");
        BufferedReader bfCarga = new BufferedReader(frCarga);
        String lineaCarga = bfCarga.readLine();
        while (lineaCarga!=null)
        {
            String[] InfoCarga = lineaCarga.split(",");
            Producto nuevoProducto = new Producto(InfoCarga[1], InfoCarga[0], Integer.parseInt(InfoCarga[2]), Integer.parseInt(InfoCarga[3]));
            almacen.insertarProducto(nuevoProducto);
            lineaCarga = bfCarga.readLine();
        }
        bfCarga.close();
        frCarga.close();
  
        //ElIMINAMOS PRODUCTOS DE LA LISTA DEL ALMACEN
        FileReader frEliminacion = new FileReader("..//Tarea de aplicación 5//src//geant//elim.txt");
        BufferedReader bfEliminacion = new BufferedReader(frEliminacion);
        String lineaEliminacion = bfEliminacion.readLine();
        while (lineaEliminacion!=null)
        {
            almacen.eliminar(lineaEliminacion);
            lineaEliminacion = bfEliminacion.readLine();
        }
        bfEliminacion.close();
        frEliminacion.close();
        
        //VENDEMOS UN PRODUCTO
        FileReader frVenta = new FileReader("..//Tarea de aplicación 5//src//geant//ventas.txt");
        BufferedReader bfVenta = new BufferedReader(frVenta);
        String lineaVenta = bfVenta.readLine();
        int total = 0;
        while (lineaVenta!=null)
        {
            String[] InfoVenta = lineaVenta.split(",");
            total += almacen.restarStock(InfoVenta[0],Integer.parseInt(InfoVenta[1]));
            lineaVenta = bfVenta.readLine();
        }
        bfVenta.close();
        frVenta.close();
        
        System.out.println("El total de la venta fue: " + total);
        almacen.listarOrdenadoPorNombre();
    }
}
