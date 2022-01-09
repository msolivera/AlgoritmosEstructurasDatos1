package ta9;
public interface IAlmacen {

    
   
    /**
     * Incorporar un nuevo producto al supermercado.
     *
     * @param unProducto
     */
    public void insertarProducto(Producto unProducto);

    /**
     * Eliminar productos que ya no se venden (por no ser comercializados m�s).
     *
     * @param clave
     * @return
     */
    public boolean eliminarProducto(Comparable clave);

    /**
     * Imprime la lista de productos
     *
     * @return
     */
    public String imprimirProductos();

   
    public Boolean agregarStock(Comparable clave, Integer cantidad);

    public Integer agregarStock(Comparable clave, Integer cantidad, Boolean devolverCantidad);
    
    /**
     * Simular la venta de un producto (reducir el stock de un producto
     * existente
     *
     * @param clave
     * @param cantidad
     * @return
     */
    public Integer restarStock(Comparable clave, Integer cantidad);

    
    public Integer restarStock(Comparable clave, Integer cantidad, Boolean devolverCantidad);
    
    /**
     * Dado un código de producto, indicar las existencias del mismo en el
     * almac�n.
     *
     * @param clave
     * @return
     */
    public IProducto buscarPorCodigo(Comparable clave);
    
    public TArbolBB<Producto> getProductos();

   
    
}
