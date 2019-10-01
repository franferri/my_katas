package coup.actions;

import coup.TestingActions;
import coup.cards.TheAmbassador;
import coup.cards.TheDuke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionTaxShould extends TestingActions {

    // Action: Take 3 coins from the treasury
    // Action can be challenged

    // Block: Cannot be blocked

    @BeforeEach
    public void before() {
        super.before();
        action = new Tax(gameEngine);
    }

    // Action
    @Test
    void player_does_action() {
        // when

        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        // then
        Assertions.assertEquals(43, gameEngine.treasury().coins());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(5, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // Player cant challenge himself (Engine integrity test)
    @Test
    void player_does_action_and_challenge_himself() {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(1));

        assertThrowsWithMessage(() -> action.doCallTheBluffOnAction(), "Action bluff can't be called over himself");
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() {
        // given
        gameEngine.player(1).influenceDeck().cards().clear();
        gameEngine.player(1).influenceDeck().receiveScrambled(new TheAmbassador());
        gameEngine.player(1).influenceDeck().receiveScrambled(new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(2));
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury().coins());

        Assertions.assertEquals(1, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    void player_does_action_and_other_calls_the_bluff_and_lose_the_call() {
        // given
        gameEngine.player(1).influenceDeck().cards().clear();
        gameEngine.player(1).influenceDeck().receiveScrambled(new TheDuke());
        gameEngine.player(1).influenceDeck().receiveScrambled(new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(2));
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(43, gameEngine.treasury().coins());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(5, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(1, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // Action cannot be blocked
    @Test
    void player_blocks_action() {
        // when

        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        Assertions.assertThrows(Exception.class, () -> action.doBlockAction());
    }

}
