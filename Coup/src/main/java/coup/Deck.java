package coup;

import coup.cards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {

        cards.add(new TheAmbassator());
        cards.add(new TheAmbassator());
        cards.add(new TheAmbassator());

        cards.add(new TheAssassin());
        cards.add(new TheAssassin());
        cards.add(new TheAssassin());

        cards.add(new TheCaptain());
        cards.add(new TheCaptain());
        cards.add(new TheCaptain());

        cards.add(new TheConptessa());
        cards.add(new TheConptessa());
        cards.add(new TheConptessa());

        cards.add(new TheDuke());
        cards.add(new TheDuke());
        cards.add(new TheDuke());

        shuffle();

    }

    public List<Card> cards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
