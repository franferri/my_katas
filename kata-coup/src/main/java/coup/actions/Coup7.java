package coup.actions;

import coup.Action;
import coup.Game;

public class Coup7 extends Action {

    // Action: Pay 7 cons, choose the player to lose Influence
    // Block: Cannot be blocked
    // Bluff: Cannot be challenged

    public void doAction(Game game) {

        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();

        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();

        game.assasinatePlayer();

    }

    public void doBlockAction(Game game) {}

}
