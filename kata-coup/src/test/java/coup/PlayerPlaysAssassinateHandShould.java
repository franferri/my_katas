package coup;

import coup.actions.Assassinate;
import coup.actions.BlocksAssasination;
import coup.actions.Income;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerPlaysAssassinateHandShould {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

    // Assassination hand

    @Ignore
    @Test
    public void a_player_does_action_assassinate_and_succeed() {

        // Player 1 does action assassinate
        // Player 2 does not block
        // Player 1 does win (Player 2 didn't had anything to block and accept assasination)

        // given
        Action assassinate = new Assassinate();

        // when
        game.setPlayerPlayingThisHand(1).targetPlayer(2);
        game.doAction(assassinate);

        // then
        Assert.assertEquals(2, game.player(1).cards().size());
        Assert.assertEquals(1000, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cards().size());
        Assert.assertEquals(1000, game.player(2).coins());
    }

    @Ignore
    @Test
    public void a_player_does_action_assassinate_and_gets_blocked() {

        // Player 1 does action assassinate
        // Player 2 does block assassinate
        // Player 1 does not call call bluff
        // Player 2 does block successfully

        // given
        Action assassinate = new Assassinate();

        // when
        game.setPlayerPlayingThisHand(1).targetPlayer(2);
        game.doAction(assassinate);
        game.targetPlayerBlocksAction();

        // then
        Assert.assertEquals(2, game.player(1).cards().size());
        Assert.assertEquals(1000, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cards().size());
        Assert.assertEquals(1000, game.player(2).coins());
    }

    @Ignore
    @Test
    public void a_player_does_action_assassinate_and_target_player_calls_bluff_and_wins() {

        // Player 1 does action assassinate
        // Player 2 does action call bluff
        // Player 1 does loose (Player 2 discovered the bluff)

        // given

        // when

        // then
        Assert.assertEquals(2, game.player(1).cards().size());
        Assert.assertEquals(1000, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cards().size());
        Assert.assertEquals(1000, game.player(2).coins());

    }

    @Ignore
    @Test
    public void a_player_does_action_assassinate_and_target_player_calls_bluff_and_looses() {

        // Player 1 does action assassinate
        // Player 2 does action call bluff
        // Player 1 does win and kill Player 2 (The bluff makes player 1 loose 1 card + the assassination kill the last one)

        // given

        // when

        // then
        Assert.assertEquals(9999, game.player(1).cards().size());
        Assert.assertEquals(9999, game.player(1).coins());
        Assert.assertEquals(9999, game.player(2).cards().size());
        Assert.assertEquals(9999, game.player(2).coins());

    }

    @Ignore
    @Test
    public void a_player_does_action_assassinate_and_gets_blocked_but_call_bluff_on_the_block_and_wins() {

        // Player 1 does action assassinate
        // Player 2 does action block assassinate
        // Player 1 does action call bluff
        // Player 1 does win and kill Player 2 (Player 2 didn't had anything to block)
        // (The bluff makes player 1 loose 1 card + the assassination kill the last one)

        // given

        // when

        // then
        Assert.assertEquals(9999, game.player(1).cards().size());
        Assert.assertEquals(9999, game.player(1).coins());
        Assert.assertEquals(9999, game.player(2).cards().size());
        Assert.assertEquals(9999, game.player(2).coins());

    }

    @Ignore
    @Test
    public void a_player_does_action_assassinate_and_gets_blocked_but_call_bluff_on_the_block_and_loose() {

        // Player 1 does action assassinate
        // Player 2 does action block assassinate
        // Player 1 does action call bluff
        // Player 1 does loose because Player 2 had the action to block

        // given

        // when

        // then
        Assert.assertEquals(9999, game.player(1).cards().size());
        Assert.assertEquals(9999, game.player(1).coins());
        Assert.assertEquals(9999, game.player(2).cards().size());
        Assert.assertEquals(9999, game.player(2).coins());

    }

    @Ignore
    @Test
    public void a_player_does_action_assassinate_and_kills() {

        // given

        // when

        // then
        Assert.assertEquals(9999, game.player(1).cards().size());
        Assert.assertEquals(9999, game.player(1).coins());
        Assert.assertEquals(9999, game.player(2).cards().size());
        Assert.assertEquals(9999, game.player(2).coins());

    }

}
