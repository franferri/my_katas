package coup;

import coup.actions.Coup10;

public abstract class Action {

    public static final Integer TEN = 10;
    public static final Integer SEVEN = 7;
    public static final Integer THREE = 3;
    public static final Integer ONE = 1;

    private GameEngine gameEngine;
    private boolean isBlocked;

    private int actionNumber = -1;

    protected Action() {
    }

    protected Action(final GameEngine gameEngine) {
        this.setGameEngine(gameEngine);
    }

    private void mustCoup10(final GameEngine gameEngine) {
        if (gameEngine.getPlayerDoingTheAction().coins() >= TEN && !(this instanceof Coup10)) {
            throw new RuntimeException("Player must coup because has 10 or more coins");
        }
    }

    private void isTheGameEnded(final GameEngine gameEngine) {
        int winner = gameEngine.whoIsTheWinner();
        if (winner > -1) {
            throw new RuntimeException("The game is done, the winner was player " + winner);
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
    public void doAction() {
        actionCantBeDoneToHimself();
        isTheGameEnded(getGameEngine());
        mustCoup10(getGameEngine());
        doActionInternal();
        isBlocked = false;
    }

    protected abstract void doActionInternal();

    // Block Action
    public void doBlockAction() {
        playerCantBlockHimself();
        doBlockActionInternal();
        isBlocked = true;
    }

    protected void doBlockActionInternal() {
        throw new RuntimeException("method not overridden");
    }

    // Bluff
    public void doCallTheBluffOnAction() {
        cannotCallBluffOnHimself();
        if (!canThisActionBeChallenged()) {
            throw new RuntimeException("This action can't be challenged");
        }
        if (getGameEngine().getPlayerDoingTheAction().canHeDoTheAction(this)) {
            getGameEngine().getPlayerCallingTheBluff().looseCard();
        } else {
            doBlockActionInternal();
            getGameEngine().getPlayerDoingTheAction().looseCard();
        }
    }

    public void doCallTheBluffOnBlockAction() {
        cannotBluffOnHisOwnBlockAction();
        if (!canThisBlockActionBeChallenged()) {
            throw new RuntimeException("This blockaction can't be challenged");
        }
        if (getGameEngine().getPlayerBlockingTheAction().canHeBlockTheAction(this)) {
            getGameEngine().getPlayerCallingTheBluff().looseCard();
        } else {
            doActionInternal();
            getGameEngine().getPlayerBlockingTheAction().looseCard();
        }
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    private void actionCantBeDoneToHimself() {
        if (getGameEngine().getPlayerDoingTheAction() == getGameEngine().getTargetPlayer()) {
            throw new RuntimeException("Action can't be done to himself");
        }
    }

    private void playerCantBlockHimself() {
        if (getGameEngine().getPlayerDoingTheAction() == getGameEngine().getPlayerBlockingTheAction()) {
            throw new RuntimeException("Player cant block himself");
        }
    }

    private void cannotCallBluffOnHimself() {
        if (getGameEngine().getPlayerDoingTheAction() == getGameEngine().getPlayerCallingTheBluff()) {
            throw new RuntimeException("Action bluff can't be called over himself");
        }
    }

    private void cannotBluffOnHisOwnBlockAction() {
        if (getGameEngine().getPlayerBlockingTheAction() == getGameEngine().getPlayerCallingTheBluff()) {
            throw new RuntimeException("BlockAction bluff can't be called over the player doing the BlockAction");
        }
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(final GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public int getActionNumber() {
        return actionNumber;
    }

    public void setActionNumber(final int actionNumber) {
        this.actionNumber = actionNumber;
    }
}
