package coup;

import coup.actions.*;

public class Game {

    private GameEngine gameEngine;
    private Action currentAction;
    private int currentActionNumber;

    public Game() {
        gameEngine = new GameEngine();
    }

    public GameEngine gameEngine() {
        return gameEngine;
    }

    public int currentActionNumber() {
        return currentActionNumber;
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public void playerTakesIncomeFromTreasury() {
        startAction();

        currentAction = new Income(gameEngine);
        currentActionNumber = 1;
        currentAction.doAction();
    }

    public void playerTakesForeignAidFromTreasury() {
        startAction();

        currentAction = new ForeignAid(gameEngine);
        currentActionNumber = 2;
        currentAction.doAction();
    }

    public void playerCoups7(int targetedPlayer) {
        startAction();
        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Coup7(gameEngine);
        currentActionNumber = 3;
        currentAction.doAction();
    }

    public void playerCoups10(int targetedPlayer) {
        startAction();

        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Coup10(gameEngine);
        currentAction.doAction();
    }

    public void playerTakesTaxesFromTreasury() {
        startAction();

        currentAction = new Tax(gameEngine);
        currentActionNumber = 4;
        currentAction.doAction();
    }

    public void playerAssassinates(int targetedPlayer) {
        startAction();
        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Assassinate(gameEngine);
        currentActionNumber = 5;
        currentAction.doAction();
    }

    public void playerExchangesCardsFromTheCourtDeck() {
        startAction();

        currentAction = new Exchange(gameEngine);
        currentActionNumber = 6;
        currentAction.doAction();
    }

    public void playerStealsFrom(int targetedPlayer) {
        startAction();
        gameEngine.targetPlayer = gameEngine.player(targetedPlayer);

        currentAction = new Steal(gameEngine);
        currentActionNumber = 7;
        currentAction.doAction();
    }

    public void playerBlocks(int playerBlocking) {
        gameEngine.playerBlockingTheAction = gameEngine.player(playerBlocking);
        currentAction.doBlockAction();
    }

    public void playerCallsTheBluff(int playerCallingTheBluff) {
        gameEngine.playerCallingTheBluff = gameEngine.player(playerCallingTheBluff);

        if (currentAction.isBlocked()) {
            currentAction.doCallTheBluffOnBlockAction();
        } else {
            currentAction.doCallTheBluffOnAction();
        }
    }

    public void startAction() {
        gameEngine.resetStatus();

        gameEngine.calculatePlayerPlaying();
        gameEngine.playerDoingTheAction = gameEngine.player(gameEngine.currentPlayerPlaying);
    }

}
