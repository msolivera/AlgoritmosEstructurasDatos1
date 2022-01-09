package UT4.TA9;

import UT3.TA4.Conversor;
import UT3.TA4.INodo;
import UT3.TA4.Nodo;

public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;

    private TArbolBB<Producto> productos;

    public Almacen(String nombre) 
    {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }
    /**
     * Metodo encargado de insertar un producto en el almacen
     * @param unProducto Producto a insertar
     */
    public void insertarProducto(Producto unProducto) 
    {
        
        IElementoAB unElemento = new TElementoAB(unProducto.getEtiqueta(), unProducto);
        productos.insertar(unElemento);
    }
    /**
     * Metodo encargado de imprimir por pantalla de forma detallada todos los productos que hay en almacen
     * @return Cadena con la representacion (toString) de cada producto
     */
    @Override
    public String imprimirProductos() 
    {
            String resultado = "";
            String inordenStr = this.productos.inOrden();
            System.out.println(inordenStr);
            String[] datos = inordenStr.split("-");
            for(String clave : datos)
            {
                    IElementoAB<Producto> producto = this.productos.buscar(clave);
                    System.out.println("Nombre: " + producto.getDatos().getNombre());
                    System.out.println("Etiqueta: " + producto.getDatos().getEtiqueta());
                    System.out.println("Precio: " + producto.getDatos().getPrecio());
                    System.out.println("Stock: " + producto.getDatos().getStock());
                    System.out.println("##################################################");
                    resultado += producto.getDatos().toString();
            }
            return resultado;
    }
    /**
     * Metodo encargado de agregar stock a un determinado producto en el almacen
     * @param clave (String) clave del producto que se desea añadir stock 
     * @param cantidad (Integer) cantidad de stock a añadir
     * @return 
     */
    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        IElementoAB<Producto> elemento = this.productos.buscar(clave); 
        
        if ( elemento != null){
            
           Integer stock = elemento.getDatos().getStock();
           elemento.getDatos().setStock(stock+cantidad);
           Integer ganancia = elemento.getDatos().getStock() * elemento.getDatos().getPrecio();
            System.out.println("Ganancia futura: "+ganancia);
            return true;
        }
        else
            return false;
       
        
    }
    /**
     * Metodo encargado de quitar stock a un determinado producto
     * @param clave (String) representación del producto a quitar stock
     * @param cantidad Cantidad de stock a quitar del producto
     * @return 
     */
    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        if (this.productos.buscar(clave) != null){
            Integer stock = this.productos.buscar(clave).getDatos().getStock();
            if (stock >= cantidad){
                this.productos.buscar(clave).getDatos().setStock(stock-cantidad);
                return this.productos.buscar(clave).getDatos().getStock();
            }
            else{
                this.productos.buscar(clave).getDatos().setStock(0);
                return 0;
            }
        }
        return null;
        
    }
    /**
     * Metodo que busca un producto dado su codigo
     * @param clave (String) codigo del producto buscado
     * @return (IProducto) buscado si lo encuentra / null si no se encuentra
     */
    @Override
    public IProducto buscarPorCodigo(Comparable clave) 
    {
            IProducto prod = null;
            IElementoAB<Producto> elem = this.productos.buscar(clave);
            if(elem != null)
            {
                    prod = new Producto(elem.getDatos().getEtiqueta(), elem.getDatos().getNombre());
                    prod.setPrecio(elem.getDatos().getPrecio());
                    prod.setStock(elem.getDatos().getPrecio());
            }
            return prod;
    }
    /**
     * Metodo encargado de eliminar un producto por completo del almacen
     * @param clave (String) del codigo de producto que se desea eliminar
     * @return Verdadero si se ha encontrado y eliminado con exito el producto. Falso si no ha sido asi
     */
    @Override
    public boolean eliminarProducto(Comparable clave) 
    {
            IElementoAB<Producto> elem = this.productos.buscar(clave);
            if(elem != null)
            {
                    System.out.println("Ganancia perdida: " + elem.getDatos().getPrecio() * elem.getDatos().getStock());
                    this.productos.eliminar(clave);
                    return true;
            }
            else
            {
                    System.out.println("Producto no encontrado.");
                    return false;
            }
    }
    /**
     * Metodo encargado de vender cantidades de un producto
     * @param clave (Sring) Clave del producto que se desea vender
     * @param cantidad Cantidad de unidades que se desean vender
     */
    public void vender(Comparable clave, int cantidad)
    {
            IElementoAB<Producto> elem = this.productos.buscar(clave);
            
            if(elem != null)
            {
                    if(elem.getDatos().getStock() >= cantidad)
                    {
                            elem.getDatos().setStock(elem.getDatos().getStock() - cantidad);
                            System.out.println("Se han vendido: " + cantidad + " productos");
                            int ganancia = cantidad * elem.getDatos().getPrecio();
                            System.out.println("Ganancias: " + ganancia);
                    }
                    else
                    {
                            System.out.println("Se han vendido: " + elem.getDatos().getStock() + " unidades");
                            int ganancia = elem.getDatos().getStock() * elem.getDatos().getPrecio();
                            System.out.println("Ganancia: " + ganancia);
                    }
            }
            else
            {
                    System.out.println("El producto no se encuentra en el almacen!");
            }
    }


   
 
   


  

   

   

   

}
