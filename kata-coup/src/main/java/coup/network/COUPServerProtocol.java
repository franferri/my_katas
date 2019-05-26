package coup.network;

import java.util.ArrayList;
import java.util.List;

public class COUPServerProtocol {

    private static final int JUST_CONNECTED = 0;
    private static final int JOINED_THE_TABLE = 1;
    private static final int WAITING = 2;
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


        } else if (theInput.equals("Game over")) {
            theOutput.add("Game over");
        } else {
            theOutput.add("Unknown parameter: " + theInput);
        }

        return theOutput;
    }



}