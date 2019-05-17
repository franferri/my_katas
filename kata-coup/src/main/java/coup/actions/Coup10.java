package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Coup10 extends Action {

    // Action: If 10 or more coins, the player must coup
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    public Coup10(GameEngine gameEngine) throws Exception {
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
    public void doActionInternal() throws Exception {
        gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction, 10);
        gameEngine.targetPlayer.looseCard();
    }

    // Block Action
    public void doBlockAction() throws Exception {
        throw new Exception("This action can't be blocked");
    }

}
