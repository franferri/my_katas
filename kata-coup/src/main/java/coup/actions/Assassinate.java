package coup.actions;

import coup.Action;
import coup.Game;

public class Assassinate extends Action {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by Contessa
    // Block can be challenged

    // Setup
    public boolean canThisActionBeChallenged() {
        return true;
    }
    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {
        returnCoinsToTreasury(game, 3);
        game.assassinatePlayer();
    }

    // Action 2
    @Override
    public void doActionInternal2(Game game)  {
        game.assassinatePlayer();
    }

    // Block Action
    public void doBlockActionInternal(Game game) throws Exception {
        //takeCoinsFromTreasury(game, 3);
        game.recoverPlayer();
    }

}
