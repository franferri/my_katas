package coup.actions;

import coup.Action;
import coup.Game;

public class Exchange extends Action {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Block: Cannot be blocked
    // Bluff: Can be challenged

    public void doAction(Game game) {

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

