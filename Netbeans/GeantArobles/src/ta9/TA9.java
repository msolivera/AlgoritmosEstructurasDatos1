package ta9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TA9 {
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
        
        Almacen almacen = new Almacen();
        
        try ( //CARGAMOS PRODUCTOS EN LA LISTA DEL ALMACEN
                FileReader frCarga = new FileReader("src//ta9//altas.txt"); 
                BufferedReader bfCarga = new BufferedReader(frCarga)) {
            String lineaCarga = bfCarga.readLine();
            int totalCargado = 0;
            while (lineaCarga!=null)
            {
                String[] infoCarga = lineaCarga.split(",");
                totalCargado += Integer.parseInt(infoCarga[2])*Integer.parseInt(infoCarga[3]);
                Producto nuevoProducto = new Producto(infoCarga[1], infoCarga[0], 
                        Integer.parseInt(infoCarga[2]), Integer.parseInt(infoCarga[3]));
                almacen.insertarProducto(nuevoProducto);
                lineaCarga = bfCarga.readLine();
            }
            System.out.println("El total agregado al stock fue: " + totalCargado);
        }
        
        try ( //VENDEMOS PRODUCTOS
            FileReader frVenta = new FileReader("src//ta9//ventas.txt"); 
            BufferedReader bfVenta = new BufferedReader(frVenta)) {
            String lineaVenta = bfVenta.readLine();
            int totalVenta = 0;
            while (lineaVenta!=null)
            {
                String[] InfoVenta = lineaVenta.split(",");
                totalVenta += almacen.restarStock(InfoVenta[0],Integer.parseInt(InfoVenta[1]));
                lineaVenta = bfVenta.readLine();
            }
            almacen.listarOrdenadoPorNombre();
            System.out.println("El total de la venta fue: " + totalVenta);
        }
        
        try ( //ElIMINAMOS PRODUCTOS DE LA LISTA DEL ALMACEN
            FileReader frEliminacion = new FileReader("src//ta9//elim.txt"); 
            BufferedReader bfEliminacion = new BufferedReader(frEliminacion)) {
            String lineaEliminacion = bfEliminacion.readLine();
            while (lineaEliminacion!=null)
            {
                almacen.eliminar(lineaEliminacion);
                lineaEliminacion = bfEliminacion.readLine();
            }
        }        
    }
}
