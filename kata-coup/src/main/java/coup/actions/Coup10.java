package coup.actions;

import coup.Action;
import coup.GameEngine;

public final class Coup10 extends Action {

    // Action: If 10 or more coins, the player must coup
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    public Coup10(final GameEngine gameEngine) {
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
    public void doActionInternal()  {
        getGameEngine().playerReturnCoinsToTreasury(getGameEngine().getPlayerDoingTheAction(), TEN);
        getGameEngine().getTargetPlayer().looseCard();
    }

    // Block Action
    public void doBlockAction()  {
        throw new RuntimeException("This action can't be blocked");
    }

}
