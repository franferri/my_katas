package coup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.mockito.Mockito.spy;

public class TestingActions {

    // TODO cuando un jugador tiene un challence y enseña la carta, tenemos q reshuflear y coger una nueva para ese player (player 1 si el challence es para la action, player 2 si el challence es para el blockeo de la acción)

    protected GameEngine gameEngine;

    protected final Player player1 = spy(new Player());
    protected final Player player2 = spy(new Player());

    protected Action action;

    protected void before()  {

        // given
        gameEngine = new GameEngine(player1, player2);
        gameEngine.startGame();

    }

    protected void assertThrowsWithMessage(Executable executable, String message) {
        Exception thrown = Assertions.assertThrows(Exception.class, executable, "The received Exception is not the expected type of Exception");
        Assertions.assertEquals(thrown.getMessage(), message, "The received Exception message is not the expected: Received = '" + thrown.getMessage() + "', Expected = '" + message + "'");
    }

}
