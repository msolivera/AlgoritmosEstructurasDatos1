/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geant;
public class Producto implements IProducto {
    
    /** Etiqueta del producto */
    private final Comparable etiqueta;
    
    /** Precio del producto */
    private Integer precio;
    
    /** Stock del producto */
    private Integer stock;
    
    /** Nombre del producto */
    private String nombre;
    
    /**
     * Constructor por defecto de la clase
     * @param etiqueta
     * @param precio
     * @param stock
     * @param nombre 
     */
    public Producto(Comparable etiqueta, Integer precio, Integer stock, String nombre) {
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
    }

    /**
     * Retorna etiqueta del producto
     * @return etiqueta
     */
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * Retorna precio del producto
     * @return precio
     */
    @Override
    public Integer getPrecio() {
        return this.precio;
    }

    /**
     * Define precio del producto
     * @param precio
     */
    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * Retorna stock del producto
     * @return stock
     */
    @Override
    public Integer getStock() {
        return this.stock;
    }

    /**
     * Define stock del producto
     * @param stock 
     */
    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Retorna nombre del producto
     * @return nombre
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Define nombre del producto
     * @param nombre 
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
