package coup.actions;

import coup.Action;
import coup.Game;

public class Assassinate extends Action {

    // Action: Pay 3 coins, choose the player to lose influence
    // Block: Can be blocked by Contessa
    // Bluff: Can be challenged

    public void doActionInternal(Game game) {

        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();

        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();

        game.assassinatePlayer();

    }

    public void doCallTheBluffOnTheBlockAction(Game game) throws Exception {
    }

    public void doBlockActionInternal(Game game) {

        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();

        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();

    }

    public void doCallTheBluffOnTheAction(Game game) throws Exception {

    }
}
