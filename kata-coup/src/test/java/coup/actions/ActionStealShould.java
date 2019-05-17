package coup.actions;

import coup.TestingActions;
import coup.cards.TheAmbassator;
import coup.cards.TheCaptain;
import coup.cards.TheDuke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionStealShould extends TestingActions {

    // Action: Take 2 coins from another player
    // Action can be challenged

    // Block: Can be blocked by Captain
    // Block by Captain can be challenged

    // Block: Can be blocked by Ambassador
    // Block by Ambassador can be challenged

    @BeforeEach
    public void before() throws Exception {
        super.before();
        action = new Steal(gameEngine);
    }


    // Action steal more than other player has
    @Test
    public void player_does_action_to_a_poor_player() {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
        gameEngine.player(2).looseCoin();

        Assertions.assertThrows(Exception.class, () -> action.doAction());
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
        action.doAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(4, gameEngine.player(1).coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(0, gameEngine.player(2).coins());
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {
        // given
        gameEngine.player(1).cards().clear();
        gameEngine.player(1).cards().add(0, new TheAmbassator());
        gameEngine.player(1).cards().add(0, new TheAmbassator());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
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
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {
        // given
        gameEngine.player(1).cards().clear();
        gameEngine.player(1).cards().add(0, new TheCaptain());
        gameEngine.player(1).cards().add(0, new TheAmbassator());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
        action.doAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(2);
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(4, gameEngine.player(1).coins());

        Assertions.assertEquals(1, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(0, gameEngine.player(2).coins());
    }

    // Action can be blocked (by Captain)
    @Test
    public void player_does_action_and_gets_block_by_captain() throws Exception {
        // given
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheCaptain());
        gameEngine.player(2).cards().add(1, new TheDuke());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
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

    // Action can be blocked (by Captain)
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_by_captain_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        // given
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheDuke());
        gameEngine.player(2).cards().add(1, new TheDuke());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
        action.doAction();

        gameEngine.playerBlockingTheAction = gameEngine.player(2);
        action.doBlockAction();

        gameEngine.playerCallingTheBluff = gameEngine.player(1);
        action.doCallTheBluffOnBlockAction();


        // then
        Assertions.assertEquals(46, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(4, gameEngine.player(1).coins());

        Assertions.assertEquals(1, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(0, gameEngine.player(2).coins());
    }

    // Action can be blocked (by Captain)
    // Block can be challenged
    // Challenger lose
    @Test
    public void player_does_action_and_gets_block_by_captain_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        // given
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheCaptain());
        gameEngine.player(2).cards().add(1, new TheDuke());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
        action.doAction();

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

    // Action can be blocked (by Ambassador)
    @Test
    public void player_does_action_and_gets_block_by_ambassador() throws Exception {
        // given
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheAmbassator());
        gameEngine.player(2).cards().add(1, new TheDuke());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
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

    // Action can be blocked (by Ambassador)
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_by_ambassador_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        // given
        gameEngine.player(2).cards().clear();
        gameEngine.player(2).cards().add(0, new TheAmbassator());
        gameEngine.player(2).cards().add(1, new TheDuke());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        gameEngine.targetPlayerForStealing = gameEngine.player(2);
        action.doAction();

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
