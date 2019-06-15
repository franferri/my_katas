package coup.network;

import coup.Game;
import coup.Player;

import java.util.ArrayList;
import java.util.List;

public class COUPServerCommunicationProtocol {

    private Game game;
    private int playerNumber;

    public static final int JUST_CONNECTED_ASKING_FOR_NAME = 0;
    private static final int PLAYER_JOINED_THE_TABLE = 1;
    private static final int WAITING_FOR_THE_GAME_TO_START = 2;

    private static final int IN_GAME = 3;

    private static final int WAITING_FOR_COUNTER_ACTION = 4;
    private static final int WAITING_FOR_COUNTER_COUNTER_ACTION = 5;
    private static final int CALLING_THE_BLUFF = 6;
    private static final int BLOCKING_ACTION = 7;
    private static final int TARGETING_PLAYER_FOR_COUP = 8;
    private static final int TARGETING_PLAYER_FOR_ASSASSINATION = 9;
    private static final int TARGETING_PLAYER_FOR_STEAL = 10;

    public int state = JUST_CONNECTED_ASKING_FOR_NAME;

    private boolean refresh_other_players_screen = false;

    public COUPServerCommunicationProtocol(int player) {
        this.game = COUPServer.game;
        this.playerNumber = player;
    }

    public List<String> processInput(String theInput) {

        // TODO: If a player gets disconnected, his cards get's revealed, but don't ruin other players play
        // TODO: If a player is inactive for 30 seconds in his round, gets kicked off
        // TODO: Server command to reset the play (same as after a play ends, will
        // TODO: If there are 6 onlinePlayers connected, no more are accepted we suggest to connect to another server
        // TODO: If there is only 1 player he cant start the game

        List<String> theOutput = new ArrayList<>();

        if (null != theInput && theInput.equals("updateTerminal")) {

            // We only update players that already joined the table
            if (state != JUST_CONNECTED_ASKING_FOR_NAME) {
                theOutput.addAll(COUPTerminalView.table(game, "", "", "", ""));
            }

        } else {

            if (state == JUST_CONNECTED_ASKING_FOR_NAME) {

                if (null != theInput && !theInput.equals("")) {

                    waitingForTheGameToStart(theInput, theOutput);
                    state = WAITING_FOR_THE_GAME_TO_START;
                    refresh_other_players_screen = true;

                } else {

                    theOutput.addAll(COUPTerminalView.renderWelcomeScreenClient());
                    refresh_other_players_screen = false;

                }

            } else if (state == WAITING_FOR_THE_GAME_TO_START) {

                if (null != theInput && !theInput.equals("") && theInput.equals("start")) {

                    gameStarted(theOutput);
                    state = IN_GAME;

                } else {

                    waitingForTheGameToStart(theInput, theOutput);

                }

                refresh_other_players_screen = true;
            } else if (state == IN_GAME && (theInput.equals("1"))) {
                doingAction(1, theOutput);
                state = WAITING_FOR_COUNTER_ACTION;
                refresh_other_players_screen = true;
            } else if (state == IN_GAME && (theInput.equals("2"))) {
                doingAction(2, theOutput);
                state = WAITING_FOR_COUNTER_ACTION;
                refresh_other_players_screen = true;
            } else if (state == IN_GAME && (theInput.equals("3"))) {
                doingAction(3, theOutput);
                state = TARGETING_PLAYER_FOR_COUP;
                refresh_other_players_screen = true;
            } else if (state == IN_GAME && (theInput.equals("4"))) {
                doingAction(4, theOutput);
                state = WAITING_FOR_COUNTER_ACTION;
                refresh_other_players_screen = true;
            } else if (state == IN_GAME && (theInput.equals("5"))) {
                doingAction(5, theOutput);
                state  = TARGETING_PLAYER_FOR_ASSASSINATION;
                refresh_other_players_screen = true;
            } else if (state == IN_GAME && (theInput.equals("6"))) {
                doingAction(6, theOutput);
                state = WAITING_FOR_COUNTER_ACTION;
                refresh_other_players_screen = true;
            } else if (state == IN_GAME && (theInput.equals("7"))) {
                doingAction(7, theOutput);
                state  = TARGETING_PLAYER_FOR_STEAL;
                refresh_other_players_screen = true;

            } else if (state == TARGETING_PLAYER_FOR_COUP) {
                targetingPlayerForCoup(theOutput);
                state  = WAITING_FOR_COUNTER_ACTION;
                refresh_other_players_screen = true;
            } else if (state == TARGETING_PLAYER_FOR_ASSASSINATION) {
                targetingPlayerForAssassination(theOutput);
                state = WAITING_FOR_COUNTER_ACTION;
                refresh_other_players_screen = true;
            } else if (state == TARGETING_PLAYER_FOR_STEAL) {
                targetingPlayerForSteal(theOutput);
                state = WAITING_FOR_COUNTER_ACTION;
                refresh_other_players_screen = true;

            } else if (state == WAITING_FOR_COUNTER_ACTION && theInput.equals("1")) {
                doingCounterAction(1, theOutput);
                state = CALLING_THE_BLUFF;
            } else if (state == WAITING_FOR_COUNTER_ACTION && theInput.equals("2")) {
                doingCounterAction(2, theOutput);
                state = WAITING_FOR_COUNTER_COUNTER_ACTION;
            } else if (state == WAITING_FOR_COUNTER_ACTION && theInput.equals("3")) {
                doingCounterAction(3, theOutput);
                state = WAITING_FOR_COUNTER_COUNTER_ACTION;

            } else if (state == WAITING_FOR_COUNTER_COUNTER_ACTION && theInput.equals("1")) {
                doingCounterCounterAction(1, theOutput);
                state = IN_GAME;
            } else if (state == WAITING_FOR_COUNTER_COUNTER_ACTION && theInput.equals("2")) {
                doingCounterCounterAction(2, theOutput);
                state = IN_GAME;

            } else {
                theOutput.addAll(COUPTerminalView.renderError());
            }

            // IF A PLAYER GETS DISCONNECTED, THE GAME WILL REVEAL HIS CARDS IMMEDIATELY
            // IF A PLAYER IS TAKING MORE THAN N MINUTES TO PLAY, WILL DIE

            // EACH PLAYER SEES THE COUNT DOWN TO BE ABLE TO BLOCK OR CALL THE BLUFF, DURING THIS TIME
            // THE ACTION IS NOT EXECUTED, SO OTHER PLAYERS CAN ACT

            // TIMES APPEAR IN THE BOARD, TO EACH USER HIS OWN

            // añadir un test al juego: un jugador q no está en su turno, intenta hacer una acción

            // During a play, linux terminal let us to change the colors, like the boldify method we created
            // Use colors like blue for actions, yellow or blinking for challenge, and red for block
            // background colors are also available, we can remark the back of the cards in game

            // if we do animations, during the time they last, we dont let the user write, we dont ask him

            if (refresh_other_players_screen) {
                COUPServer.playersThreadsUpdateTerminal(playerNumber);
            }

        }

        String firstLine = theOutput.remove(0);
        theOutput.add(0, COUPTerminalView.cleanTerminal() + COUPTerminalView.normalize() + firstLine);

        ArrayList<String> toTheClient = new ArrayList<>();
        for (int i = 0; i < theOutput.size(); i++) {
            toTheClient.add(theOutput.get(i));
        }

        return toTheClient;
    }

    public void waitingForTheGameToStart(String theInput, List<String> theOutput) {
        Player player = game.gameEngine().player(playerNumber);
        if (null == player.name() || player.name().equals("WAITING")) {
            player.setName(theInput);
        }

        theOutput.addAll(COUPTerminalView.table(game, "", "", "", ""));
        theOutput.addAll(COUPTerminalView.commandLineWaitingForTheGameToStart());

    }

    public void gameStarted(List<String> theOutput) {

        theOutput.addAll(COUPTerminalView.table(game, "Player NNN start", "", "", ""));
        theOutput.addAll(COUPTerminalView.commandLineInGame(game));

    }

    public void doingAction(int action, List<String> theOutput) {

        switch (action) {
            case 1:
                game.playerTakesIncomeFromTreasury();
                theOutput.addAll(COUPTerminalView.table(game, "Player " + game.gameEngine().playerDoingTheAction.name() + " is doing Income", "", "", ""));
                theOutput.addAll(COUPTerminalView.commandPostAction(game));

                break;
            case 2:
                game.playerTakesForeignAidFromTreasury();
                theOutput.addAll(COUPTerminalView.table(game, "Player " + game.gameEngine().playerDoingTheAction.name() + " is doing Foreign Aid", "", "", ""));
                theOutput.addAll(COUPTerminalView.commandPostAction(game));
                break;
            case 3:
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing Coup", "", "", ""));
                theOutput.addAll(COUPTerminalView.commandLinePlayers(game));
                break;
            case 4:
                game.playerTakesTaxesFromTreasury();
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing Tax", "", "", ""));
                theOutput.addAll(COUPTerminalView.commandPostAction(game));
                break;
            case 5:
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing Assassination", "to Player YYY", "", ""));
                theOutput.addAll(COUPTerminalView.commandLinePlayers(game));
                break;
            case 6:
                game.playerExchangesCardsFromTheCourtDeck();
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing Exchange", "", "", ""));
                theOutput.addAll(COUPTerminalView.commandPostAction(game));
                break;
            case 7:
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing Steal", "to Player YYY", "", ""));
                theOutput.addAll(COUPTerminalView.commandLinePlayers(game));
                break;
        }

    }

    public void doingCounterAction(int action, List<String> theOutput) {

        switch (action) {
            case 1:
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing ??????", "", "Player KKK is challenging", ""));
                theOutput.addAll(COUPTerminalView.commandPostPostAction(game));
                break;
            case 2:
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing ??????", "", "Player KKK is blocking", ""));
                theOutput.addAll(COUPTerminalView.commandPostPostAction(game));
                break;
            case 3:
                // Let it pass
                break;
        }

    }

    public void doingCounterCounterAction(int action, List<String> theOutput) {

        switch (action) {
            case 1:
                theOutput.addAll(COUPTerminalView.table(game, "Player NNN is doing ??????", "", "Player KKK is blocking", "Player ZZZ is challenging"));
                //theOutput.addAll(COUPTerminalView.commandPostPostAction(game));
                break;
            case 2:
                // Let it pass
                break;

        }

    }

    public void targetingPlayerForCoup(String theInput, List<String> theOutput) {

        theOutput.addAll(COUPTerminalView.table(game, "Player " + game.gameEngine().playerDoingTheAction.name() + " is doing Coup", "to the player "+game.gameEngine().player(Integer.parseInt(theInput)), "", ""));
        theOutput.addAll(COUPTerminalView.commandLineInGame(game));

    }
    public void targetingPlayerForAssassination(String theInput, List<String> theOutput) {

        theOutput.addAll(COUPTerminalView.table(game, "Player " + game.gameEngine().playerDoingTheAction.name() + " is doing Assassination", "to the player "+game.gameEngine().player(Integer.parseInt(theInput)), "", ""));
        theOutput.addAll(COUPTerminalView.commandLineInGame(game));

    }
    public void targetingPlayerForSteal(String theInput, List<String> theOutput) {

        theOutput.addAll(COUPTerminalView.table(game, "Player " + game.gameEngine().playerDoingTheAction.name() + " is doing Steal", "to the player "+game.gameEngine().player(Integer.parseInt(theInput)), "", ""));
        theOutput.addAll(COUPTerminalView.commandLineInGame(game));

    }

}