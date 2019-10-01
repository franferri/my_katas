package coup.decks;

import coup.cards.TheAmbassador;
import coup.cards.TheAssassin;
import coup.cards.TheCaptain;
import coup.cards.TheContessa;
import coup.cards.TheDuke;

public final class CourtDeck extends Deck {

    public CourtDeck() {

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

}
