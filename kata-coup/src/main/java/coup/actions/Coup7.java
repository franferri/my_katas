package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Coup7 extends Action {

    // Action: Pay 7 cons, choose the player to lose Influence
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    public Coup7() {
    }

    public Coup7(GameEngine gameEngine) {
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
        gameEngine.playerReturnCoinsToTreasury(gameEngine.playerDoingTheAction, 7);
        gameEngine.targetPlayerForAssassination.looseCard();
    }

    // Block Action
    public void doBlockAction() throws Exception {
        throw new Exception("This action can't be blocked");
    }

}
