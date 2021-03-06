package coup.actions;

import coup.TestingActions;
import coup.cards.TheAmbassador;
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
    public void before()  {
        super.before();
        action = new ForeignAid(gameEngine);
    }

    // Action
    @Test
    void player_does_action()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        // then
        Assertions.assertEquals(44, gameEngine.treasury().coins());

        Assertions.assertEquals(2, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(4, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).influenceDeck().cards().size());
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

    // Player cant block himself (Engine integrity test)
@Test
void player_does_action_and_blocks_himself()  {
        // given
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheDuke());
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(1));

        assertThrowsWithMessage(() -> action.doBlockAction(), "Player cant block himself");
    }

    // Action can be blocked
    @Test
    void player_does_action_and_gets_block()  {
        // given
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheDuke());
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        action.doBlockAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury().coins());

        Assertions.assertEquals(2, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // BlockAction bluff can't be called over the player doing the BlockAction (Engine integrity test)
    @Test
    void player_does_action_and_gets_block_then_the_player_blocking_challenge_himself()  {
        // given
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
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
    void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call()  {
        // given
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheAmbassador());

        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        action.doBlockAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(1));
        action.doCallTheBluffOnBlockAction();

        // then
        Assertions.assertEquals(44, gameEngine.treasury().coins());

        Assertions.assertEquals(2, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(4, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(1, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

    // Action can be blocked
    // Block can be challenged
    // Challenger lose
    @Test
    void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call()  {
        // when
        gameEngine.setPlayerDoingTheAction(gameEngine.player(1));
        action.doAction();

        // We make sure the player is bluffing
        gameEngine.player(2).influenceDeck().cards().clear();
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheDuke());
        gameEngine.player(2).influenceDeck().receiveScrambled( new TheDuke());

        gameEngine.setPlayerBlockingTheAction(gameEngine.player(2));
        action.doBlockAction();

        gameEngine.setPlayerCallingTheBluff(gameEngine.player(1));
        action.doCallTheBluffOnBlockAction();

        // then

        Assertions.assertEquals(46, gameEngine.treasury().coins());

        Assertions.assertEquals(1, gameEngine.player(1).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(1).wallet().coins());

        Assertions.assertEquals(2, gameEngine.player(2).influenceDeck().cards().size());
        Assertions.assertEquals(2, gameEngine.player(2).wallet().coins());
    }

}
