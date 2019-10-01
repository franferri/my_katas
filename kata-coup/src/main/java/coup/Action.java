package coup;

import coup.actions.Coup10;

public abstract class Action {

    public static final Integer TEN = 10;
    public static final Integer SEVEN = 7;
    public static final Integer THREE = 3;
    public static final Integer ONE = 1;

    private TheTable theTable;
    private boolean isBlocked;

    protected Action() {
    }

    protected Action(final TheTable theTable) {
        this.setTheTable(theTable);
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return true;
    }

    public boolean canThisBlockActionBeChallenged() {
        return true;
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

    private void mustCoup10(final TheTable theTable) {
        if (theTable.getPlayerDoingTheAction().wallet().coins() >= TEN && !(this instanceof Coup10)) {
            throw new RuntimeException("Player must coup because has 10 or more coins");
        }
    }

    private void isTheGameEnded(final TheTable theTable) {
        int winner = theTable.whoIsTheWinner();
        if (winner > -1) {
            throw new RuntimeException("The game is done, the winner was player " + winner);
        }
    }

    // Action
    public void doAction() {
        actionCantBeDoneToHimself();
        isTheGameEnded(getTheTable());
        mustCoup10(getTheTable());
        doActionInternal();
        isBlocked = false;
    }

    // Bluff
    public void doCallTheBluffOnAction() {
        cannotCallBluffOnHimself();
        if (!canThisActionBeChallenged()) {
            throw new RuntimeException("This action can't be challenged");
        }
        if (getTheTable().getPlayerDoingTheAction().canHeDoTheAction(this)) {
            getTheTable().getPlayerCallingTheBluff().looseCard();
        } else {
            doBlockActionInternal();
            getTheTable().getPlayerDoingTheAction().looseCard();
        }
    }

    public void doCallTheBluffOnBlockAction() {
        cannotBluffOnHisOwnBlockAction();
        if (!canThisBlockActionBeChallenged()) {
            throw new RuntimeException("This blockaction can't be challenged");
        }
        if (getTheTable().getPlayerBlockingTheAction().canHeBlockTheAction(this)) {
            getTheTable().getPlayerCallingTheBluff().looseCard();
        } else {
            doActionInternal();
            getTheTable().getPlayerBlockingTheAction().looseCard();
        }
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    private void actionCantBeDoneToHimself() {
        if (getTheTable().getPlayerDoingTheAction() == getTheTable().getTargetPlayer()) {
            throw new RuntimeException("Action can't be done to himself");
        }
    }

    private void playerCantBlockHimself() {
        if (getTheTable().getPlayerDoingTheAction() == getTheTable().getPlayerBlockingTheAction()) {
            throw new RuntimeException("Player cant block himself");
        }
    }

    private void cannotCallBluffOnHimself() {
        if (getTheTable().getPlayerDoingTheAction() == getTheTable().getPlayerCallingTheBluff()) {
            throw new RuntimeException("Action bluff can't be called over himself");
        }
    }

    private void cannotBluffOnHisOwnBlockAction() {
        if (getTheTable().getPlayerBlockingTheAction() == getTheTable().getPlayerCallingTheBluff()) {
            throw new RuntimeException("BlockAction bluff can't be called over the player doing the BlockAction");
        }
    }

    public TheTable getTheTable() {
        return theTable;
    }

    public void setTheTable(final TheTable theTable) {
        this.theTable = theTable;
    }

}
