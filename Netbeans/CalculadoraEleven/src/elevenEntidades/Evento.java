
package elevenEntidades;

/**
 * Clase Evento
 * @author Micaela Olivera
 */
public class Evento {

    private String temporada;
    //identificadores:
    private final String idPartido;
    private final String idEvento;
    //equipos protagonistas (nombres):
    private final String equipoEvento;
    private final String oponente;
    ////equipos protagonistas (identificadores):
    private int idEquipoEvento;
    private int idOponente;
    //jugador protagonista del evento nombre e id:
    private final String jugador;
    private int idJugador;
    //atributos que permiten los calculos:
    private final float tipoEvento;
    private final String resultadoJugada;
    private final float gol;
    private final float ladoCancha;
    /*atributos que permiten verificaciones sobre el estado 
     de filtro en que se encuentra el evento. 
     */
    private int verificado;
    private int equiposTransformados;
    private int jugadorTransformado;

    /**
     * Constructor de la clase
     *
     * @param idOdsp
     * @param id 
     * @param eventType1
     * @param eventTeam
     * @param opponent
     * @param player
     * @param shotOutCome
     * @param isGoal
     * @param side
     */
    public Evento(String idOdsp, String id, float eventType1, String eventTeam,
            String opponent, String player, String shotOutCome, float isGoal, float side) {

        this.idPartido = idOdsp;
        this.idEvento = id;
        this.tipoEvento = eventType1;
        this.equipoEvento = eventTeam;
        this.oponente = opponent;
        this.jugador = player;
        this.resultadoJugada = shotOutCome;
        this.gol = isGoal;
        this.ladoCancha = side;
        this.verificado = 0;
        this.equiposTransformados = 0;
        this.jugadorTransformado = 0;

    }

    /**
     * metodo que devuelve el id del evento
     *
     * @return
     */
    public String getId() {
        return this.idEvento;
    }

    /**
     * metodo que devuelve el id del partido al que pertenece el evento
     *
     * @return
     */
    public String getIdPartido() {
        return this.idPartido;
    }

    /**
     * metodo que imprime la informacion detallada del evento
     */
    public void mostrarInfo() {
        System.out.println("ID de partido: " + this.idPartido + " ID de evento: " + this.idEvento);
        System.out.println("Equipos: " + this.equipoEvento + " vs " + this.oponente);
        System.out.println("Identificadores: " + this.idEquipoEvento + " vs " + this.idOponente);
        System.out.println("PROTAGONISTA " + this.jugador + " = " + this.idJugador);
        //verifica si la temporada ya se agrego o no al evento.
        if (!(temporada==null)) {
            System.out.println("Temporada: " + this.temporada);
        }else{
            System.out.println("sin datos de temporada");
        }

    }

    /**
     * metodo que cambia el valor del atributo verificado el cual se utiliza
     * durante la depuracion de informacion
     */
    public void setVerificadoUno() {
        this.verificado = 1;
    }

    /**
     * retorna el valor del atributo verificado el cual puede tener un valor
     * cero o uno
     *
     * @return
     */
    public int getVerificado() {
        return this.verificado;
    }

    /**
     * metodo que cambia el valor del atributo equiposTransformados el cual se
     * utiliza durante la depuracion de informacion para obtener el id de los
     * equipos dados sus nombres.
     */
    public void setEquiposTransformados() {
        this.equiposTransformados = 1;
    }

    /**
     * metodo que cambia el valor del atributo equiposTransformados el cual se
     * utiliza durante la depuracion de informacion para obtener el id de los
     * equipos dados sus nombres.
     */
    public void setEquiposTransformadosCero() {
        this.equiposTransformados = 0;
    }

    /**
     * metodo que devuelve el valor del atributo de control
     * equiposTransformados.
     *
     * @return
     */
    public int getEquiposTransformados() {
        return this.equiposTransformados;
    }

    /**
     * metodo que cambia el valor del atributo jugadorTransformado el cual se
     * utiliza durante la depuracion de informacion para obtener el id del
     * jugador dado su nombre.
     */
    public void setJugadorTransformado() {
        this.jugadorTransformado = 1;
    }

    /**
     * metodod que devuelve el valor del atributo de control jugadorTransformado
     *
     * @return
     */
    public int getJugadorTransformado() {
        return this.jugadorTransformado;
    }

    /**
     * metodo que retorna el nombre del equipo protagonista del evento
     *
     * @return
     */
    public String getEquipoEvento() {
        return this.equipoEvento;
    }

    /**
     * metodo que permite asignar el id del equipo protagonista
     *
     * @param id
     */
    public void setIdEquipoEvento(int id) {
        this.idEquipoEvento = id;
    }

    /**
     * metodo que retorna el id del equipo protagonista del evento
     *
     * @return
     */
    public int getEquipoEventoId() {
        return this.idEquipoEvento;
    }

    /**
     * metodo que retorna el nombre del equipo oponente del evento
     *
     * @return
     */
    public String getOponente() {
        return this.oponente;
    }

    /**
     * metodo que permite asignar el id del equipo oponente
     *
     * @param id
     */

    public void setOponente(int id) {
        this.idOponente = id;
    }

    /**
     * metodo que retorna el id del equipo oponente del evento
     *
     * @return
     */
    public int getOponenteId() {
        return this.idOponente;
    }

    /**
     * metodo que devuelve el nombre del jugador del evento
     *
     * @return
     */
    public String getJugador() {
        return this.jugador;
    }

    /**
     * metodo que permite asignar el id del jugador
     *
     * @param id
     */
    public void setJugador(int id) {
        this.idJugador = id;
    }

    /**
     * metoro que retorna el id del jugador del evento
     *
     * @return
     */
    public int getIdJugador() {
        return this.idJugador;
    }

    /**
     * retorna el valor del atributo gol del evento
     *
     * @return
     */
    public float getGol() {
        return this.gol;
    }

    /**
     * metodo que permite asignarle al evento una temporada
     *
     * @param temporada
     */
    public void setTemporada(String temporada) {
        this.temporada = temporada;

    }

    /**
     * metodo que devuelve la temporada del evento
     *
     * @return
     */
    public String getTemporada() {
        return this.temporada;
    }

    /**
     * metodo que devuelve el valor de la variable del tipo de evento
     *
     * @return
     */
    public float getTipoEvento() {
        return this.tipoEvento;
    }

    /**
     * metodo que devuelve el valor de la variable shotOutCome
     *
     * @return
     */
    public String resultadoJugada() {
        return this.resultadoJugada;
    }
    /**
     * Metodo que devuelve el valor de la variable side
     * @return 
     */
    public float getLadoCancha(){
        return this.ladoCancha;
    }

}
