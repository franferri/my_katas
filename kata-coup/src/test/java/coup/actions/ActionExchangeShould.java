package coup.actions;

import coup.Card;
import coup.Player;
import coup.TestingActions;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ActionExchangeShould extends TestingActions {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    @BeforeEach
    public void before() throws Exception {
        super.before();
        action = new Exchange(gameEngine);
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury());
        Assertions.assertEquals(11, gameEngine.deck().cards().size());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(1).coins());

        Assertions.assertEquals(2, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Player cant challenge himself (Engine integrity test)
    @Test
    public void player_does_action_and_challenge_himself() throws Exception {

        // given
        List<Card> cards = Arrays.asList(new TheDuke(), new TheDuke());

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.player(1).cards().clear();// Needs to be here since the action will reshuffle the hand

        when(player1.cards()).thenReturn(cards);

        gameEngine.playerCallingTheBluff = gameEngine.player(1);

        assertThrowsWithMessage(() -> action.doCallTheBluffOnAction(), "Action bluff can't be called over himself");
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {

        gameEngine.player(1).cards().clear();// Needs to be here since the action will reshuffle the hand
        gameEngine.player(1).cards().add(0, new TheDuke());
        gameEngine.player(1).cards().add(0, new TheDuke());

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
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {

        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.player(1).cards().clear(); // Needs to be here since the action will reshuffle the hand
        gameEngine.player(1).cards().add(0, new TheAmbassator());
        gameEngine.player(1).cards().add(0, new TheDuke());

        gameEngine.playerCallingTheBluff = gameEngine.player(2);
        action.doCallTheBluffOnAction();

        // then
        Assertions.assertEquals(46, gameEngine.treasury());

        Assertions.assertEquals(2, gameEngine.player(1).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(1).coins());

        Assertions.assertEquals(1, gameEngine.player(2).cardsInGame());
        Assertions.assertEquals(2, gameEngine.player(2).coins());
    }

    // Action cannot be blocked
    @Test
    public void player_blocks_action() throws Exception {
        // when
        gameEngine.playerDoingTheAction = gameEngine.player(1);
        action.doAction();

        gameEngine.playerBlockingTheAction = gameEngine.player(2);

        Assertions.assertThrows(Exception.class, () -> action.doBlockAction());
    }

}
