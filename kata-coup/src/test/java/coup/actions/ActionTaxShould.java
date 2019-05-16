package coup.actions;

import coup.TestingActions;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionTaxShould extends TestingActions {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked

    @BeforeEach
    public void before() throws Exception {
        super.before();
        action = new Tax();
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when

        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        // then
        Assertions.assertEquals(43, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(5, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheAmbassator());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(1, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheDuke());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

        // then
        Assertions.assertEquals(43, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(5, game.player(1).coins());

        Assertions.assertEquals(1, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action cannot be blocked
    @Test
    public void player_blocks_action() throws Exception {
        // when

        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        Assertions.assertThrows(Exception.class, () -> action.doBlockAction(game));
    }

}
