package coup.actions;

import coup.Action;
import coup.TheTable;

public final class Steal extends Action {

    // Action: Take 2 coins from another player
    // Action can be challenged

    // Block: Can be blocked by Captain
    // Block by Captain can be challenged

    // Block: Can be blocked by Ambassador
    // Block by Ambassador can be challenged


    public Steal() {
    }

    public Steal(final TheTable theTable) {
        super(theTable);
    }

    // Action
    public void doActionInternal()  {
        getTheTable().playerTakesCoinsFromOtherPlayer(getTheTable().getPlayerDoingTheAction(), getTheTable().getTargetPlayer(), 2);
    }

    // Block Action
    public void doBlockActionInternal()  {
        getTheTable().playerTakesCoinsFromOtherPlayer(getTheTable().getTargetPlayer(), getTheTable().getPlayerDoingTheAction(), 2);
    }

}
