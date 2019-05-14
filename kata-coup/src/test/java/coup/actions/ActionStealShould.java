package coup.actions;

import coup.ActionTests;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ActionStealShould extends ActionTests {

    // Action: Take 2 coins from another player
    // Action can be challenged

    // Block: Can be blocked by Captain
    // Block by Captain can be challenged

    // Block: Can be blocked by Ambassador
    // Block by Ambassador can be challenged

    @Before
    public void before() throws Exception {
        super.before();
        action = new Steal();
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

    // Action can be blocked (by Captain)
    @Test
    public void player_does_action_and_gets_block_by_captain() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked (by Captain)
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_by_captain_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked (by Captain)
    // Block can be challenged
    // Challenger lose
    @Test
    public void player_does_action_and_gets_block_by_captain_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked (by Ambassador)
    @Test
    public void player_does_action_and_gets_block_by_ambassador() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked (by Ambassador)
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_by_ambassador_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked (by Ambassador)
    // Block can be challenged
    // Challenger lose
    @Test
    public void player_does_action_and_gets_block_by_ambassador_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        assertTrue(false);
    }


}
