package coup.actions;

import coup.Action;
import coup.TheTable;

public final class Assassinate extends Action {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by Contessa
    // Block can be challenged

    public Assassinate() {
    }

    public Assassinate(final TheTable theTable) {
        super(theTable);
    }

    private boolean paid = false;

    // Action
    public void doActionInternal() {
        if (!paid) {
            getTheTable().playerReturnCoinsToTreasury(getTheTable().getPlayerDoingTheAction(), THREE);
            paid = true;
        }
        getTheTable().getTargetPlayer().looseCard();
    }

    // Block Action
    public void doBlockActionInternal() {
        getTheTable().getTargetPlayer().restoreLostCard();
    }

}
