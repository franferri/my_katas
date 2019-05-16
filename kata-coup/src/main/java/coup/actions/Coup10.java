package coup.actions;

import coup.Action;
import coup.Game;

public class Coup10 extends Action {

    // Action: If 10 or more coins, the player must coup
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {
        game.playerReturnCoinsToTreasury(game.playerDoingTheAction, 10);
        game.playerLoosesCard(game.targetPlayerForAssassination);
    }

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        throw new Exception("This action can't be blocked");
    }

}
