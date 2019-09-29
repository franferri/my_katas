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

    private final List<Card> cards = new ArrayList<>();

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

    public List<Card> cards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
