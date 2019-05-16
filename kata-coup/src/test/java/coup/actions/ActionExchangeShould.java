package coup.actions;

import coup.TestingActions;
import coup.cards.TheAmbassator;
import coup.cards.TheDuke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionExchangeShould extends TestingActions {

    // Action: Take 2 cards, return 2 cards to the Court Deck
    // Action can be challenged

    // Block: Cannot be blocked
    // -

    @BeforeEach
    public void before() throws Exception {
        super.before();
        action = new Exchange();
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.player(1).cards().clear();// Needs to be here since the action will reshuffle the hand
        game.player(1).cards().add(0, new TheDuke());
        game.player(1).cards().add(0, new TheDuke());

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnAction(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(1, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (lose)
    @Test
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {

        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.player(1).cards().clear(); // Needs to be here since the action will reshuffle the hand
        game.player(1).cards().add(0, new TheAmbassator());
        game.player(1).cards().add(0, new TheDuke());

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnAction(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(1, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action cannot be blocked
    @Test
    public void player_blocks_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);

        Assertions.assertThrows(Exception.class, () -> action.doBlockAction(game));
    }

}
