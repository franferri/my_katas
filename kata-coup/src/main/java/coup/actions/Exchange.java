package coup.actions;

import coup.Action;
import coup.Card;
import coup.Game;

import java.util.ArrayList;
import java.util.List;

public class Exchange extends Action {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    List<Card> cardsInPlayerHand;
    List<Card> originalDeck;

    // Setup
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {

        cardsInPlayerHand = new ArrayList<>(game.playerDoingTheAction.cards()); // We save the original hand, in case we get blocked
        originalDeck = new ArrayList<>(game.deck().cards());

        game.playerDoingTheAction.cards().add(game.deck().cards().remove(game.deck().cards().size() - 1));
        game.playerDoingTheAction.cards().add(game.deck().cards().remove(game.deck().cards().size() - 1));

        game.playerDoingTheAction.shuffleCardsInHand();

        game.deck().cards().add(game.playerDoingTheAction.cards().remove(0));
        game.deck().cards().add(game.playerDoingTheAction.cards().remove(1));

    }

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        throw new Exception("This action can't be blocked");
    }

    public void doBlockActionInternal(Game game) throws Exception {

        game.playerDoingTheAction.cards().clear();
        game.playerDoingTheAction.cards().addAll(cardsInPlayerHand);

        game.deck().cards().clear();
        game.deck().cards().addAll(originalDeck);

    }

}

