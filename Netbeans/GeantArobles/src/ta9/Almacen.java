package ta9;


public class Almacen implements IAlmacen {
    
    private String direccion;
    private String telefono;
    private String nombre;
    private final TArbolBB<Producto> arbolProductos = new TArbolBB();
  
    
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
    public TArbolBB getArbolProductos() {
        return this.arbolProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        TElementoAB<Producto> nuevoElemento = new TElementoAB(unProducto.getEtiqueta(), unProducto);
        this.arbolProductos.insertar(nuevoElemento);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return this.arbolProductos.eliminar(clave);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> aux = arbolProductos.buscar(clave);
        if(aux==null){
            return false;
        }else{ 
            IProducto producto = (IProducto) aux.getDatos();
            Integer actualStock = producto.getStock();
            producto.setStock(actualStock+cantidad);
            return true;
        }
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> aux = arbolProductos.buscar(clave);
        if(aux==null){
            return 0;
        }else{ 
            //IProducto producto = (IProducto) aux.getDatos();
              Producto producto= aux.getDatos();
            Integer actualStock = producto.getStock()-cantidad;
            if(actualStock>0){
                producto.setStock(actualStock);
                return producto.getPrecio() * cantidad;
            }else{
                this.arbolProductos.eliminar(clave);
                return producto.getPrecio()*producto.getStock();
            }
        }
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB<Producto> aux = arbolProductos.buscar(clave);
        if(aux != null){
            return aux.getDatos();
        }
        else{
            return null;
        }
    }
    
    @Override
    public int cantidadProductos() {
        return arbolProductos.obtenerTamanio();
    }
    
    @Override
    public void listarOrdenadoPorNombre() { //inserto ordenado por nombre en otra lista
        TArbolBB arbolOrdenadoResultado = new TArbolBB();
        arbolEtiquetaEsNombre(this.arbolProductos.getRaiz(),arbolOrdenadoResultado);
        String productos = arbolOrdenadoResultado.inOrden();
        String[] variosProductos = productos.split(",");
        for(String unProducto:variosProductos){
            System.out.println(unProducto);

        }
    }
    
    public void arbolEtiquetaEsNombre(TElementoAB<Producto> elemento,TArbolBB arbol){
        if(arbol.buscar(elemento.getEtiqueta())==null){
            Producto producto = elemento.getDatos();
            arbol.insertar(new TElementoAB(producto.getNombre().trim()+", Stock: "+producto.getStock(),producto));
        }
        if(elemento.getHijoIzq()!=null){
            arbolEtiquetaEsNombre(elemento.getHijoIzq(),arbol);
        }
        if(elemento.getHijoDer()!=null){
            arbolEtiquetaEsNombre(elemento.getHijoDer(),arbol);
        }
    }
    
    public int cantidadDeStock(){
        
        TElementoAB<Producto> raiz = this.arbolProductos.getRaiz();
        
        return this.contarStock(raiz);
    }
    
    private int contarStock(TElementoAB<Producto> producto){
        
        if (producto.getHijoIzq() != null) {
            return producto.getDatos().getStock() + contarStock(producto.getHijoIzq());
        }
        if (producto.getHijoDer() != null) {
            return producto.getDatos().getStock() + contarStock(producto.getHijoDer());
        }
        return producto.getDatos().getStock();
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet because products don´t have descriptions."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String imprimirProductos() {
        return this.arbolProductos.preOrden();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return this.arbolProductos.preOrdenConSeparador(separador);
    }
}
