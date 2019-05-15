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

    // Setup
    public boolean canThisActionBeChallenged() {
        return true;
    }

    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {

        game.targetPlayerForStealing.looseCoin();
        game.targetPlayerForStealing.looseCoin();

        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();

    }

    // Block Action
    public void doBlockActionInternal(Game game) throws Exception {

        game.targetPlayerForStealing.addCoin();
        game.targetPlayerForStealing.addCoin();

        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();

    }

}
