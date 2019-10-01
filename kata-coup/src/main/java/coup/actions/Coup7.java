package coup.actions;

import coup.Action;
import coup.TheTable;

public final class Coup7 extends Action {

    // Action: Pay 7 cons, choose the player to lose Influence
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    public Coup7(final TheTable theTable) {
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
    public void doActionInternal() {
        getTheTable().playerReturnCoinsToTreasury(getTheTable().getPlayerDoingTheAction(), SEVEN);
        getTheTable().getTargetPlayer().looseCard();
    }

    // Block Action
    public void doBlockAction() {
        throw new RuntimeException("This action can't be blocked");
    }


}
