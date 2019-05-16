package coup.actions;

import coup.Action;
import coup.Game;

public class Assassinate extends Action {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by Contessa
    // Block can be challenged

    boolean paid = false;

    // Action
    public void doActionInternal(Game game) throws Exception {

        if (!paid) {
            game.playerReturnCoinsToTreasury(game.playerDoingTheAction, 3);
            paid = true;
        }
        game.targetPlayerForAssassination.looseCard();
    }

    // Block Action
    public void doBlockActionInternal(Game game) throws Exception {
        game.targetPlayerForAssassination.restoreLostCard();
    }

}
