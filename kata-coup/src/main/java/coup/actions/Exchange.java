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

    public Exchange(GameEngine gameEngine) {
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

        cardsInPlayerHand = new ArrayList<>(gameEngine.playerDoingTheAction.cards()); // We save the original hand, in case we get blocked
        originalDeck = new ArrayList<>(gameEngine.deck().cards());

        gameEngine.playerDoingTheAction.cards().add(gameEngine.deck().cards().remove(gameEngine.deck().cards().size() - 1));
        gameEngine.playerDoingTheAction.cards().add(gameEngine.deck().cards().remove(gameEngine.deck().cards().size() - 1));

        gameEngine.playerDoingTheAction.shuffleCardsInHand();

        gameEngine.deck().cards().add(gameEngine.playerDoingTheAction.cards().remove(0));
        gameEngine.deck().cards().add(gameEngine.playerDoingTheAction.cards().remove(1));

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

