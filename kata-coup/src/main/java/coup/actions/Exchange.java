package coup.actions;

import coup.Action;
import coup.Card;
import coup.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class Exchange extends Action {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    public Exchange() {
    }

    public Exchange(GameEngine gameEngine) throws Exception {
        super(gameEngine);
    }

    List<Card> cardsInPlayerHand;
    List<Card> originalDeck;

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal() throws Exception {

        // We save the original hand, in case we get blocked, to rollback
        cardsInPlayerHand = new ArrayList<>(gameEngine.playerDoingTheAction.cards());
        originalDeck = new ArrayList<>(gameEngine.deck().cards());

        Card card1 = gameEngine.deck().cards().remove(0);
        Card card2 = gameEngine.deck().cards().remove(0);

        gameEngine.playerDoingTheAction.cards().add(card1);
        gameEngine.playerDoingTheAction.cards().add(card2);

        gameEngine.playerDoingTheAction.shuffleCardsInHand();
        gameEngine.playerDoingTheAction.shuffleCardsInHand();
        gameEngine.playerDoingTheAction.shuffleCardsInHand();
        gameEngine.playerDoingTheAction.shuffleCardsInHand();

        gameEngine.deck().cards().add(gameEngine.playerDoingTheAction.returnActiveCardToCourtDeck());
        gameEngine.deck().cards().add(gameEngine.playerDoingTheAction.returnActiveCardToCourtDeck());

    }

    // Block Action
    public void doBlockAction() throws Exception {
        throw new Exception("This action can't be blocked");
    }

    public void doBlockActionInternal() throws Exception {

        gameEngine.playerDoingTheAction.cards().clear();
        gameEngine.playerDoingTheAction.cards().addAll(cardsInPlayerHand);

        gameEngine.deck().cards().clear();
        gameEngine.deck().cards().addAll(originalDeck);

    }

}

