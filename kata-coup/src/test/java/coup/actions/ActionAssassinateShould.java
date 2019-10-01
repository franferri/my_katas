package coup.actions;

import coup.TestingActions;
import coup.cards.TheAmbassador;
import coup.cards.TheAssassin;
import coup.cards.TheContessa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionAssassinateShould extends TestingActions {

    // Action: Pay 3 coins, choose the player to lose influence
    // Action can be challenged

    // Block: Can be blocked by a player claiming Contessa
    // Block can be challenged

    @BeforeEach
    protected void before() {
        super.before();
        action = new Assassinate(gameEngine);
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
    void player_does_action_to_himself() {
        // given
        gameEngine.player(1).wallet().receive(1);

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(1));

        assertThrowsWithMessage(() -> action.doAction(), "Action can't be done to himself");
    }

    // Action
    @Test
    void player_does_action() {
        // given
        gameEngine.player(1).wallet().receive(1);

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));

        action.doAction();

        // then
        Assertions.assertEquals(2, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(0, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(1, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // Player cant challenge himself (Engine integrity test)
    @Test
    void player_does_action_and_challenge_himself() {
        // given
        gameEngine.player(1).influenceDeck().cards().clear();
        gameEngine.player(1).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(1).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(1).wallet().receive(1);

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));
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
        gameEngine.player(1).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(1).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(1).wallet().receive(1);

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));
        action.doAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(2));
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(49, gameEngine.treasury().coins());

        Assertions.assertEquals(1, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(0, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    void player_does_action_and_other_calls_the_bluff_and_lose_the_call() {
        // given
        gameEngine.player(1).influenceDeck().cards().clear();
        gameEngine.player(1).influenceDeck().receiveScrambled( new TheAssassin());
        gameEngine.player(1).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(1).wallet().receive(1);

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));
        action.doAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(2));
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(49, gameEngine.treasury().coins());

        Assertions.assertEquals(2, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(0, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(0, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertTrue(gameEngine.player(2).isDead());
    }

    // Player cant block himself (Engine integrity test)
    @Test
    void player_does_action_and_blocks_himself() {
        // given
        gameEngine.player(1).wallet().receive(1);

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(1));

        assertThrowsWithMessage(() -> action.doBlockAction(), "Player cant block himself");
    }

    // Action can be blocked
    @Test
    void player_does_action_and_gets_block() {
        // given
        gameEngine.player(1).wallet().receive(1);

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        action.doBlockAction();

        // then
        Assertions.assertEquals(2, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(0, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // BlockAction bluff can't be called over the player doing the BlockAction (Engine integrity test)
    @Test
    void player_does_action_and_gets_block_then_the_player_blocking_challenge_himself() {
        // given
        gameEngine.player(1).wallet().receive(1);

        // given
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));

        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        action.doBlockAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(2));

        assertThrowsWithMessage(() -> action.doCallTheBluffOnBlockAction(), "BlockAction bluff can't be called over the player doing the BlockAction");
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger wins
    @Test
    void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() {
        // given
        gameEngine.player(1).wallet().receive(1);

        // given
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));

        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        action.doBlockAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(1));
        action.doCallTheBluffOnBlockAction();

        // then
        Assertions.assertEquals(2, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(0, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(0, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertTrue(gameEngine.player(2).isDead());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger lose
    @Test
    void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() {
        // given
        gameEngine.player(1).wallet().receive(1);

        // given
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled(new TheContessa());
        gameEngine.player(2).influenceDeck().receiveScrambled(new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        gameEngine.setTargetPlayer(gameEngine.player(2));

        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        action.doBlockAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(1));
        action.doCallTheBluffOnBlockAction();

        // then
        Assertions.assertEquals(1, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(0, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());

    }

}
