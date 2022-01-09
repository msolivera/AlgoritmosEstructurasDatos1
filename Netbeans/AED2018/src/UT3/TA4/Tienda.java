/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA4;

import java.io.IOException;

/**
 * Clase encargada de crear y administrar la tienda
 * @author nicolasgonzalezmartinez
 */
public class Tienda {
        
        Lista<Producto> listaProductos;
        /**
         * Constructor de la tienda
         */
        public Tienda()
        {
               this.listaProductos = new Lista(); 
        }
        /**
         * Incorpora un nuevo producto a la tienda
         * @param unProducto Producto que se desea insertar
         */
        public void incorporarProducto(Producto unProducto)
        {
                Conversor convertir = new Conversor();
                Comparable codigo = convertir.charToString(unProducto.codigo);
                if(this.buscarPorCodigo(unProducto.codigo) == null)
                {
                        Nodo unNodo = new Nodo(unProducto, (codigo));
                        this.listaProductos.insertar(unNodo);
                }
                else
                {
                        Producto miProducto = this.buscarPorCodigo(unProducto.codigo);
                        this.agregarStock(miProducto , unProducto.stock);
                }
                
        }
        /**
         * Agrega una cantidad ´x´ de stock a un producto ya existente o crea un producto nuevo con ´x´ unidades
         * @param unProducto Producto a agregar stock
         * @param cantidad cantidad de unidades extra
         */
        public void agregarStock(Producto unProducto, int cantidad)
        {
                Conversor convertir = new Conversor();
                Comparable codigo = convertir.charToString(unProducto.codigo);
                if(buscarPorCodigo(unProducto.codigo) != null)
                {
                        unProducto.stock += cantidad;
                        INodo unNodo = new Nodo(unProducto,codigo);
                        this.listaProductos.eliminar(codigo);
                        this.listaProductos.insertar(unNodo);
                }
        }
        /**
         * Metodo encargado de quitar stock de un producto
         * @param unProducto Producto a sustraer stock
         * @param cantidad Cantidad de stock a quitar
         */
        public void reducirStock(Producto unProducto, int cantidad)
        {
                
                Conversor convertir = new Conversor();
                Comparable codigo = convertir.charToString(unProducto.codigo);
                if(buscarPorCodigo(unProducto.codigo) != null)
                {
                        unProducto.stock -= cantidad;
                        INodo unNodo = new Nodo(unProducto,codigo);
                        this.listaProductos.eliminar(codigo);
                        this.listaProductos.insertar(unNodo);
                }
        }
        /**
         * Metodo que imprime todos los productos en tienda
         */
        public void imprimir()
        {
                Conversor conv = new Conversor();
                INodo unNodo = this.listaProductos.getPrimero();
                while(unNodo != null)
                {
                        Producto unProducto = (Producto) unNodo.getDato();
                        String codigo = conv.charToString(unProducto.codigo);
                        System.out.print("Nombre: " + unProducto.nombre + "  <>  ");
                        System.out.print("Codigo: " + codigo + "  <>  ");
                        System.out.print("Precio: " + unProducto.precio + "  <>  ");
                        System.out.println("Stock: " + unProducto.stock);
                        unNodo = unNodo.getSiguiente();
                        
                }
                        
        }
        /**
         * Metodo que busca un producto dado su codigo
         * @param codigo Codigo del producto que se desea buscar
         * @return producto de tipo Producto si se encuentra y nulo, si no se encuentra
         */
        public Producto buscarPorCodigo(char[] codigo)
        {
                Conversor conver = new Conversor();
                String comparar = conver.charToString(codigo);
                int contador = -1;
                boolean encontrado = false;
                INodo unNodo = this.listaProductos.getPrimero();
                while(unNodo != null && !encontrado)
                {
                        Comparable comp = (Comparable) comparar;
                        if(unNodo.getEtiqueta().equals(comp))
                        {
                                encontrado = true;
                                break;
                        }
                        unNodo = unNodo.getSiguiente();
                }
                if(encontrado)
                {
                        return (Producto) unNodo.getDato();
                }
                else
                {
                        return null;
                }
        }
        
        /**
         * Metodo que devuelve la cantidad de productos en la lista de productos
         * @return Número entero que representa la cantidad de productos en la lista
         */
        public int cantidadProductos()
        {
                return this.listaProductos.cantElementos();
        }
        
        /**
         * Cargar productos a la tienda desde un archivo
         * @param ruta Ruta de acceso al archivo
         */
        public void cargarArchivo(String ruta) throws IOException
        {
                ManejadorArchivo file = new ManejadorArchivo();
                Lista lineas = file.leerArchivo(ruta);
                INodo unNodo = lineas.getPrimero();
                Conversor conv = new Conversor();
                while(unNodo != null)
                {
                        String cadena = (String) unNodo.getDato();
                        String[] datos = cadena.split(",");
                        String nombre = datos[1];
                        char[] codigo = conv.strintToChar(datos[0]);
                        float precio =  Integer.parseInt(datos[2]);
                        int stock = Integer.parseInt(datos[3]);
                        Producto unProducto = new Producto(nombre,codigo,precio,stock);
                        this.incorporarProducto(unProducto);
                        unNodo = unNodo.getSiguiente();
                }
        }
        
        /**
         * Elimina productos desde un archivo dado
         * @param ruta Ruta del arhivo a analizar
         */
        public void eliminarArchivo(String ruta) throws IOException
        {
                ManejadorArchivo file = new ManejadorArchivo();
                Lista lineas = file.leerArchivo(ruta);
                INodo unNodo = lineas.getPrimero();
                Conversor conv = new Conversor();
                while(unNodo != null)
                {
                        
                        String cadena = (String) unNodo.getDato();
                        String[] datos = cadena.split(",");
                        char[] codigo = conv.strintToChar(datos[0]);
                        Comparable comp = (Comparable) datos[0];
                        if(this.buscarPorCodigo(codigo) != null)
                        {
                                this.listaProductos.eliminar(comp);
                        }
                        unNodo = unNodo.getSiguiente();   
                }
        }
        /**
         * Dado un archivo, procesa todas las ventas del mismo
         * @param ruta Ruta del arhivo a efectuar las ventas
         */
        public void venderArchivo(String ruta) throws IOException
        {
                ManejadorArchivo file = new ManejadorArchivo();
                Lista lineas = file.leerArchivo(ruta);
                INodo unNodo = lineas.getPrimero();
                Conversor conv = new Conversor();
                while(unNodo != null)
                {
                        String cadena = (String) unNodo.getDato();
                        String[] datos = cadena.split(",");
                        char[] codigo = conv.strintToChar(datos[0]);
                        Producto unProducto = this.buscarPorCodigo(codigo);
                        if(unProducto != null)
                        {
                                int cantidadVendida = Integer.parseInt(datos[1]);
                                int stockDisponible = unProducto.stock;
                                if(stockDisponible >= cantidadVendida)
                                {
                                        this.reducirStock(unProducto, cantidadVendida);
                                        Comparable elim = (Comparable) datos[0];
                                        this.listaProductos.eliminar(elim);
                                        this.incorporarProducto(unProducto);
                                }
                        }
                        unNodo = unNodo.getSiguiente();
                }
        }
}
