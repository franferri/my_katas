package coup.actions;

import coup.Action;
import coup.Game;

public class ForeignAid extends Action {

    // Action: Take two coins from the treasury
    // Action cannot be challenged

    // Block: Can be blocked by a player claiming the Duke
    // Block can be challenged

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }
    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {
        takeCoinsToTreasury(game, 2);
    }

    // Block Action
    public void doBlockActionInternal(Game game) throws Exception {
        returnCoinsToTreasury(game, 2);
    }

}
