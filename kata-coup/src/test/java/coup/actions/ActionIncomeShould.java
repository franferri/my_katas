package coup.actions;

import coup.ActionTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionIncomeShould extends ActionTests {

    // Action: Take 1 coin from the treasury
    // Action cannot be challenged

    // Block: Cannot be blocked

    @Before
    public void before() throws Exception {
        super.before();
        action = new Income();
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        // then
        Assert.assertEquals(45, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(3, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Action cannot be challenged
    @Test(expected = Exception.class)
    public void player_calls_the_bluff_over_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

    }

    // Action cannot be blocked
    @Test(expected = Exception.class)
    public void player_blocks_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);
    }

}
