package coup.actions;

import coup.TestingActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionIncomeShould extends TestingActions {

    // Action: Take 1 coin from the treasury
    // Action cannot be challenged

    // Block: Cannot be blocked

    @BeforeEach
    public void before()  {
        super.before();
        action = new Income(gameEngine);
    }

    // Action
    @Test
    void player_does_action()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        // then
        Assertions.assertEquals(45, gameEngine.treasury().coins());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(3, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // Action cannot be challenged
    @Test
    void player_calls_the_bluff_over_action()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(2));
        assertThrowsWithMessage(() -> action.doCallTheBluffOnAction(), "This action can't be challenged");

    }

    // Action cannot be blocked
    @Test
    void player_blocks_action()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));

        Assertions.assertThrows(Exception.class, () -> action.doBlockAction());
    }

}
