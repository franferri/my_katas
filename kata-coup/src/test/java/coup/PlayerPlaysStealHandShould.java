package coup;

import org.junit.Before;
import org.junit.Ignore;

public class PlayerPlaysStealHandShould {

    Game game;

    @Ignore
    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

}
