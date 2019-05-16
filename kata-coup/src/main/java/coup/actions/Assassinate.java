package coup.actions;

import coup.Action;
import coup.Game;

public class Assassinate extends Action {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by Contessa
    // Block can be challenged

    // Action
    public void doActionInternal(Game game) throws Exception {
        game.playerReturnCoinsToTreasury(game.playerDoingTheAction,3);
        game.playerLoosesCard(game.targetPlayerForAssassination);
    }

    public void doActionInternal2(Game game) {
        game.playerLoosesCard(game.targetPlayerForAssassination);
    }

    // Block Action
    public void doBlockActionInternal(Game game) throws Exception {
        game.recoverPlayer();
    }

}
