package coup;

import coup.cards.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeckShould {

    @Test
    public void a_new_deck_consist_in_three_copies_of_each_characters_card() {

        // given
        Deck deck = new Deck();

        // when
        List<Card> cards = deck.cards();

        int ambassators = 0;
        int assasins = 0;
        int captains = 0;
        int conptesas = 0;
        int dukes = 0;

        for (Card card : cards) {

            if (card instanceof TheAmbassator) {
                ++ambassators;
            }
            if (card instanceof TheAssassin) {
                ++assasins;
            }
            if (card instanceof TheCaptain) {
                ++captains;
            }
            if (card instanceof TheConptessa) {
                ++conptesas;
            }
            if (card instanceof TheDuke) {
                ++dukes;
            }

        }

        // then
        assertEquals(3, ambassators);
        assertEquals(3, assasins);
        assertEquals(3, captains);
        assertEquals(3, conptesas);
        assertEquals(3, dukes);

    }

    @Test
    public void a_new_deck_has_a_total_of_fifteen_cards() {

        // given
        Deck deck = new Deck();

        // when
        List<Card> cards = deck.cards();

        // then
        assertEquals(15, cards.size());

    }

}
