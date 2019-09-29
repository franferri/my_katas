package coup.actions;

import coup.Action;
import coup.GameEngine;

public final class Income extends Action {

    // Action: Take 1 coin from the treasury
    // Action cannot be challenged

    // Block: Cannot be blocked
    // --

    public Income() {
    }

    public Income(final GameEngine gameEngine) {
        super(gameEngine);
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal() {
        getGameEngine().playerTakeCoinsFromTreasury(getGameEngine().getPlayerDoingTheAction(), ONE);
    }

    // Block Action
    public void doBlockAction() {
        throw new RuntimeException("This action can't be blocked");
    }

}
