package coup;

import coup.actions.Coup10;

public abstract class Action {

    protected GameEngine gameEngine;
    private boolean isBlocked;

    protected Action() {
    }

    protected Action(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    private void mustCoup10(GameEngine gameEngine)  {
        if (gameEngine.playerDoingTheAction.coins() >= 10 && !(this instanceof Coup10)) {
            throw new RuntimeException("Player must coup because has 10 or more coins");
        }
    }

    private void isTheGameEnded(GameEngine gameEngine)  {
        int winner = gameEngine.whoIsTheWinner();
        if (winner > -1) {
            throw new RuntimeException("The game is done, the winner was player " + winner);
        }
    }

    // Setup
    protected boolean canThisActionBeChallenged() {
        return true;
    }

    protected boolean canThisBlockActionBeChallenged() {
        return true;
    }

    // Action
    public void doAction()  {
        actionCantBeDoneToHimself();
        isTheGameEnded(gameEngine);
        mustCoup10(gameEngine);
        doActionInternal();
        isBlocked = false;
    }

    protected abstract void doActionInternal() ;

    // Block Action
    public void doBlockAction()  {
        playerCantBlockHimself();
        doBlockActionInternal();
        isBlocked = true;
    }

    protected void doBlockActionInternal()  {
        throw new RuntimeException("method not overridden");
    }

    // Bluff
    public void doCallTheBluffOnAction()  {
        cannotCallBluffOnHimself();
        if (!canThisActionBeChallenged()) {
            throw new RuntimeException("This action can't be challenged");
        }
        if (gameEngine.playerDoingTheAction.canHeDoTheAction(this)) {
            gameEngine.playerCallingTheBluff.looseCard();
        } else {
            doBlockActionInternal();
            gameEngine.playerDoingTheAction.looseCard();
        }
    }

    public void doCallTheBluffOnBlockAction()  {
        cannotBluffOnHisOwnBlockAction();
        if (!canThisBlockActionBeChallenged()) {
            throw new RuntimeException("This blockaction can't be challenged");
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

    private void actionCantBeDoneToHimself()  {
        if (gameEngine.playerDoingTheAction == gameEngine.targetPlayer) {
            throw new RuntimeException("Action can't be done to himself");
        }
    }

    private void playerCantBlockHimself()  {
        if (gameEngine.playerDoingTheAction == gameEngine.playerBlockingTheAction) {
            throw new RuntimeException("Player cant block himself");
        }
    }

    private void cannotCallBluffOnHimself()  {
        if (gameEngine.playerDoingTheAction == gameEngine.playerCallingTheBluff) {
            throw new RuntimeException("Action bluff can't be called over himself");
        }
    }

    private void cannotBluffOnHisOwnBlockAction()  {
        if (gameEngine.playerBlockingTheAction == gameEngine.playerCallingTheBluff) {
            throw new RuntimeException("BlockAction bluff can't be called over the player doing the BlockAction");
        }
    }

}
