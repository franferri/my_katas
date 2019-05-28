package simulation;

import coup.Game;
import coup.cards.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoPlayersGameShould {

    private Game game;

    @BeforeEach
    void before() throws Exception {
        game = new Game(2);
    }

    @Test
    void simplePlay() throws Exception {

        // given
        game.gameEngine().player(1).cards().clear();
        game.gameEngine().player(1).cards().add(new TheAssassin());
        game.gameEngine().player(1).cards().add(new TheCaptain());

        game.gameEngine().player(2).cards().clear();
        game.gameEngine().player(2).cards().add(new TheContessa());
        game.gameEngine().player(2).cards().add(new TheContessa());

        // when

        // Player 1 hand
        game.playerTakesForeignAidFromTreasury();

        // Player 2 hand
        game.playerExchangesCardsFromTheCourtDeck();

        game.gameEngine().player(2).cards().clear();
        game.gameEngine().player(2).cards().add(new TheAmbassator());
        game.gameEngine().player(2).cards().add(new TheContessa());

        // Player 1 hand
        game.playerAssassinates(2);

        // Player 2 hand
        game.playerBlocks(2);

        // Player 1 hand
        game.playerCallsTheBluff(1);

        // Player 2 hand
        game.playerTakesForeignAidFromTreasury();

        // Player 1 hand
        game.playerStealsFrom(2);

        // Player 2 hand
        game.playerBlocks(2);

        // Player 1 hand
        game.playerCallsTheBluff(1);

        // then
        Assertions.assertEquals(2, game.gameEngine().whoIsTheWinner());
        Assertions.assertTrue(game.gameEngine().player(1).isDead());

    }

    @Test
    void playUsingAllActions() throws Exception {

        // when
        // then

        game.playerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.playerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(40, 2, 6, 2, 4);

        game.playerAssassinates(1);
        assertGameSituation(43, 1, 6, 2, 1);

        game.playerExchangesCardsFromTheCourtDeck();
        assertGameSituation(43, 1, 6, 2, 1);

        game.playerStealsFrom(1);
        assertGameSituation(43, 1, 4, 2, 3);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(40, 1, 7, 2, 3);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(37, 1, 7, 2, 6);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(34, 1, 10, 2, 6);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(31, 1, 10, 2, 9);

        game.playerCoups10(2);
        assertGameSituation(41, 1, 0, 1, 9);

        game.playerCoups7(1);
        assertGameSituation(48, 0, 0, 1, 2);

        Assertions.assertEquals(2, game.gameEngine().whoIsTheWinner());
        Assertions.assertTrue(game.gameEngine().player(1).isDead());

    }


    @Test
    void playUsingAllActionsAndTheyGetBlocked() throws Exception {

        // when
        // then

        game.playerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.playerTakesForeignAidFromTreasury();
        game.playerBlocks(1);
        assertGameSituation(45, 2, 3, 2, 2);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(42, 2, 6, 2, 2);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(39, 2, 6, 2, 5);

        game.playerTakesTaxesFromTreasury();
        assertGameSituation(36, 2, 9, 2, 5);

        game.playerAssassinates(1);
        game.playerBlocks(1);
        assertGameSituation(39, 2, 9, 2, 2);

        game.playerExchangesCardsFromTheCourtDeck();
        assertGameSituation(39, 2, 9, 2, 2);

        game.playerStealsFrom(1);
        game.playerBlocks(1);
        assertGameSituation(39, 2, 9, 2, 2);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_wins_Tax_Assassination() throws Exception {

        // when
        // then

        game.gameEngine().player(1).cards().clear();
        game.gameEngine().player(1).cards().add(new TheDuke());
        game.gameEngine().player(1).cards().add(new TheDuke());

        game.gameEngine().player(2).cards().clear();
        game.gameEngine().player(2).cards().add(new TheAssassin());
        game.gameEngine().player(2).cards().add(new TheAssassin());

        game.playerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.playerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.playerTakesTaxesFromTreasury();
        game.playerCallsTheBluff(2);
        assertGameSituation(40, 2, 6, 1, 4);

        game.playerAssassinates(1);
        game.playerCallsTheBluff(1);
        assertGameSituation(43, 0, 6, 1, 1);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_loses_Tax_Assassination() throws Exception {

        // when
        // then

        game.gameEngine().player(1).cards().clear();
        game.gameEngine().player(1).cards().add(new TheContessa());
        game.gameEngine().player(1).cards().add(new TheContessa());

        game.gameEngine().player(2).cards().clear();
        game.gameEngine().player(2).cards().add(new TheContessa());
        game.gameEngine().player(2).cards().add(new TheContessa());

        game.playerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.playerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.playerTakesTaxesFromTreasury();
        game.playerCallsTheBluff(2);
        assertGameSituation(43, 1, 3, 2, 4);

        game.playerAssassinates(1);
        game.playerCallsTheBluff(1);
        assertGameSituation(46, 1, 3, 1, 1);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_wins_Exchange_Steal() throws Exception {

        // when
        // then

        game.gameEngine().player(1).cards().clear();
        game.gameEngine().player(1).cards().add(new TheAmbassator());
        game.gameEngine().player(1).cards().add(new TheAmbassator());

        game.gameEngine().player(2).cards().clear();
        game.gameEngine().player(2).cards().add(new TheCaptain());
        game.gameEngine().player(2).cards().add(new TheCaptain());

        game.playerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.playerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.playerExchangesCardsFromTheCourtDeck();
        game.playerCallsTheBluff(2);
        assertGameSituation(43, 2, 3, 1, 4);

        game.playerStealsFrom(1);
        game.playerCallsTheBluff(1);
        assertGameSituation(43, 1, 1, 1, 6);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_loses_Exchange_Steal() throws Exception {

        // when
        // then

        game.gameEngine().player(1).cards().clear();
        game.gameEngine().player(1).cards().add(new TheContessa());
        game.gameEngine().player(1).cards().add(new TheContessa());

        game.gameEngine().player(2).cards().clear();
        game.gameEngine().player(2).cards().add(new TheContessa());
        game.gameEngine().player(2).cards().add(new TheContessa());

        game.playerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.playerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.playerExchangesCardsFromTheCourtDeck();
        game.playerCallsTheBluff(2);
        assertGameSituation(43, 1, 3, 2, 4);

        game.playerStealsFrom(1);
        game.playerCallsTheBluff(1);
        assertGameSituation(43, 1, 3, 1, 4);

    }

    // calls all the bluff in all blockactions and wins
    // calls all the bluff in all blockactions and looses

    void assertGameSituation(int treasury, int player1_cards, int player1_coins, int player2_cards, int player2_coins) {
        Assertions.assertEquals(treasury, game.gameEngine().treasury());
        Assertions.assertEquals(11, game.gameEngine().deck().cards().size());

        Assertions.assertEquals(player1_cards, game.gameEngine().player(1).cardsInGame());
        Assertions.assertEquals(player1_coins, game.gameEngine().player(1).coins());

        Assertions.assertEquals(player2_cards, game.gameEngine().player(2).cardsInGame());
        Assertions.assertEquals(player2_coins, game.gameEngine().player(2).coins());
    }

    // We need to test from 2 - 6 players
    // We need to test all actions, blocks, bluffs actions, bluff blocks
    // We need to test player A does an action and every other player blocks it
    // We need to test player A does an action and every other player calls bluffs it and wins the call
    // We need to test player A does an action and every other player calls bluffs it and loses the call
    // We need to test player A does an action and every other player blocks it every other player calls the bluff on the block and wins the call
    // We need to test player A does an action and every other player blocks it every other player calls the bluff on the block and loses the call

    // We need to assert the outcomes of every path

}
