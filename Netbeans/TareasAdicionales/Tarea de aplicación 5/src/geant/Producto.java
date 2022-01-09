package geant;

public class Producto implements IProducto{
    
    private String nombre;
    private final Comparable codigo;
    private Integer precio;
    private Integer stock;
    
    public Producto(String Nombre, Comparable Codigo, Integer Precio, int Stock){
        this.nombre = Nombre;
        this.codigo = Codigo;
        this.precio = Precio;
        this.stock = Stock;
    }
    
    @Override
    public Comparable getEtiqueta() {
        return this.codigo;
    }

    @Override
    public Integer getPrecio() {
        return this.precio;
    }

    @Override
    public void setPrecio(Integer Precio) {
        this.precio = Precio;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public void setStock(Integer Stock) {
        this.stock = Stock;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
}
