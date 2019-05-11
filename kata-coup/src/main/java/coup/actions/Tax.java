package coup.actions;

import coup.Action;
import coup.Game;

public class Tax extends Action {

    // Action: Take 3 coins from the treasury
    // Block: Cannot be blocked
    // Bluff: Can be challenged



    public void doActionInternal(Game game) {
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();

        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();
    }

    public void doBlockAction(Game game) throws Exception {

        throw new Exception("This action can't be blocked");

    }

    public void doBlockActionInternal(Game game) {
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();
        game.returnCoinToTreasury();

        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();
    }


    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    public void doCallTheBluffOnTheAction(Game game) throws Exception {

        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }

        doCallTheBluffOnAction(game);

    }

    public void doCallTheBluffOnTheBlockAction(Game game) throws Exception {

        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        doCallTheBluffOnBlockAction(game);

    }

}
