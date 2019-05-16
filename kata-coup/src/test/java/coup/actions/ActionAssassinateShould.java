package coup.actions;

import coup.ActionTests;
import coup.cards.TheAmbassator;
import coup.cards.TheAssassin;
import coup.cards.TheContessa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionAssassinateShould extends ActionTests {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by Contessa
    // Block can be challenged

    @Before
    public void before() throws Exception {
        super.before();
        action = new Assassinate();
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
        game.player(1).gainCoin();

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);

        action.doAction(game);

        // then
        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
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
        game.player(1).gainCoin();

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

        // then
        Assert.assertEquals(49, game.treasury());

        Assert.assertEquals(1, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheAssassin());
        game.player(1).cards().add(0, new TheAmbassator());
        game.player(1).gainCoin();

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

        // then
        Assert.assertEquals(49, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(0, game.player(2).cardsInGame());
        Assert.assertTrue(game.player(2).isDead());
    }

    // Action can be blocked
    @Test
    public void player_does_action_and_gets_block() throws Exception {
        // given
        game.player(1).gainCoin();

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);

        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        // then
        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        // given
        game.player(1).gainCoin();

        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheAmbassator());
        game.player(2).cards().add(1, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);

        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockActionInternal(game);

        // then
        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(0, game.player(2).cardsInGame());
        Assert.assertTrue(game.player(2).isDead());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger lose
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        // given
        game.player(1).gainCoin();

        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheContessa());
        game.player(2).cards().add(1, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);

        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockActionInternal(game);

        // then
        Assert.assertEquals(1, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

}
