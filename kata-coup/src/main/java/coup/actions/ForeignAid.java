package coup.actions;

import coup.Action;
import coup.Game;

public class ForeignAid extends Action {

    // Action: Take two coins from the treasury
    // Block: Can be blocked by a player claiming the Duke
    // Bluff: Cannot be challenged


    public void doActionInternal(Game game) {
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();

        game.playerPlayingHand().addCoin();
        game.playerPlayingHand().addCoin();
    }

    public void doBlockActionInternal(Game game) {

        game.returnCoinToTreasury();
        game.returnCoinToTreasury();

        game.playerPlayingHand().looseCoin();
        game.playerPlayingHand().looseCoin();

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



    public void doCallTheBluffOnTheBlockAction(Game game) throws Exception {

        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        doCallTheBluffOnBlockAction(game);

    }

}
