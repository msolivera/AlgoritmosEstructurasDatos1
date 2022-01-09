
package elevenResultados;
import elevenEntidades.*;
import elevenBasicArbolBB.*;
import elevenBasicLista.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Meki
 */
public class GestorDeInfo {
    
    public ElevenCalculador eleven;
    Lista<Partido> partidos;
    Lista<PartidoCompleto> partidosCompletos;


public GestorDeInfo (ElevenCalculador calculador){
    
    eleven = calculador;
    partidos = new Lista<>();
    partidosCompletos = new Lista<>();
}

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
                        TElementoAB <Jugador> nodo = new TElementoAB (jugadorNuevo.getId(), jugadorNuevo);
                        //Nodo<Jugador> nodo = new Nodo(jugadorNuevo.getId(), jugadorNuevo);
                        this.eleven.getArbolJugadores().insertar(nodo);
                    
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
                         TElementoAB <Equipo> nodo = new TElementoAB(equipoNuevo.getId(), equipoNuevo);
                        //Nodo<Equipo> nodo = new Nodo(equipoNuevo.getId(), equipoNuevo);
                        if (this.eleven.getArbolEquipos().buscar(nodo.getEtiqueta()) == null) {

                        this.eleven.getArbolEquipos().insertar(nodo);
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
                        int local = this.eleven.nombreIdEquipo(contenido[4]);
                        int visitante = this.eleven.nombreIdEquipo(contenido[5]);

                        //crear el Partido
                        Partido partidoNuevo = new Partido(id, fecha, liga, temporada, local, visitante);
                        //creo el nodo a insertar
                        TElementoAB<Partido> nodo = new TElementoAB(partidoNuevo.getId(), partidoNuevo);
                        Nodo<Partido> nodoParaFiltro = new Nodo(partidoNuevo.getId(), partidoNuevo);
                        //Nodo<Partido> nodo = new Nodo(partidoNuevo.getId(), partidoNuevo);
                        this.partidos.insertarPrimero(nodoParaFiltro);
                        this.eleven.getArbolPartidos().insertar(nodo);

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
                        
                        TElementoAB<Evento> nodoEvento = new TElementoAB(idEvento, evento);
                        this.eleven.getArbolEventos().insertar(nodoEvento);

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

   // public void cargarPartidosCompleto(String nombreArchivo) {
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

                            this.partidosCompletos.insertarPrimero(nodo);

                            //EQUIPOS
                            /*
                            Para cada id de equipo, lo busco en la lista de quipos, si es un equipo existente,
                            tengo que clonar ese nodo y se le asigna al objeto equipo del partido
                            los el objeto equipo del nodo encontrado.
                            En el caso que el id no se encuentre se inserta un objeto provisorio el cual
                            posteriormente servira para filtrar informacion
                            */
                            Lista<Equipo> listaEquipos = this.eleven.getArbolEquipos().inOrden();
                            if (listaEquipos.buscar(idEquipo1) != null) {
                                //busco el id del equipo en la lista de equipos
                                Nodo<Equipo> equipo = listaEquipos.buscar(idEquipo1).clonar();//clonar nodo encontrado
                                partidoCNuevo.setEquipoLocal(equipo.getDato()); //seteo el equipo del partipo por el dato del nodo
                            } else {
                                Equipo equipoAux = new Equipo(idEquipo1, "NA"); //inserccion de equipo auxiliar
                                partidoCNuevo.setEquipoLocal(equipoAux);

                            }
                            if (listaEquipos.buscar(idEquipo2) != null) {
                                Nodo<Equipo> equipo = listaEquipos.buscar(idEquipo2).clonar();
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
                            Lista<Jugador> listaJugadores = this.eleven.getArbolJugadores().inOrden();
                            if (listaJugadores.buscar(idJugadorL1) != null) {
                                //busco el jugador en la lista de jugadores
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL1).clonar(); //si existe, clonar nodo encontrado
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
                            if (listaJugadores.buscar(idJugadorL2) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL2).clonar();
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
                            if (listaJugadores.buscar(idJugadorL3) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL3).clonar();
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
                            if (listaJugadores.buscar(idJugadorL4) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL4).clonar();
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
                            if (listaJugadores.buscar(idJugadorL5) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL5).clonar();
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
                            if (listaJugadores.buscar(idJugadorL6) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL6).clonar();
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
                            if (listaJugadores.buscar(idJugadorL7) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL7).clonar();
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
                            if (listaJugadores.buscar(idJugadorL8) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL8).clonar();
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
                            if (listaJugadores.buscar(idJugadorL9) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL9).clonar();
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
                            if (listaJugadores.buscar(idJugadorL10) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL10).clonar();
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
                            if (listaJugadores.buscar(idJugadorL11) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorL11).clonar();
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

                            if (listaJugadores.buscar(idJugadorV1) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV1).clonar();
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
                            if (listaJugadores.buscar(idJugadorV2) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV2).clonar();
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
                            if (listaJugadores.buscar(idJugadorV3) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV3).clonar();
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
                            if (listaJugadores.buscar(idJugadorV4) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV4).clonar();
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
                            if (listaJugadores.buscar(idJugadorV5) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV5).clonar();
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
                            if (listaJugadores.buscar(idJugadorV6) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV6).clonar();
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
                            if (listaJugadores.buscar(idJugadorV7) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV7).clonar();
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
                            if (listaJugadores.buscar(idJugadorV8) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV8).clonar();
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
                            if (listaJugadores.buscar(idJugadorV9) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV9).clonar();
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
                            if (listaJugadores.buscar(idJugadorV10) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV10).clonar();
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
                            if (listaJugadores.buscar(idJugadorV11) != null) {
                                Nodo<Jugador> jugador = listaJugadores.buscar(idJugadorV11).clonar();
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
 
    public void cargarPartidosCompletoArbol() {
        Nodo<PartidoCompleto> aux = this.partidosCompletos.getPrimero();
        while (aux != null) {
            Nodo<Partido> aux2 = this.partidos.getPrimero();
            while (aux2 != null) {
                if (aux.getDato().getFecha().equals(aux2.getDato().getFecha())) {
                    if (aux.getDato().getLocal() == (aux2.getDato().getLocal())) {
                        if (aux.getDato().getVisitante() == aux2.getDato().getVisitante()) {
                            aux.getDato().setId(aux2.getDato().getId());
                            TElementoAB<PartidoCompleto> partido = new TElementoAB(aux.getEtiqueta(), aux.getDato());
                            this.eleven.getArbolPartidosCompletos().insertar(partido);
                        }
                    }
                }
               aux2 = aux2.getSiguiente();
            }
            aux = aux.getSiguiente();

        }
    }
    /**
     * Metodo que crea las ligas y temporadas que se usaran en los calculos
     */
    public void crearTemporadasLigas() {
        System.out.println("creando ligas y temporadas");
        Lista<PartidoCompleto> listaPartidosCompletos = this.eleven.getArbolPartidosCompletos().inOrden();
        Nodo<PartidoCompleto> nodoPartido = listaPartidosCompletos.getPrimero();
        //se recorre la lista de partidos completos
        while (nodoPartido != null) {
            //por cada partido creo un objeto y un nodo con la informacion relacionada a la temporada del partido
            Temporada temporadaNueva = new Temporada(nodoPartido.getDato().getTemporada());
            Liga ligaNueva = new Liga(nodoPartido.getDato().getLiga());
            Nodo<Temporada> temporadaInsertar = new Nodo(temporadaNueva.getId(), temporadaNueva);
            Nodo<Liga> ligaInsertar = new Nodo(ligaNueva.getId(), ligaNueva);
            //busco si el nodo ya existe
            if (this.eleven.getListaTemporadas().buscar(temporadaInsertar.getEtiqueta()) == null) {
                //si el nodo no se encuentra inserto en la lista
                this.eleven.getListaTemporadas().insertar(temporadaInsertar);
            }
            if (this.eleven.getListaLigas().buscar(ligaInsertar.getEtiqueta()) == null) {
                //si el nodo no existe lo inserto en la lista
                this.eleven.getListaLigas().insertar(ligaInsertar);

            }

            nodoPartido = nodoPartido.getSiguiente();
        }
    }

    /**
     * Metodo encargado de obtener el nombre del jugador que aparece en un evento,
     * encontrar su id y agregarlo al mismo
     */
    public void transformacionEventoJugador() {
        
        System.out.println("Transformando los jugadores de los eventos..");
        Lista<Evento> listaEventos = this.eleven.getArbolEventos().inOrden();
        int var = 0;
        Nodo<Evento> unEvento = listaEventos.getPrimero();
        //comienzo a recorrer los eventos
        while (unEvento != null) {
            //guardo en una variable el id del jugador
            int variableId = this.eleven.nombreIdJugador(unEvento.getDato().getJugador());
            //verifico si el jugador existe en la lista de jugadores
            if (this.eleven.getArbolJugadores().buscar(variableId) != null) {
                //si el jugador es valido, seteo el id del jugador
                unEvento.getDato().setJugador(variableId);
                //cambio el valor de la variable jugadorTransformado a 1
                unEvento.getDato().setJugadorTransformado();
                //System.out.println("seteado" + variableId);

            }
            unEvento = unEvento.getSiguiente();

        }
        //vuelvo a recorrer los eventos
        Nodo<Evento> eventoFinal =listaEventos.getPrimero();
        while (eventoFinal != null) {
            //verifico si quedo algun evento cuyos jugadores no hayan sido transformados por no existir los mismos
            if (eventoFinal.getDato().getJugadorTransformado() == 0) {
               this.eleven.getArbolEventos().eliminar(eventoFinal.getEtiqueta());
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
        Lista<Evento> listaEventos = this.eleven.getArbolEventos().inOrden();
        System.out.println("Transformando los equipos de los eventos..");
        Nodo<Evento> evento = listaEventos.getPrimero();
        //comienzo a recorrer los eventos
        while (evento != null) {
            //guardo en una variable el id del equipo del evento
            int variableId = this.eleven.nombreIdEquipo(evento.getDato().getEquipoEvento());
            //verifico si el equipo existe en la lista de equipos
            if (this.eleven.getArbolEquipos().buscar(variableId) != null) {
                //seteo el id del equipo
                evento.getDato().setIdEquipoEvento(variableId);
                //cambio el valor de la variable a uno
                evento.getDato().setEquiposTransformados();
            }
            evento = evento.getSiguiente();
        }
        //vuelvo a recorrer la lista
        Nodo<Evento> eventoFinal = listaEventos.getPrimero();
        while (eventoFinal != null) {
            //verifico si quedo algun evento cuyos equipos no hayan sido transformados por no existir los mismos
            if (eventoFinal.getDato().getEquiposTransformados() == 0) {
                 this.eleven.getArbolEventos().eliminar(eventoFinal.getEtiqueta()); //deberia ser una FASE 2 O 3
            }
            eventoFinal = eventoFinal.getSiguiente();
        }

    }
    /**
     * Metodo encargado de obtener el nombre del equipo oponente que aparece en un evento,
     * encontrar su id y agregarlo al mismo
     */
    public void transformacionEventoEquipoOponente() {
        Lista<Evento> listaEventos = this.eleven.getArbolEventos().inOrden();
        System.out.println("Transformando los equipos de los eventos..");
        Nodo<Evento> evento = listaEventos.getPrimero();
        //comienzo a recorrer los eventos
        while (evento != null) {
            //verifico si el equipo existe en la lista de equipos
            int variableId2 = this.eleven.nombreIdEquipo(evento.getDato().getOponente());
            if (this.eleven.getArbolEquipos().buscar(variableId2) != null) {
                //seteo el id del equipo
                evento.getDato().setOponente(variableId2);
                //cambio el valor de la variable a cero
                evento.getDato().setEquiposTransformadosCero();
            }
            evento = evento.getSiguiente();

        }
        //vuelvo a recorrer la lista
        Nodo<Evento> eventoFinal = listaEventos.getPrimero();
        while (eventoFinal != null) {
            //verifico si quedo algun evento cuyos jugadores no hayan sido transformados por no existir los mismos
            if (eventoFinal.getDato().getEquiposTransformados() == 1) {
                this.eleven.getArbolEventos().eliminar(eventoFinal.getEtiqueta()); 
            }
            eventoFinal = eventoFinal.getSiguiente();
        }

    }

    public void asignarEventoJugador() {
        /**
         * Metodo que asigna a cada jugador, sus eventos asociados
         */
        System.out.println("Asignando eventos al jugador");
        Lista<Evento> listaEventos = this.eleven.getArbolEventos().inOrden();
        Lista<Jugador> listaJugadores = this.eleven.getArbolJugadores().inOrden();
        Nodo<Evento> evento = listaEventos.getPrimero();
        //recorro los eventos
        while (evento != null) {
            Nodo<Jugador> jugador = listaJugadores.getPrimero();
            //recorro los jugadores
            while (jugador != null) {
                //verifico si el id del jugador, coincide con el id de jugador del evento
                if (jugador.getDato().getId() == evento.getDato().getIdJugador()) {
                    //se clona el nodo del evento y se inserta en la lista de eventos del jugador
                    jugador.getDato().susEventos().insertar(new Nodo(evento.getEtiqueta(),evento.getDato()));
                }
                jugador = jugador.getSiguiente();

            }

            evento = evento.getSiguiente();

        }

    }
   
   
    
    //EQUIPOS
    /*
                            Para cada id de equipo, lo busco en la lista de quipos, si es un equipo existente,
                            tengo que clonar ese nodo y se le asigna al objeto equipo del partido
                            los el objeto equipo del nodo encontrado.
                            En el caso que el id no se encuentre se inserta un objeto provisorio el cual
                            posteriormente servira para filtrar informacion
     */
    public void verificacionEquipos(PartidoCompleto partidoCNuevo, int idEquipo, String localVisitante) {
        Lista<Equipo> listaEquipos = this.eleven.getArbolEquipos().inOrden();

        if (localVisitante.equals("local")) {
            if (this.eleven.getArbolEquipos().buscar(idEquipo) != null) {
                //busco el id del equipo en la lista de equipos
                Nodo<Equipo> equipo = listaEquipos.buscar(idEquipo).clonar();//clonar nodo encontrado
                partidoCNuevo.setEquipoLocal(equipo.getDato()); //seteo el equipo del partipo por el dato del nodo
            } else {
                Equipo equipoAux = new Equipo(idEquipo, "NA"); //inserccion de equipo auxiliar
                partidoCNuevo.setEquipoLocal(equipoAux);

            }
        } else {
            if (this.eleven.getArbolEquipos().buscar(idEquipo) != null) {
                //busco el id del equipo en la lista de equipos
                Nodo<Equipo> equipo = listaEquipos.buscar(idEquipo).clonar();//clonar nodo encontrado
                partidoCNuevo.setEquipoVisitante(equipo.getDato()); //seteo el equipo del partipo por el dato del nodo
            } else {
                Equipo equipoAux = new Equipo(idEquipo, "NA"); //inserccion de equipo auxiliar
                partidoCNuevo.setEquipoVisitante(equipoAux);
            }
        }
    }
            
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
    public void verificacionJugador(PartidoCompleto partidoCNuevo, int idJugador, String posicion, String liga, String localVisitante) {
        if (this.eleven.getArbolJugadores() != null) {
            if (localVisitante.equals("local")) {
                if (this.eleven.getArbolJugadores().buscar(idJugador) != null) {
                    //busco el jugador en la lista de jugadores
                    TElementoAB<Jugador> jugador = this.eleven.getArbolJugadores().buscar(idJugador);//si existe
                   Nodo<Jugador> jugadorInsertar = new Nodo(jugador.getEtiqueta(),jugador.getDatos());
                    partidoCNuevo.jugadoresLocal.insertar(jugadorInsertar); //inserto nodo en lista de jugadores
                    partidoCNuevo.jugadoresLocalId[0] = idJugador; //guardo el id del jugador
                    partidoCNuevo.posicionesLocal[0] = posicion; //guardo la posicion del jugador

                    if (jugador.getDatos().susLigas().buscar(liga) == null) { //verifico si la liga del partido ya esta agregada a las ligas del jugador
                        jugador.getDatos().susLigas().insertar(new Nodo(liga, null)); //agrego liga al jugador
                    }
                } else {
                    Jugador jugadorAux = new Jugador(idJugador, "NA"); //jugador provisorio
                    Nodo< Jugador> jugadorElemento = new Nodo(jugadorAux.getId(), jugadorAux);
                    partidoCNuevo.jugadoresLocal.insertar(jugadorElemento);

                }

            } else {
                if (this.eleven.getArbolJugadores().buscar(idJugador) != null) {
                    //busco el jugador en la lista de jugadores
                    TElementoAB<Jugador> jugador = this.eleven.getArbolJugadores().buscar(idJugador);//si existe
                    Nodo<Jugador> jugadorInsertar = new Nodo(jugador.getEtiqueta(),jugador.getDatos());
                    partidoCNuevo.jugadoresVisitante.insertar(jugadorInsertar); //inserto nodo en lista de jugadores
                    partidoCNuevo.jugadoresVisitanteId[0] = idJugador; //guardo el id del jugador
                    partidoCNuevo.posicionesVisitante[0] = posicion; //guardo la posicion del jugador

                    if (jugador.getDatos().susLigas().buscar(liga) == null) { //verifico si la liga del partido ya esta agregada a las ligas del jugador
                        jugador.getDatos().susLigas().insertar(new Nodo(liga, null)); //agrego liga al jugador
                    }
                } else {
                    Jugador jugadorAux = new Jugador(idJugador, "NA"); //jugador provisorio
                    Nodo< Jugador> jugadorElemento = new Nodo(jugadorAux.getId(), jugadorAux);
                    partidoCNuevo.jugadoresVisitante.insertar(jugadorElemento);

                }

            }

        } else {
            System.out.println("Arbol Vacio");
        }
    }
}
