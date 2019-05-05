package coup;

import coup.actions.ForeignAid;
import coup.actions.Income;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PlayerPlaysForeignAidHandShould {

    Game game;

    @Ignore
    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

    // Foreign Aid hand

    @Test
    public void a_player_does_action_foreign_aid() {

        // Player 1 does action foreign aid
        // Player 2 don't block

        // given
        Action action = new ForeignAid();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        // then
        Assert.assertEquals(44, game.treasury());

        Assert.assertEquals(2, game.player(1).cards().size());
        Assert.assertEquals(4, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cards().size());
        Assert.assertEquals(2, game.player(2).coins());

    }

    @Test
    public void a_player_does_action_foreign_aid_but_other_player_blocks_successfully() {

        // Player 1 does action foreign aid
        // Player 2 blocks successfully

        // given
        Action action = new ForeignAid();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);
        game.targetPlayerBlocksAction();

        // then
        Assert.assertEquals(44, game.treasury());

        Assert.assertEquals(2, game.player(1).cards().size());
        Assert.assertEquals(4, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cards().size());
        Assert.assertEquals(2, game.player(2).coins());

    }

    @Ignore
    @Test
    public void a_player_does_action_foreign_aid_but_other_player_blocks_successfully_but_player_1_calls_the_bluff() {

        // Player 1 does action foreign aid
        // Player 2 blocks
        // Player 1 calls the bluff


    }

}