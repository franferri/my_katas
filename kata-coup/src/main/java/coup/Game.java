package coup;

import coup.actions.Assassinate;
import coup.actions.Coup10;
import coup.actions.Coup7;
import coup.actions.Exchange;
import coup.actions.ForeignAid;
import coup.actions.Income;
import coup.actions.Steal;
import coup.actions.Tax;

public final class Game {

    private GameEngine gameEngine;
    private Action currentAction;

    public Game() {
        gameEngine = new GameEngine();
    }

    public GameEngine gameEngine() {
        return gameEngine;
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public void playerTakesIncomeFromTreasury() {
        startAction();

        currentAction = new Income(gameEngine);
        currentAction.doAction();
    }

    public void playerTakesForeignAidFromTreasury() {
        startAction();

        currentAction = new ForeignAid(gameEngine);
        currentAction.doAction();
    }

    public void playerCoups7(final int targetedPlayer) {
        startAction();
        gameEngine.setTargetPlayer(gameEngine.player(targetedPlayer));

        currentAction = new Coup7(gameEngine);
        currentAction.doAction();
    }

    public void playerCoups10(final int targetedPlayer) {
        startAction();

        gameEngine.setTargetPlayer(gameEngine.player(targetedPlayer));

        currentAction = new Coup10(gameEngine);
        currentAction.doAction();
    }

    public void playerTakesTaxesFromTreasury() {
        startAction();

        currentAction = new Tax(gameEngine);
        currentAction.doAction();
    }

    public void playerAssassinates(final int targetedPlayer) {
        startAction();
        gameEngine.setTargetPlayer(gameEngine.player(targetedPlayer));

        currentAction = new Assassinate(gameEngine);
        currentAction.doAction();
    }

    public void playerExchangesCardsFromTheCourtDeck() {
        startAction();

        currentAction = new Exchange(gameEngine);
        currentAction.doAction();
    }

    public void playerStealsFrom(final int targetedPlayer) {
        startAction();
        gameEngine.setTargetPlayer(gameEngine.player(targetedPlayer));

        currentAction = new Steal(gameEngine);
        currentAction.doAction();
    }

    public void playerBlocks(final int playerBlocking) {
        gameEngine.setPlayerBlockingTheAction(gameEngine.player(playerBlocking));
        currentAction.doBlockAction();
    }

    public void playerCallsTheBluff(final int playerCallingTheBluff) {
        gameEngine.setPlayerCallingTheBluff(gameEngine.player(playerCallingTheBluff));

        if (currentAction.isBlocked()) {
            currentAction.doCallTheBluffOnBlockAction();
        } else {
            currentAction.doCallTheBluffOnAction();
        }
    }

    public void startAction() {
        gameEngine.resetStatus();

        gameEngine.calculatePlayerPlaying();
        gameEngine.setPlayerDoingTheAction(gameEngine.player(gameEngine.getCurrentPlayerPlaying()));
    }

}
