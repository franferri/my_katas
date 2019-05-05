package coup;

import org.junit.Before;

public class PlayerPlaysForeignAidHandShould {

    Game game;

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }

}
