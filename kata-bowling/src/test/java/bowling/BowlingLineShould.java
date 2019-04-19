package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingLineShould {

    @Test
    public void tryOneTime() {

        // given
        Game game = new Game();

        // when
        int result = game.score("1");

        // then
        assertEquals(1, result);

    }

    @Test
    public void tryTwoTimes() {

        // given
        Game game = new Game();

        // when
        int result = game.score("11");

        // then
        assertEquals(2, result);

    }

    @Test
    public void tryOneFail() {

        // given
        Game game = new Game();

        // when
        int result = game.score("-");

        // then
        assertEquals(0, result);

    }

    @Test
    public void tryOneFailOneSuccess() {

        // given
        Game game = new Game();

        // when
        int result = game.score("-1");

        // then
        assertEquals(1, result);

    }

    @Test
    public void tryOneSpare() {

        // given
        Game game = new Game();

        // when
        int result = game.score("1/"); // you cleared the frame in the second try (spare shoot)

        // then
        assertEquals(10, result);

    }

    @Test
    public void tryOneSpareAndOneTry() {

        // given
        Game game = new Game();

        // when
        int result = game.score("1/1"); // you cleared the frame in the second try (spare shoot)

        // then
        assertEquals(12, result);

    }

    @Test
    public void tryAFewSpares() {

        // given
        Game game = new Game();

        // when
        int result = game.score("1/3/23"); // you cleared the frame in the second try (spare shoot)

        // then
        assertEquals(30, result);

    }

    @Test
    public void tryManySpares() {

        // given
        Game game = new Game();

        // when
        int result = game.score("5/5/5/5/5/5/5/5/5/5/5"); // you cleared the frame in the second try (spare shoot)

        // then
        assertEquals(150, result);

    }

}
