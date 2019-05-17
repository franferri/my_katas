package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Coup10 extends Action {

    // Action: If 10 or more coins, the player must coup
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    public Coup10() {
    }

    public Coup10(GameEngine gameEngine) {
        super(gameEngine);
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.targetPlayerForAssassination) {
            throw new Exception("Action can't be done to himself");
        }
        gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction, 10);
        gameEngine.targetPlayerForAssassination.looseCard();
    }

    // Block Action
    public void doBlockAction() throws Exception {
        throw new Exception("This action can't be blocked");
    }

}
