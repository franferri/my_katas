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
        action = new Tax(gameEngine);
    }

    // Action
    @Test
    void player_does_action() throws Exception {
        // when

        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        // then
        Assertions.assertEquals(43, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(5, gameEngine.player(1).coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Player cant challenge himself (Engine integrity test)
    @Test
    void player_does_action_and_challenge_himself() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(1);

        assertThrowsWithMessage(() -> action.doCallTheBluffOnAction(), "Action bluff can't be called over himself");
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {
        // given
        gameEngine.player(1).cards().clear();
        gameEngine.player(1).cards().add(0, new TheAmbassator());
        gameEngine.player(1).cards().add(0, new TheAmbassator());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(2);
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury());

        Assertions.assertEquals(1, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(1).coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {
        // given
        gameEngine.player(1).cards().clear();
        gameEngine.player(1).cards().add(0, new TheDuke());
        gameEngine.player(1).cards().add(0, new TheAmbassator());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(2);
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(43, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(5, gameEngine.player(1).coins());

        Assertions.assertEquals(1, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Action cannot be blocked
    @Test
    void player_blocks_action() throws Exception {
        // when

        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerBlockingTheAction = gameEngine.player(2);
        Assertions.assertThrows(Exception.class, () -> action.doBlockAction());
    }

}