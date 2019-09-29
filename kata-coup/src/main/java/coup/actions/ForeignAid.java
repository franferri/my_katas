package coup.actions;

import coup.Action;
import coup.GameEngine;

public final class ForeignAid extends Action {

    // Action: Take two coins from the treasury
    // Action cannot be challenged

    // Block: Can be blocked by a player claiming the Duke
    // Block can be challenged

    public ForeignAid() {
    }

    public ForeignAid(final GameEngine gameEngine) {
        super(gameEngine);
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal() {
        getGameEngine().playerTakeCoinsFromTreasury(getGameEngine().getPlayerDoingTheAction(), 2);
    }

    // Block Action
    public void doBlockActionInternal() {
        getGameEngine().playerReturnCoinsToTreasury(getGameEngine().getPlayerDoingTheAction(), 2);
    }

}
