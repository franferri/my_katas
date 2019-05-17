package simulation;

import coup.Game;
import coup.GameEngine;
import coup.Player;
import coup.actions.Assassinate;
import coup.actions.Exchange;
import coup.actions.ForeignAid;
import coup.actions.Steal;
import coup.cards.TheAmbassator;
import coup.cards.TheAssassin;
import coup.cards.TheCaptain;
import coup.cards.TheContessa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwoPlayersGameShould {

    private Game game;

    @BeforeEach
    public void before() throws Exception {
        game = new Game(2);
    }

    @Test
    public void simplePlay() throws Exception {

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
    public void playUsingAllActions() throws Exception {

        game.playerTakesIncomeFromTreasury();
        game.playerTakesForeignAidFromTreasury();
        game.playerTakesTaxesFromTreasury();
        game.playerAssassinates(1);
        game.playerExchangesCardsFromTheCourtDeck();
        game.playerStealsFrom(1);

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
