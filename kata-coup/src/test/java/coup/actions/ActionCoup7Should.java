package coup.actions;

import coup.Action;
import coup.ActionTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ActionCoup7Should extends ActionTests {

    // Action: Pay 7 cons, choose the player to lose Influence
    // Action cannot be challenged

    // Block: Cannot be blocked

    @Before
    public void before() throws Exception {
        super.before();
        action = new Coup7();
    }

    // Action costs money
    @Test(expected = Exception.class)
    public void player_needs_money_to_do_the_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);

        action.doAction(game);
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // given

        // when
        game.playerDoingTheAction = game.player(1);
        game.playerTakeCoinsFromTreasury(game.playerDoingTheAction,5);
        game.targetPlayerForAssassination = game.player(2);

        action.doAction(game);

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
        // given
        Action action = new Coup7();

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);
    }

    // Action cannot be blocked
    @Test(expected = Exception.class)
    public void player_blocks_action() throws Exception {
        // given
        Action action = new Coup7();

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);
    }

}
