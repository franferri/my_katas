package coup.actions;

import coup.ActionTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ActionCoup10Should extends ActionTests {

    // Action: If 10 or more coins, the player must coup
    // Action cannot be challenged

    // Block: Cannot be blocked

    @Before
    public void before() throws Exception {
        super.before();
        action = new Coup10();
    }

    // Action costs money
    @Test(expected = Exception.class)
    public void player_needs_money_to_do_the_action() throws Exception {
        // when
        game.setPlayerPlayingThisHand(1);
        game.setTargetPlayerForAssasination(2);

        game.doAction(action);
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // given
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

    // Action cannot be challenged
    @Test(expected = Exception.class)
    public void player_calls_the_bluff_over_action() throws Exception {
        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);
    }

    // Action cannot be blocked
    @Test(expected = Exception.class)
    public void player_blocks_action() throws Exception {
        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);
    }

}
