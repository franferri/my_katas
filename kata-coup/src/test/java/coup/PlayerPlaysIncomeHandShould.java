package coup;

import coup.actions.Assassinate;
import coup.actions.BlocksAssasination;
import coup.actions.Income;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PlayerPlaysIncomeHandShould {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

    // Income hand

    @Test
    public void a_player_does_action_income() {

        // Player 1 does action income
        // Player 2 can't block

        // given
        Action action = new Income();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        // then
        Assert.assertEquals(45, game.treasury());

        Assert.assertEquals(2, game.player(1).cards().size());
        Assert.assertEquals(3, game.player(1).coins());

        Assert.assertEquals(2, game.player(2).cards().size());
        Assert.assertEquals(2, game.player(2).coins());

    }


}
