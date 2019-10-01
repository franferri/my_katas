package coup.actions;

import coup.TheTable;

public final class ForeignAid extends Action {

    // Action: Take two coins from the treasury
    // Action cannot be challenged

    // Block: Can be blocked by a player claiming the Duke
    // Block can be challenged

    public ForeignAid() {
    }

    public ForeignAid(final TheTable theTable) {
        super(theTable);
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal() {
        getTheTable().playerTakeCoinsFromTreasury(getTheTable().getPlayerDoingTheAction(), 2);
    }

    // Block Action
    public void doBlockActionInternal() {
        getTheTable().playerReturnCoinsToTreasury(getTheTable().getPlayerDoingTheAction(), 2);
    }

}
