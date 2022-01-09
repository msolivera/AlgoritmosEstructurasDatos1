
package elevenCode;

/**
 * Clase Partido (equivalente a Matches)
 * @author Micaela Olivera
 */
public class Partido {

    private final String idOdps;
    private final String fecha;
    private final String temporada;
    private final String liga;
    private final int equipoLocalId;
    private final int equipoVisitanteId;

    /**
     * Constructor de la clase
     * @param idOdsp
     * @param date
     * @param league
     * @param season
     * @param equipo1
     * @param equipo2 
     */
    public Partido(String idOdsp, String date, String league, String season, int equipo1, int equipo2) {

        this.idOdps = idOdsp;
        this.fecha = date;
        this.temporada = season;
        this.liga = league;
        this.equipoLocalId = equipo1;
        this.equipoVisitanteId = equipo2;

    }
    /**
     * Metodo encargado de imprimir la informacion detallada del partido
     */
    public void mostrarInfo() {
        System.out.println("ID: " + this.idOdps);
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Temporada: " + this.temporada);
        System.out.println("Liga: " + this.liga);
        System.out.println("Equipos:");
        System.out.println(this.equipoLocalId + " vs " + this.equipoVisitanteId);

    }
    /**
     * Metodo que devuelve el id del partido
     * @return 
     */
    public String getId() {
        return this.idOdps;
    }
    /**
     * metodo que devuelve la fecha del partido
     * @return 
     */
    public String getFecha() {
        return this.fecha;
    }
    /**
     * metodo que devuelve la temporada del partido
     * @return 
     */
    public String getTemporada() {
        return this.temporada;
    }
    /**
     * metodo que devuelve la liga del partido
     * @return 
     */
    public String getLiga() {
        return this.liga;
    }
    /**
     * devuelve el id del equipo local
     * @return 
     */
    public int getLocal() {

        return this.equipoLocalId;
    }
    /**
     * devuelve el id del equipo visitante
     * @return 
     */
    public int getVisitante() {

        return this.equipoVisitanteId;
    }

}
