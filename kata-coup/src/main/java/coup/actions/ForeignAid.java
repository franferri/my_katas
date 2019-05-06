package coup.actions;

import coup.Action;
import coup.Game;

public class ForeignAid extends Action {

    // Take two coins from the treasury.

    public void doAction(Game game) {

        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();

        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();

    }

    public void doBlockAction(Game game) {

        game.returnCoinToTreasury();
        game.returnCoinToTreasury();

        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();

    }

}
