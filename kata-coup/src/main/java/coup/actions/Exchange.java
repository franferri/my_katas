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

    public List<Card> originalCardsInPlayerHand;
    private List<Card> originalDeck;

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal()  {

        // We save the original hand, in case we get blocked, to rollback
        originalCardsInPlayerHand = new ArrayList<>(gameEngine.playerDoingTheAction.cards());
        originalDeck = new ArrayList<>(gameEngine.deck().cards());

        gameEngine.dealCardsToThePlayer(gameEngine.playerDoingTheAction);

        gameEngine.playerDoingTheAction.shuffleCardsInHand();
        gameEngine.playerDoingTheAction.shuffleCardsInHand();
        gameEngine.playerDoingTheAction.shuffleCardsInHand();
        gameEngine.playerDoingTheAction.shuffleCardsInHand();

        gameEngine.deck().cards().add(gameEngine.playerDoingTheAction.returnActiveCardToCourtDeck());
        gameEngine.deck().cards().add(gameEngine.playerDoingTheAction.returnActiveCardToCourtDeck());

    }

    // Block Action
    public void doBlockAction()  {
        throw new RuntimeException("This action can't be blocked");
    }

    public void doBlockActionInternal() {

        gameEngine.playerDoingTheAction.cards().clear();
        gameEngine.playerDoingTheAction.cards().addAll(originalCardsInPlayerHand);

        gameEngine.deck().cards().clear();
        gameEngine.deck().cards().addAll(originalDeck);

    }

}

