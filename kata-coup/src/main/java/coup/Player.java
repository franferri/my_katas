package coup;

import coup.actions.Exchange;
import coup.coins.Coins;
import coup.coins.Wallet;
import coup.decks.Deck;
import coup.decks.InfluenceDeck;

import java.util.List;
import java.util.Random;

public final class Player {

    private Wallet wallet;

    private final InfluenceDeck influenceDeck;
    private final InfluenceDeck lostInfluenceDeck;

    public Player() {
        wallet = new Wallet();
        influenceDeck = new InfluenceDeck();
        lostInfluenceDeck = new InfluenceDeck();
    }

    public Coins wallet() {
        return wallet;
    }

    public Deck influenceDeck() {
        return influenceDeck;
    }

    public Deck lostInfluenceDeck() {
        return lostInfluenceDeck;
    }

    public void looseCard() {

        if (influenceDeck().cards().size() < 2) {
            dies();
            return;
        }

        int cardLost = new Random().nextInt(influenceDeck().cards().size());
        lostInfluenceDeck().receiveScrambled(influenceDeck().dealSpecific(cardLost));

    }

    public void restoreLostCard() {

        int lastCardOfTheDeck = lostInfluenceDeck().cards().size() - 1;
        influenceDeck().receiveScrambled(lostInfluenceDeck().dealSpecific(lastCardOfTheDeck));

    }

    public void dies() {
        lostInfluenceDeck().receiveScrambled(influenceDeck().cards());
        influenceDeck().cards().clear();
    }

    public boolean isDead() {
        return lostInfluenceDeck().cards().size() == 2;
    }

    public Card returnActiveCardToCourtDeck() {
        if (isDead()) {
            throw new RuntimeException("Player is dead, don't have any visible cards");
        }

        for (int i = 0; i < influenceDeck.cards().size(); i++) {
            return influenceDeck.dealSpecific(i);
        }

        return null;
    }

    public int cardsInGame() {
        return influenceDeck().cards().size();
    }

    public boolean canHeBlockTheAction(final Action action) {

        for (Card card : influenceDeck.cards()) {

            if (null == card.blocksAction()) {
                continue;
            }

            Class classz = card.blocksAction().getClass();
            if (classz == null) {
                return false;
            }

            if (classz == action.getClass()) {
                return true;
            }

        }

        return false;

    }

    public boolean canHeDoTheAction(final Action action) {

        List<Card> cardsToCheck = influenceDeck().cards();

        if (action instanceof Exchange) {
            cardsToCheck = ((Exchange) action).getOriginalCardsInPlayerHand();
        }

        for (Card card : cardsToCheck) {

            if (null == card.doAction()) {
                continue;
            }

            Class classz = card.doAction().getClass();
            if (classz == null) {
                return false;
            }

            if (classz == action.getClass()) {
                return true;
            }

        }

        return false;

    }

    public void shuffleCardsInHand() {
        influenceDeck.shuffle();
    }

}
