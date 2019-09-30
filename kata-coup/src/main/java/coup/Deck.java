package coup;

import coup.cards.TheAmbassador;
import coup.cards.TheAssassin;
import coup.cards.TheCaptain;
import coup.cards.TheContessa;
import coup.cards.TheDuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Deck {

    private static final int MAX_CARDS = 15;
    private static final int MIN_CARDS = 0;

    private final List<Card> cards = new ArrayList<>();
    private List<Card> savedDeck = new ArrayList<>();

    public Deck() {

        cards.add(new TheAmbassador());
        cards.add(new TheAmbassador());
        cards.add(new TheAmbassador());

        cards.add(new TheAssassin());
        cards.add(new TheAssassin());
        cards.add(new TheAssassin());

        cards.add(new TheCaptain());
        cards.add(new TheCaptain());
        cards.add(new TheCaptain());

        cards.add(new TheContessa());
        cards.add(new TheContessa());
        cards.add(new TheContessa());

        cards.add(new TheDuke());
        cards.add(new TheDuke());
        cards.add(new TheDuke());

    }

    public int cards() {
        return cards.size();
    }

    public List<Card> cardsForTesting() {
        return cards;
    }

    /**
     * Shuffle the deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deal a card from the top of the deck
     */
    public Card deal() throws RuntimeException {

        if (this.cards.size() - 1 < MIN_CARDS) {
            throw new RuntimeException("MIN_CARDS breached");
        }

        return this.cards.remove(0);
    }

    /**
     * Add a card to the deck
     */
    public void receive(final Card card) throws RuntimeException {

        if (this.cards.size() + 1 > MAX_CARDS) {
            throw new RuntimeException("MAX_CARDS breached");
        }

        this.cards.add(card);
    }

    /**
     * Add cards to the deck
     */
    public void receive(final List<Card> cards) throws RuntimeException {

        for (Card card : cards) {
            receive(card);
        }
    }

    public void saveDeck() {
        savedDeck = new ArrayList<>(cards);
    }

    public void restoreDeck() {
        cards.clear();
        receive(savedDeck);
        savedDeck.clear();
    }

}
