package coup;

import coup.actions.Assassinate;
import coup.actions.BlocksAssasination;
import coup.actions.Income;
import org.junit.Before;
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

}
