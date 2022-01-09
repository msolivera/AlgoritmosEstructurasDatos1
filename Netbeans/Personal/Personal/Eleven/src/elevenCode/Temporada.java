
package elevenCode;

/**
 * Clase Temporada
 * @author Micaela Olivera
 */
public class Temporada {

    private final String id;

    /**
     * Constructor de la clase
     * @param id 
     */
    public Temporada(String id) {

        this.id = id;
    }
    /**
     * Retorna el valor de su atributo id
     * @return 
     */
    public String getId() {
        return this.id;

    }
    /**
     * metodo encargado de mostrar la informacion de
     * la temporada
     */
    public void mostrarInfo() {
        System.out.println("Identificador: " + this.id);
    }

}
