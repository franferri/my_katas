package simulation;

import coup.COUP;
import coup.cards.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoPlayersGameShould {

    private COUP game;

    @BeforeEach
    void before()  {
        game = new COUP();

        game.theTable().addPlayer();
        game.theTable().addPlayer();

        game.theTable().startGame();
    }

    @Test
    void simplePlay()  {

        // given
        game.theTable().player(1).influenceDeck().cards().clear();
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheAssassin());
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheCaptain());

        game.theTable().player(2).influenceDeck().cards().clear();
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheContessa());
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheContessa());

        // when

        // Player 1 hand
        game.actionPlayerTakesForeignAidFromTreasury();

        // Player 2 hand
        game.actionPlayerExchangesCardsFromTheCourtDeck();

        game.theTable().player(2).influenceDeck().cards().clear();
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheAmbassador());
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheContessa());

        // Player 1 hand
        game.actionPlayerAssassinates(2);

        // Player 2 hand
        game.actionPlayerBlocks(2);

        // Player 1 hand
        game.actionPlayerCallsTheBluff(1);

        // Player 2 hand
        game.actionPlayerTakesForeignAidFromTreasury();

        // Player 1 hand
        game.actionPlayerStealsFrom(2);

        // Player 2 hand
        game.actionPlayerBlocks(2);

        // Player 1 hand
        game.actionPlayerCallsTheBluff(1);

        // then
        Assertions.assertEquals(2, game.theTable().whoIsTheWinner());
        Assertions.assertTrue(game.theTable().player(1).isDead());

    }

    @Test
    void playUsingAllActions()  {

        // when
        // then

        game.actionPlayerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.actionPlayerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(40, 2, 6, 2, 4);

        game.actionPlayerAssassinates(1);
        assertGameSituation(43, 1, 6, 2, 1);

        game.actionPlayerExchangesCardsFromTheCourtDeck();
        assertGameSituation(43, 1, 6, 2, 1);

        game.actionPlayerStealsFrom(1);
        assertGameSituation(43, 1, 4, 2, 3);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(40, 1, 7, 2, 3);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(37, 1, 7, 2, 6);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(34, 1, 10, 2, 6);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(31, 1, 10, 2, 9);

        game.actionPlayerCoups10(2);
        assertGameSituation(41, 1, 0, 1, 9);

        game.actionPlayerCoups7(1);
        assertGameSituation(48, 0, 0, 1, 2);

        Assertions.assertEquals(2, game.theTable().whoIsTheWinner());
        Assertions.assertTrue(game.theTable().player(1).isDead());

    }


    @Test
    void playUsingAllActionsAndTheyGetBlocked()  {

        // when
        // then

        game.actionPlayerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.actionPlayerTakesForeignAidFromTreasury();
        game.actionPlayerBlocks(1);
        assertGameSituation(45, 2, 3, 2, 2);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(42, 2, 6, 2, 2);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(39, 2, 6, 2, 5);

        game.actionPlayerTakesTaxesFromTreasury();
        assertGameSituation(36, 2, 9, 2, 5);

        game.actionPlayerAssassinates(1);
        game.actionPlayerBlocks(1);
        assertGameSituation(39, 2, 9, 2, 2);

        game.actionPlayerExchangesCardsFromTheCourtDeck();
        assertGameSituation(39, 2, 9, 2, 2);

        game.actionPlayerStealsFrom(1);
        game.actionPlayerBlocks(1);
        assertGameSituation(39, 2, 9, 2, 2);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_wins_Tax_Assassination()  {

        // when
        // then

        game.theTable().player(1).influenceDeck().cards().clear();
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheDuke());
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheDuke());

        game.theTable().player(2).influenceDeck().cards().clear();
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheAssassin());
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheAssassin());

        game.actionPlayerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.actionPlayerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.actionPlayerTakesTaxesFromTreasury();
        game.actionPlayerCallsTheBluff(2);
        assertGameSituation(40, 2, 6, 1, 4);

        game.actionPlayerAssassinates(1);
        game.actionPlayerCallsTheBluff(1);
        assertGameSituation(43, 0, 6, 1, 1);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_loses_Tax_Assassination()  {

        // when
        // then

        game.theTable().player(1).influenceDeck().cards().clear();
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheContessa());
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheContessa());

        game.theTable().player(2).influenceDeck().cards().clear();
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheContessa());
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheContessa());

        game.actionPlayerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.actionPlayerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.actionPlayerTakesTaxesFromTreasury();
        game.actionPlayerCallsTheBluff(2);
        assertGameSituation(43, 1, 3, 2, 4);

        game.actionPlayerAssassinates(1);
        game.actionPlayerCallsTheBluff(1);
        assertGameSituation(46, 1, 3, 1, 1);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_wins_Exchange_Steal()  {

        // when
        // then

        game.theTable().player(1).influenceDeck().cards().clear();
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheAmbassador());
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheAmbassador());

        game.theTable().player(2).influenceDeck().cards().clear();
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheCaptain());
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheCaptain());

        game.actionPlayerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.actionPlayerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.actionPlayerExchangesCardsFromTheCourtDeck();
        game.actionPlayerCallsTheBluff(2);
        assertGameSituation(43, 2, 3, 1, 4);

        game.actionPlayerStealsFrom(1);
        game.actionPlayerCallsTheBluff(1);
        assertGameSituation(43, 1, 1, 1, 6);

    }

    @Test
    void playUsingAllActionsAndTheyGetChallenged_and_playerinitiatingaction_loses_Exchange_Steal()  {

        // when
        // then

        game.theTable().player(1).influenceDeck().cards().clear();
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheContessa());
        game.theTable().player(1).influenceDeck().receiveScrambled(new TheContessa());

        game.theTable().player(2).influenceDeck().cards().clear();
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheContessa());
        game.theTable().player(2).influenceDeck().receiveScrambled(new TheContessa());

        game.actionPlayerTakesIncomeFromTreasury();
        assertGameSituation(45, 2, 3, 2, 2);

        game.actionPlayerTakesForeignAidFromTreasury();
        assertGameSituation(43, 2, 3, 2, 4);

        game.actionPlayerExchangesCardsFromTheCourtDeck();
        game.actionPlayerCallsTheBluff(2);
        assertGameSituation(43, 1, 3, 2, 4);

        game.actionPlayerStealsFrom(1);
        game.actionPlayerCallsTheBluff(1);
        assertGameSituation(43, 1, 3, 1, 4);

    }

    // calls all the bluff in all blockactions and wins
    // calls all the bluff in all blockactions and looses

    void assertGameSituation(int treasury, int player1_cards, int player1_coins, int player2_cards, int player2_coins) {
        Assertions.assertEquals(treasury, game.theTable().treasury().coins());
        Assertions.assertEquals(11, game.theTable().courtDeck().cards().size());

        Assertions.assertEquals(player1_cards, game.theTable().player(1).cardsInGame());
        Assertions.assertEquals(player1_coins, game.theTable().player(1).wallet().coins());

        Assertions.assertEquals(player2_cards, game.theTable().player(2).cardsInGame());
        Assertions.assertEquals(player2_coins, game.theTable().player(2).wallet().coins());
    }

    // We need to test from 2 - 6 onlinePlayers
    // We need to test all actions, blocks, bluffs actions, bluff blocks
    // We need to test player A does an action and every other player blocks it
    // We need to test player A does an action and every other player calls bluffs it and wins the call
    // We need to test player A does an action and every other player calls bluffs it and loses the call
    // We need to test player A does an action and every other player blocks it every other player calls the bluff on the block and wins the call
    // We need to test player A does an action and every other player blocks it every other player calls the bluff on the block and loses the call

    // We need to assert the outcomes of every path

}
