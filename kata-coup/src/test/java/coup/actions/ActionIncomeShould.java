package coup.actions;

import coup.Action;
import coup.Game;
import coup.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionIncomeShould {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);
        game.startGame();

    }

    // Action: Take 1 coin from the treasury

    @Test
    public void a_player_does_action_income() {

        // given
        Action action = new Income();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        // then
        Assert.assertEquals(45, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(3, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());

    }

    // Block: Cannot be blocked

    @Test(expected = Exception.class)
    public void a_player_tries_to_block_action_income() throws Exception {

        // given
        Action action = new Income();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);

    }

    // Bluff: Cannot be challenged

    @Test(expected = Exception.class)
    public void a_player_calls_the_bluff_over_action_income() throws Exception {

        // given
        Action action = new Income();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);

    }

}
