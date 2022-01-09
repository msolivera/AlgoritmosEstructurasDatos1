
package elevenCode;

/**
 * Clase Equipo
 * @author Micaela Olivera
 */
public class Equipo {

    private final int id;
    private final String nombre;
    /**
     * Constructor de la clase
     * @param id
     * @param name 
     */
    public Equipo(int id, String name) {

        this.id = id;
        this.nombre = name;
    }
    /**
     * metodo que devuelve el valor del atributo id
     * @return 
     */
    public int getId() {
        return this.id;
    }
    /**
     * metodo que devuleve el valor del atributo nombre
     * @return 
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Metodo que imprime la informacion del equipo
     */
    public void mostrarInfo() {
        System.out.println("Id: " + this.id);
        System.out.println("Nombre: " + this.nombre);
    }

}
