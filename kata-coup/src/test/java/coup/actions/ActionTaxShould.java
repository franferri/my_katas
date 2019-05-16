package coup.actions;

import coup.ActionTests;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionTaxShould extends ActionTests {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked

    @Before
    public void before() throws Exception {
        super.before();
        action = new Tax();
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when

        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        // then
        Assert.assertEquals(43, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(5, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheAmbassator());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

        // then
        Assert.assertEquals(46, game.treasury());

        Assert.assertEquals(1, game.player(1).cardsInGame());
        Assert.assertEquals(2, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheDuke());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

        // then
        Assert.assertEquals(43, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(5, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
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
