package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Income extends Action {

    // Action: Take 1 coin from the treasury
    // Action cannot be challenged

    // Block: Cannot be blocked
    // --

    public Income() {
    }

    public Income(GameEngine gameEngine) throws Exception {
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
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction,1);
    }

    // Block Action
    public void doBlockAction() throws Exception {
        throw new Exception("This action can't be blocked");
    }

}
