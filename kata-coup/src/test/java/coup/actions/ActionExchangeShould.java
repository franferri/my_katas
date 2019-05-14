package coup.actions;

import coup.ActionTests;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
        assertTrue(false);
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {
        assertTrue(false);
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {
        assertTrue(false);
    }

    // Action cannot be blocked
    @Test(expected = Exception.class)
    public void player_blocks_action() throws Exception {
        assertTrue(false);
    }

}
