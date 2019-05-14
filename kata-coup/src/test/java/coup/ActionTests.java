package coup;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ActionTests {

    // TODO cuando un jugador tiene un challence y enseña la carta, tenemos q reshuflear y coger una nueva para ese player (player 1 si el challence es para la action, player 2 si el challence es para el blockeo de la acción)

    protected Game game;
    protected Action action;

    protected void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);
        game.startGame();

    }

    // Action costs money
    @Ignore
    @Test(expected = Exception.class)
    public void player_needs_money_to_do_the_action() throws Exception {
        assertTrue(false);
    }

    // Action
    @Ignore
    @Test
    public void player_does_action() throws Exception {
        assertTrue(false);
    }

    // Action cannot be challenged
    @Ignore
    @Test(expected = Exception.class)
    public void player_calls_the_bluff_over_action() throws Exception {
        assertTrue(false);
    }

    // Action can be challenged
    // Challenger (wins)
    @Ignore
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {
        assertTrue(false);
    }

    // Action can be challenged
    // Challenger (lose)
    @Ignore
    @Test
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {
        assertTrue(false);
    }

    // Action cannot be blocked
    @Ignore
    @Test(expected = Exception.class)
    public void player_blocks_action() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked
    @Ignore
    @Test
    public void player_does_action_and_gets_block() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger wins
    @Ignore
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger lose
    @Ignore
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        assertTrue(false);
    }

    // Action can be blocked
    // Block cannot be challenged
    @Ignore
    @Test(expected = Exception.class)
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block() throws Exception {
        assertTrue(false);
    }

}
