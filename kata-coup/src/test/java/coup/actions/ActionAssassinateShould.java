package coup.actions;

import coup.Action;
import coup.Game;
import coup.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ActionAssassinateShould {

    Game game;

    @Ignore
    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);
        game.startGame();

    }

    // Action: Pay 3 coins, choose the player to lose influence

    @Test
    public void player1_does_action_assassinate_and_succeed() throws Exception {

        // given
        Action action = new Assassinate();
        game.player(1).addCoin();

        // when
        game.setPlayerPlayingThisHand(1);
        game.setTargetPlayerForAssasination(2);

        game.doAction(action);

        // then
        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Block: Can be blocked by Contessa
    @Test
    public void player_1_does_action_assassinate_and_gets_blocked_by_player_2_conptessa() throws Exception {

        // given
        Action action = new Assassinate();
        game.player(1).addCoin();

        // when
        game.setPlayerPlayingThisHand(1);
        game.setTargetPlayerForAssasination(2);

        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

        // then
        Assert.assertEquals(2, game.player(1).cards().size());
        Assert.assertEquals(3, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cards().size());
        Assert.assertEquals(2, game.player(2).coins());
    }


    // Bluff: Can be challenged
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
