package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Tax extends Action {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked
    // --

    public Tax() {
    }

    public Tax(GameEngine gameEngine) throws Exception {
        super(gameEngine);
    }

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Block Action
    public void doActionInternal() throws Exception {
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction,3);
    }

    // Block Action
    public void doBlockAction() throws Exception {
        throw new Exception("This action can't be blocked");
    }

    public void doBlockActionInternal() throws Exception {
        gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction,3);
    }

}
