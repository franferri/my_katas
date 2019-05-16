package coup.actions;

import coup.Action;
import coup.Game;

public class Steal extends Action {

    // Action: Take 2 coins from another player
    // Action can be challenged

    // Block: Can be blocked by Captain
    // Block by Captain can be challenged

    // Block: Can be blocked by Ambassador
    // Block by Ambassador can be challenged

    // Action
    public void doActionInternal(Game game) throws Exception {
        game.playerTakesCoinsFromOtherPlayer(game.playerDoingTheAction, game.targetPlayerForStealing, 2);
    }

    // Block Action
    public void doBlockActionInternal(Game game) throws Exception {
        game.playerTakesCoinsFromOtherPlayer(game.targetPlayerForStealing, game.playerDoingTheAction, 2);
    }

}
