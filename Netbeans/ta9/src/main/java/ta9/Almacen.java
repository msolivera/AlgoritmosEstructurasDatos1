package ta9;

public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;

    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    public TArbolBB<Producto> getProductos() {
        return productos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        IElementoAB<Producto> producto = new TElementoAB(unProducto.getEtiqueta(), unProducto);
        IElementoAB<Producto> encontrado = productos.buscar(unProducto.getEtiqueta());
        if (encontrado == null) {
            productos.insertar(producto);
        } else {
            Producto p = encontrado.getDatos();
            agregarStock(p.getEtiqueta(), unProducto.getStock());
        }
    }

    @Override
    public String imprimirProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        IElementoAB<Producto> prod = productos.buscar(clave);
        if (prod == null) {
            return false;
        }
        prod.getDatos().setStock(cantidad);
        return true;
    }

    @Override
    public Integer agregarStock(Comparable clave, Integer cantidad, Boolean devolverCantidad) {
        IProducto producto = buscarPorCodigo(clave);
        if (producto != null) {
            agregarStock(clave, cantidad);
            Integer precio = producto.getPrecio();
            return cantidad * precio;
        }
        return 0;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        int cant = 0;
        IElementoAB<Producto> elem = productos.buscar(clave);
        if (elem != null) {

            cant = elem.getDatos().restarStock(cantidad) * elem.getDatos().getPrecio();
        }
        return cant;

    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad, Boolean devolverCantidad) {
        IProducto producto = buscarPorCodigo(clave);
        if (producto != null) {
            restarStock(clave, cantidad);
            Integer precio = producto.getPrecio();
            return cantidad * precio;
        }
        return 0;
    }

    @Override
    public IProducto buscarPorCodigo(Comparable clave) {
        IElementoAB<Producto> nuevo = this.productos.buscar(clave);
        if (nuevo != null) {
            return nuevo.getDatos();
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        IElementoAB producto = productos.buscar(clave);
        if (producto != null) {
            productos.eliminar(clave);
            producto = productos.buscar(clave);
            if (producto == null) {
                return true;
            }
        }
        return false;
    }

}
