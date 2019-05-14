package coup.actions;

import coup.Action;
import coup.Game;

public class Exchange extends Action {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    // Setup
    public boolean canThisActionBeChallenged() {
        return true;
    }
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {

    }

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        throw new Exception("This action can't be blocked");
    }

    public void doBlockActionInternal(Game game) throws Exception {
        //
    }

}

