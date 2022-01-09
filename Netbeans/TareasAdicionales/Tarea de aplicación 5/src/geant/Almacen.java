package geant;


public class Almacen implements IAlmacen {
    
    private String direccion;
    private String telefono;
    private String nombre;
    private final Lista listaProductos = new Lista();
  
    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Lista getListaProductos() {
        return this.listaProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo nuevoNodo = new Nodo(unProducto, unProducto.getEtiqueta(), null);
        this.listaProductos.insertar(nuevoNodo);
    }

    @Override
    public boolean eliminar(Comparable Clave) {
        return this.listaProductos.eliminar(Clave);
    }

    @Override
    public Boolean agregarStock(Comparable Clave, Integer Cantidad) {
        INodo aux = listaProductos.buscar(Clave);
        if(aux == listaProductos.getPrimero()&& aux.compareTo(Clave)==0){
            IProducto producto = (IProducto) aux.getDato();
            Integer actualStock = producto.getStock();
            producto.setStock(actualStock+Cantidad);
            return true;
        }
        else{
            if(aux.getSiguiente()!=null){
                IProducto producto = (IProducto) aux.getSiguiente().getDato();
                Integer nuevoStock = producto.getStock()+Cantidad;
                producto.setStock(nuevoStock);
                INodo actual = aux.getSiguiente();
                actual.setDato(producto);
                return true;
            }
        return false;
        }
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        INodo aux = listaProductos.buscar(clave);
        Integer venta;
        if(aux == listaProductos.getPrimero()&& aux.compareTo(clave)==0){
            IProducto producto = (IProducto) aux.getDato();
            Integer actualStock = producto.getStock()-cantidad;
            producto.setStock(actualStock);
            
            venta = producto.getPrecio() * cantidad;
            return venta;
        }
        else{
            if(aux.getSiguiente()!=null){
                IProducto producto = (IProducto) aux.getSiguiente().getDato();
                Integer actualStock = producto.getStock()-cantidad;
                producto.setStock(actualStock);
                INodo actual = aux.getSiguiente();
                actual.setDato(producto);
                venta = producto.getPrecio() * cantidad;
                return venta;
            }
        }
        return 0;
    }

    @Override
    public IProducto buscarPorCodigo(Comparable clave) {
        INodo aux = listaProductos.buscar(clave);
        INodo primeroLista = listaProductos.getPrimero();
        if(aux.equals(primeroLista)){
            return (IProducto) primeroLista.getDato();
        }
        else{
            return (IProducto) aux.getSiguiente().getDato();
        }
    }
    
    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }
    
    @Override
    public void listarOrdenadoPorNombre() {
        INodo aux = listaProductos.getPrimero();
        int total = 0;
        Lista nombres = new Lista();
        while(aux!=null){
            IProducto producto = (IProducto) aux.getDato();
            INodo nodo = new Nodo(producto,producto.getNombre(),null);
            nombres.insertar(nodo);
            total += producto.getPrecio() * producto.getStock();
            aux = aux.getSiguiente();
        }
        
        INodo unNombre = nombres.getPrimero();
        while(unNombre!=null){
            IProducto productoNombre = (IProducto) unNombre.getDato();
            System.out.println(unNombre.getEtiqueta()+" "+productoNombre.getStock());
            unNombre = unNombre.getSiguiente();
        }
        System.out.println("El total gastado fue: " + total);
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet because products don´t have descriptions."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String imprimirProductos() {
        return this.listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return this.listaProductos.imprimir(separador);
    }
}
