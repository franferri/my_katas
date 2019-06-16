package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Tax extends Action {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked
    // --

    public int actionNumber = 4;

    public Tax() {
    }

    public Tax(GameEngine gameEngine) {
        super(gameEngine);
    }

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Block Action
    public void doActionInternal()  {
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction,3);
    }

    // Block Action
    public void doBlockAction()  {
        throw new RuntimeException("This action can't be blocked");
    }

    public void doBlockActionInternal()  {
        gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction,3);
    }

}
