package elevenEntidades;

import elevenBasicArbolBB.TArbolBB;
import elevenBasicArbolBB.TElementoAB;
import elevenBasicLista.Lista;
import elevenBasicLista.Nodo;


/**
 * Clase encargada de cargar toda la informacion y realizar todos los calculos
 * sobre los datos.
 *
 * @author Micaela Olivera
 */
public class ElevenCalculador implements IElevenCalculador {

    //listas con las cargas iniciales con datos crudos

    private final TArbolBB<Jugador> arbolJugadores; //referente al archivo players

    private final TArbolBB<Equipo> arbolEquipos; //referente al archivo teams

    private final TArbolBB<Partido> arbolPartidos; //referente al archivo metches

    private TArbolBB<PartidoCompleto> arbolPartidosCompletos; //referente al archivo match-standing

    private TArbolBB<Evento> arbolEventos; //referente al archivo events

    private final Lista<Liga>listaLigas; //se crean a partir de los datos ya cargados
    private final Lista<Temporada> listaTemporadas;//se crean a partir de los datos ya cargados  
    private final TArbolBB<Jugador> eleven;

    /**
     * Constructor de la clase
     */
    public ElevenCalculador() {

        this.arbolJugadores = new TArbolBB();
        this.arbolEventos = new TArbolBB();
        this.arbolEquipos = new TArbolBB();
        this.arbolPartidos = new TArbolBB();
        this.arbolPartidosCompletos = new TArbolBB();
        this.listaLigas = new Lista<>();
        this.listaTemporadas = new Lista<>();
        this.eleven = new TArbolBB();


    }

    public TArbolBB<Jugador> getArbolJugadores() {
        return arbolJugadores;
    }

    public TArbolBB<Equipo> getArbolEquipos() {
        return arbolEquipos;
    }

    public TArbolBB<Partido> getArbolPartidos() {
        return arbolPartidos;
    }

    public TArbolBB<PartidoCompleto> getArbolPartidosCompletos() {
        return arbolPartidosCompletos;
    }

    public TArbolBB<Evento> getArbolEventos() {
        return arbolEventos;
    }

    public Lista<Liga> getListaLigas() {
        return listaLigas;
    }

    public Lista<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }

//public void setArbolPartidosCompletos (TArbolBB<PartidoCompleto> unArbol){
public void setArbolPartidosCompletos (TArbolBB<PartidoCompleto> unArbol){
    this.arbolPartidosCompletos = unArbol;
}

//public void setArbolEventos (TArbolBB <Evento>unArbol){
public void setArbolEventos (TArbolBB <Evento>unArbol){
    this.arbolEventos = unArbol;
}
    public TArbolBB<Jugador> getEleven() {
        return eleven;
    }

    /**
     * Metodo que imprime toda la informacion de los jugadores
     */
    @Override
    public void imprimirJugadores() {
        
        //verifico si la lista es vacia
        if (arbolJugadores.esVacio()) {
            System.out.println("arbol vacio");
        }
        Lista<Jugador> auxiliar = this.arbolJugadores.inOrden();
        Nodo<Jugador> aux = auxiliar.getPrimero();
        //recorro lista de jugadores
        while (aux != null) {
            //imprimo informacion
            aux.getDato().mostrarInfo();
            aux = aux.getSiguiente();
        }
    }
    /**
     * Metodo que imprime toda la informacion de los equipos
     */
    @Override
    public void imprimirEquipos() {
        //verifico si la lista es vacia
        if (arbolEquipos.esVacio()) {
            System.out.println("arbol vacia");
        }
        
        Lista<Equipo> auxiliar = this.arbolEquipos.inOrden();
        Nodo<Equipo> aux = auxiliar.getPrimero(); 
        //recorro lista de equipos
        while (aux != null) {
            //imprimo informacion
            aux.getDato().mostrarInfo();
            aux = aux.getSiguiente();
        }

    }
    /**
     * Metodo que imprime toda la informacion de los partidos (matches)
     */
    @Override
    public void imprimirPartidos() {
         //verifico si la lista es vacia
        
        if (arbolPartidos.esVacio()) {
            System.out.println("arbol vacia");
        }
         Lista<Partido> auxiliar = this.arbolPartidos.inOrden();
        Nodo<Partido> aux = auxiliar.getPrimero(); 
        //recorro lista de partidos
        while (aux != null) {
            //imprimo informacion
            aux.getDato().mostrarInfo();
            aux = aux.getSiguiente();
        }

    }
    /**
     * Metodo que imprime la informacion de los partidos Completos (match-standings)
     */
    public void imprimirPartidosCompletos() { //cambiar para que imprima los valores finales
        //verifico si la lista es vacia

        if (arbolPartidosCompletos.esVacio()) {
            System.out.println("arbol vacia");
        }
        //recorro lista de partidos
        Lista<PartidoCompleto> auxiliar = this.arbolPartidosCompletos.inOrden();
        Nodo<PartidoCompleto> aux = auxiliar.getPrimero();
        while (aux != null) {
            //imprimo informacion
            aux.getDato().mostrarInfo();
            aux = aux.getSiguiente();
        }

    }

    /**
     * Metodo que imprime la informacion de los eventos
     */
    @Override
    public void imprimirEventos() {
        //verifico si la lista es vacia
        
        if (arbolEventos.esVacio()) {
            System.out.println("lista vacia");
        }
        //recorro lista de eventos
        Lista<Evento> auxiliar = this.arbolEventos.inOrden();
        Nodo<Evento> aux = auxiliar.getPrimero();
        while (aux != null) {
            //imprimo informacion
            aux.getDato().mostrarInfo();
            aux = aux.getSiguiente();

        }
    }
    /**
     * Metodo que imprime la informacion de las ligas
     */
    public void imprimirLigas() {
        //verifico si la lista es vacia
        
        if (listaLigas.esVacia()) {
            System.out.println("lista vacia");
        }
        //recorro lista de ligas      
        Nodo<Liga> aux = listaLigas.getPrimero();
        while (aux != null) {
            //imprimo informacion
            aux.getEtiqueta();
            aux = aux.getSiguiente();

        }

    }

    /**
     * Metodo que imprime la informacion de las temporadas
     */
    public void imprimirTemporadas() {
        //verifico si la lista es vacia

        if (listaTemporadas.esVacia()) {
            System.out.println("arbol vacio");
        }
        //recorro lista de temporadas
        Nodo<Temporada> aux = listaTemporadas.getPrimero();
        while (aux != null) {
            //imprimo informacion
            aux.getDato().mostrarInfo();
            aux = aux.getSiguiente();

        }

    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadEquipos() {
        return this.arbolEquipos.obtenerTamanio();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadJugadores() {
        return this.arbolJugadores.obtenerTamanio();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadPartidos() {
        return this.arbolPartidos.obtenerTamanio();
    }

       public int cantidadPartidosCompletos() {
        return this.arbolPartidosCompletos.obtenerTamanio();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadEventos() {
        return this.arbolEventos.obtenerTamanio();
    }
  
    /**
     * Metodo que retorna la cantidad de elementos de la lista
     * @return 
     */
    public int cantidadLigas() {
        return this.listaLigas.cantElementos();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadTemporadas() {
        return this.listaTemporadas.cantElementos();
    }

    /**
     * Metodo que dada una lista recibida por parametro,
     * devuelve el jugador que tiene mas eventos asociados.
     * @param listaJugadores
     * @return 
     */
    public Nodo<Jugador> masParticipacion(Lista<Jugador> listaJugadores) {
       // if (listaJugadores.esVacia() || listaJugadores == null) {
          //  System.out.println("No se encuentra informacion");
        //}
       
      //  Lista<Jugador> lista = arbol.inordenLista();
        Nodo<Jugador> jugador = listaJugadores.getPrimero();
        //creo un objeto auxiliar para poder crear el nodo resultante
        Jugador auxilar = new Jugador(0, "auxilar");
        //nodo que guardara el valor del jugador con mas eventos
        Nodo<Jugador> resultante = new Nodo(auxilar.getId(), auxilar);
        //recorro la lista recibida
        while (jugador != null) {
            //por cada jugador obtengo la cantidad de participaciones (eventos asociados)
            int variable = jugador.getDato().participaciones();
            //verifico si las participaciones del dato del nodo resultante son menores que las participaciones del jugador encontrado
            if (resultante.getDato().participaciones() < variable) {
                //en caso positivo seteo el dato del nodo resultamte y guardo el correspondiente al jugador
                resultante.setDato(jugador.getDato());
            }

            jugador = jugador.getSiguiente();
        }

        //devuelvo como resultado el nodo cuyo dato almacena al jugador con mayor cantidad de eventos asociados
        return resultante;

    }
    /**
     * Metodo que dada una temporada recibida por parametros
     * devuelve el nombre del jugador que mas eventos asociados tiene
     * por cada una de las ligas existentes
     * @param temporada 
     */
    @Override
    public void masParticipacionPorTemporada(String temporada) {
        System.out.println("LOS MEJORES JUGADORES DE LA TEMPORADA " + temporada + " SON:");
        //verifico si la temporada recibida es valida o no
        if (this.listaTemporadas.buscar(temporada) == null) {
            System.out.println("no hay informacion para la temporada " + temporada);
        } else {
            Nodo<Liga> liga = this.listaLigas.getPrimero();
            //recorro las ligas
            while (liga != null) {
                //guardo en una variable el nombre de la liga
                String ligaNombre = liga.getEtiqueta().toString();
                //creo una lista de jugadores para almacenar los jugadores uqe pertenecen en la liga
                Lista<Jugador> resultados = new Lista<>();
                Lista<PartidoCompleto> listaPartidosCompletos = this.arbolPartidosCompletos.inOrden();
                Nodo<PartidoCompleto> partido = listaPartidosCompletos.getPrimero();
                //recorro los partidos
                while (partido != null) {
                    //verifico si la temporada del partido coincide con la recibida por parametro
                    if (partido.getDato().getTemporada().equals(temporada)) {
                        //verifico si la liga del partido coincide con la liga que se esta recorriendo
                        if (partido.getDato().getLiga().equals(ligaNombre)) {
                            //clonar el nodo del jugador de la lista de jugadores locales del partido, que tenga mas eventos asociados
                            Nodo<Jugador> local = masParticipacion(partido.getDato().getJugadoresLocales()).clonar();
                            //clonar el nodo del jugador de la lista de jugadores visitantes del partido, que tenga mas eventos asociados
                            Nodo<Jugador> Visitante = masParticipacion(partido.getDato().getJugadoresVisitantes()).clonar();
                            //agrego ambos nodos a la lista de resultados
                            Nodo unLocal = new Nodo(local.getEtiqueta(),local.getDato());
                            Nodo unVisitante = new Nodo(Visitante.getEtiqueta(),Visitante.getDato());
                            resultados.insertar(unLocal);
                            resultados.insertar(unVisitante);

                        }
                    }
                    partido = partido.getSiguiente();
                }
                //cada vez que dejo de recorrer una liga:
                System.out.println("LIGA " + liga.getEtiqueta());
                System.out.println("JUGADOR CON MAS PARTICIPACION: ");
                //si las participaciones de los jugadores de la liga fueron todas cero, no se arroja resultado
                if (masParticipacion(resultados).getDato().participaciones() == 0) {
                    System.out.println("No hay informacion");
                } else {
                    //se calcula el jugador con mas participacion de la lista de jugadores resultantes por liga
                    masParticipacion(resultados).getDato().infoReducido();
                }
                //continuo recorriendo
                liga = liga.getSiguiente();
            }

        }
    }
    /**
     * Metodo que devuelve el nombre de las ligas en las que participo
     * un jugador
     * @param nombreJugador 
     */
    @Override
    public String nombreLigasDeJugador(String nombreJugador) {
        String res =  "";
        boolean flag = false;
        Lista<Jugador> listaJugadores = this.arbolJugadores.inOrden();
        Nodo<Jugador> aux = listaJugadores.getPrimero();
        //recorro la lista de jugadores
        while (aux != null) {
            //verifico que el jugador exista en la lista de jugadores
            if (aux.getDato().getNombre().equals(nombreJugador)) {
                //verifico si el jugador tiene una lista de ligas con informacion
                if (!(aux.getDato().susLigas().esVacia())) {
                    //imprimo la informacion de las ligas
                   res += aux.getDato().infoLigas() + "/n";
                    flag = true;
                }
            }
            aux = aux.getSiguiente();
        }
        //si la bandera no cambio, significa que no tiene ligas asociadas
        if (flag == false) {
            res ="no se encuentran ligas para " + nombreJugador;
        }
        return res;
    }
    
    
    
    /***
     * Metodo encargado de calcular el mejor arquero dada una temporada
     * encuentra al arquero que salvo mas intentos de gol
     * @param temporada 
     */
   
    @Override
    public void mejorArqueroPorTemporada(String temporada) {
        //verifico si la temporada es valida
        if (this.listaTemporadas.buscar(temporada) == null) {
            System.out.println("no existe la temporada " + temporada);
        } else {
            //lista para guardar los resultados de arqueros
            Lista<Jugador> arqueros = new Lista<>();
            Lista<Evento>listaEventos = this.arbolEventos.inOrden();
            Nodo<Evento> evento = listaEventos.getPrimero();
            Lista <PartidoCompleto> partidosCompletos = this.arbolPartidosCompletos.inOrden();
            //recorro los eventos
            while (evento != null) {
                //verifico que el evento sea de tipo Evento = 1 (attemp)
                if (evento.getDato().getTipoEvento() == 1) {
                    //verifico que el resultado de la jugada sea = 1 (saved)
                    if (evento.getDato().resultadoJugada().equals("1")) {
                        //verifico que el gol =0 (no hubo gol)
                        if (evento.getDato().getGol() == 0) {                         
                            Nodo<PartidoCompleto> partido = partidosCompletos.getPrimero();
                            //recorro la lista de partidos
                            while (partido != null) {
                                //verifico que la temporada del partido coincida con la recibida por parametro
                                if (partido.getDato().getTemporada().equals(temporada)) {
                                    if (partido.getDato().getId() != null) {
                                        //guardo en variable el id del partido del evento que se esta recorriendo
                                        String idPartido = evento.getDato().getIdPartido();
                                        //comparo el id del partido con el id del partido del evento
                                        if (partido.getDato().getId().equals(idPartido)) {
                                            //guardo en variable el id del jugador en la posicion de arquero (siempre es el indice 0)
                                            int idArquero = partido.getDato().jugadoresVisitanteId[0];
                                            //verifico que el jugador exista en la lista de jugadores
                                            if (partido.getDato().jugadoresVisitante.buscar(idArquero) != null) {
                                                //clonar nodo
                                                Lista<Jugador> arquerosVisitantes = partido.getDato().jugadoresVisitante;
                                                Nodo<Jugador> arquero = arquerosVisitantes.buscar(idArquero).clonar();
                                                //inserto en resultados
                                                arqueros.insertar(arquero);
                                            }
                                        }
                                    }
                                }
                                partido = partido.getSiguiente();
                            }
                        }
                    }
                }
                evento = evento.getSiguiente();
            }

            Nodo<Jugador> aux = arqueros.getPrimero();
            //variable para guardar el id del mejor arquero
            Comparable idGanador = 0;
            //variable para guardar la cantidad de veces que aparece el arquero
            int ocurrencias = 0;
            //recorro la lista de arqueros
            //cuento cuantas veces se repite cada elemento
            while (aux != null) {
                int contador = 0;
                Nodo<Jugador> aux2 = arqueros.getPrimero();
                while (aux2 != null) {
                    if (aux.getEtiqueta().equals(aux2.getEtiqueta())) {
                        contador++;
                    }
                    aux2 = aux2.getSiguiente();
                }
                //voy guardando en variables el id del arquero que tiene mayores apariciones 
                //se guarda tambien la cantidad de veces que aparecen en la lista
                if (ocurrencias < contador) {
                    ocurrencias = contador;
                    idGanador = aux.getEtiqueta();
                }
                aux = aux.getSiguiente();
            }
            //se vuelve a buscar en la lista de aruqeros el con el id del mejor arquero y se devuelve la informacion
            Nodo<Jugador> mejorArquero = arqueros.buscar(idGanador);
            System.out.println("-Mejor arquero de la temporara " + temporada + " es:");
            mejorArquero.getDato().infoReducido();
            System.out.println("Con " + ocurrencias + " goles atajados.");

        }
    }
    /**
     * metodo que calcula el mejor arquero
     * toma en cuenta los eventos de goles salvados y 
     * encuentra al arquero que salvo mas intentos de gol
     */
    public void mejorArquero() {
        //kista para guardar resultados
        Lista<Jugador> arqueros = new Lista<>();
        Lista<Evento>listaEventos = this.arbolEventos.inOrden();
        Nodo<Evento> evento = listaEventos.getPrimero();
        Lista <PartidoCompleto> partidosCompletos = this.arbolPartidosCompletos.inOrden();
        //recorro los eventos
        while (evento != null) {
            //verifico que los atributos del evento indiquen un gol salvado
            if (evento.getDato().getTipoEvento() == 1) {
                if (evento.getDato().resultadoJugada().equals("1")) {
                    if (evento.getDato().getGol() == 0) {
                        Nodo<PartidoCompleto> partido = partidosCompletos.getPrimero();
                        while (partido != null) {
                            //recorro los partidos y guardo el id del partido del evento
                            if (partido.getDato().getId() != null) {
                                String idPartido = evento.getDato().getIdPartido();
                                //verifico si el id del partido es igual al id del partido del evento
                                if (partido.getDato().getId().equals(idPartido)) {
                                    //tomo el id del jugador arquero del equipo oponente
                                    int idArquero = partido.getDato().jugadoresVisitanteId[0];
                                    //verifico si el jugadore existe en la lista de jugadores
                                    if (partido.getDato().jugadoresVisitante.buscar(idArquero) != null) {
                                        //clono el nodo del jugador y lo inserto en la lista de los jugadores 
                                        Lista<Jugador> arquerosVisitantes = partido.getDato().jugadoresVisitante;
                                        Nodo<Jugador> arquero = arquerosVisitantes.buscar(idArquero).clonar();
                                        //verifico que el jugador no haya sido agregado anteriormente
                                        if (this.eleven.buscar(arquero.getEtiqueta()) == null) {
                                            //clono el nodo del jugador y lo inserto en la lista de los jugadores 
                                            arqueros.insertar(arquero);

                                        }
                                    }
                                }

                            }
                            partido = partido.getSiguiente();
                        }
                    }
                }
            }
            evento = evento.getSiguiente();
        }

        Nodo<Jugador> aux = arqueros.getPrimero();
        //variable para guardar el id del mejor arquero
        Comparable idGanador = 0;
        //variable para guardar la cantidad de goles salvados
        int ocurrencias = 0;
        /**
         * recorro la lista de arqueros, contando cuantas veces se repite el id
         * de cada jugador, a su vez se va guardando en la variable el id del jugador que
         * se repite mas veces
        */
        while (aux != null) {
            int contador = 0;
            Nodo<Jugador> aux2 = arqueros.getPrimero();
            while (aux2 != null) {
                if (aux.getEtiqueta().equals(aux2.getEtiqueta())) {
                    contador++;
                }
                aux2 = aux2.getSiguiente();
            }
            if (ocurrencias < contador) {
                ocurrencias = contador;
                idGanador = aux.getEtiqueta();
            }
            aux = aux.getSiguiente();
        }
        //busco el id del mejor arquero en la lista de resultados e imprimo su informacion
        Nodo<Jugador> mejorArquero = arqueros.buscar(idGanador);
        TElementoAB <Jugador> mejorArqueroEleven = new TElementoAB (mejorArquero.getEtiqueta(),mejorArquero.getDato());
        this.eleven.insertar(mejorArqueroEleven);
        System.out.println("-Mejor arquero es:");
       mejorArqueroEleven.getDatos().infoReducido();
        System.out.println("Con " + ocurrencias + " goles atajados.");

    }
    /**
     * Metodo que calcula el mejor zaguero segun la poscicion que se recibe por parametro
     * (puede ser zaguero izquierdo o derecho)
     * @param posicionCodigo 
     */
    public void mejorZaguero(String posicionCodigo) {
        //lista que guardara resultados
        Lista<Jugador> zagueros = new Lista<>();
        Lista<Evento>listaEventos = this.arbolEventos.inOrden();
        Nodo<Evento> evento = listaEventos.getPrimero();
        Lista <PartidoCompleto> partidosCompletos = this.arbolPartidosCompletos.inOrden();
        
        while (evento != null) {
            //se recorre la lista de eventos en busqueda de eventos de intentos bloqueados o corner del lado del equipo visitante
            if ((evento.getDato().getTipoEvento() == 1 && evento.getDato().resultadoJugada().equals("3"))
                    || (evento.getDato().getTipoEvento() == 2 && evento.getDato().getLadoCancha() == 2)) {
                Nodo<PartidoCompleto> partido = partidosCompletos.getPrimero();
                while (partido != null) {
                    //recorro los partidos y encuentro el partido cuyo id coincida con el id del partido del evento
                    if (partido.getDato().getId() != null) {
                        String idPartido = evento.getDato().getIdPartido();
                        if (partido.getDato().getId().equals(idPartido)) {
                            //recorro el vector de pociciones en busca de la pocicion que coincida con la recibida por parametro
                            String[] posiciones = partido.getDato().posicionesVisitante;
                            for (int i = 0; i < posiciones.length; i++) {
                                int indice;
                                if (posiciones[i] != null) {
                                    if (posiciones[i].equals(posicionCodigo)) {
                                        //guardo el indice de la posicion y en el vector que guarda los id de los jugadores encuento el id
                                        //del jugador que se corresponde con la posicion
                                        indice = i;
                                        int[] idLocales = partido.getDato().jugadoresVisitanteId;
                                        for (int j = 0; j < idLocales.length; j++) {
                                            if (j == i) {
                                                //busco al jugador que juega en la posicion deseada en la lista de jugadores del partido
                                               Lista<Jugador> zagueroVisitantes = partido.getDato().jugadoresVisitante;
                                                Nodo<Jugador> zaguero =zagueroVisitantes.buscar(idLocales[j]).clonar();
                                                if (!"nulo".equals(zaguero.getDato().getNombre())) {
                                                    //corroboro que el jugador no haya sido agregado a la lista de los once mejores anteriormente
                                                    if (this.eleven.buscar(zaguero.getEtiqueta()) == null) {
                                                        zagueros.insertar(zaguero);
                                                    }
                                                }
                                            }

                                        }
                                    }

                                }
                            }

                        }

                    }
                    partido = partido.getSiguiente();
                }
            }
            evento = evento.getSiguiente();
        }
        /**
         * recorro la lista de zagueros, contando cuantas veces se repite el id
         * de cada jugador, a su vez se va guardando en la variable el id del jugador que
         * se repite mas veces y cuantas veces se repite
        */
        Nodo<Jugador> aux = zagueros.getPrimero();
        Comparable idZaguero = 0;
        int ocurrencias = 0;
        while (aux != null) {
            int contador = 0;
            Nodo<Jugador> aux2 = zagueros.getPrimero();
            while (aux2 != null) {
                if (aux.getEtiqueta().equals(aux2.getEtiqueta())) {
                    contador++;
                }
                aux2 = aux2.getSiguiente();
            }
            if (ocurrencias < contador) {
                ocurrencias = contador;
                idZaguero = aux.getEtiqueta();
            }
            aux = aux.getSiguiente();
        }
        if (!zagueros.esVacia()) {
            Nodo<Jugador> zagueroResultante = zagueros.buscar(idZaguero).clonar();
            TElementoAB <Jugador> zagueroEleven = new TElementoAB(zagueroResultante.getEtiqueta(),zagueroResultante.getDato());
            this.eleven.insertar(zagueroEleven);
            
            switch (posicionCodigo) {
                case "ZI":
                    System.out.println("-El Zaguero izquierdo es:");
                    zagueroEleven.getDatos().infoReducido();
                    System.out.println("Con " + ocurrencias + " intentos bloqueados desde esta posicion");
                    break;
                case "ZD":
                    System.out.println("-El Zaguero Derecho es:");
                    zagueroEleven.getDatos().infoReducido();
                    System.out.println("Con " + ocurrencias + " intentos bloqueados desde esta posicion");
                    break;
                 case "ZC":
                    System.out.println("-El Zaguero Central es:");
                    zagueroEleven.getDatos().infoReducido();
                    System.out.println("Con " + ocurrencias + " intentos bloqueados desde esta posicion");
                    break;                   
            }
        }

    }

    /**
     * Metodo encargado de calcular al mejor delantero dada una poscicion recibida por parametro
     * @param posicionCodigo 
     */
    public void mejorDelantero(String posicionCodigo) {
         //lista que guardara resultados
        Lista<Jugador> delanteros = new Lista<>();
        Lista<Evento>listaEventos = this.arbolEventos.inOrden();
        Nodo<Evento> evento = listaEventos.getPrimero();
        Lista <PartidoCompleto> partidosCompletos = this.arbolPartidosCompletos.inOrden();
        while (evento != null) {
            //recorro los eventos en los cuales existan eventos de gol
            if (evento.getDato().getTipoEvento() == 1) {
                if (evento.getDato().getGol() == 1) {
                    Nodo<PartidoCompleto> partido = partidosCompletos.getPrimero();
                    while (partido != null) {
                        //recorro los partidos buscando el partido cuyo id coincida con el del partipo del evento
                        if (partido.getDato().getId() != null) {
                            String idPartido = evento.getDato().getIdPartido();
                            if (partido.getDato().getId().equals(idPartido)) {
                                //recorro el vector de posiciones del equipo local y busco el indice cuyo resultado sea equivalente a la posicion recibida
                                String[] posiciones = partido.getDato().posicionesLocal;
                                for (int i = 0; i < posiciones.length; i++) {
                                    int indice;
                                    if (posiciones[i] != null) {
                                        if (posiciones[i].equals(posicionCodigo)) {
                                            //cuando encuentro el indice lo guardo en una variable
                                            indice = i;
                                            int[] idLocales = partido.getDato().jugadoresLocalId;
                                            //recorro el vector que guarda los id de los jugadores y encuentro el jugador que juega en la posicion requerida
                                            for (int j = 0; j < idLocales.length; j++) {
                                                if (j == i) {
                                                    //busco el jugador en la lista de jugadores y se clona el nodo
                                                    Lista<Jugador> delanteronLocales = partido.getDato().jugadoresLocal;
                                                    Nodo<Jugador> delantero = delanteronLocales.buscar(idLocales[j]).clonar();
                                                    if (!"nulo".equals(delantero.getDato().getNombre())) {
                                                        //se verfica que el jugador no se haya ingresado anteriormente
                                                        if (this.eleven.buscar(delantero.getEtiqueta()) == null) {
                                                            delanteros.insertar(delantero);
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    }

                                }
                            }

                        }
                        partido = partido.getSiguiente();
                    }

                }
            }
            evento = evento.getSiguiente();
        }
        /**
         * recorro la lista de delanteros, contando cuantas veces se repite el id
         * de cada jugador, a su vez se va guardando en la variable el id del jugador que
         * se repite mas veces y cuantas veces se repite
         * 
        */
        Nodo<Jugador> aux = delanteros.getPrimero();
        Comparable idDelantero = 0;
        int ocurrencias = 0;
        while (aux != null) {
            int contador = 0;
            Nodo<Jugador> aux2 = delanteros.getPrimero();
            while (aux2 != null) {
                if (aux.getEtiqueta().equals(aux2.getEtiqueta())) {
                    contador++;
                }
                aux2 = aux2.getSiguiente();
            }
            if (ocurrencias < contador) {
                ocurrencias = contador;
                idDelantero = aux.getEtiqueta();
            }
            aux = aux.getSiguiente();
        }
        //segun la posicion recibida sera el mensaje que imprime
        if (!delanteros.esVacia()) {
            Nodo<Jugador> delanteroResultante = delanteros.buscar(idDelantero).clonar();
            TElementoAB<Jugador> delanteroEleven = new TElementoAB (delanteroResultante.getEtiqueta(),delanteroResultante.getDato());
            this.eleven.insertar(delanteroEleven);
            switch (posicionCodigo) {
                case "DI":
                    System.out.println("-El delantero izquierdo es:");
                    delanteroEleven.getDatos().infoReducido();
                    System.out.println("Con " + ocurrencias + " goles realizados desde esta posicion");
                    break;
                case "DD":
                    System.out.println("-El delantero Derecho es:");
                    delanteroEleven.getDatos().infoReducido();
                    System.out.println("Con " + ocurrencias + " goles realizados desde esta posicion");
                    break;
                case "DC":
                    System.out.println("-El delantero Central es:");
                    delanteroEleven.getDatos().infoReducido();
                    System.out.println("Con " + ocurrencias + " goles realizados desde esta posicion");
                    break;
                default:
                    System.out.println("No se encuentran registros ");
                    break;
            }

        }
    }
    /**
     * Metodo encargado de calcular al mejor medio campista segun una posicion dada
     * @param posicionCodigo 
     */
    public void mejorMedioCampista(String posicionCodigo) {
         //lista que guardara resultados
        Lista<Jugador> medios = new Lista<>();
        Lista <PartidoCompleto> partidosCompletos = this.arbolPartidosCompletos.inOrden();
        Nodo<PartidoCompleto> partido = partidosCompletos.getPrimero();
        while (partido != null) {
            //recorro los partidos y busco en sus vectores de pociciones a aquella que corresponda a un medio campista
            String[] posiciones = partido.getDato().posicionesLocal;
            for (int i = 0; i < posiciones.length; i++) {
                int indice;
                if (posiciones[i] != null) {
                    //cuando encuentro un medio campista guardo la pocicion y busco el id en el vector que guarda el id de los jugadores
                    if (posiciones[i].equals(posicionCodigo)) {
                        indice = i;
                        int[] idLocales = partido.getDato().jugadoresLocalId;
                        for (int j = 0; j < idLocales.length; j++) {
                            if (j == i) {
                                //cuando encuentro el medio campista verifico que exista en la lista de jugadores
                                Lista<Jugador> medioCampistaLocal = partido.getDato().jugadoresLocal;
                                Nodo<Jugador> medioCampista = medioCampistaLocal.buscar(idLocales[j]).clonar();
                                if (!"nulo".equals(medioCampista.getDato().getNombre())) {
                                    //verifico que no se haya ingresado anteriormente en la lista de los once mejores
                                    if (this.eleven.buscar(medioCampista.getEtiqueta()) == null) {
                                        //verifico que el medio campista no este ingresado en la lista de medio campistas 
                                        if (medios.buscar(medioCampista.getEtiqueta()) == null) {
                                            medios.insertar(medioCampista);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            partido = partido.getSiguiente();
        }
        /**
         * recorro la lista de medio campistas, contando cuantos eventos asociados tiene
         * cada uno, se va guardando en varible el id del jugador con mas eventos
         * y la cantidad de eventos.
         * 
        */
        Nodo<Jugador> aux = medios.getPrimero();
        Comparable idmedio = 0;
        int eventos = 0;
        while (aux != null) {
            int contador = aux.getDato().participaciones();
            if (eventos < contador) {
                eventos = contador;
                idmedio = aux.getEtiqueta();
            }
            aux = aux.getSiguiente();
        }
        if (!medios.esVacia()) {
            
            Nodo<Jugador> medioCampistaResultante = medios.buscar(idmedio).clonar();
            TElementoAB<Jugador> medioCampistaEleven = new TElementoAB (medioCampistaResultante.getEtiqueta(),medioCampistaResultante.getDato());
            this.eleven.insertar(medioCampistaEleven);
            switch (posicionCodigo) {
                case "MI":
                    System.out.println("-El Medio Campista izquierdo es:");
                    medioCampistaEleven.getDatos().infoReducido();
                    System.out.println("Con " + eventos + " participaciones desde esta posicion");
                    break;
                case "MD":
                    System.out.println("-El Medio Campista Derecho es:");
                    medioCampistaEleven.getDatos().infoReducido();
                    System.out.println("Con " + eventos + " participaciones desde esta posicion");
                    break;
                case "MC":
                    System.out.println("-El Medio Campista Central es:");
                    medioCampistaEleven.getDatos().infoReducido();
                    System.out.println("Con " + eventos + " participaciones desde esta posicion");
                    break;
                default:
                    System.out.println("No se encuentran registros ");
                    break;
            }

        }

    }

    /**
     * Metodo encargado de calcular cual fue el delantero menos efectivo
     * dada una temporada recibida por parametro
     * @param temporada 
     */
    @Override
    public void delanteroMenosEfectivo(String temporada) {
        if (this.listaTemporadas.buscar(temporada) == null) {
            System.out.println("no existe la temporada " + temporada);
        } else {
             //lista que guardara resultados
            Lista<Jugador> delanteros = new Lista<>();
            Lista<Evento> listaEventos = this.arbolEventos.inOrden();
            Nodo<Evento> evento = listaEventos.getPrimero();
            Lista<PartidoCompleto> listaPartidosCompletos = this.arbolPartidosCompletos.inOrden();
            while (evento != null) {
                //recorro todos los eventos buscando aquellos en los que haya un intento de gol bloqueado
                if (evento.getDato().getTipoEvento() == 1) {
                    if (evento.getDato().resultadoJugada().equals("2")) {
                        Nodo<PartidoCompleto> partido = listaPartidosCompletos.getPrimero();
                        while (partido != null) {
                            //recorro los partidos y busco el partico cuyo id coincida con el id del partido del evento
                            if (partido.getDato().getTemporada().equals(temporada)) {
                                if (partido.getDato().getId() != null) {
                                    String idPartido = evento.getDato().getIdPartido();
                                    if (partido.getDato().getId().equals(idPartido)) {
                                        //recorro el vector de posiciones del equipo local y busco el indice cuyo resultado sea equivalente a la posicion recibida
                                        String[] posiciones = partido.getDato().posicionesLocal;
                                        for (int i = 0; i < posiciones.length; i++) {
                                            int indice;
                                            if (posiciones[i] != null) {
                                                if (posiciones[i].equals("DD") || posiciones[i].equals("DI") || posiciones[i].equals("DC")) {
                                                    //cuando encuentro el indice lo guardo en una variable
                                                    indice = i;
                                                    //recorro el vector que guarda los id de los jugadores y encuentro el jugador que juega en la posicion requerida
                                                    int[] idLocales = partido.getDato().jugadoresLocalId;
                                                    for (int j = 0; j < idLocales.length; j++) {
                                                        if (j == i) {
                                                            //busco el jugador en la lista de jugadores y se clona el nodo
                                                            Lista<Jugador> delanterosLocales =  partido.getDato().jugadoresLocal;
                                                            Nodo<Jugador> delantero = delanterosLocales.buscar(idLocales[j]).clonar();
                                                            if (!"nulo".equals(delantero.getDato().getNombre())) {
                                                               
                                                                delanteros.insertar(delantero);
                                                                
                                                            }
                                                        }

                                                    }
                                                }
                                            }

                                        }
                                    }

                                }

                            }
                            partido = partido.getSiguiente();
                        }
                    }
                }
                evento = evento.getSiguiente();
            }
          /**
         * recorro la lista de delanteros, contando cuantas veces se repite el id
         * de cada jugador, a su vez se va guardando en la variable el id del jugador que
         * se repite mas veces y cuantas veces se repite
         * 
        */
            Nodo<Jugador> aux = delanteros.getPrimero();
            Comparable idMenosEfectivo = 0;
            int ocurrencias = 0;
            while (aux != null) {
                int contador = 0;
                Nodo<Jugador> aux2 = delanteros.getPrimero();
                while (aux2 != null) {
                    if (aux.getEtiqueta().equals(aux2.getEtiqueta())) {
                        contador++;
                    }
                    aux2 = aux2.getSiguiente();
                }
                if (ocurrencias < contador) {
                    ocurrencias = contador;
                    idMenosEfectivo = aux.getEtiqueta();
                }
                aux = aux.getSiguiente();
            }
            if (!delanteros.esVacia()) {
                Nodo<Jugador> delanteroMenosEfectivo = delanteros.buscar(idMenosEfectivo);
                System.out.println("-El delantero menos efectivo de la temporada " + temporada + " es:");
                delanteroMenosEfectivo.getDato().infoReducido();
                System.out.println("Con " + ocurrencias + " intentos perdidos.");
            } else {
                System.out.println("No se encuentran registros para la temporada " + temporada
                );
            }

        }
    }

    /**
     * Metodo que calcula que equipo efectuo mas goles dada una temporada
     * @param temporada 
     */
    @Override
    public void equipoGoleador(String temporada) {
        //verifico si la temporada es valida
        if (this.listaTemporadas.buscar(temporada) == null) {
            System.out.println("no existe la temporada " + temporada);
        } else {
            //lista que guardara resultados
            Lista<Equipo> equiposGol = new Lista<>();
            Lista<Equipo> listaEquipos = this.arbolEquipos.inOrden();
            Lista<Evento> listaEventos = this.arbolEventos.inOrden();

            Nodo<Evento> evento = listaEventos.getPrimero();
            while (evento != null) {
                if (evento.getDato().getTemporada() != null) {
                    //recorro los eventos que coincidan en la temporada y que tengan un evento de gol
                    if (evento.getDato().getTemporada().equals(temporada)) {
                        if (evento.getDato().getGol() == 1) {
                            //busco en la lista de quipos el id del equipo del evento
                            if (listaEquipos.buscar(evento.getDato().getEquipoEventoId()) != null) {
                                //si el equipo existe clono el nodo y lo guardo en la lista de resultados
                                Nodo<Equipo> aux = listaEquipos.buscar(evento.getDato().getEquipoEventoId()).clonar();
                                equiposGol.insertarPrimero(aux);
                            }

                        }
                    }
                }
                evento = evento.getSiguiente();
            }
            /*
            recorro la lista de resultados y cuento cuantas veces se repite cada equipo
            a su vez se guarda en variable el id del equipo que tiene mas apariciones
            y cuantas veces se repite
            */
            String nombre = "";
            int ocurrencias = 0;
            Nodo<Equipo> aux = equiposGol.getPrimero();

            while (aux != null) {
                int contador = 0;
                Nodo<Equipo> aux2 = equiposGol.getPrimero();
                while (aux2 != null) {
                    if (aux.getEtiqueta().equals(aux2.getEtiqueta())) {
                        contador++;
                    }
                    aux2 = aux2.getSiguiente();
                }
                if (ocurrencias < contador) {
                    ocurrencias = contador;
                    nombre = aux.getDato().getNombre();
                }
                aux = aux.getSiguiente();
            }
            //vuelvo a buscar el iddel equipo goleador en la lista de resultados, e imprimo la informacion
            int idEquipo = nombreIdEquipo(nombre);
            Nodo<Equipo> mejorEquipo = equiposGol.buscar(idEquipo);
            System.out.println("-Partido que realizo mas goles durante la temporara " + temporada + ":");
            mejorEquipo.getDato().mostrarInfo();
            System.out.println("Con " + ocurrencias + " goles realizados.");
        }
    }

    /**
     * Metodo que calcula que equipo recibio mas goles dada una temporada
     * @param temporada 
     */
    @Override
    public void equipoGoleado(String temporada) {
        //verifico si la temporada es valida
        if (this.listaTemporadas.buscar(temporada) == null) {
            System.out.println("no existe la temporada " + temporada);
        } else {
             //lista que guardara resultados
            Lista<Equipo> equiposGol = new Lista<>();
            Lista<Equipo> listaEquipos = this.arbolEquipos.inOrden();
            Lista<Evento> listaEventos = this.arbolEventos.inOrden();
            Nodo<Evento> evento = listaEventos.getPrimero();
            while (evento != null) {
                if(evento.getDato().getTemporada() != null){
                //recorro los eventos que coincidan en la temporada y que tengan un evento de gol
                if (evento.getDato().getTemporada().equals(temporada)) {
                    if (evento.getDato().getGol() == 1) {
                         //si el equipo existe clono el nodo y lo guardo en la lista de resultados
                        if (listaEquipos.buscar(evento.getDato().getOponenteId()) != null) {
                            Nodo<Equipo> aux = listaEquipos.buscar(evento.getDato().getOponenteId()).clonar();

                            equiposGol.insertarPrimero(aux);
                        }

                    }
                }
                }
                evento = evento.getSiguiente();
            }
            /*
            recorro la lista de resultados y cuento cuantas veces se repite cada equipo
            a su vez se guarda en variable el id del equipo que tiene mas apariciones
            y cuantas veces se repite
            */
            String nombre = "";
            int ocurrencias = 0;
            Nodo<Equipo> aux = equiposGol.getPrimero();

            while (aux != null) {
                int contador = 0;
                Nodo<Equipo> aux2 = equiposGol.getPrimero();
                while (aux2 != null) {
                    if (aux.getEtiqueta().equals(aux2.getEtiqueta())) {
                        contador++;
                    }
                    aux2 = aux2.getSiguiente();
                }
                if (ocurrencias < contador) {
                    ocurrencias = contador;
                    nombre = aux.getDato().getNombre();
                }
                aux = aux.getSiguiente();
            }
            //vuelvo a buscar el iddel equipo goleado en la lista de resultados, e imprimo la informacion
            int idEquipo = nombreIdEquipo(nombre);
            Nodo<Equipo> peorEquipo = equiposGol.buscar(idEquipo);
            System.out.println("-Partido que recibio mas goles durante la temporara " + temporada + ":");
            peorEquipo.getDato().mostrarInfo();
            System.out.println("Con " + ocurrencias + " goles recibidos.");
        }
    }
    /**
     * Metodo encargado de volcar los resultados para un equipo ideal
     * el mismo invoca a los metodos que calcula a los mejores jugadores  
     * segun una determinada posicion y centraliza sus resultados.
     */
    @Override
    public void onceIdeal() {

        System.out.println("Calculando el once ideal...");
        mejorArquero();
        System.out.println("**************");
        mejorDelantero("DI");
        System.out.println("**************");
        mejorDelantero("DC");
        System.out.println("**************");
        mejorDelantero("DD");
        System.out.println("**************");
        mejorMedioCampista("MI");
        System.out.println("**************");
        mejorMedioCampista("MC");
        System.out.println("**************");
        mejorMedioCampista("MD");
        System.out.println("**************");
        mejorZaguero("ZI");
        System.out.println("**************");
        mejorZaguero("ZD");
        System.out.println("**************");
        mejorZaguero("ZC");
        System.out.println("**************");
        mejorZaguero("ZC");
    }

        /**
     * Metodo encargado de devolver el id de un equipo dado un nombre
     * recibido por parametro
     * @param unNombre
     * @return 
     */
    public int nombreIdEquipo(String unNombre) {
        //variable que guardara el resultado
        int resultado = 0;
        Lista<Equipo> listaEquipos = this.arbolEquipos.inOrden();
        Nodo<Equipo> aux = listaEquipos.getPrimero();
        //recorro la lista
        while (aux != null) {
            //verifico si el nombre del equipo coincide con el recibido por parametro
            if (aux.getDato().getNombre().contains(unNombre)) {
                //asigno el id del equipo al resultado
                resultado = Integer.valueOf(aux.getEtiqueta().toString());
            }

            aux = aux.getSiguiente();
        }
        //retorno el resultado.
        return resultado;
    }
    
        /**
     * Metodo encargado de devolver el id de un jugador dado un nombre
     * recibido por parametro
     * @param unNombre
     * @return 
     */
    public int nombreIdJugador(String unNombre) {
        //variable que guardara el resultado
        int resultado = 0;
        Lista<Jugador> listaJugadores = this.arbolJugadores.inOrden();
        Nodo<Jugador> aux = listaJugadores.getPrimero();
        //recorro la lista
        while (aux != null) {
            //verifico si el nombre del jugador coincide con el recibido por parametro
            if (aux.getDato().getNombre().contains(unNombre)) {
                //asigno el id del jugador al resultado
                resultado = Integer.valueOf(aux.getEtiqueta().toString());
            }

            aux = aux.getSiguiente();
        }
        return resultado;
    }
    
  /**
     * Metodo que dado el id de un jugador, devuelve su nombre como cadena de caracteres
     * @param unId
     * @return 
     */
    public String idNombreJugador(int unId) {
        
        //variable que almacenara el resultado final
        String resultado = "";
        Lista<Jugador> listaJugadores = this.arbolJugadores.inOrden();
        Nodo<Jugador> aux = listaJugadores.getPrimero();
        //recorro la lista de jugadores
        while (aux != null) {
            //verifico si el id del jugador coincide con el recibido por parametro
            if (aux.getEtiqueta().equals(unId)) {
                //asigno el valor a la variable
                resultado = aux.getDato().getNombre();
            }

            aux = aux.getSiguiente();
        }
        //retorno el valor 
        return resultado;
    }
    /**
     * Metodo que dado el id de un equipo, devuelve su nombre como cadena de caracteres
     * @param unId
     * @return 
     */
    public String idNombreEquipo(int unId) {
        //variable que almacenara el resultado final
        String resultado = "";
        Lista<Equipo> listaEquipos = this.arbolEquipos.inOrden();
        Nodo<Equipo> aux = listaEquipos.getPrimero();
        //recorro la lista de equipos
        while (aux != null) {
            //verifico si el id del equipo coincide con el recibido por parametro
            if (aux.getEtiqueta().equals(unId)) {
                //asigno el valor a la variable
                resultado = aux.getDato().getNombre();
            }

            aux = aux.getSiguiente();
        }
        //retorno el valor
        return resultado;

    }
    
  public void depuradorPartidosCompletosJugador() {
        //TArbolBB<PartidoCompleto > partidosCompletosFase2 = new TArbolBB<>();
        TArbolBB<PartidoCompleto > partidosCompletosFase2 = new TArbolBB<>();
        System.out.println("Trabajando en filtrar informacion");
        Lista<PartidoCompleto> listaPartidosCompletos = this.arbolPartidosCompletos.inOrden();
        Nodo<PartidoCompleto> partido = listaPartidosCompletos.getPrimero();
        while (partido != null) {
            boolean flag1 = false;
            boolean flag2 = false;
            Lista <Jugador> jugadoresLocal = partido.getDato().jugadoresLocal;
            Nodo<Jugador> aux = jugadoresLocal.getPrimero();
            while (aux != null) {
                if ((this.arbolJugadores.buscar(aux.getEtiqueta()) != null)&& (!aux.getDato().getNombre().equals("NA"))) {
                    flag1 = true;

                }
                aux = aux.getSiguiente();
            }
            
             Lista <Jugador> jugadoresVisitante = partido.getDato().jugadoresLocal;
            Nodo<Jugador> aux2 = jugadoresVisitante.getPrimero();
            while (aux2 != null) {
                if ((this.arbolJugadores.buscar(aux2.getEtiqueta())!= null)&& (!aux2.getDato().getNombre().equals("NA"))){
                    flag2 = true;

                }
                aux2 = aux2.getSiguiente();
            }
            if(flag1 == true && flag2 == true){
               // TElementoAB <PartidoCompleto> partidoInsertar = new TElementoAB (partido.getEtiqueta(),partido.getDato());
                TElementoAB <PartidoCompleto> partidoInsertar = new TElementoAB(partido.getEtiqueta(),partido.getDato());
                partidosCompletosFase2.insertar(partidoInsertar);
                
            }
            partido = partido.getSiguiente();

        }
        this.setArbolPartidosCompletos(partidosCompletosFase2);

    }
    public void depuradorPartidos() {
        TArbolBB<PartidoCompleto > partidosCompletosFase2 = new TArbolBB<>();
        System.out.println("trabajando en la depuracion de informacion");
        Lista<PartidoCompleto> listaPartidosCompletos = this.arbolPartidosCompletos.inOrden();
        Nodo<PartidoCompleto> aux = listaPartidosCompletos.getPrimero();
        while (aux != null) {
            System.out.println(aux.getEtiqueta());
            Lista <Partido> listaPartidos = this.arbolPartidos.inOrden();
            Nodo<Partido> aux2 = listaPartidos.getPrimero();
            while (aux2 != null) {
                System.out.println(aux2.getEtiqueta());
                if (aux.getDato().getLiga().equals(aux2.getDato().getLiga())) {
                    if (aux.getDato().getTemporada().equals(aux2.getDato().getTemporada())) {
                        if (aux.getDato().getLocal() == (aux2.getDato().getLocal())) {
                            if (aux.getDato().getVisitante() == aux2.getDato().getVisitante()) {
                                aux.getDato().setId(aux2.getDato().getId());
                                //TElementoAB<PartidoCompleto> nodo = new TElementoAB (aux.getEtiqueta(), aux.getDato());
                                TElementoAB<PartidoCompleto> nodo = new TElementoAB (aux.getEtiqueta(), aux.getDato());
                                partidosCompletosFase2.insertar(nodo);
                            }
                        }
                    }
                }

                aux2 = aux2.getSiguiente();
            }
            aux = aux.getSiguiente();

        }
        this.setArbolPartidosCompletos(partidosCompletosFase2);
    }


    public void depuradorDeEventos() {
        System.out.println("trabajando en la depuracion de eventos");
        Lista<Evento> eventos = this.arbolEventos.inOrden();
        Lista<PartidoCompleto> partidos = this.arbolPartidosCompletos.inOrden();
        Nodo<Evento> aux = eventos.getPrimero();
        while (aux != null) {
            Nodo<PartidoCompleto> aux2 = partidos.getPrimero();
            while (aux2 != null) {
                if (aux.getDato().getIdPartido().equals(aux2.getDato().getId())) {
                    String temporada = aux2.getDato().getTemporada();
                    TElementoAB<Evento> evento = this.arbolEventos.buscar(aux.getEtiqueta());
                    
                    evento.getDatos().setTemporada(temporada);
                    break;
                }
                aux2 = aux2.getSiguiente();
            }
            aux = aux.getSiguiente();

        }

    }

}