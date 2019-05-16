package coup.actions;

import coup.TestingActions;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionForeignAidShould extends TestingActions {

    // Action: Take two coins from the treasury
    // Action cannot be challenged

    // Block: Can be blocked by a player claiming the Duke
    // Block can be challenged

    @BeforeEach
    public void before() throws Exception {
        super.before();
        action = new ForeignAid();
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        // then
        Assertions.assertEquals(44, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(4, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action cannot be challenged
    @Test
    public void player_calls_the_bluff_over_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);

        Assertions.assertThrows(Exception.class, () -> action.doCallTheBluffOnActionInternal(game));
    }

    // Action can be blocked
    @Test
    public void player_does_action_and_gets_block() throws Exception {
        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheDuke());
        game.player(2).cards().add(0, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheAmbassator());
        game.player(2).cards().add(1, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockActionInternal(game);

        // then
        Assertions.assertEquals(44, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(4, game.player(1).coins());

        Assertions.assertEquals(1, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger lose
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        // We make sure the player is bluffing
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheDuke());
        game.player(2).cards().add(1, new TheDuke());

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockActionInternal(game);

        // then

        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(1, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

}
