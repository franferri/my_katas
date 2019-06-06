package coup.network;

import coup.Game;
import coup.Player;

import java.util.ArrayList;
import java.util.List;

public class COUPServerCommunicationProtocol {

    private Game game;
    private Player player;

    private static final int JUST_CONNECTED = 0;
    private static final int JOINED_THE_TABLE = 1;
    private static final int WAITING = 2;

    private static final int WAITING_FOR_PLAYER_TO_PLAY = 3;

    private static final int DOING_ACTION = 4;
    private static final int CALLING_THE_BLUFF = 5;
    private static final int BLOCKING_ACTION = 6;

    private int state = JUST_CONNECTED;

    private boolean refresh_others = false;

    public COUPServerCommunicationProtocol(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    public List<String> processInput(String theInput) {
        List<String> theOutput = new ArrayList<>();

        if (null != theInput && theInput.equals("updateTerminal")) {

            theOutput.addAll(COUPTerminalView.table(6, "","", "", ""));

        } else {

            if (state == JUST_CONNECTED) {

                theOutput.addAll(COUPTerminalView.renderWelcomeScreenClient());

                // If there are 6 onlinePlayers connected, no more are accepted we suggest to connect to another server

                state = JOINED_THE_TABLE;

                refresh_others = false;
                // We update all connected onlinePlayers console to reflect the new joiner

            } else if (state == JOINED_THE_TABLE) {

                state = WAITING;
                theOutput.addAll(COUPTerminalView.table(6, "Player 1 is doing Assasination", "on Player 6","Player 5 is blocking", "Player 2 is calling the bluff"));
                refresh_others = true;
                // We update all connected onlinePlayers console to reflect the new joiner

            } else if (state == WAITING && theInput.equals("start")) {

                // If there is only 1 player he cant start the ga

                state = WAITING_FOR_PLAYER_TO_PLAY;
                theOutput.addAll(COUPTerminalView.table(6, "Player 2 is doing Assasination", "on Player 333","AAAAAA 5 is blocking", "BBBBBB 2 is calling the bluff"));

                refresh_others = true;
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
                theOutput.addAll(COUPTerminalView.table(6, "Player 2 is doing Assasination", "on Player 333","AAAAAA 5 is blocking", "BBBBBB 2 is calling the bluff"));
            }

            // IF A PLAYER GETS DISCONNECTED, THE GAME WILL REVEAL HIS CARDS INMEDIATELY
            // IF A PLAYER IS TAKING MORE THAN N MINUTES TO PLAY, WILL DIE

            // EACH PLAYER SEES THE COUNT DOWN TO BE ABLE TO BLOCK OR CALL THE BLUF, DURING THIS TIME
            // THE ACTION IS NOT EXECUTED, SO OTHER PLAYERS CAN ACT

            // TIMES APPEAR IN THE BOARD, TO EACH USER HIS OWN

            // añadir un test al juego: un jugador q no está en su turno, intenta hacer una acción

            // During a play, linux terminal let us to change the colors, like the boldify method we created
            // Use colors like blue for actions, yellow or blinking for challenge, and red for block
            // background colors are also available, we can remark the back of the cards in game

            // if we do animations, during the time they last, we dont let the user write, we dont ask him

            if (refresh_others) {
                game.playersThreadsUpdateTerminal(player.name());
            }

        }

        String firstLine = theOutput.remove(0);
        theOutput.add(0, COUPTerminalView.cleanTerminal() + COUPTerminalView.normalize() + firstLine);

        ArrayList<String> toTheClient = new ArrayList<>();
        for (int i = 0; i < theOutput.size(); i++) {

            //   if (i - 1 == theOutput.size()) {
            //       toTheClient.add(theOutput.get(i));
            //   } else {
            toTheClient.add(theOutput.get(i));
            //  }

        }

        return toTheClient;
    }

}