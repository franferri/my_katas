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
        action = new ForeignAid(gameEngine);
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        // then
        Assertions.assertEquals(44, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(4, gameEngine.player(1).coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Action cannot be challenged
    @Test
    public void player_calls_the_bluff_over_action() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(2);

        Assertions.assertThrows(Exception.class, () -> action.doCallTheBluffOnAction());
    }

    // Action can be blocked
    @Test
    public void player_does_action_and_gets_block() throws Exception {
        // given
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheDuke());
        gameEngine.player(2).cards().add(0, new TheAmbassator());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerBlockingTheAction = gameEngine.player(2);
        action.doBlockAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(1).coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        // given
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheAmbassator());
        gameEngine.player(2).cards().add(1, new TheAmbassator());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerBlockingTheAction = gameEngine.player(2);
        action.doBlockAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(1);
        action.doCallTheBluffOnBlockAction();

        // then
        Assertions.assertEquals(44, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(4, gameEngine.player(1).coins());

        Assertions.assertEquals(1, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger lose
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        // We make sure the player is bluffing
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheDuke());
        gameEngine.player(2).cards().add(1, new TheDuke());

        gameEngine.playerBlockingTheAction = gameEngine.player(2);
        action.doBlockAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(1);
        action.doCallTheBluffOnBlockAction();

        // then

        Assertions.assertEquals(46, gameEngine.treasury());

        Assertions.assertEquals(1, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(1).coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

}
