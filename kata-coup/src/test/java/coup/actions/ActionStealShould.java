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
        action = new Steal();
    }


    // Action steal more than other player has
    @Test
    public void player_does_action_to_a_poor_player() {
        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        game.player(2).looseCoin();

        Assertions.assertThrows(Exception.class, () -> action.doAction(game));
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(4, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(0, game.player(2).coins());
    }

    // Action can be challenged
    // Challenger (wins)
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheAmbassator());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

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
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(0, new TheCaptain());
        game.player(1).cards().add(0, new TheAmbassator());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        game.playerCallingTheBluff = game.player(2);
        action.doCallTheBluffOnActionInternal(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(4, game.player(1).coins());

        Assertions.assertEquals(1, game.player(2).cardsInGame());
        Assertions.assertEquals(0, game.player(2).coins());
    }

    // Action can be blocked (by Captain)
    @Test
    public void player_does_action_and_gets_block_by_captain() throws Exception {
        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheCaptain());
        game.player(2).cards().add(1, new TheDuke());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be blocked (by Captain)
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_by_captain_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheDuke());
        game.player(2).cards().add(1, new TheDuke());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockActionInternal(game);


        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(4, game.player(1).coins());

        Assertions.assertEquals(1, game.player(2).cardsInGame());
        Assertions.assertEquals(0, game.player(2).coins());
    }

    // Action can be blocked (by Captain)
    // Block can be challenged
    // Challenger lose
    @Test
    public void player_does_action_and_gets_block_by_captain_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {
        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheCaptain());
        game.player(2).cards().add(1, new TheDuke());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockActionInternal(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(1, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());


    }

    // Action can be blocked (by Ambassador)
    @Test
    public void player_does_action_and_gets_block_by_ambassador() throws Exception {
        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheAmbassator());
        game.player(2).cards().add(1, new TheDuke());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(2, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

    // Action can be blocked (by Ambassador)
    // Block can be challenged
    // Challenger wins
    @Test
    public void player_does_action_and_gets_block_by_ambassador_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {
        // given
        game.player(2).cards().clear();
        game.player(2).cards().add(0, new TheAmbassator());
        game.player(2).cards().add(1, new TheDuke());

        // when
        game.playerDoingTheAction = game.player(1);
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockActionInternal(game);

        // then
        Assertions.assertEquals(46, game.treasury());

        Assertions.assertEquals(1, game.player(1).cardsInGame());
        Assertions.assertEquals(2, game.player(1).coins());

        Assertions.assertEquals(2, game.player(2).cardsInGame());
        Assertions.assertEquals(2, game.player(2).coins());
    }

}
