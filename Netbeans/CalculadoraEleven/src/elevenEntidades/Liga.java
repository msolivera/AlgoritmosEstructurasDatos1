
package elevenEntidades;

/**
 * Clase Liga
 * @author Micaela Olivera
 */
public class Liga {

    private final String id;

    /**
     * Constructor de la clase
     *
     * @param id
     */
    public Liga(String id) {

        this.id = id;

    }

    /**
     * Metodo que retorna el valor de latributo id de la liga
     *
     * @return
     */
    public String getId() {
        return this.id;
    }

    public String mostrarInfo() {
        String res = "";

        res = this.id;
        return res;
    }
}
