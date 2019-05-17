package coup.actions;

import coup.Action;
import coup.TestingActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionCoup7Should extends TestingActions {

    // Action: Pay 7 cons, choose the player to lose Influence
    // Action cannot be challenged

    // Block: Cannot be blocked

    @BeforeEach
    public void before() throws Exception {
        super.before();
        action = new Coup7(gameEngine);
    }

    // Action costs money
    @Test
    public void player_needs_money_to_do_the_action() {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForAssassination = gameEngine.player(2);

        assertThrowsWithMessage(() -> action.doAction(), "Player don't have enough coins");
    }

    // Action cant be done to himself (Engine integrity test)
@Test
    public void player_does_action_to_himself() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction, 5);
        gameEngine.targetPlayerForAssassination = gameEngine.player(1);

        assertThrowsWithMessage(() -> action.doAction(), "Action can't be done to himself");
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction, 5);
        gameEngine.targetPlayerForAssassination = gameEngine.player(2);

        action.doAction();

        // then
        Assertions.assertEquals(48, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(0, gameEngine.player(1).coins());

        Assertions.assertEquals(1, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Action cannot be challenged
    @Test
    public void player_calls_the_bluff_over_action() throws Exception {
        // given
        Action action = new Coup7(gameEngine);

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction, 5);
        gameEngine.targetPlayerForAssassination = gameEngine.player(2);

        action.doAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(2);

        assertThrowsWithMessage(() -> action.doCallTheBluffOnAction(), "This action can't be challenged");

    }

    // Action cannot be blocked
    @Test
    public void player_blocks_action() throws Exception {
        // given
        Action action = new Coup7(gameEngine);

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.playerDoingTheAction, 5);
        gameEngine.targetPlayerForAssassination = gameEngine.player(2);

        action.doAction();

        gameEngine.playerBlockingTheAction = gameEngine.player(2);

        Assertions.assertThrows(Exception.class, () -> action.doBlockAction());

    }

}
