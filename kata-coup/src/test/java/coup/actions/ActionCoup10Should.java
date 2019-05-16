package coup.actions;

import coup.TestingActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionCoup10Should extends TestingActions {

    // Action: If 10 or more coins, the player must coup
    // Action cannot be challenged

    // Block: Cannot be blocked

    @BeforeEach
    public void before() throws Exception {
        super.before();
        action = new Coup10();
    }

    // Action costs money
    @Test
    public void player_needs_money_to_do_the_action() {
        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForAssassination = game.player(2);

        Assertions.assertThrows(Exception.class, () -> action.doAction(game));
    }

    // Action
    @Test
    public void player_does_action() throws Exception {

        // when
        game.playerDoingTheAction = game.player(1);
        game.playerTakeCoinsFromTreasury(game.playerDoingTheAction, 8);

        game.targetPlayerForAssassination = game.player(2);

        action.doAction(game);

        // then
        Assertions.assertEquals(48, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(0, game.player(1).coins());

        Assertions.assertEquals(1, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action cannot be challenged
    @Test
    public void player_calls_the_bluff_over_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        game.playerTakeCoinsFromTreasury(game.playerDoingTheAction, 8);
        game.targetPlayerForAssassination = game.player(2);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        Assertions.assertThrows(Exception.class, () -> action.doCallTheBluffOnAction(game));
    }

    // Action cannot be blocked
    @Test
    public void player_blocks_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        game.playerTakeCoinsFromTreasury(game.playerDoingTheAction, 8);
        game.targetPlayerForAssassination = game.player(2);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);

        Assertions.assertThrows(Exception.class, () -> action.doBlockAction(game));
    }

}
