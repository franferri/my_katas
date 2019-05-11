package coup.actions;

import coup.Action;
import coup.Game;

public class Coup10 extends Action {

    // Action: If 10 or more coins, the player must coup
    // Block: Cannot be blocked
    // Bluff: Cannot be challenged

    public void doActionInternal(Game game) {

        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();

        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();

        game.assassinatePlayer();

    }

    public boolean canThisActionBeChallenged() {
        return false;
    }

    public void doCallTheBluffOnTheAction(Game game) throws Exception {

        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }

        doCallTheBluffOnAction(game);

    }

    public void doBlockActionInternal(Game game) throws Exception {

        throw new Exception("This action can't be blocked");

    }

    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    public void doCallTheBluffOnTheBlockAction(Game game) throws Exception {

        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        doCallTheBluffOnBlockAction(game);

    }

}
