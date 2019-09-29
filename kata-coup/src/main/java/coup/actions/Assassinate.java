package coup.actions;

import coup.Action;
import coup.GameEngine;

public final class Assassinate extends Action {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by Contessa
    // Block can be challenged

    public Assassinate() {
    }

    public Assassinate(final GameEngine gameEngine) {
        super(gameEngine);
    }

    private boolean paid = false;

    // Action
    public void doActionInternal() {
        if (!paid) {
            getGameEngine().playerReturnCoinsToTreasury(getGameEngine().getPlayerDoingTheAction(), THREE);
            paid = true;
        }
        getGameEngine().getTargetPlayer().looseCard();
    }

    // Block Action
    public void doBlockActionInternal() {
        getGameEngine().getTargetPlayer().restoreLostCard();
    }

}
