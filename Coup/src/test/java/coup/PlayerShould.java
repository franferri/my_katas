package coup;

import coup.cards.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerShould {

    @Before
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        Game game = new Game(player1, player2);

    }

    @Test
    public void a_player_does_action_income() {
    }

    @Test
    public void a_player_does_action_foreign_aid() {
    }

    @Test
    public void a_player_does_action_coup() {
    }

    @Test
    public void a_player_does_action_tax() {
    }

    @Test
    public void a_player_does_action_assassinate() {
    }

    @Test
    public void a_player_does_action_exchange() {
    }

    @Test
    public void a_player_does_action_steal() {
    }

    @Test
    public void a_player_does_action_block_foreign_aid() {
    }

    @Test
    public void a_player_does_action_block_stealing() {
    }

    @Test
    public void a_player_does_action_block_assassination() {
    }

}
