package coup;

import coup.actions.ForeignAid;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
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

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(4, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    @Test
    public void a_player_does_action_foreign_aid_but_other_player_blocks_successfully() {

        // Player 1 does action foreign aid
        // Player 2 blocks successfully
        // Player 1 don't call the bluff, accepts the block

        // given
        Action action = new ForeignAid();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

        // then
        Assert.assertEquals(46, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(2, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    @Test
    public void a_player_does_action_foreign_aid_but_other_player_blocks_but_player_1_calls_the_bluff_on_the_block_successfully() {

        // Player 1 does action foreign aid
        // Player 2 blocks (but don't have any TheDuke to block)
        // Player 1 calls the bluff and win

        // given

        Action action = new ForeignAid();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        // We make sure the player is bluffing
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheAmbassator());
        game.player(2).cards().add(1, new TheAmbassator());

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

        game.setPlayerCallingTheBluffAndOnWho(1, 2);
        game.doCallTheBluff(action);

        // then

        Assert.assertEquals(44, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(4, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    @Test
    public void a_player_does_action_foreign_aid_but_other_player_blocks_but_player_1_calls_the_bluff_on_the_block_and_looses() {

        // Player 1 does action foreign aid
        // Player 2 blocks (and has TheDuke to block successfully)
        // Player 1 calls the bluff and looses

        // given

        Action action = new ForeignAid();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        // We make sure the player is bluffing
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheDuke());
        game.player(2).cards().add(1, new TheDuke());

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

        game.setPlayerCallingTheBluffAndOnWho(1, 2);
        game.doCallTheBluff(action);


        // then

        Assert.assertEquals(46, game.treasury());

        Assert.assertEquals(1, game.player(1).cardsInGame());
        Assert.assertEquals(2, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }


}

