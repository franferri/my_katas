package coup.actions;

import coup.Action;
import coup.TheTable;

public final class Coup10 extends Action {

    // Action: If 10 or more coins, the player must coup
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    public Coup10(final TheTable theTable) {
        super(theTable);
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
        getTheTable().playerReturnCoinsToTreasury(getTheTable().getPlayerDoingTheAction(), TEN);
        getTheTable().getTargetPlayer().looseCard();
    }

    // Block Action
    public void doBlockAction()  {
        throw new RuntimeException("This action can't be blocked");
    }

}
