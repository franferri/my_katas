package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Assassinate extends Action {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by Contessa
    // Block can be challenged

    public Assassinate() {
    }

    public Assassinate(GameEngine gameEngine) {
        super(gameEngine);
    }

    private boolean paid = false;

    // Action
    public void doActionInternal()  {
        if (!paid) {
            gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction, 3);
            paid = true;
        }
        gameEngine.targetPlayer.looseCard();
    }

    // Block Action
    public void doBlockActionInternal()  {
        gameEngine.targetPlayer.restoreLostCard();
    }

}
