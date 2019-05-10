package coup.actions;

import coup.Action;
import coup.Game;

public class Tax extends Action {

    // Action: Take 3 coins from the treasury
    // Block: Cannot be blocked
    // Bluff: Can be challenged

    public void doAction(Game game) {

        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();

        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();

    }

    public void doBlockAction(Game game) {}

}
