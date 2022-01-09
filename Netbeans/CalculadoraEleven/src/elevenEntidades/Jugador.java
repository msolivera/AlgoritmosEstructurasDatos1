
package elevenEntidades;

import elevenBasicLista.Lista;
import elevenBasicLista.Nodo;
import elevenBasicArbolBB.TArbolBB;

/**
 * Clase Jugador
 * @author Micaela Olivera
 */
public class Jugador implements IEntidadBase {

    private final int id;
    private final String nombre;
    private final Lista<Evento> susEvento;
    private final Lista<Liga> susLigas;

    /**
     * Constructor de la clase
     *
     * @param id
     * @param name
     */
    public Jugador(int id, String name) {

        this.id = id;
        this.nombre = name;
        this.susEvento = new Lista<>();
        this.susLigas = new Lista<>();

    }

    /**
     * Metodo que devuelve el valor del atributo id del jugador
     *
     * @return
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Metodo que devuelve el valor del atributo nombre del jugador
     *
     * @return
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que imprime la informacion detallada del jugador, asi como tambien
     * las ligas en las que participo, y la informacion detallada de todos los
     * eventos en los que participo.
     */
    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + this.id + " Nombre: " + this.nombre);
        //se corrobora previamente que la lista no este vacia
        if (!this.susEvento.esVacia()) {
            System.out.println("Participaciones: " + this.participaciones());
           // Lista<Evento> susEventos = this.susEvento.inordenLista();
            Nodo<Evento> evento = susEvento.getPrimero();
            //recorro la lista de eventos
            while (evento != null) {
                //imprimo la informacion de cada evento
                evento.getDato().mostrarInfo();
                evento = evento.getSiguiente();
            }
        }
        //se corrobora previamente que la lista no este vacia
        if (!this.susLigas.esVacia()) {
            System.out.println("LIGAS:");
           // Lista<Liga> ligas = this.susLigas.inordenLista();
            Nodo<Liga> liga = susLigas.getPrimero();
            //recorro la lista de ligas
            while (liga != null) {
                //imprimo la informacion de la liga
                liga.imprimirEtiqueta();
                liga = liga.getSiguiente();
            }
        }
    }

    /**
     * Metodo que imprime la informacion basica del jugador
     */
    public void infoReducido() {
        System.out.println("Nombre: " + this.nombre);
    }

    /**
     * Metodo encargado de imprimir solamente el nombre del jugador y las ligas
     * para las que jugo.
     * @return 
     */
    public String infoLigas() {
        String res = "";
        //se corrobora previamente que la lista no este vacia
        if (!this.susLigas.esVacia()) {
            Nodo<Liga> liga = susLigas.getPrimero();
            //recorro la lista de ligas
            while (liga != null) {
                
                res = liga.getDato().mostrarInfo();
                liga = liga.getSiguiente();
            }
        } else {
            //se imprime este mensaje en caso de que el jugador no tenga ligas asociadas.
            res = "Sin informacion Relacionada.";
        }
        return res;
    }

    /**
     * Retorna la lista de eventos en los que participo el jugador
     *
     * @return
     */
    public Lista<Evento> susEventos() {
        return this.susEvento;
    }

    /**
     * retorna la lista de las ligas en las que participo el jugador.
     *
     * @return
     */
    public Lista<Liga> susLigas() {
        return this.susLigas;
    }

    /**
     * Metodo encargado de contar la cantidad de eventos que estan asociados al
     * jugador. Retorna la cantidad de eventos en de la lista de eventosd el
     * jugador.
     *
     * @return
     */
    public int participaciones() {
        if(!susEvento.esVacia()){
            return this.susEvento.cantElementos();
        }else{
            return 0;
        }
        
    }

    /**
     * Metodo encargado de buscar en cada uno de los eventos de la lista
     * susEventos de jugador a aquellos en los que se encuentra un Gol. Retorna
     * el numero de eventos en los que el jugador efectuo goles.
     *
     * @return
     */
    public float cantidadDeGoles() {
        float resultado = 0;
        //se verifica si la lista esta vacia
        if (susEvento.esVacia()) {
            return resultado;
        }
        //Lista<Evento> eventos = this.susEvento.inordenLista();
            Nodo<Evento> evento = susEvento.getPrimero();
        //recorro la lista 
        while (evento != null) {
            //busco los eventos en los que exista un gol
            if (evento.getDato().getGol() == 1.0) {
                //sumo uno a la variable
                resultado++;
            }
            evento = evento.getSiguiente();
        }

        return resultado;

    }

}
