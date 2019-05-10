package coup.actions;

import coup.Game;
import coup.Player;
import org.junit.Before;
import org.junit.Ignore;

public class ActionExchangeShould {

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

}
