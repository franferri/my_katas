package coup.actions;

import coup.Action;
import coup.Game;

public class Tax extends Action {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked
    // --

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Block Action
    public void doActionInternal(Game game) throws Exception {
        game.playerTakeCoinsFromTreasury(game.playerDoingTheAction,3);
    }

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        throw new Exception("This action can't be blocked");
    }

    public void doBlockActionInternal(Game game) throws Exception {
        game.playerReturnCoinsToTreasury(game.playerDoingTheAction,3);
    }

}
