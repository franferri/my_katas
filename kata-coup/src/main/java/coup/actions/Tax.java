package coup.actions;

import coup.TheTable;

public final class Tax extends Action {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked
    // --

    public Tax() {
    }

    public Tax(final TheTable theTable) {
        super(theTable);
    }

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Block Action
    public void doActionInternal() {
        getTheTable().playerTakeCoinsFromTreasury(getTheTable().getPlayerDoingTheAction(), THREE);
    }

    // Block Action
    public void doBlockAction() {
        throw new RuntimeException("This action can't be blocked");
    }

    public void doBlockActionInternal() {
        getTheTable().playerReturnCoinsToTreasury(getTheTable().getPlayerDoingTheAction(), THREE);
    }

}
