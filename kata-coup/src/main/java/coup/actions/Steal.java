package coup.actions;

import coup.Action;
import coup.GameEngine;

public final class Steal extends Action {

    // Action: Take 2 coins from another player
    // Action can be challenged

    // Block: Can be blocked by Captain
    // Block by Captain can be challenged

    // Block: Can be blocked by Ambassador
    // Block by Ambassador can be challenged


    public Steal() {
    }

    public Steal(final GameEngine gameEngine) {
        super(gameEngine);
    }

    // Action
    public void doActionInternal()  {
        getGameEngine().playerTakesCoinsFromOtherPlayer(getGameEngine().getPlayerDoingTheAction(), getGameEngine().getTargetPlayer(), 2);
    }

    // Block Action
    public void doBlockActionInternal()  {
        getGameEngine().playerTakesCoinsFromOtherPlayer(getGameEngine().getTargetPlayer(), getGameEngine().getPlayerDoingTheAction(), 2);
    }

}
