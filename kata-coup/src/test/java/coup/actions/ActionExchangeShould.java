package coup.actions;

import coup.ActionTests;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionExchangeShould extends ActionTests {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    @Before
    public void before() throws Exception {
        super.before();
        action = new Exchange();
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        // then
        Assert.assertEquals(46, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(2, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.player(1).cards().clear();// Needs to be here since the action will reshuffle the hand
        game.player(1).cards().add(0, new TheDuke());
        game.player(1).cards().add(0, new TheDuke());

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);

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

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.player(1).cards().clear(); // Needs to be here since the action will reshuffle the hand
        game.player(1).cards().add(0, new TheAmbassator());
        game.player(1).cards().add(0, new TheDuke());

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);

        // then
        Assert.assertEquals(46, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(2, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
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
