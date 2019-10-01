package coup.actions;

import coup.Action;
import coup.Card;
import coup.TheTable;

import java.util.ArrayList;
import java.util.List;

public final class Exchange extends Action {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    public Exchange() {
    }

    public Exchange(final TheTable theTable) {
        super(theTable);
    }

    private List<Card> originalCardsInPlayerHand;
    private List<Card> originalDeck;

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal() {

        // We save the original hand, in case we get blocked, to rollback
        setOriginalCardsInPlayerHand(new ArrayList<>(getTheTable().getPlayerDoingTheAction().influenceDeck().cards()));
        getTheTable().courtDeck().saveDeck();

        getTheTable().dealCardsToThePlayer(getTheTable().getPlayerDoingTheAction());

        getTheTable().getPlayerDoingTheAction().shuffleCardsInHand();

        getTheTable().courtDeck().receiveScrambled(getTheTable().getPlayerDoingTheAction().returnActiveCardToCourtDeck());
        getTheTable().courtDeck().receiveScrambled(getTheTable().getPlayerDoingTheAction().returnActiveCardToCourtDeck());

    }

    // Block Action
    public void doBlockAction() {
        throw new RuntimeException("This action can't be blocked");
    }

    public void doBlockActionInternal() {

        getTheTable().getPlayerDoingTheAction().influenceDeck().cards().clear();
        getTheTable().getPlayerDoingTheAction().influenceDeck().receiveScrambled(getOriginalCardsInPlayerHand());

        getTheTable().courtDeck().restoreDeck();

    }

    public List<Card> getOriginalCardsInPlayerHand() {
        return originalCardsInPlayerHand;
    }

    private void setOriginalCardsInPlayerHand(final List<Card> originalCardsInPlayerHand) {
        this.originalCardsInPlayerHand = originalCardsInPlayerHand;
    }
}

