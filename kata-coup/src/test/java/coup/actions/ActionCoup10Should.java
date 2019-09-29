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
    public void before()  {
        super.before();
        action = new Coup10(gameEngine);
    }

    // Action costs money
    @Test
    void player_needs_money_to_do_the_action() {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));

        assertThrowsWithMessage(() -> action.doAction(), "Player don't have enough coins");
    }

    // Action cant be done to himself (Engine integrity test)
    @Test
    void player_does_action_to_himself()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.getPlayerDoingTheAction(), 8);

        gameEngine.setTargetPlayer(gameEngine.player(1));

        assertThrowsWithMessage(() -> action.doAction(), "Action can't be done to himself");
    }

    // Action
    @Test
    void player_does_action()  {

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.getPlayerDoingTheAction(), 8);

        gameEngine.setTargetPlayer(gameEngine.player(2));

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
    void player_calls_the_bluff_over_action()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.getPlayerDoingTheAction(), 8);
        gameEngine.setTargetPlayer(gameEngine.player(2));
        action.doAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(2));
        assertThrowsWithMessage(() -> action.doCallTheBluffOnAction(), "This action can't be challenged");
    }

    // Action cannot be blocked
    @Test
    void player_blocks_action()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.getPlayerDoingTheAction(), 8);
        gameEngine.setTargetPlayer(gameEngine.player(2));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));

        Assertions.assertThrows(Exception.class, () -> action.doBlockAction());
    }

    // Action forced by the engine (Engine integrity test)
    @Test
    void player_must_do_the_action_but_tries_other_action()  {

        // given
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.playerTakeCoinsFromTreasury(gameEngine.getPlayerDoingTheAction(), 8);

        gameEngine.setTargetPlayer(gameEngine.player(2));

        // when
        // then

        action = new Income(gameEngine);
        assertThrowsWithMessage(() -> action.doAction(), "Player must coup because has 10 or more coins");
        action = new ForeignAid(gameEngine);
        assertThrowsWithMessage(() -> action.doAction(), "Player must coup because has 10 or more coins");
        action = new Coup7(gameEngine);
        assertThrowsWithMessage(() -> action.doAction(), "Player must coup because has 10 or more coins");
        action = new Tax(gameEngine);
        assertThrowsWithMessage(() -> action.doAction(), "Player must coup because has 10 or more coins");
        action = new Assassinate(gameEngine);
        assertThrowsWithMessage(() -> action.doAction(), "Player must coup because has 10 or more coins");
        action = new Exchange(gameEngine);
        assertThrowsWithMessage(() -> action.doAction(), "Player must coup because has 10 or more coins");
        action = new Steal(gameEngine);
        assertThrowsWithMessage(() -> action.doAction(), "Player must coup because has 10 or more coins");

    }

}
