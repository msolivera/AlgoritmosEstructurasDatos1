package elevenCode;

import java.util.Scanner;

/**
 * Clase Main del programa, la cual arrojara todos los resultados.
 *
 * @author Micaela Olivera
 */
public class ElevenResultados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Instancia del calculador
        ElevenCalculador calculador = new ElevenCalculador();

        //CARGA DE ARCHIVOS
        calculador.cargarJugadores("src\\elevenDataBase\\players.csv");
        calculador.cargarEquipos("src\\elevenDataBase\\teams.csv");
        calculador.cargarPartidos("src\\elevenDataBase\\matches.csv");
        calculador.cargarEventos("src\\elevenDataBase\\eventos.csv");
        //calculador.cargarEventos("src\\elevenDataBase\\events-short.csv");
        calculador.cargarPartidosCompleto("src\\elevenDataBase\\match-standings.csv");
        calculador.crearTemporadasLigas();
        //PRIMER RECUENTO DE RESULTADOS
        System.out.println("JUGADORES " + calculador.cantidadJugadores());
        System.out.println("EQUIPOS " + calculador.cantidadEquipos());
        System.out.println("PARTIDOS MATCHES " + calculador.cantidadPartidos());
        System.out.println("EVENTOS " + calculador.cantidadEventos());
        System.out.println("PARTIDOS MATCH-STANDING " + calculador.cantidadPartidosCompletos());
        System.out.println("TEMPORADAS " + calculador.cantidadTemporadas());
        System.out.println("LIGAS " + calculador.cantidadLigas());

        //DEPURACIONES Y RESULTADOS
        calculador.depuradorPartidosCompletosJugador();
        calculador.cantidadPartidosCompletosVerificados();
        calculador.depuradorPartidos();
        System.out.println("PARTIDOS LUEGO DE DEPURACION " + calculador.cantidadPartidosCompletosVerificados());
        calculador.depuradorDeEventos();
        calculador.transformacionEventoJugador();
        calculador.transformacionEventoEquipoEvento();
        calculador.transformacionEventoEquipoOponente();
        System.out.println("EVENTOS LUEGO DE DEPURACION " + calculador.cantidadEventosVerificados());
        //RELACIONAMIENTO DE EVENTOS Y JUGADORES
        calculador.asignarEventoJugador();

        /*se crea Scanner para poder leer entradas de teclado del usuario*/
        Scanner sc = new Scanner(System.in);
        /*Menu de inicio con sus opciones correspondientes*/
        while (true) {
            System.out.println("\n");
            System.out.println("Bienvenido a ELEVEN \nEscriba el numero de la opcion deseada y luego presione ENTER:");
            System.out.println("1 ________ Jugadores con mas participacion en 2012");
            System.out.println("2 _________Jugadores con mas participacion en 2013");
            System.out.println("3 _________Jugadores con mas participacion en 2014");
            System.out.println("4 _________Jugadores con mas participacion en 2015");
            System.out.println("5 _________Mostrar las ligas en las que participo un jugador");
            System.out.println("6 _________Mejor arquero de la temporada 2012");
            System.out.println("7 _________Mejor arquero de la temporada 2013");
            System.out.println("8 _________Mejor arquero de la temporada 2014");
            System.out.println("9 _________Mejor arquero de la temporada 2015");
            System.out.println("10_________Delantero menos efectivo de la temporada 2012");
            System.out.println("11_________Delantero menos efectivo de la temporada 2013");
            System.out.println("12_________Delantero menos efectivo de la temporada 2014");
            System.out.println("13_________Delantero menos efectivo de la temporada 2015");
            System.out.println("14_________Equipo que realizo mas goles en 2012");
            System.out.println("15_________Equipo que realizo mas goles en 2013");
            System.out.println("16_________Equipo que realizo mas goles en 2014");
            System.out.println("17_________Equipo que realizo mas goles en 2015");
            System.out.println("18_________Equipo que recibio mas goles en 2012");
            System.out.println("19_________Equipo que recibio mas goles en 2013");
            System.out.println("20_________Equipo que recibio mas goles en 2014");
            System.out.println("21_________Equipo que recibio mas goles en 2015");
            System.out.println("22_________ONCE IDEAL");
            System.out.println("23_________Salir del sistema\n\n");

            int opcionSeleccionada = sc.nextInt();

            opciones(opcionSeleccionada, calculador);
            System.out.println("\n");
        }
    }

    /**
     * Metodo que recibe las opciones del usuario y realiza las consultas
     * pertinentes
     *
     * @param opcion
     * @param calculador
     */
    public static void opciones(int opcion, ElevenCalculador calculador) {
        Scanner nuevoSc = new Scanner(System.in);
        switch (opcion) {
            case 1:
                calculador.masParticipacionPorTemporada("2012");
                break;
            case 2:
                calculador.masParticipacionPorTemporada("2013");
                break;
            case 3:
                calculador.masParticipacionPorTemporada("2014");
                break;
            case 4:
                calculador.masParticipacionPorTemporada("2015");
                break;
            case 5:
                System.out.println("Ingrese un nombre para comenzar la busqueda");
                String nombre = nuevoSc.nextLine();
                calculador.nombreLigasDeJugador(nombre);
                break;
            case 6:
                calculador.mejorArqueroPorTemporada("2012");
                break;
            case 7:
                calculador.mejorArqueroPorTemporada("2013");
                break;
            case 8:
                calculador.mejorArqueroPorTemporada("2014");
                break;
            case 9:
                calculador.mejorArqueroPorTemporada("2015");
                break;
            case 10:
                calculador.delanteroMenosEfectivo("2012");
                break;
            case 11:
                calculador.delanteroMenosEfectivo("2013");
                break;
            case 12:
                calculador.delanteroMenosEfectivo("2014");
                break;
            case 13:
                calculador.delanteroMenosEfectivo("2015");
                break;
            case 14:
                calculador.equipoGoleador("2012");
                break;
            case 15:
                calculador.equipoGoleador("2013");
                break;
            case 16:
                calculador.equipoGoleador("2014");
                break;
            case 17:
                calculador.equipoGoleador("2015");
                break;
            case 18:
                calculador.equipoGoleado("2012");
                break;
            case 19:
                calculador.equipoGoleado("2013");
                break;
            case 20:
                calculador.equipoGoleado("2014");
                break;
            case 21:
                calculador.equipoGoleado("2015");
                break;
            case 22:
                calculador.onceIdeal();
                break;
            case 23:
                System.exit(0);
                break;

        }

    }

}
