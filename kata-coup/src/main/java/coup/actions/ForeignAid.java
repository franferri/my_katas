package coup.actions;

import coup.Action;
import coup.GameEngine;

public class ForeignAid extends Action {

    // Action: Take two coins from the treasury
    // Action cannot be challenged

    // Block: Can be blocked by a player claiming the Duke
    // Block can be challenged

    public int actionNumber = 2;

    public ForeignAid() {
    }

    public ForeignAid(GameEngine gameEngine) {
        super(gameEngine);
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal()  {
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction, 2);
    }

    // Block Action
    public void doBlockActionInternal()  {
        gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction, 2);
    }

}
