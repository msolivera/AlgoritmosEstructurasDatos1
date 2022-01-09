package UT4.TA9;
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
            TArbolProductos arbol = new TArbolProductos();
            Almacen almacen = new Almacen("UCU");
            // cargar los productos desde el archivo "altasprueba.txt"
            // listar los productos ordenados por codigo, junto con su cantidad existente
            //emitir el valor del stock
            // simular las ventas a partir del archivo "ventaspruebas.txt"
            // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
            // listar los productos ordenados por codigo, junto con su cantidad existente

            try
            {
                    
            String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/UT4/TA9/altasPrueba.txt");
            for (String linea : lineas) 
            {
                    String[] datos = linea.split(",");
                    if(datos.length == 4)
                    {
                            Comparable etiqueta = datos[0];
                            String nombre = datos[1];
                            int stock = Integer.parseInt(datos[2]);
                            int precio = Integer.parseInt(datos[3]);
                            Producto pro_A = new Producto(etiqueta, nombre);
                            pro_A.setStock(stock);
                            pro_A.setPrecio(precio);
                            almacen.insertarProducto(pro_A);
                    }
            }
            String[] lineas1 = ManejadorArchivosGenerico.leerArchivo("src/UT4/TA9/ventasPrueba.txt");
            for (String linea1 : lineas1) 
            {
                    String[] datos1 = linea1.split(",");
                    String idV = datos1[0];
                    int cantidadV = Integer.parseInt(datos1[1]);
                    almacen.vender(idV, cantidadV);
            }

            String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/UT4/TA9/elimPrueba.txt");
            for (String linea2 : lineas2) 
            {
                    Comparable lineaComp = linea2;
                    almacen.eliminarProducto(lineaComp);
            }
            
            }
            catch(Exception e)
            {
                    
            }
            
            
            /*
            TArbolProductos arbol = new TArbolProductos();
            Producto pro1 = new Producto(1,"Helado");
            pro1.setPrecio(100);
            pro1.setStock(1);
            Producto pro2 = new Producto(2,"Frutilla");
            pro2.setPrecio(50);
            pro2.setStock(20);
            TElementoAB<Producto> elem1 = new TElementoAB(1,pro1);
            TElementoAB<Producto> elem2 = new TElementoAB(2,pro2);
            arbol.insertar(elem1);
            arbol.insertar(elem2);
            System.out.println(arbol.valorar());
    
            */
    }
}

