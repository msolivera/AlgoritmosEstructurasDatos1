package elevenCode;

import elevenBasic.Lista;
import elevenBasic.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Clase encargada de cargar toda la informacion y realizar todos los calculos
 * sobre los datos.
 *
 * @author Micaela Olivera
 */
public class ElevenCalculador implements IElevenCalculador {

    //listas con las cargas iniciales con datos crudos

    private final Lista<Jugador> listaJugadores; //referente al archivo players
    private final Lista<Equipo> listaEquipos; //referente al archivo teams
    private final Lista<Partido> listaPartidos; //referente al archivo metches
    private final Lista<PartidoCompleto> listaPartidosCompletos; //referente al archivo match-standing
    private final Lista<Evento> listaEventos; //referente al archivo events

    private final Lista<Liga> listaLigas; //se crean a partir de los datos ya cargados
    private final Lista<Temporada> listaTemporadas;//se crean a partir de los datos ya cargados  

    //Listas de verificacion de elementos con los que posteriormente se van a realizar los calculos.
    private final Lista<PartidoCompleto> partidosCompletosFase2;
    private final Lista<Evento> listaEventosFase1;
    //lista que almacena a los once mejores jugadores.
    private final Lista<Jugador> eleven;

    /**
     * Constructor de la clase
     */
    public ElevenCalculador() {

        this.listaJugadores = new Lista<>();
        this.listaEventos = new Lista<>();
        this.listaEquipos = new Lista<>();
        this.listaPartidos = new Lista<>();
        this.listaPartidosCompletos = new Lista<>();
        this.listaLigas = new Lista<>();
        this.listaTemporadas = new Lista<>();
        this.listaEventosFase1 = new Lista<>();
        this.partidosCompletosFase2 = new Lista<>();
        this.eleven = new Lista<>();

    }

    /**
     * Clase encargada de cargar los Jugadores en su lista de jugadores
     *
     * @param nombreArchivo archivo de jugadores
     */
    @Override
    public void cargarJugadores(String nombreArchivo) {
        System.out.println("cargando jugadores");
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            int contador = 0;//el contador se utiliza para saltear la linea de referencias al inicio de cada achivo
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            while ((lineas = br.readLine()) != null) {
                if (contador == 0) {
                    //no hacer nada, para avitar los nombres de los campos
                    contador = 1;
                } else {
                    
                    String[] contenido;
                    
                    //separa los datos deparados por ;
                    contenido = lineas.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        //quitan las comillas de cada dato
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                                       
                    //verifico que el contenido este completo
                    boolean verificador = true;
                    for (String string : contenido) {
                        if (string.equalsIgnoreCase("")) { //si hay un valor nulo en alguno de los datos, descarto la linea completa
                            verificador = false;
                        }
                    }
                    //si la linea es completa
                    if (verificador == true) {

                        //guardo los datos a utilizar en variables
                        int id = Integer.valueOf(contenido[0]);
                        String nombre = contenido[1];

                        //se crea el jugador
                        Jugador jugadorNuevo = new Jugador(id, nombre);
                        //se crea el nodo a insertar
                        Nodo<Jugador> nodo = new Nodo(jugadorNuevo.getId(), jugadorNuevo);
                        this.listaJugadores.insertarPrimero(nodo);
                    
                    }
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
        System.out.println("Archivo " + nombreArchivo + " leido satisfactoriamente");
    }

    /**
     * Clase encargada de cargar los equipos a su lista de equipos
     *
     * @param nombreArchivo archivo de equipos
     */
    @Override
    public void cargarEquipos(String nombreArchivo) {
        System.out.println("cargando equipos");
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            int contador = 0;//el contador se utiliza para saltear la linea de referencias al inicio de cada achivo
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {
                if (contador == 0) {
                    //no hacer nada, para avitar los nombres de los campos
                    contador = 1;
                } else {

                    String[] contenido;
                    //se separa los datos que se encuentan separador por ;
                    contenido = lineas.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        //quito las comillas de los datos
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                    //verifico que la linea este completa
                    boolean verificador = true;
                    for (String string : contenido) {//si hay un valor nulo en alguno de los datos, descarto la linea completa
                        if (string.equalsIgnoreCase("")) {
                            verificador = false;
                        }
                    }
                    //si la linea es valida
                    if (verificador == true) {

                        //guardo en las variables los datos a utilizar
                        int id = Integer.valueOf(contenido[0]);
                        String nombre = contenido[1];

                        //se crea el equipo
                        Equipo equipoNuevo = new Equipo(id, nombre);
                        //se crea el nodo a insertar
                        Nodo<Equipo> nodo = new Nodo(equipoNuevo.getId(), equipoNuevo);
                        if (this.listaEquipos.buscar(nodo.getEtiqueta()) == null) {

                        this.listaEquipos.insertarPrimero(nodo);
                         }
                    }
                    
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
        System.out.println("Archivo " + nombreArchivo + " leido satisfactoriamente");
    }

    /**
     * Metodo encargado de cargar los partidos a su lista de partidos
     *
     * @param nombreArchivo
     */
    @Override
    public void cargarPartidos(String nombreArchivo) {
        System.out.println("cargando matches");
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            int contador = 0;//el contador se utiliza para saltear la linea de referencias al inicio de cada achivo
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {
                if (contador == 0) {
                    //no hacer nada, para avitar los nombres de los campos
                    contador = 1;
                } else {

                    String[] contenido;
                    //separo los datos que estan separados por ;
                    contenido = lineas.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        //quito las comillas
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                    //verifico que la linea este completa
                    boolean verificador = true;
                    for (String string : contenido) {//si hay un valor nulo en alguno de los datos, descarto la linea completa
                        if (string.equalsIgnoreCase("")) {
                            verificador = false;
                        }
                    }
                    //si la linea es valida
                    if (verificador == true){
                    
                        //guardo en variables los datos que voy a utilizar
                        String id = contenido[0];
                        String fecha = contenido[1];
                        String liga = contenido[2];
                        String temporada = contenido[3];
                        int local = nombreIdEquipo(contenido[4]);
                        int visitante = nombreIdEquipo(contenido[5]);

                        //crear el Partido
                        Partido partidoNuevo = new Partido(id, fecha, liga, temporada, local, visitante);
                        //creo el nodo a insertar
                        Nodo<Partido> nodo = new Nodo(partidoNuevo.getId(), partidoNuevo);
                        this.listaPartidos.insertarPrimero(nodo);

                    }
                    
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
        System.out.println("Archivo " + nombreArchivo + " leido satisfactoriamente");
    }

    /**
     * metodo encargado de guardar los eventos en su lista de eventos
     *
     * @param nombreArchivo archivo de eventos
     */
    @Override
    public void cargarEventos(String nombreArchivo) {
        System.out.println("cargando eventos");
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            int contador = 0;//el contador se utiliza para saltear la linea de referencias al inicio de cada achivo
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {
                if (contador == 0) {
                    //no hacer nada, para avitar los nombres de los campos
                    contador = 1;
                } else {

                    String[] contenido;
                    //separo los datos que estan separados por ;
                    contenido = lineas.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        //quito las comillas
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                    //verifico que la linea este completa
                    boolean verificador = true;
                    for (String string : contenido) {//si hay un valor nulo en alguno de los datos, descarto la linea completa
                        if (string.equalsIgnoreCase("")) {
                            verificador = false;
                        }
                    }
                    //si la linea es valida
                    if (verificador == true) {
                        //guardo en variables los datos que voy a utilizar
                        String idPartido = contenido[0];
                        String idEvento = contenido[1];
                        float tipoEvento = Float.parseFloat(contenido[5]);
                        float ladoCancha = Float.parseFloat(contenido[7]);
                        String equipoEvento = contenido[8];
                        String oponente = contenido[9];
                        String jugador = contenido[10];
                        String resultadoJugada = contenido[15];
                        float gol = Float.parseFloat(contenido[16]);

                        //crear el evento
                        Evento evento = new Evento(idPartido, idEvento, tipoEvento, equipoEvento, oponente, jugador, resultadoJugada, gol, ladoCancha);
                        //creo el nodo a insertar

                        Nodo<Evento> nodoEvento = new Nodo(idEvento, evento);//crea el nodo que contiene al standing cuya etiqueta concatena los dos id de los equipos
                        this.listaEventos.insertarPrimero(nodoEvento);

                    }
                    
                }
            }

            br.close();
            fr.close();
            System.out.println("Archivo " + nombreArchivo + " leido satisfactoriamente");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }

    }

    /**
     * Metodo encargado de guardar los partidos completos en la lista de
     * partidosCompletos
     * @param nombreArchivo
     */
    @Override
    public void cargarPartidosCompleto(String nombreArchivo) {
        System.out.println("cargando match-standing");
        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            int contador = 0;//el contador se utiliza para saltear la linea de referencias al inicio de cada achivo
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {
                if (contador == 0) {
                    //no hacer nada, para avitar los nombres de los campos
                    contador = 1;
                } else {

                    String[] contenido;
                    //separo los datos separados por ;
                    contenido = lineas.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        //quito las comillas
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                    //verifico que la lines sea completa
                    boolean verificador = true;
                    for (String string : contenido) {//si hay un valor nulo en alguno de los datos, descarto la linea completa
                        if (string.equalsIgnoreCase("")) {
                            verificador = false;
                        }
                    }
                    //si la linea es valida
                    if (verificador == true) {

                       
                            int idEquipo1 = Integer.valueOf(contenido[0]);
                            int idEquipo2 = Integer.valueOf(contenido[1]);
                            int idJugadorL1 = Integer.valueOf(contenido[2]);
                            int idJugadorL2 = Integer.valueOf(contenido[3]);
                            int idJugadorL3 = Integer.valueOf(contenido[4]);
                            int idJugadorL4 = Integer.valueOf(contenido[5]);
                            int idJugadorL5 = Integer.valueOf(contenido[6]);
                            int idJugadorL6 = Integer.valueOf(contenido[7]);
                            int idJugadorL7 = Integer.valueOf(contenido[8]);
                            int idJugadorL8 = Integer.valueOf(contenido[9]);
                            int idJugadorL9 = Integer.valueOf(contenido[10]);
                            int idJugadorL10 = Integer.valueOf(contenido[11]);
                            int idJugadorL11 = Integer.valueOf(contenido[12]);
                            int idJugadorV1 = Integer.valueOf(contenido[13]);
                            int idJugadorV2 = Integer.valueOf(contenido[14]);
                            int idJugadorV3 = Integer.valueOf(contenido[15]);
                            int idJugadorV4 = Integer.valueOf(contenido[16]);
                            int idJugadorV5 = Integer.valueOf(contenido[17]);
                            int idJugadorV6 = Integer.valueOf(contenido[18]);
                            int idJugadorV7 = Integer.valueOf(contenido[19]);
                            int idJugadorV8 = Integer.valueOf(contenido[20]);
                            int idJugadorV9 = Integer.valueOf(contenido[21]);
                            int idJugadorV10 = Integer.valueOf(contenido[22]);
                            int idJugadorV11 = Integer.valueOf(contenido[23]);
                            String posicionL1 = contenido[24];
                            String posicionL2 = contenido[25];
                            String posicionL3 = contenido[26];
                            String posicionL4 = contenido[27];
                            String posicionL5 = contenido[28];
                            String posicionL6 = contenido[29];
                            String posicionL7 = contenido[30];
                            String posicionL8 = contenido[31];
                            String posicionL9 = contenido[32];
                            String posicionL10 = contenido[33];
                            String posicionL11 = contenido[34];
                            String posicionV1 = contenido[35];
                            String posicionV2 = contenido[36];
                            String posicionV3 = contenido[37];
                            String posicionV4 = contenido[38];
                            String posicionV5 = contenido[39];
                            String posicionV6 = contenido[40];
                            String posicionV7 = contenido[41];
                            String posicionV8 = contenido[42];
                            String posicionV9 = contenido[43];
                            String posicionV10 = contenido[44];
                            String posicionV11 = contenido[45];
                            String liga = contenido[46];
                            String temporada = contenido[47];
                            String fecha = contenido[48];

                            //creo el nuevo partido
                            PartidoCompleto partidoCNuevo = new PartidoCompleto(fecha, temporada, liga, idEquipo1, idEquipo2);
                            //comienzo a poblar las listas de partido con la informacion de la linea
                            //como el partido no tiene id, se concatena los id de los dos equipos del partido de forma provisoria
                            Nodo<PartidoCompleto> nodo = new Nodo(String.valueOf(idEquipo1).concat("vs").concat(String.valueOf(idEquipo2)), partidoCNuevo);

                            this.listaPartidosCompletos.insertarPrimero(nodo);

                            //EQUIPOS
                            /*
                            Para cada id de equipo, lo busco en la lista de quipos, si es un equipo existente,
                            tengo que clonar ese nodo y se le asigna al objeto equipo del partido
                            los el objeto equipo del nodo encontrado.
                            En el caso que el id no se encuentre se inserta un objeto provisorio el cual
                            posteriormente servira para filtrar informacion
                            */
                            if (this.listaEquipos.buscar(idEquipo1) != null) {
                                //busco el id del equipo en la lista de equipos
                                Nodo<Equipo> equipo = this.listaEquipos.buscar(idEquipo1).clonar();//clonar nodo encontrado
                                partidoCNuevo.setEquipoLocal(equipo.getDato()); //seteo el equipo del partipo por el dato del nodo
                            } else {
                                Equipo equipoAux = new Equipo(idEquipo1, "NA"); //inserccion de equipo auxiliar
                                partidoCNuevo.setEquipoLocal(equipoAux);

                            }
                            if (this.listaEquipos.buscar(idEquipo2) != null) {
                                Nodo<Equipo> equipo = this.listaEquipos.buscar(idEquipo2).clonar();
                                partidoCNuevo.setEquipoVisitante(equipo.getDato());
                            } else {
                                Equipo equipoAux = new Equipo(idEquipo2, "NA");
                                partidoCNuevo.setEquipoVisitante(equipoAux);

                            }
                            //JUGADORES DEL EQUIPO LOCAL
                            /*
                            PARA CADA ID DE JUGADOR, lo busco en la lista de jugadores, si es un jugador existente,
                            tengo que clonar ese nodo.
                            Agrego el nodo clonado a la lista de jugadores locales del partido.
                            agrego el id del jugador en el vector que guarda los id de los jugadores locales.
                            agrego la poscicion que ocupa el jugador en el vector que guarda la formacion del equipo local
                            Estos dos ultimos se agregan en indices equivalentes.
                            Luego recorro la lista de ligas del jugador, si la liga del partido no fue ingresada aun en este jugador,
                            le inserto un nodo liga, de lo contrario no inserto ligas repetidas.
                            Si el jugador no existe en la lista de jugadores, se inserta un jugador provisorio con un valor que posteriormente
                            ayudara a filtrar la informacion
                            */
                            if (this.listaJugadores.buscar(idJugadorL1) != null) {
                                //busco el jugador en la lista de jugadores
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL1).clonar(); //si existe, clonar nodo encontrado
                                partidoCNuevo.jugadoresLocal.insertar(jugador); //inserto nodo en lista de jugadores
                                partidoCNuevo.jugadoresLocalId[0] = idJugadorL1; //guardo el id del jugador
                                partidoCNuevo.posicionesLocal[0] = posicionL1; //guardo la posicion del jugador

                                if (jugador.getDato().susLigas().buscar(liga) == null) { //verifico si la liga del partido ya esta agregada a las ligas del jugador
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null)); //agrego liga al jugador
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL1, "NA"); //jugador provisorio
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL2) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL2).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[1] = idJugadorL2;
                                partidoCNuevo.posicionesLocal[1] = posicionL2;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL2, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL3) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL3).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[2] = idJugadorL3;
                                partidoCNuevo.posicionesLocal[2] = posicionL3;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }

                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL3, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL4) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL4).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[3] = idJugadorL4;
                                partidoCNuevo.posicionesLocal[3] = posicionL4;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL4, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL5) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL5).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[4] = idJugadorL5;
                                partidoCNuevo.posicionesLocal[4] = posicionL5;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL5, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL6) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL6).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[5] = idJugadorL6;
                                partidoCNuevo.posicionesLocal[5] = posicionL6;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL6, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL7) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL7).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[6] = idJugadorL7;
                                partidoCNuevo.posicionesLocal[6] = posicionL7;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL7, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL8) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL8).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[7] = idJugadorL8;
                                partidoCNuevo.posicionesLocal[7] = posicionL8;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL8, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL9) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL9).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[8] = idJugadorL9;
                                partidoCNuevo.posicionesLocal[8] = posicionL9;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL9, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL10) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL10).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[9] = idJugadorL10;
                                partidoCNuevo.posicionesLocal[9] = posicionL10;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL10, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorL11) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorL11).clonar();
                                partidoCNuevo.jugadoresLocal.insertar(jugador);
                                partidoCNuevo.jugadoresLocalId[10] = idJugadorL11;
                                partidoCNuevo.posicionesLocal[10] = posicionL11;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorL11, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresLocal.insertar(jugador);

                            }
                            //JUGADORES DEL EQUIPO VISITANTE
                            /*PARA CADA ID DE JUGADOR, lo busco en la lista de jugadores, si es un jugador existente,
                            tengo que clonar ese nodo.
                            Agrego el nodo clonado a la lista de jugadores visitantes del partido.
                            agrego el id del jugador en el vector que guarda los id de los jugadores visitantes.
                            agrego la poscicion que ocupa el jugador en el vector que guarda la formacion del equipo visitante
                            Estos dos ultimos se agregan en indices equivalentes.
                            Luego recorro la lista de ligas del jugador, si la liga del partido no fue ingresada aun en este jugador,
                            le inserto un nodo liga, de lo contrario no inserto ligas repetidas.
                            Si el jugador no existe en la lista de jugadores, se inserta un jugador provisorio con un valor que posteriormente
                            ayudara a filtrar la informacion
                            */

                            if (this.listaJugadores.buscar(idJugadorV1) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV1).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[0] = idJugadorV1;
                                partidoCNuevo.posicionesVisitante[0] = posicionV1;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV1, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV2) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV2).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[1] = idJugadorV2;
                                partidoCNuevo.posicionesVisitante[1] = posicionV2;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV2, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV3) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV3).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[2] = idJugadorV3;
                                partidoCNuevo.posicionesVisitante[2] = posicionV3;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV3, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV4) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV4).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[3] = idJugadorV4;
                                partidoCNuevo.posicionesVisitante[3] = posicionV4;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV4, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV5) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV5).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[4] = idJugadorV5;
                                partidoCNuevo.posicionesVisitante[4] = posicionV5;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV5, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV6) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV6).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[5] = idJugadorV6;
                                partidoCNuevo.posicionesVisitante[5] = posicionV6;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV6, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV7) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV7).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[6] = idJugadorV7;
                                partidoCNuevo.posicionesVisitante[6] = posicionV7;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV7, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV8) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV8).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[7] = idJugadorV8;
                                partidoCNuevo.posicionesVisitante[7] = posicionV8;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV8, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                jugador.getDato().susLigas().insertar(new Nodo(liga, null));

                            }
                            if (this.listaJugadores.buscar(idJugadorV9) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV9).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[8] = idJugadorV9;
                                partidoCNuevo.posicionesVisitante[8] = posicionV9;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV9, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV10) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV10).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[9] = idJugadorV10;
                                partidoCNuevo.posicionesVisitante[9] = posicionV10;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV10, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }
                            if (this.listaJugadores.buscar(idJugadorV11) != null) {
                                Nodo<Jugador> jugador = this.listaJugadores.buscar(idJugadorV11).clonar();
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);
                                partidoCNuevo.jugadoresVisitanteId[10] = idJugadorV11;
                                partidoCNuevo.posicionesVisitante[10] = posicionV11;
                                if (jugador.getDato().susLigas().buscar(liga) == null) {
                                    jugador.getDato().susLigas().insertar(new Nodo(liga, null));
                                }
                            } else {
                                Jugador jugadorAux = new Jugador(idJugadorV11, "NA");
                                Nodo<Jugador> jugador = new Nodo(jugadorAux.getId(), jugadorAux);
                                partidoCNuevo.jugadoresVisitante.insertar(jugador);

                            }

                            // } 
                        
                    }
                }
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
        System.out.println("Archivo " + nombreArchivo + " leido satisfactoriamente");
    }
    /**
     * Metodo que crea las ligas y temporadas que se usaran en los calculos
     */
    public void crearTemporadasLigas() {
        System.out.println("creando ligas y temporadas");

        Nodo<PartidoCompleto> nodoPartido = this.listaPartidosCompletos.getPrimero();
        //se recorre la lista de partidos completos
        while (nodoPartido != null) {
            //por cada partido creo un objeto y un nodo con la informacion relacionada a la temporada del partido
            Temporada temporadaNueva = new Temporada(nodoPartido.getDato().getTemporada());
            Nodo<Temporada> temporadaInsertar = new Nodo(temporadaNueva.getId(), temporadaNueva);
            //busco si el nodo ya existe
            if (listaTemporadas.buscar(temporadaInsertar.getEtiqueta()) == null) {
                //si el nodo no se encuentra inserto en la lista
                listaTemporadas.insertar(temporadaInsertar);
            }

            nodoPartido = nodoPartido.getSiguiente();
        }
        //se vuelve a recorrert la lista de partidos
        Nodo<PartidoCompleto> nodoPartido2 = this.listaPartidosCompletos.getPrimero();
        while (nodoPartido2 != null) {
            //se crea un objeto y un nodo con la informacion referente a la liga del partido
            Liga ligaNueva = new Liga(nodoPartido2.getDato().getLiga());
            Nodo<Liga> ligaInsertar = new Nodo(ligaNueva.getId(), ligaNueva);
            //busco si el nodo ya existe
            if (listaLigas.buscar(ligaInsertar.getEtiqueta()) == null) {
                //si el nodo no existe lo inserto en la lista
                listaLigas.insertar(ligaInsertar);

            }

            nodoPartido2 = nodoPartido2.getSiguiente();

        }
    }
    public void depuradorPartidosCompletosJugador() {

        System.out.println("Trabajando en filtrar informacion");
        Nodo<PartidoCompleto> partido = this.listaPartidosCompletos.getPrimero();
        while (partido != null) {
            boolean flag1 = false;
            boolean flag2 = false;
            Nodo<Jugador> aux = partido.getDato().jugadoresLocal.getPrimero();
            while (aux != null) {
                if ((this.listaJugadores.buscar(aux.getEtiqueta()) != null)&& (!aux.getDato().getNombre().equals("NA"))) {
                    flag1 = true;

                }
                aux = aux.getSiguiente();
            }
            Nodo<Jugador> aux2 = partido.getDato().jugadoresVisitante.getPrimero();
            while (aux2 != null) {
                if ((this.listaJugadores.buscar(aux2.getEtiqueta())!= null)&& (!aux2.getDato().getNombre().equals("NA"))){
                    flag2 = true;

                }
                aux2 = aux2.getSiguiente();
            }
            if(flag1 == true && flag2 == true){
                this.partidosCompletosFase2.insertar(partido.clonar());
                
            }
            partido = partido.getSiguiente();

        }

    }
    public void depuradorPartidos() {
        System.out.println("trabajando en la depuracion de informacion");
        Nodo<PartidoCompleto> aux = this.partidosCompletosFase2.getPrimero();
        while (aux != null) {
            Nodo<Partido> aux2 = this.listaPartidos.getPrimero();
            while (aux2 != null) {
                if (aux.getDato().getLiga().equals(aux2.getDato().getLiga())) {
                    if (aux.getDato().getTemporada().equals(aux2.getDato().getTemporada())) {
                        if (aux.getDato().getIdLocal() == (aux2.getDato().getLocal())) {
                            if (aux.getDato().getIdVisitante() == aux2.getDato().getVisitante()) {
                                aux.getDato().setId(aux2.getDato().getId());
                            }
                        }
                    }
                }

                aux2 = aux2.getSiguiente();
            }
            aux = aux.getSiguiente();

        }
        Nodo<PartidoCompleto> aux3 = this.partidosCompletosFase2.getPrimero();
        while (aux3 != null) {
            if (aux3.getDato().getId() == null) {
                partidosCompletosFase2.eliminar(aux3.getEtiqueta());
            }
            aux3 = aux3.getSiguiente();
        }
    }



    public void depuradorDeEventos() {
        System.out.println("trabajando en la depuracion de eventos");
        Nodo<Evento> aux = this.listaEventos.getPrimero();
        while (aux != null) {
            Nodo<PartidoCompleto> aux2 = this.partidosCompletosFase2.getPrimero();
            while (aux2 != null) {
                if (aux.getDato().getIdPartido().equals(aux2.getDato().getId())) {
                    aux.getDato().setVerificadoUno();
                    aux.getDato().setTemporada(aux2.getDato().getTemporada());
                    listaEventosFase1.insertarPrimero(aux.clonar());
                    break;
                }
                aux2 = aux2.getSiguiente();
            }
            aux = aux.getSiguiente();

        }

    }
    /**
     * Metodo encargado de obtener el nombre del jugador que aparece en un evento,
     * encontrar su id y agregarlo al mismo
     */
    public void transformacionEventoJugador() {

        System.out.println("Transformando los jugadores de los eventos..");
        Nodo<Evento> evento = this.listaEventosFase1.getPrimero();

        //comienzo a recorrer los eventos
        while (evento != null) {
            //guardo en una variable el id del jugador
            int variableId = nombreIdJugador(evento.getDato().getJugador());
            //verifico si el jugador existe en la lista de jugadores
            if (this.listaJugadores.buscar(variableId) != null) {
                //si el jugador es valido, seteo el id del jugador
                evento.getDato().setJugador(variableId);
                //cambio el valor de la variable jugadorTransformado a 1
                evento.getDato().setJugadorTransformado();

            }
            evento = evento.getSiguiente();

        }
        //vuelvo a recorrer los eventos
        Nodo<Evento> eventoFinal = this.listaEventosFase1.getPrimero();
        while (eventoFinal != null) {
            //verifico si quedo algun evento cuyos jugadores no hayan sido transformados por no existir los mismos
            if (eventoFinal.getDato().getJugadorTransformado() == 0) {
                this.listaEventosFase1.eliminar(eventoFinal.getEtiqueta());//DEBERIA SER UN FASE 2
                // System.out.println("eliminado");
            }
            eventoFinal = eventoFinal.getSiguiente();
        }

    }
    /**
     * Metodo encargado de obtener el nombre del equipo que aparece en un evento,
     * encontrar su id y agregarlo al mismo
     */
    public void transformacionEventoEquipoEvento() {

        System.out.println("Transformando los equipos de los eventos..");
        Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
        //comienzo a recorrer los eventos
        while (evento != null) {
            //guardo en una variable el id del equipo del evento
            int variableId = nombreIdEquipo(evento.getDato().getEquipoEvento());
            //verifico si el equipo existe en la lista de equipos
            if (this.listaEquipos.buscar(variableId) != null) {
                //seteo el id del equipo
                evento.getDato().setIdEquipoEvento(variableId);
                //cambio el valor de la variable a uno
                evento.getDato().setEquiposTransformados();
            }
            evento = evento.getSiguiente();
        }
        //vuelvo a recorrer la lista
        Nodo<Evento> eventoFinal = this.listaEventosFase1.getPrimero();
        while (eventoFinal != null) {
            //verifico si quedo algun evento cuyos equipos no hayan sido transformados por no existir los mismos
            if (eventoFinal.getDato().getEquiposTransformados() == 0) {
                this.listaEventosFase1.eliminar(eventoFinal.getEtiqueta()); //deberia ser una FASE 2 O 3
            }
            eventoFinal = eventoFinal.getSiguiente();
        }

    }
    /**
     * Metodo encargado de obtener el nombre del equipo oponente que aparece en un evento,
     * encontrar su id y agregarlo al mismo
     */
    public void transformacionEventoEquipoOponente() {
        System.out.println("Transformando los equipos de los eventos..");
        Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
        //comienzo a recorrer los eventos
        while (evento != null) {
            //verifico si el equipo existe en la lista de equipos
            int variableId2 = nombreIdEquipo(evento.getDato().getOponente());
            if (this.listaEquipos.buscar(variableId2) != null) {
                //seteo el id del equipo
                evento.getDato().setOponente(variableId2);
                //cambio el valor de la variable a cero
                evento.getDato().setEquiposTransformadosCero();
            }
            evento = evento.getSiguiente();

        }
        //vuelvo a recorrer la lista
        Nodo<Evento> eventoFinal = this.listaEventosFase1.getPrimero();
        while (eventoFinal != null) {
            //verifico si quedo algun evento cuyos jugadores no hayan sido transformados por no existir los mismos
            if (eventoFinal.getDato().getEquiposTransformados() == 1) {
                this.listaEventosFase1.eliminar(eventoFinal.getEtiqueta()); //deberia ser una FASE 2 O 3
            }
            eventoFinal = eventoFinal.getSiguiente();
        }

    }

    public void asignarEventoJugador() {
        /**
         * Metodo que asigna a cada jugador, sus eventos asociados
         */
        System.out.println("Asignando eventos al jugador");
        Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
        //recorro los eventos
        while (evento != null) {
            Nodo<Jugador> jugador = this.listaJugadores.getPrimero();
            //recorro los jugadores
            while (jugador != null) {
                //verifico si el id del jugador, coincide con el id de jugador del evento
                if (jugador.getDato().getId() == evento.getDato().getIdJugador()) {
                    //se clona el nodo del evento y se inserta en la lista de eventos del jugador
                    jugador.getDato().susEventos().insertarPrimero(evento.clonar());
                }
                jugador = jugador.getSiguiente();

            }

            evento = evento.getSiguiente();

        }

    }
    /**
     * Metodo que imprime toda la informacion de los jugadores
     */
    @Override
    public void imprimirJugadores() {
        
        //verifico si la lista es vacia
        if (listaJugadores.esVacia()) {
            System.out.println("Lista vacia");
        }
        Nodo<Jugador> aux = this.listaJugadores.getPrimero();
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
        if (listaEquipos.esVacia()) {
            System.out.println("Lista vacia");
        }
        Nodo<Equipo> aux = this.listaEquipos.getPrimero();
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
        
        if (listaPartidos.esVacia()) {
            System.out.println("Lista vacia");
        }
        //recorro lista de partidos
        Nodo<Partido> aux = this.listaPartidos.getPrimero();
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
        
        if (listaPartidosCompletos.esVacia()) {
            System.out.println("Lista vacia");
        }
        //recorro lista de partidos
        Nodo<PartidoCompleto> aux = this.listaPartidosCompletos.getPrimero();
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
        
        if (listaEventos.esVacia()) {
            System.out.println("lista vacia");
        }
        //recorro lista de eventos
        Nodo<Evento> aux = this.listaEventosFase1.getPrimero();
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
        Nodo<Liga> aux = this.listaLigas.getPrimero();
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
            System.out.println("lista vacia");
        }
        //recorro lista de temporadas
        Nodo<Temporada> aux = this.listaTemporadas.getPrimero();
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
        return this.listaEquipos.cantElementos();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadJugadores() {
        return this.listaJugadores.cantElementos();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadPartidos() {
        return this.listaPartidos.cantElementos();
    }

       public int cantidadPartidosCompletos() {
        return this.listaPartidosCompletos.cantElementos();
    }
    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadPartidosCompletosVerificados() {
        return this.partidosCompletosFase2.cantElementos();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadPartidosCompletosVerificado() { //al final me quedo solo con esta
        return this.partidosCompletosFase2.cantElementos();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadEventos() {
        return this.listaEventos.cantElementos();
    }

    /**
     * Metodo que retorna la cantidad de elementos de la lista
     *
     * @return
     */
    public int cantidadEventosVerificados() {
        return this.listaEventosFase1.cantElementos();
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
     * Metodo que dado el id de un jugador, devuelve su nombre como cadena de caracteres
     * @param unId
     * @return 
     */
    public String idNombreJugador(int unId) {
        
        //variable que almacenara el resultado final
        String resultado = "";
        Nodo<Jugador> aux = this.listaJugadores.getPrimero();
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
        Nodo<Equipo> aux = this.listaEquipos.getPrimero();
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
    /**
     * Metodo encargado de devolver el id de un jugador dado un nombre
     * recibido por parametro
     * @param unNombre
     * @return 
     */
    public int nombreIdJugador(String unNombre) {
        //variable que guardara el resultado
        int resultado = 0;
        Nodo<Jugador> aux = this.listaJugadores.getPrimero();
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
     * Metodo encargado de devolver el id de un equipo dado un nombre
     * recibido por parametro
     * @param unNombre
     * @return 
     */
    public int nombreIdEquipo(String unNombre) {
        //variable que guardara el resultado
        int resultado = 0;
        Nodo<Equipo> aux = this.listaEquipos.getPrimero();
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
     * Metodo que dada una lista recibida por parametro,
     * devuelve el jugador que tiene mas eventos asociados.
     * @param lista
     * @return 
     */
    public Nodo<Jugador> masParticipacion(Lista<Jugador> lista) {
        Nodo<Jugador> jugador = lista.getPrimero();
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
                Nodo<PartidoCompleto> partido = this.listaPartidosCompletos.getPrimero();
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
                            resultados.insertar(local);
                            resultados.insertar(Visitante);

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
    public void nombreLigasDeJugador(String nombreJugador) {
        boolean flag = false;
        Nodo<Jugador> aux = this.listaJugadores.getPrimero();
        //recorro la lista de jugadores
        while (aux != null) {
            //verifico que el jugador exista en la lista de jugadores
            if (aux.getDato().getNombre().equals(nombreJugador)) {
                //verifico si el jugador tiene una lista de ligas con informacion
                if (!(aux.getDato().susLigas().esVacia())) {
                    //imprimo la informacion de las ligas
                    aux.getDato().infoLigas();
                    flag = true;
                }
            }
            aux = aux.getSiguiente();
        }
        //si la bandera no cambio, significa que no tiene ligas asociadas
        if (flag == false) {
            System.out.println("no se encuentran ligas para " + nombreJugador);
        }

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
            Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
            //recorro los eventos
            while (evento != null) {
                //verifico que el evento sea de tipo Evento = 1 (attemp)
                if (evento.getDato().getTipoEvento() == 1) {
                    //verifico que el resultado de la jugada sea = 1 (saved)
                    if (evento.getDato().resultadoJugada().equals("1")) {
                        //verifico que el gol =0 (no hubo gol)
                        if (evento.getDato().getGol() == 0) {
                            Nodo<PartidoCompleto> partido = this.partidosCompletosFase2.getPrimero();
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
                                                Nodo<Jugador> arquero = partido.getDato().jugadoresVisitante.buscar(idArquero).clonar();
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
        Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
        //recorro los eventos
        while (evento != null) {
            //verifico que los atributos del evento indiquen un gol salvado
            if (evento.getDato().getTipoEvento() == 1) {
                if (evento.getDato().resultadoJugada().equals("1")) {
                    if (evento.getDato().getGol() == 0) {
                        Nodo<PartidoCompleto> partido = this.partidosCompletosFase2.getPrimero();
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
                                        Nodo<Jugador> arquero = partido.getDato().jugadoresVisitante.buscar(idArquero).clonar();
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
        this.eleven.insertar(mejorArquero);
        System.out.println("-Mejor arquero es:");
        mejorArquero.getDato().infoReducido();
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
        Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
        while (evento != null) {
            //se recorre la lista de eventos en busqueda de eventos de intentos bloqueados o corner del lado del equipo visitante
            if ((evento.getDato().getTipoEvento() == 1 && evento.getDato().resultadoJugada().equals("3"))
                    || (evento.getDato().getTipoEvento() == 2 && evento.getDato().getLadoCancha() == 2)) {
                Nodo<PartidoCompleto> partido = this.partidosCompletosFase2.getPrimero();
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
                                                Nodo<Jugador> zaguero = partido.getDato().jugadoresVisitante.buscar(idLocales[j]).clonar();
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
            this.eleven.insertar(zagueroResultante);
            switch (posicionCodigo) {
                case "ZI":
                    System.out.println("-El Zaguero izquierdo es:");
                    zagueroResultante.getDato().infoReducido();
                    System.out.println("Con " + ocurrencias + " intentos bloqueados desde esta posicion");
                    break;
                case "ZD":
                    System.out.println("-El Zaguero Derecho es:");
                    zagueroResultante.getDato().infoReducido();
                    System.out.println("Con " + ocurrencias + " intentos bloqueados desde esta posicion");
                    break;
                 case "ZC":
                    System.out.println("-El Zaguero Central es:");
                    zagueroResultante.getDato().infoReducido();
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
        Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
        while (evento != null) {
            //recorro los eventos en los cuales existan eventos de gol
            if (evento.getDato().getTipoEvento() == 1) {
                if (evento.getDato().getGol() == 1) {
                    Nodo<PartidoCompleto> partido = this.partidosCompletosFase2.getPrimero();
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
                                                    Nodo<Jugador> delantero = partido.getDato().jugadoresLocal.buscar(idLocales[j]).clonar();
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
            this.eleven.insertar(delanteroResultante);
            switch (posicionCodigo) {
                case "DI":
                    System.out.println("-El delantero izquierdo es:");
                    delanteroResultante.getDato().infoReducido();
                    System.out.println("Con " + ocurrencias + " goles realizados desde esta posicion");
                    break;
                case "DD":
                    System.out.println("-El delantero Derecho es:");
                    delanteroResultante.getDato().infoReducido();
                    System.out.println("Con " + ocurrencias + " goles realizados desde esta posicion");
                    break;
                case "DC":
                    System.out.println("-El delantero Central es:");
                    delanteroResultante.getDato().infoReducido();
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
        Nodo<PartidoCompleto> partido = this.partidosCompletosFase2.getPrimero();
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
                                Nodo<Jugador> medioCampista = partido.getDato().jugadoresLocal.buscar(idLocales[j]).clonar();
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
            Nodo<Jugador> delanteroResultante = medios.buscar(idmedio).clonar();
            this.eleven.insertar(delanteroResultante);
            switch (posicionCodigo) {
                case "MI":
                    System.out.println("-El Medio Campista izquierdo es:");
                    delanteroResultante.getDato().infoReducido();
                    System.out.println("Con " + eventos + " participaciones desde esta posicion");
                    break;
                case "MD":
                    System.out.println("-El Medio Campista Derecho es:");
                    delanteroResultante.getDato().infoReducido();
                    System.out.println("Con " + eventos + " participaciones desde esta posicion");
                    break;
                case "MC":
                    System.out.println("-El Medio Campista Central es:");
                    delanteroResultante.getDato().infoReducido();
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
            Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
            while (evento != null) {
                //recorro todos los eventos buscando aquellos en los que haya un intento de gol bloqueado
                if (evento.getDato().getTipoEvento() == 1) {
                    if (evento.getDato().resultadoJugada().equals("2")) {
                        Nodo<PartidoCompleto> partido = this.partidosCompletosFase2.getPrimero();
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
                                                            Nodo<Jugador> delantero = partido.getDato().jugadoresLocal.buscar(idLocales[j]).clonar();
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
            Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
            while (evento != null) {
                //recorro los eventos que coincidan en la temporada y que tengan un evento de gol
                if (evento.getDato().getTemporada().equals(temporada)) {
                    if (evento.getDato().getGol() == 1) {
                        //busco en la lista de quipos el id del equipo del evento
                        if (this.listaEquipos.buscar(evento.getDato().getEquipoEventoId()) != null) {
                            //si el equipo existe clono el nodo y lo guardo en la lista de resultados
                            Nodo<Equipo> aux = this.listaEquipos.buscar(evento.getDato().getEquipoEventoId()).clonar();
                            equiposGol.insertar(aux);
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
            Nodo<Evento> evento = this.listaEventosFase1.getPrimero();
            while (evento != null) {
                //recorro los eventos que coincidan en la temporada y que tengan un evento de gol
                if (evento.getDato().getTemporada().equals(temporada)) {
                    if (evento.getDato().getGol() == 1) {
                         //si el equipo existe clono el nodo y lo guardo en la lista de resultados
                        if (this.listaEquipos.buscar(evento.getDato().getOponenteId()) != null) {
                            Nodo<Equipo> aux = this.listaEquipos.buscar(evento.getDato().getOponenteId()).clonar();

                            equiposGol.insertar(aux);
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

}
