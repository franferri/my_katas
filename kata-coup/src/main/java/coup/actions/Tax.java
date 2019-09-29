package coup.actions;

import coup.Action;
import coup.GameEngine;

public final class Tax extends Action {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked
    // --

    public Tax() {
    }

    public Tax(final GameEngine gameEngine) {
        super(gameEngine);
    }

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Block Action
    public void doActionInternal() {
        getGameEngine().playerTakeCoinsFromTreasury(getGameEngine().getPlayerDoingTheAction(), THREE);
    }

    // Block Action
    public void doBlockAction() {
        throw new RuntimeException("This action can't be blocked");
    }

    public void doBlockActionInternal() {
        getGameEngine().playerReturnCoinsToTreasury(getGameEngine().getPlayerDoingTheAction(), THREE);
    }

}
