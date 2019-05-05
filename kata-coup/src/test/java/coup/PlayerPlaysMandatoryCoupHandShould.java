package coup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PlayerPlaysMandatoryCoupHandShould {

    Game game;

    @Ignore
    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);

    }


    @Ignore
    @Test
    public void a_player_has_to_coup_another_player_when_reaches_10_coins() {
        // TODO
    }

}
