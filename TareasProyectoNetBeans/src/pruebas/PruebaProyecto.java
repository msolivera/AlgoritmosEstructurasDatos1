/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author Meki
 */
public class PruebaProyecto {

    /**
     * Constantes para cada columna del archivo
     */
    public static final int ID_ODSP = 0;
    public static final int ID_EVENT = 1;
    public static final int SORT_ORDER = 2;
    public static final int TIME = 3;
    public static final int TEXT = 4;
    public static final int EVENT_TYPE = 5;
    public static final int EVENT_TYPE2 = 6;
    public static final int SIDE = 7;
    public static final int EVENT_TEAM = 8;
    public static final int OPPONENT = 9;
    public static final int PLAYER = 10;
    public static final int PLAYER2 = 11;
    public static final int PLAYER_IN = 12;
    public static final int PLAYER_OUT = 13;
    public static final int SHOT_PLACE = 14;
    public static final int SHOT_OUTCOME = 15;
    public static final int IS_GOAL = 16;
    public static final int LOCATION = 17;
    public static final int BODYPART = 18;
    public static final int ASSIST_METHOD = 19;
    public static final int SITUATION = 20;
    public static final int FAST_BREAK = 21;

    public static void main(String[] args) {
// Ej.:
        String linea = "\"SEqvxt5j/\";\"SEqvxt5j55\";55.0;60.0;\"Foul by Igor de Camargo (Borussia Monchengladbach).\";3.0;\"NA\";2.0;\"Borussia Monchengladbach\";\"Bayern Munich\";\"igor de camargo\";\"NA\";\"NA\";\"NA\";\"NA\";\"NA\";0.0;\"NA\";\"NA\";0.0;\"NA\";0.0";
        String lineaSplit[] = linea.split(";");
        System.out.println("ID_ODSP = " + lineaSplit[ID_ODSP]);
        System.out.println("ID_EVENT = " + lineaSplit[ID_EVENT]);
        System.out.println("SORT_ORDER = " + lineaSplit[SORT_ORDER]);
        System.out.println("TIME = " + lineaSplit[TIME]);
        System.out.println("TEXT = " + lineaSplit[TEXT]);
        System.out.println("EVENT_TYPE = " + lineaSplit[EVENT_TYPE]);
        System.out.println("EVENT_TYPE2 = " + lineaSplit[EVENT_TYPE2]);
        System.out.println("SIDE = " + lineaSplit[SIDE]);
        System.out.println("EVENT_TEAM = " + lineaSplit[EVENT_TEAM]);
        System.out.println("OPPONENT = " + lineaSplit[OPPONENT]);
        System.out.println("PLAYER = " + lineaSplit[PLAYER]);
        System.out.println("PLAYER2 = " + lineaSplit[PLAYER2]);
        System.out.println("PLAYER_IN = " + lineaSplit[PLAYER_IN]);
        System.out.println("PLAYER_OUT = " + lineaSplit[PLAYER_OUT]);
        System.out.println("SHOT_PLACE = " + lineaSplit[SHOT_PLACE]);
        System.out.println("SHOT_OUTCOME = " + lineaSplit[SHOT_OUTCOME]);
        System.out.println("IS_GOAL = " + lineaSplit[IS_GOAL]);
        System.out.println("LOCATION = " + lineaSplit[LOCATION]);
        System.out.println("BODYPART = " + lineaSplit[BODYPART]);
        System.out.println("ASSIST_METHOD = " + lineaSplit[ASSIST_METHOD]);
        System.out.println("SITUATION = " + lineaSplit[SITUATION]);
        System.out.println("FAST_BREAK = " + lineaSplit[FAST_BREAK]);

    }
}
