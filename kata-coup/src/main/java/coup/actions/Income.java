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

    public boolean canThisActionBeChallenged() {
        return false;
    }

    public void doCallTheBluffOnTheAction(Game game) throws Exception {

        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }

        doCallTheBluff(game);

    }

    public void doBlockAction(Game game) throws Exception {

        throw new Exception("This action can't be blocked");

    }

    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    public void doCallTheBluffOnTheBlockAction(Game game) throws Exception {

        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        doCallTheBluff(game);

    }

}
