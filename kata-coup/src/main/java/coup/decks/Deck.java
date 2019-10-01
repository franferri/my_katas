package coup.decks;

import coup.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private static final int MAX_CARDS = 15;
    private static final int MIN_CARDS = 0;

    protected final List<Card> cards = new ArrayList<>();
    private List<Card> savedDeck = new ArrayList<>();

    public List<Card> cards() {
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
    public Card dealFromTheTop() {
        if (this.cards.size() - 1 < MIN_CARDS) {
            throw new RuntimeException("Not enough cards");
        }
        return this.cards.remove(0);
    }

    /**
     * Deal a specific card from the deck
     */
    public Card dealSpecific(final int position) {
        if (this.cards.size() - 1 < MIN_CARDS) {
            throw new RuntimeException("Not enough cards");
        }
        return this.cards.remove(position);
    }

    /**
     * Add a card to the deck scrambled
     */
    public void receiveScrambled(final Card card) {
        if (this.cards.size() + 1 > MAX_CARDS) {
            throw new RuntimeException("Too many cards in play");
        }

        int scrambledPosition = 0;
        if (this.cards.size() > 0) {
            scrambledPosition = new Random().nextInt(this.cards.size());
        }
        this.cards.add(scrambledPosition, card);
    }

    /**
     * Add cards to the deck scrambled
     */
    public void receiveScrambled(final List<Card> cards) {

        for (Card card : cards) {
            receiveScrambled(card);
        }
    }

    public void saveDeck() {
        savedDeck = new ArrayList<>(cards);
    }

    public void restoreDeck() {
        cards.clear();
        receiveScrambled(savedDeck);
        savedDeck.clear();
    }

}
