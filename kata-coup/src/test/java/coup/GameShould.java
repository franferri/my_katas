package coup;

import coup.cards.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class GameShould {

    Game game;

    // TODO: If the game only have 2 players the rules are different
    // Mode 1 Normal (as with many players)
    // Mode 2 The selected starting player (player 1) gets only 1 coin at the beginning of the game
    // Mode 3 divide the cards in 3 sets of 5 (each set has 1 of each characters), Each player (player 1 and player 2) pick one of the sets and selects secretly a card and discard the rest.
    // Shuffle the third set and deal 1 card to each player and then put the remaining 3 cards face down ad court deck


    // TODO: If the game only have 2 players the rules are different
    // The selected starting player (player 1) gets only 1 coin at the beginning of the game

    // TODO: To cover 3 players or more, to choose who is doing the actions in the tests, we can just use random(), or the test repeats itself for all possible combinations in a loop (changing who does the action, who calls the bluff, who blocks the action, and who calls the bluff on the block action)



    @BeforeEach
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

    // CONTENTS

    // COUP game is a 2-6 players game

    @Test
    public void a_game_needs_2_players_at_least() throws Exception {
        // given
        Player player1 = new Player();

        // then
        Assertions.assertThrows(Exception.class, () -> new Game(player1));
    }

    @Test
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
        Assertions.assertThrows(Exception.class, () -> new Game(player1, player2, player3, player4, player5, player6, player7));
    }

    // The Treasury starts with 50 coins

    @Test
    public void a_new_game_has_a_treasury_of_50_coins() {

        // when
        int treasury = game.treasury();

        // then
        Assertions.assertEquals(50, treasury);

    }

    // The deck has 15 character cards (3 each of Duke, Assassin, Captain, Ambassador, Contessa)

    @Test
    public void a_new_game_has_a_deck() {

        // when
        Deck deck = game.deck();

        // then
        Assertions.assertNotNull(deck);

    }

    @Test
    public void a_new_game_has_a_deck_of_15_cards() {

        // when
        Deck deck = game.deck();

        // then
        Assertions.assertEquals(15, deck.cards().size());

    }

    @Test
    public void a_new_game_has_a_deck_that_consist_in_three_copies_of_each_characters_card() {

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
            if (card instanceof TheContessa) {
                ++conptesas;
            }
            if (card instanceof TheDuke) {
                ++dukes;
            }

        }

        // then
        Assertions.assertEquals(3, ambassators);
        Assertions.assertEquals(3, assasins);
        Assertions.assertEquals(3, captains);
        Assertions.assertEquals(3, conptesas);
        Assertions.assertEquals(3, dukes);

    }

    // SET-UP

    // Shuffle all the characters cards and deal 2 to each player

    @Test
    public void a_game_starts_with_a_shuffled_deck() throws Exception {

        // when
        Deck deck = game.deck();
        List<Card> originalOrderCards = new ArrayList<>(deck.cards());

        game.startGame();

        // then
        Assertions.assertNotEquals(originalOrderCards, deck.cards());

    }

    @Test
    public void a_new_game_starts_with_two_character_cards_per_player() throws Exception {

        // given
        int amountOfCardsAvailableInTheCourtDeck = game.deck().cards().size();
        int cardsTakenFromTheDeck = game.players.size() * 2;

        // when
        game.startGame();

        // then
        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(2).cardsInGame());

        Assertions.assertEquals(amountOfCardsAvailableInTheCourtDeck - cardsTakenFromTheDeck, game.deck().cards().size());

    }

    // Give each player 2 coins

    @Test
    public void a_new_game_starts_with_two_coins_per_player() throws Exception {

        // when
        game.startGame();

        // then
        Assertions.assertEquals(2, game.player(1).coins());
        Assertions.assertEquals(2, game.player(2).coins());

    }

    // GOAL

    // To eliminate the influence of all other players and be the last survivor

    @Test
    public void a_player_wins_when_no_more_players_left_alive() throws Exception {

        // when
        game.startGame();

        game.player(1).dies();

        // then
        Assertions.assertEquals(2, game.whoIsTheWinner());

    }

    // INFLUENCE

    // Face down cards in front of a player represent who they influence at court
    @Test
    public void a_new_game_starts_with_two_non_visible_character_cards_per_player() throws Exception {

        // when
        game.startGame();

        // then
        for (Player player : game.players) {
            Assertions.assertFalse(player.cards().get(0).isVisible());
            Assertions.assertFalse(player.cards().get(1).isVisible());
        }

    }

    // Every time a player loses an influence they have to turn over and reveal one of their face down cards
    @Test
    public void when_a_player_loses_influence_must_reveal_one_of_its_cards() throws Exception {

        // when
        game.startGame();
        game.player(1).looseCard();

        // then
        Assertions.assertEquals(1, game.player(1).cardsInGame());

    }
    // When a player has lost all their influence they are exiled and out of the game

    @Test
    public void a_player_dies_when_he_runs_out_of_cards() throws Exception {

        // when
        game.startGame();
        game.player(1).dies();

        // then
        Assertions.assertTrue(game.player(1).isDead());

    }

}