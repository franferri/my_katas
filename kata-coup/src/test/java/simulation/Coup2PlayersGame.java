package simulation;

import coup.Action;
import coup.Game;
import coup.Player;
import coup.actions.Assassinate;
import coup.actions.Exchange;
import coup.actions.ForeignAid;
import coup.actions.Steal;
import coup.cards.TheAmbassator;
import coup.cards.TheAssassin;
import coup.cards.TheCaptain;
import coup.cards.TheContessa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Coup2PlayersGame {

    Game game;
    Action action;

    @BeforeEach
    public void before() throws Exception {

        // given
        Player player1 = new Player();
        Player player2 = new Player();

        game = new Game(player1, player2);
        game.startGame();

    }

    // TODO: This is a simple simulation of a play, were we hardcoded the decisions to be able to predict the outcome, so we can decide to refactor the library better.

    @Test
    public void simplePlay() throws Exception {
        // given
        game.player(1).cards().clear();
        game.player(1).cards().add(new TheAssassin());
        game.player(1).cards().add(new TheCaptain());

        game.player(2).cards().clear();
        game.player(2).cards().add(new TheContessa());
        game.player(2).cards().add(new TheContessa());

        // when

        // Player 1 hand
        //game.player(1).doesActionForeignAid();
        game.playerDoingTheAction = game.player(1);
        action = new ForeignAid();
        action.doAction(game);

        // Player 2 hand
        //game.player(2).doesActionExchange();
        game.playerDoingTheAction = game.player(2);
        action = new Exchange();
        action.doAction(game);

        game.player(2).cards().clear();
        game.player(2).cards().add(new TheAmbassator());
        game.player(2).cards().add(new TheContessa());

        // Player 1 hand
        //game.player(1).doesActionAssassinate().onPlayer(2);
        game.playerDoingTheAction = game.player(1);
        action = new Assassinate();
        game.targetPlayerForAssassination = game.player(2);
        action.doAction(game);

        // Player 2 hand
        //game.player(2).doesBlockTheAction();
        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        // Player 1 hand
        //game.player(1).doesCallTheBluff();
        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockAction(game);

        // Player 2 hand
        //game.player(2).doesActionForeignAid();
        game.playerDoingTheAction = game.player(2);
        action = new ForeignAid();
        action.doAction(game);

        // Player 1 hand
        //game.player(1).doesActionStealing().onPlayer(2);
        game.playerDoingTheAction = game.player(1);
        action = new Steal();
        game.targetPlayerForStealing = game.player(2);
        action.doAction(game);

        // Player 2 hand
        //game.player(2).doesCallTheBluff
        game.playerBlockingTheAction = game.player(2);
        action.doBlockAction(game);

        // Player 1 hand
        //game.player(1).doesCallTheBluff();
        game.playerCallingTheBluff = game.player(1);
        action.doCallTheBluffOnBlockAction(game);

        // then
        Assertions.assertEquals(2, game.whoIsTheWinner());
        Assertions.assertTrue(game.player(1).isDead());

    }

}
