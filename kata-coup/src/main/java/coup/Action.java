package coup;

import coup.actions.Coup10;

public abstract class Action {

    protected GameEngine gameEngine;
    private boolean isBlocked;

    public Action() {
    }

    public Action(GameEngine gameEngine) throws Exception {
        this.gameEngine = gameEngine;
    }

    private void mustCoup10(GameEngine gameEngine) throws Exception {
        if (gameEngine.playerDoingTheAction.coins() >= 10 && !(this instanceof Coup10)) {
            throw new Exception("Player must coup because has 10 or more coins");
        }
    }

    private void isTheGameEnded(GameEngine gameEngine) throws Exception {
        int winner = gameEngine.whoIsTheWinner();
        if (winner > -1) {
            throw new Exception("The game is done, the winner was player " + winner);
        }
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return true;
    }

    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    // Action
    public void doAction() throws Exception {
        actionCantBeDoneToHimself();
        isTheGameEnded(gameEngine);
        mustCoup10(gameEngine);
        doActionInternal();
        isBlocked = false;
    }

    public abstract void doActionInternal() throws Exception;

    // Block Action
    public void doBlockAction() throws Exception {
        playerCantBlockHimself();
        doBlockActionInternal();
        isBlocked = true;
    }

    public void doBlockActionInternal() throws Exception {
        throw new Exception("method not overridden");
    }

    // Bluff
    public void doCallTheBluffOnAction() throws Exception {
        cannotCallBluffOnHimself();
        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }
        if (gameEngine.playerDoingTheAction.canHeDoTheAction(this)) {
            gameEngine.playerCallingTheBluff.looseCard();
        } else {
            doBlockActionInternal();
            gameEngine.playerDoingTheAction.looseCard();
        }
    }

    public void doCallTheBluffOnBlockAction() throws Exception {
        cannotBluffOnHisOwnBlockAction();
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }
        if (gameEngine.playerBlockingTheAction.canHeBlockTheAction(this)) {
            gameEngine.playerCallingTheBluff.looseCard();
        } else {
            doActionInternal();
            gameEngine.playerBlockingTheAction.looseCard();
        }
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    private void actionCantBeDoneToHimself() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.targetPlayer) {
            throw new Exception("Action can't be done to himself");
        }
    }

    private void playerCantBlockHimself() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.playerBlockingTheAction) {
            throw new Exception("Player cant block himself");
        }
    }

    private void cannotCallBluffOnHimself() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.playerCallingTheBluff) {
            throw new Exception("Action bluff can't be called over himself");
        }
    }

    private void cannotBluffOnHisOwnBlockAction() throws Exception {
        if (gameEngine.playerBlockingTheAction == gameEngine.playerCallingTheBluff) {
            throw new Exception("BlockAction bluff can't be called over the player doing the BlockAction");
        }
    }

}
