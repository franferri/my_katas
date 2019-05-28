package coup;

import coup.actions.*;
import coup.network.COUPServer;
import coup.network.COUPServerNetworkListenerThread;

import java.util.Hashtable;
import java.util.Set;

public class Game {

    private GameEngine gameEngine;
    private Action currentAction;

    private Hashtable<Player, COUPServerNetworkListenerThread> players = new Hashtable<>();

    public Game() {

    }

    public void addPlayer(COUPServerNetworkListenerThread thread, Player player) {
        players.put(player, thread);
    }

    public int players() {
        return players.size();
    }

    public void playersThreadsUpdateTerminal(String playerToAvoid) {

        COUPServer.updateServerTerminal();

        Set<Player> playersKeys = players.keySet();
        for (Player player : playersKeys) {
            if (!player.name().equals(playerToAvoid)) {
                players.get(player).updateTerminal();
            }
        }

    }

    public void startGame() throws Exception {
        Set<Player> keys = players.keySet();
        gameEngine = new GameEngine(keys.toArray(new Player[0]));
        gameEngine.startGame();
    }

    public Game(int players) throws Exception {

        Player[] playersList = new Player[players];

        for (int i = 0; i < players; i++) {
            playersList[i] = new Player();
        }

        gameEngine = new GameEngine(playersList);

        gameEngine.startGame();

    }

    public GameEngine gameEngine() {
        return gameEngine;
    }

    public void playerTakesIncomeFromTreasury() throws Exception {
        startAction();

        currentAction = new Income(gameEngine);
        currentAction.doAction();
    }

    public void playerTakesForeignAidFromTreasury() throws Exception {
        startAction();

        currentAction = new ForeignAid(gameEngine);
        currentAction.doAction();
    }

    public void playerCoups7(int targetedPlayer) throws Exception {
        startAction();
        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Coup7(gameEngine);
        currentAction.doAction();
    }

    public void playerCoups10(int targetedPlayer) throws Exception {
        startAction();

        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Coup10(gameEngine);
        currentAction.doAction();
    }

    public void playerTakesTaxesFromTreasury() throws Exception {
        startAction();

        currentAction = new Tax(gameEngine);
        currentAction.doAction();
    }

    public void playerAssassinates(int targetedPlayer) throws Exception {
        startAction();
        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Assassinate(gameEngine);
        currentAction.doAction();
    }

    public void playerExchangesCardsFromTheCourtDeck() throws Exception {
        startAction();

        currentAction = new Exchange(gameEngine);
        currentAction.doAction();
    }

    public void playerStealsFrom(int targetedPlayer) throws Exception {
        startAction();
        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Steal(gameEngine);
        currentAction.doAction();
    }

    public void playerBlocks(int playerBlocking) throws Exception {
        gameEngine.playerBlockingTheAction = gameEngine.player(playerBlocking);
        currentAction.doBlockAction();
    }

    public void playerCallsTheBluff(int playerCallingTheBluff) throws Exception {
        gameEngine.playerCallingTheBluff = gameEngine.player(playerCallingTheBluff);

        if (currentAction.isBlocked()) {
            currentAction.doCallTheBluffOnBlockAction();
        } else {
            currentAction.doCallTheBluffOnAction();
        }
    }

    private void startAction() {
        gameEngine.resetStatus();

        gameEngine.calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(gameEngine.currentPlayerPlaying);
    }

}
