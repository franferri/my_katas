package coup;

import coup.actions.Coup7;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PlayerPlaysCoupHandShould {

    Game game;

    @Ignore
    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

    // Coup hand

    @Test
    public void a_player_does_action_coup() {

        // Player 1 has 7 coins and does action coup
        // Player 2 can't block

        // given
        Action action = new Coup7();

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

        // when
        game.setPlayerPlayingThisHand(1);
        game.setTargetPlayerForAssasination(2);

        game.doAction(action);

        // then
        Assert.assertEquals(41, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

}
