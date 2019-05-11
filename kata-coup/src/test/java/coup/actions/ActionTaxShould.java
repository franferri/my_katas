package coup.actions;

import coup.Action;
import coup.Game;
import coup.Player;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionTaxShould {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);
        game.startGame();

    }

    // Action: Take 3 coins from the treasury

    @Test
    public void player_1_does_action_tax_and_dont_get_blocked() throws Exception {

        // given
        Action action = new Tax();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        // then
        Assert.assertEquals(43, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(5, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    // Block: Cannot be blocked

    @Test(expected = Exception.class)
    public void player_1_does_action_tax_and_get_blocked() throws Exception {

        // given
        Action action = new Tax();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

    }

    // Bluff: Can be challenged

    @Test
    public void player_1_does_action_tax_and_player_2_calls_the_bluff_AND_WINS_the_call() throws Exception {

        // given
        Action action = new Tax();

        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheAmbassator());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);

        // then
        Assert.assertEquals(46, game.treasury());

        Assert.assertEquals(1, game.player(1).cardsInGame());
        Assert.assertEquals(2, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    @Test
    public void player_1_does_action_tax_and_player_2_calls_the_bluff_AND_LOSE_the_call() throws Exception {

        // given
        Action action = new Tax();

        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheDuke());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);

        // then
        Assert.assertEquals(43, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(5, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

}
