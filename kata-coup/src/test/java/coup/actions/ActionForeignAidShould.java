package coup.actions;

import coup.Action;
import coup.Game;
import coup.Player;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionForeignAidShould {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);
        game.startGame();

    }

    // Action: Take two coins from the treasury

    @Test
    public void player_1_does_action_foreign_aid_and_dont_get_blocked() throws Exception {

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

    // Block: Can be blocked by a player claiming the Duke

    @Test
    public void player_1_does_action_foreign_aid_but_player_2_blocks_successfully_because_he_has_the_duke_and_player_1_dont_call_the_bluff() throws Exception {

        // given
        Action action = new ForeignAid();

        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheDuke());
        game.player(2).cards().add(0, new TheAmbassator());

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
    public void player_1_does_action_foreign_aid_but_player_2_blocks_BUT_player_1_calls_the_bluff_on_the_block_AND_WINS_the_call() throws Exception {

        // given

        Action action = new ForeignAid();

        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheAmbassator());
        game.player(2).cards().add(1, new TheAmbassator());

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

        game.doPlayerCallingTheBluffOnTheBlockAction(1, 2, action);

        // then

        Assert.assertEquals(44, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(4, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    @Test
    public void player_1_does_action_foreign_aid_but_player_2_blocks_BUT_player_1_calls_the_bluff_on_the_block_AND_LOSES_the_call() throws Exception {

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

        game.doPlayerCallingTheBluffOnTheBlockAction(1, 2, action);

        // then

        Assert.assertEquals(46, game.treasury());

        Assert.assertEquals(1, game.player(1).cardsInGame());
        Assert.assertEquals(2, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    // Bluff: Cannot be challenged

    @Test(expected = Exception.class)
    public void player_1_does_action_foreign_aid_and_player_2_calls_the_bluff() throws Exception {

        // given
        Action action = new ForeignAid();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.doPlayerCallingTheBluffOnTheAction(2,1,action);

    }

}
