package coup;

import coup.cards.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameShould {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

    @Test(expected = Exception.class)
    public void a_game_needs_2_players_at_least() throws Exception {

        // given
        Player player1 = new Player();

        // then
        new Game(player1);

    }

    @Test(expected = Exception.class)
    public void a_game_can_have_until_6_players() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();
        Player player6 = new Player();
        Player player7 = new Player();

        // then
        new Game(player1, player2, player3, player4, player5, player6, player7);

    }

    @Test
    public void a_new_game_starts_with_a_treasury_of_10_coins_per_player() {

        // when
        int treasury = game.treasury();

        // then
        assertEquals(46, treasury);

    }

    @Test
    public void a_new_game_starts_with_a_deck() {

        // when
        Deck deck = game.deck();

        // then
        assertNotNull(deck);

    }


    @Test
    public void a_new_game_starts_with_two_coins_per_player() {

        // then
        assertEquals(2, game.player(1).coins());
        assertEquals(2, game.player(2).coins());

    }

    @Test
    public void a_game_can_shuffle_the_deck() {

        // when
        Deck deck = game.deck();
        List<Card> originalOrderCards = new ArrayList<>(deck.cards());

        game.deck().shuffle();

        // then
        assertNotEquals(originalOrderCards, deck.cards());

    }

    @Test
    public void a_new_game_starts_with_two_character_cards_per_player() {

        // then
        assertEquals(2, game.player(1).cards().size());
        assertEquals(2, game.player(2).cards().size());

    }

    @Test
    public void a_player_dies_when_he_runs_out_of_cards() {

        // when
        game.player(1).dies();

        // then
        assertTrue(game.player(1).isDead());

    }

    @Test
    public void a_player_wins_when_no_more_players_left_alive() {

        // A player is dead when his cards are all visible

        // when
        game.killPlayer(1);

        // then
        assertNotNull(game.whoIsTheWinner());

    }

}