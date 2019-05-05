package coup.actions;

import coup.Action;
import coup.Game;

public class Income extends Action {

    // Take one coin from the treasury.

    public void doAction(Game game) {

        game.takeCoinFromTreasury();
        game.playerPlayingHand().addCoin();

    }

}
