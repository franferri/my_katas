package coup.actions;

import coup.Action;
import coup.Game;

public class Income extends Action {

    // Action: Take 1 coin from the treasury
    // Action cannot be challenged

    // Block: Cannot be blocked
    // --

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {
        game.playerTakeCoinsFromTreasury(game.playerDoingTheAction,1);
    }

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        throw new Exception("This action can't be blocked");
    }

}
