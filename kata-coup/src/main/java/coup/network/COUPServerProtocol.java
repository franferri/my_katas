package coup.network;

import java.util.ArrayList;
import java.util.List;

public class COUPServerProtocol {

    private static final int JUST_CONNECTED = 0;
    private static final int JOINED_THE_TABLE = 1;
    private static final int WAITING = 2;

    private static final int WAITING_FOR_PLAYER_TO_PLAY = 3;

    private static final int DOING_ACTION = 4;
    private static final int CALLING_THE_BLUFF = 5;
    private static final int BLOCKING_ACTION = 6;

    private static final int ACTIVE = 10000;

    private int state = JUST_CONNECTED;

    public List<String> processInput(String theInput) {
        List<String> theOutput = new ArrayList<>();

        if (state == JUST_CONNECTED) {

            // If we are the first player, we create the game here with 1 player

            theOutput.add("\033[H\033[2J");
            theOutput.addAll(ASCIIArt.welcome());
            theOutput.add("");
            theOutput.add("There are [ " + ASCIIArt.boldify("X") + " ] players on the table. Press Enter to join.");

            // If there are 6 players connected, no more are accepted we suggest to connect to another server

            state = JOINED_THE_TABLE;

        } else if (state == JOINED_THE_TABLE) {

            // Game .addPlayer()

            // We update all connected players console to reflect the new joiner

            theOutput.add("\033[H\033[2J");
            theOutput.addAll(ASCIIArt.table());
            state = WAITING;

        } else if (state == WAITING && theInput.equals("start")) {

            // If there is only 1 player he cant start the game

            theOutput.add("\033[H\033[2J");
            theOutput.addAll(ASCIIArt.showCurrentTable());

            state = WAITING_FOR_PLAYER_TO_PLAY;

        } else if (state == WAITING_FOR_PLAYER_TO_PLAY && theInput.equals("income")) {

            state = DOING_ACTION;

        } else if (state == WAITING_FOR_PLAYER_TO_PLAY && theInput.equals("foreign_aid")) {

            state = DOING_ACTION;

        } else if (state == WAITING_FOR_PLAYER_TO_PLAY && theInput.equals("coup7")) {

            state = DOING_ACTION;

        } else if (state == WAITING_FOR_PLAYER_TO_PLAY && theInput.equals("coup10")) {

            state = DOING_ACTION;

        } else if (state == WAITING_FOR_PLAYER_TO_PLAY && theInput.equals("tax")) {

            state = DOING_ACTION;

        } else if (state == DOING_ACTION && theInput.equals("call the bluff")) {

            state = CALLING_THE_BLUFF;

        } else if (state == DOING_ACTION && theInput.equals("block")) {

            state = BLOCKING_ACTION;

        } else if (state == BLOCKING_ACTION && theInput.equals("call the bluff")) {

            state = CALLING_THE_BLUFF;

        } else if (theInput.equals("Game over")) {
            theOutput.add("Game over");
        } else {
            theOutput.add("Unknown parameter: " + theInput);
        }

        // IF A PLAYER GETS DISCONNECTED, THE GAME WILL REVEAL HIS CARDS INMEDIATELY
        // IF A PLAYER IS TAKING MORE THAN N MINUTES TO PLAY, WILL DIE

        // EACH PLAYER SEES THE COUNT DOWN TO BE ABLE TO BLOCK OR CALL THE BLUF, DURING THIS TIME
        // THE ACTION IS NOT EXECUTED, SO OTHER PLAYERS CAN ACT

        // TIMES APPEAR IN THE BOARD, TO EACH USER HIS OWN

        // añadir un test al juego: un jugador q no está en su turno, intenta hacer una acción

        return theOutput;
    }



}