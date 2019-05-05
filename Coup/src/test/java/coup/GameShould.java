package coup;

import coup.cards.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameShould {

    @Test(expected = Exception.class)
    public void a_game_needs_2_players_at_least() throws Exception {

        // given
        Player player1 = new Player();

        // then
        new Game(player1);

    }

    @Test(expected = Exception.class)
    public void a_game_can_have_only_4_players() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();

        // then
        new Game(player1, player2, player3, player4, player5);

    }

    @Test
    public void a_new_game_starts_with_a_treasury_of_10_coins_per_player() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        // when
        Game game = new Game(player1, player2);
        int treasury = game.treasury();

        // then
        assertEquals(16, treasury);

    }

    @Test
    public void a_new_game_starts_with_a_deck() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        // when
        Game game = new Game(player1, player2);
        Deck deck = game.deck();

        // then
        assertNotNull(deck);

    }

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

    @Test
    public void a_new_game_starts_with_two_coins_per_player() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        // when
        Game game = new Game(player1, player2);

        // then
        List<Player> players = game.players();
        for (Player player : players) {
            assertEquals(2, player.coins());
        }

    }

    @Test
    public void a_game_can_shuffle_the_deck() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        Game game = new Game(player1, player2);

        // when
        Deck deck = game.deck();
        List<Card> originalOrderCards = new ArrayList<>(deck.cards());

        game.deck().shuffle();

        // then
        assertNotEquals(originalOrderCards, deck.cards());

    }

    @Test
    public void a_new_game_starts_with_two_character_cards_per_player() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        // when
        Game game = new Game(player1, player2);

        // then
        List<Player> players = game.players();
        for (Player player : players) {
            assertEquals(2, player.cards().size());
        }

    }

}
