package UT4.TA9;
public class Producto implements IProducto {
    
    private Comparable etiqueta;
    private String nombre;
    private Integer precio;
    private Integer stock;

    public Producto(Comparable etiqueta, String nombre) 
    {
        this.etiqueta = etiqueta;
        this.nombre = nombre;
        this.stock = 0;
        this.precio = 0;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Integer getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return stock;
    }
    /**
     * Agregar stock existencias de stock a este producto
     * @param stock Cantidad que se va a agregar
     */
    public void agergarStock(Integer stock) {
        this.stock += stock;
    }
    
// restarStock devolverá -1 si se pretende extraer más de lo que hay... 
    // y el campo stock quedará inalterado
    /**
     * Metodo que quita stock a este producto
     * @param stock Cantidad de unidades a quitar de este producto
     * @return valor de stock actualizado si es correcto / -1 si se desea quitar mas unidades de las que existen
     */
    public Integer restarStock(Integer stock) {
        if (stock > this.stock) {
            return -1;
        } else {
            setStock(this.stock - stock);
            return this.stock;
        }
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

}
