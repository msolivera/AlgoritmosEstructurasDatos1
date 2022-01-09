package geantGenerics;

import java.io.BufferedReader;
import java.io.FileReader;


public class ArchivosAlmacen {

    public static void main(String args[]) throws Exception {
        
        // Creo nuevo almacen
        Almacen almacen = new Almacen("calle 123", "24054345", "Almacen");
        
        // Lector para leer archivos
        BufferedReader lector;
        
        // Auxiliar para guarda contenidos
        String contenidos;
        
        // Archivo ARCHIVO_ALTAS
        // Abro archivo
        lector = new BufferedReader(new FileReader("src\\geantGenerics\\altas.txt"));
        contenidos = lector.readLine() + "\n";
        while (lector.readLine() != null) {
            contenidos += lector.readLine() + "\n";
        }
        lector.close();
        // Creo y agrego nuevo producto por cada línea
        for (String linea : contenidos.split("\n")) {
            String columnas[] = linea.split(",");
            if (columnas.length == 4)
                almacen.insertarProductoStock(new Producto(columnas[0], Integer.valueOf(columnas[2]), Integer.valueOf(columnas[3]), columnas[1]));
        }
        System.out.println(almacen.imprimirSeparador("\n"));
        
        System.out.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.out.println("Stock producto 1000031:" + almacen.buscarPorCodigo("1000031").getStock());
        System.out.println("Valor total stock:" + almacen.valorTotalStock());
        
        System.out.println("-----------------------------------------------------------");
        
        // Archivo ARCHIVO_VENTAS
        // Abro archivo
        lector = new BufferedReader(new FileReader("src\\geantGenerics\\ventas.txt"));
        contenidos = lector.readLine() + "\n";
        while (lector.readLine() != null) {
            contenidos += lector.readLine() + "\n";
        }
        lector.close();
        // Resto stock según ventas del archivo
        for (String linea : contenidos.split("\n")) {
            String columnas[] = linea.split(",");
            if (columnas.length == 2)
                almacen.restarStock(columnas[0], Integer.valueOf(columnas[1]));
        }
        System.out.println(almacen.imprimirSeparador("\n"));
        
        System.out.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.out.println("Stock producto 1000031:" + almacen.buscarPorCodigo("1000031").getStock());
        System.out.println("Valor total stock:" + almacen.valorTotalStock());
        
        System.out.println("-----------------------------------------------------------");
        
        // Archivo ARCHIVO_ELIM
        // Abro archivo
        lector = new BufferedReader(new FileReader("src\\geantGenerics\\elim.txt"));
        contenidos = lector.readLine() + "\n";
        while (lector.readLine() != null) {
            contenidos += lector.readLine() + "\n";
        }
        lector.close();
        // Elimino las etiquetas del archivo
        for (String linea : contenidos.split("\n")) {
            almacen.eliminar(linea.trim());
        }
        System.out.println(almacen.imprimirSeparador("\n"));
        
        System.out.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.out.println("Valor total stock:" + almacen.valorTotalStock());
        
        System.out.println("-----------------------------------------------------------");
        
        
    }
}
