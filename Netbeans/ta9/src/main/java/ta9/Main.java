/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta9;

/**
 *
 * @author Bruno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TArbolBB arbol = new TArbolBB();

        // cargar los productos desde el archivo "altasprueba.txt"
        // listar los productos ordenados por codigo, junto con su cantidad existente
        //emitir el valor del stock
        // simular las ventas a partir del archivo "ventaspruebas.txt"
        // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
        // listar los productos ordenados por codigo, junto con su cantidad existente
        IAlmacen almacen = new Almacen("Geant");

        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\ta9\\altasPrueba.txt");
        
        String[][] resultado = new String[archivo.length][2];
        Integer montoAgregado = 0;
        for (int i = 0; i < archivo.length; i++) {
            resultado[i] = archivo[i].split(",", -1);
            Producto producto = new Producto(resultado[i][0], resultado[i][1]);
            producto.setPrecio(Integer.parseInt(resultado[i][2]));
            producto.setStock(Integer.parseInt(resultado[i][3]));
            //IElementoAB<Producto> prod = new TElementoAB<>(producto.getEtiqueta(), producto);
            //almacen.getProductos().insertar(prod);
            almacen.insertarProducto(producto);
            montoAgregado += almacen.agregarStock(producto.getEtiqueta(), Integer.parseInt(resultado[i][3]), true);
        }

        System.out.println("Monto agregado: " + montoAgregado);

        int valorStock = 0;

        String[] ventas = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\ta9\\ventasPrueba.txt");
        String[][] resul = new String[ventas.length][2];
        for (int i = 0; i < ventas.length; i++) {
            resul[i] = ventas[i].split(",", -1);
            valorStock += almacen.restarStock(resul[i][0], Integer.parseInt(resul[i][1]));

        }

        String[] eliminar = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\ta9\\elimPrueba.txt");
        //String[][] resultadoEliminar = new String[eliminar.length][1];
        //System.out.println("hola"+resultadoEliminar[0]);
        Integer montoRestado = 0;
        for (int i = 0; i < eliminar.length; i++) {
            Comparable clave = eliminar[i];
            IProducto producto = almacen.buscarPorCodigo(clave);
            if (producto != null) {
                Integer monto = producto.getStock();
                Integer precio = producto.getPrecio();

                montoRestado += monto * precio;

                almacen.eliminarProducto(clave);
            }
        }

        System.out.println("Monto restado: " + montoRestado);
    }

}
