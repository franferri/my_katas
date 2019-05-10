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

    public void doBlockAction(Game game) throws Exception {

        throw new Exception("This action can't be blocked");

    }

    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    @Override
    public void doCallTheBluffOnTheAction(Game game) throws Exception {

    }

    public void doCallTheBluffOnTheBlockAction(Game game) throws Exception {

        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        doCallTheBluff(game);

    }

}
