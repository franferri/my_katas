package coup.actions;

import coup.Action;
import coup.GameEngine;

public class Steal extends Action {

    // Action: Take 2 coins from another player
    // Action can be challenged

    // Block: Can be blocked by Captain
    // Block by Captain can be challenged

    // Block: Can be blocked by Ambassador
    // Block by Ambassador can be challenged

    public Steal() {
    }

    public Steal(GameEngine gameEngine) {
        super(gameEngine);
    }

    // Action
    public void doActionInternal() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.targetPlayerForStealing) {
            throw new Exception("Action can't be done to himself");
        }
        gameEngine.playerTakesCoinsFromOtherPlayer(gameEngine.playerDoingTheAction, gameEngine.targetPlayerForStealing, 2);
    }

    // Block Action
    public void doBlockActionInternal() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.playerBlockingTheAction) {
            throw new Exception("Player cant block himself");
        }
        gameEngine.playerTakesCoinsFromOtherPlayer(gameEngine.targetPlayerForStealing, gameEngine.playerDoingTheAction, 2);
    }

}
