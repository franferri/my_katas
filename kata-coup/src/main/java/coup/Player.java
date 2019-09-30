package coup;

import coup.actions.Exchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class Player {

    private int coins = 0;

    private final List<Card> influenceDeck = new ArrayList<>();
    private final List<Card> lostInfluenceDeck = new ArrayList<>();

    public void gainCoin() {
        ++coins;
    }

    public void looseCoin() {
        --coins;
    }

    public int coins() {
        return coins;
    }

    public List<Card> influenceDeck() {
        return influenceDeck;
    }

    public List<Card> lostInfluenceDeck() {
        return lostInfluenceDeck;
    }

    private String name;

    public Player(final String name) {
        this.name = name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void looseCard() {

        if (influenceDeck().size() < 2) {
            dies();
            return;
        }

        int cardLost = new Random().nextInt(influenceDeck().size());
        lostInfluenceDeck().add(influenceDeck().remove(cardLost));

    }

    public void restoreLostCard() {

        int lastCardOfTheDeck = lostInfluenceDeck().size() - 1;
        influenceDeck().add(lostInfluenceDeck().remove(lastCardOfTheDeck));

    }

    public void dies() {
        lostInfluenceDeck().addAll(influenceDeck());
        influenceDeck().clear();
    }

    public boolean isDead() {
        return lostInfluenceDeck().size() == 2;
    }

    public Card returnActiveCardToCourtDeck() {
        if (isDead()) {
            throw new RuntimeException("Player is dead, don't have any visible cards");
        }

        for (int i = 0; i < influenceDeck.size(); i++) {
            return influenceDeck.remove(i);
        }

        return null;
    }

    public int cardsInGame() {
        return influenceDeck().size();
    }

    public boolean canHeBlockTheAction(final Action action) {

        for (Card card : influenceDeck) {

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

        List<Card> cardsToCheck = influenceDeck();

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
        Collections.shuffle(influenceDeck);
    }

}
