package coup.actions;

import coup.Action;
import coup.Game;
import coup.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionCoup10Should {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);
        game.startGame();

    }

    // Action: Pay 10 cons, choose the player to lose Influence

    @Test
    public void a_player_does_action_coup_10() throws Exception {

        // given
        Action action = new Coup10();

        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();

        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();

        // when
        game.setPlayerPlayingThisHand(1);
        game.setTargetPlayerForAssasination(2);

        game.doAction(action);

        // then
        Assert.assertEquals(48, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    // Block: Cannot be blocked

    @Test(expected = Exception.class)
    public void a_player_tries_to_block_action_coup_10() throws Exception {

        // given
        Action action = new Coup10();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

    }

    // Bluff: Cannot be challenged

    @Test(expected = Exception.class)
    public void a_player_calls_the_bluff_over_action_coup_10() throws Exception {

        // given
        Action action = new Coup10();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);

    }

}
