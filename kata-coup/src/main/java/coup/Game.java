package coup;

import coup.actions.*;

public class Game {

    private GameEngine gameEngine;
    private Action currentAction;

    private int currentPlayerPlaying = 0;

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

    public Player player(int player) {
        return gameEngine.player(player);
    }

    public void calculatePlayerPlaying() {

        int nextPlayer = ++currentPlayerPlaying;

        // Si estamos en el último player, hay q ir al primero
        // Si el siguiente player esta muerto, lo saltamos hasta encontrar uno vivo
        // Si no encontramos ningún otro player vivo, el q qda es el ganador

        if (nextPlayer > gameEngine.players.size()) {
            nextPlayer = 1;
        }

        for (int i = 0; i < gameEngine.players.size(); i++) {

            if (gameEngine.player(nextPlayer).isDead()) {
                ++nextPlayer;
            } else {
                currentPlayerPlaying = nextPlayer;
                return;
            }

        }

    }

    public void playerTakesIncomeFromTreasury() throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);

        currentAction = new Income(gameEngine);
        currentAction.doAction();
    }

    public void playerTakesForeignAidFromTreasury() throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);

        currentAction = new ForeignAid(gameEngine);
        currentAction.doAction();
    }

    public void playerCoups7(int targetedPlayer) throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);
        gameEngine.targetPlayerForAssassination = gameEngine.player(targetedPlayer);

        currentAction = new Coup7(gameEngine);
        currentAction.doAction();

    }

    public void playerCoups10(int targetedPlayer) throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);

        gameEngine.targetPlayerForAssassination = gameEngine.player(targetedPlayer);

        currentAction = new Coup10(gameEngine);
        currentAction.doAction();

    }

    public void playerTakesTaxesFromTreasury() throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);

        currentAction = new Tax(gameEngine);
        currentAction.doAction();

    }

    public void playerAssassinates(int targetedPlayer) throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);
        gameEngine.targetPlayerForAssassination = gameEngine.player(targetedPlayer);

        currentAction = new Assassinate(gameEngine);
        currentAction.doAction();
    }

    public void playerExchangesCardsFromTheCourtDeck() throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);

        currentAction = new Exchange(gameEngine);
        currentAction.doAction();
    }

    public void playerStealsFrom(int targetedPlayer) throws Exception {
        calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(currentPlayerPlaying);

        currentAction = new Steal(gameEngine);
        gameEngine.targetPlayerForStealing = gameEngine.player(targetedPlayer);
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

}
