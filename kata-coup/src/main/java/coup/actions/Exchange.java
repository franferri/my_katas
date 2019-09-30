package coup.actions;

import coup.Action;
import coup.Card;
import coup.GameEngine;

import java.util.ArrayList;
import java.util.List;

public final class Exchange extends Action {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    public Exchange() {
    }

    public Exchange(final GameEngine gameEngine) {
        super(gameEngine);
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
        setOriginalCardsInPlayerHand(new ArrayList<>(getGameEngine().getPlayerDoingTheAction().influenceDeck()));
        originalDeck = new ArrayList<>(getGameEngine().deck().cardsForTest());

        getGameEngine().dealCardsToThePlayer(getGameEngine().getPlayerDoingTheAction());

        getGameEngine().getPlayerDoingTheAction().shuffleCardsInHand();


        getGameEngine().deck().receive(getGameEngine().getPlayerDoingTheAction().returnActiveCardToCourtDeck());
        getGameEngine().deck().receive(getGameEngine().getPlayerDoingTheAction().returnActiveCardToCourtDeck());

    }

    // Block Action
    public void doBlockAction() {
        throw new RuntimeException("This action can't be blocked");
    }

    public void doBlockActionInternal() {

        getGameEngine().getPlayerDoingTheAction().influenceDeck().clear();
        getGameEngine().getPlayerDoingTheAction().influenceDeck().addAll(getOriginalCardsInPlayerHand());

        getGameEngine().deck().cardsForTest().clear();
        getGameEngine().deck().receive(originalDeck);

    }

    public List<Card> getOriginalCardsInPlayerHand() {
        return originalCardsInPlayerHand;
    }

    public void setOriginalCardsInPlayerHand(final List<Card> originalCardsInPlayerHand) {
        this.originalCardsInPlayerHand = originalCardsInPlayerHand;
    }
}

