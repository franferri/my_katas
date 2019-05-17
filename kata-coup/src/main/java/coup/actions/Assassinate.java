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

    public Assassinate(GameEngine gameEngine) throws Exception {
        super(gameEngine);
    }

    boolean paid = false;

    // Action
    public void doActionInternal() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.targetPlayerForAssassination) {
            throw new Exception("Action can't be done to himself");
        }
        if (!paid) {
            gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction, 3);
            paid = true;
        }
        gameEngine.targetPlayerForAssassination.looseCard();
    }

    // Block Action
    public void doBlockActionInternal() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.playerBlockingTheAction) {
            throw new Exception("Player cant block himself");
        }
        gameEngine.targetPlayerForAssassination.restoreLostCard();
    }

}
