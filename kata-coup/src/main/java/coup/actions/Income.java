package coup.actions;

import coup.Action;
import coup.Game;

public class Income extends Action {

    // Action: Take 1 coin from the treasury
    // Block: Cannot be blocked
    // Bluff: Cannot be challenged

    public void doAction(Game game) {

        game.takeCoinFromTreasury();
        game.playerPlayingHand().addCoin();

    }

    public void doBlockAction(Game game) {
    }

}
