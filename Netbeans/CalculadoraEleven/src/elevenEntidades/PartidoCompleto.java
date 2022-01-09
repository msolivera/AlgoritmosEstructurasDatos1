
package elevenEntidades;

import elevenBasicArbolBB.TArbolBB;
import elevenBasicLista.*;

/**
 * Clase PartdidoCompleto (equivalente a match-standing)
 * @author Micaela Olivera
 */
public class PartidoCompleto implements IPartido {

    //identificador del partido

    private String idOdps;
    //informacion basica
    private final String fecha;
    private final String temporada;
    private final String liga;
    //identificadores de los equipos: local y visitante
    private final int localId;
    private final int visitanteId;
    //objetos equipo local y visitante
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    //lista de los jugadores del equipo local y visitante respectivamente
    public Lista<Jugador> jugadoresLocal;
    public Lista<Jugador> jugadoresVisitante;
    //vectores que guardan los id de los jugadores del equipo local y visitante
    public int[] jugadoresLocalId;
    public int[] jugadoresVisitanteId;
    /*vectores que guardan la formacion del equipo local y visitante respectivamente
     se encuentran insertados de forma tal que su indice coincide con el orden
     en que fueron insertados los id de los jugadores en el vector de jugadores.
     */
    public String[] posicionesLocal;
    public String[] posicionesVisitante;
    /*atributo que permite verificaciones sobre el estado 
     de filtro en que se encuentra el partido*/
    private int verificado;

    /**
     * Constructor de la clase
     *
     * @param fecha
     * @param temporada
     * @param liga
     * @param idLocal
     * @param idVisitante
     */
    public PartidoCompleto(String fecha, String temporada, String liga, int idLocal, int idVisitante) {

        this.fecha = fecha;
        this.temporada = temporada;
        this.liga = liga;
        this.localId = idLocal;
        this.visitanteId = idVisitante;
        jugadoresLocal = new Lista<>();
        jugadoresVisitante = new Lista<>();
        jugadoresLocalId = new int[11];
        jugadoresVisitanteId = new int[11];
        posicionesLocal = new String[11];
        posicionesVisitante = new String[11];
        this.verificado = 0;

    }

    /**
     * metodo que imprime la informacion detallada del partido
     */
    public void mostrarInfo() {
        System.out.println("PARTIDO");
        //verifica si el id del partido ya fue insertado o no
        if (this.idOdps != null) {
            System.out.println("Identificador: " + this.idOdps);
        }
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Temporara: " + this.temporada);
        System.out.println("Liga: " + this.liga);

        System.out.println("EQUIPOS: ");
        System.out.println(this.equipoLocal.getNombre() + " vs " + this.equipoVisitante.getNombre());
        System.out.println("Jugadores equipo: " + this.equipoLocal.getNombre());
        //Lista<Jugador> auxiliar = this.jugadoresLocal.inordenLista();
        Nodo<Jugador> aux = jugadoresLocal.getPrimero();
        //recorro la lista de jugadores del equipo local
        while (aux != null) {
            //imprimo informacion del jugador
            aux.getDato().infoReducido();
            aux = aux.getSiguiente();
        }
        //formacion del equipo local
        System.out.println("FORMACION:");
        for (int i = 0; i < posicionesLocal.length; i++) {
            System.out.println(posicionesLocal[i]);

        }
        System.out.println("Jugadores equipo: " + this.equipoVisitante.getNombre());
       // Lista<Jugador> auxiliar2 = this.jugadoresVisitante.inordenLista();
        Nodo<Jugador> aux2 = jugadoresVisitante.getPrimero();
        //recorro la lista de los jugadores del equipo visitante
        while (aux2 != null) {
            //imprimo la informacion
            aux2.getDato().infoReducido();
            aux2 = aux2.getSiguiente();
        }
        //formacion del equipo visitante
        System.out.println("FORMACION:");
        for (int i = 0; i < posicionesVisitante.length; i++) {
            System.out.println(posicionesVisitante[i]);

        }

    }

    /**
     * metodo que permite asignar un id al partido
     *
     * @param nuevoId
     */
    public void setId(String nuevoId) {

        this.idOdps = nuevoId;
    }

    /**
     * metodo que devuelve el id del partido
     *
     * @return
     */
    public String getId() {

        return this.idOdps;

    }

    /**
     * metodo que devuelve la fecha del partido
     *
     * @return
     */
    public String getFecha() {
        return this.fecha;
    }

    /**
     * metodo que devuelve la temporada del partido
     *
     * @return
     */
    public String getTemporada() {
        return this.temporada;
    }

    /**
     * metodo que devuelve la liga del partido
     *
     * @return
     */
    public String getLiga() {
        return this.liga;
    }

    /**
     * metodo que cambia el valor del atributo verificado el cual se utiliza
     * durante la depuracion de informacion
     */
    public void setVerificado() {
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
     * metodo que devuelve la lista de jugadores del equipo local
     *
     * @return
     */
    public Lista<Jugador> getJugadoresLocales() {
        return this.jugadoresLocal;
    }

    /**
     * metodo que devuelve la lista de los jugadores del equipo visitante
     *
     * @return
     */
    public Lista<Jugador> getJugadoresVisitantes() {
        return this.jugadoresVisitante;
    }

    /**
     * metodo que devuelve el vector que almacena los id de los jugadores del
     * equipo local
     *
     * @return
     */
    public int[] getJugadoresLocalesId() {
        return this.jugadoresLocalId;
    }

    /**
     * metodo que devuelve el vector que almacena los id de los jugadores del
     * equipo vistante
     *
     * @return
     */
    public int[] getJugadoresVisitanteId() {
        return this.jugadoresVisitanteId;
    }

    /**
     * metodo que devuelve el vector que almacena la formacion del equipo local
     *
     * @return
     */
    public String[] getPosicionesLocal() {
        return this.posicionesLocal;
    }

    /**
     * metodo que devuelve el vector que almacena la formacion del equipo
     * visitante
     *
     * @return
     */
    public String[] getPosicionesVisitante() {
        return this.posicionesVisitante;
    }

    /**
     * metodo que asigna al equipo local
     *
     * @param equipo
     */
    public void setEquipoLocal(Equipo equipo) {
        this.equipoLocal = equipo;
    }

    /**
     * metodo que asigna al equipo visitante
     *
     * @param equipo
     */
    public void setEquipoVisitante(Equipo equipo) {
        this.equipoVisitante = equipo;
    }

    /**
     * metodo que devuelve al equipo local
     *
     * @return
     */
    public Equipo getEquipoLocal() {
        return this.equipoLocal;
    }

    /**
     * metodo que devuelve al equipo visitante
     *
     * @return
     */
    public Equipo getEquipoVisitante() {
        return this.equipoVisitante;
    }

    /**
     * metodo que devuelve el id del equipo local
     *
     * @return
     */
    @Override
    public int getLocal() {
        return this.localId;
    }

    /**
     * metodo que devuelve el id del equipo visitante
     *
     * @return
     */
    @Override
    public int getVisitante() {
        return this.visitanteId;
    }

}
