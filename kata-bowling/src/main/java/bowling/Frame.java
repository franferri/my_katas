package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private Character roll1;
    private Character roll2;

    private Frame(char roll1, Character roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    public boolean isSpare() {
        return roll2 != null && roll2 == '/';
    }

    public boolean isStrike() {
        return roll1 == 'X';
    }

    public int getScore() {
        if (isSpare() || isStrike()) { return 10; }

        return getRollValue(roll1) + getRollValue(roll2);
    }

    public int getRoll1Score() {
        return getRollValue(roll1);
    }

    public int getRoll2Score() {
        return getRollValue(roll2);
    }

    private int getRollValue(Character roll) {
        if (roll == null) { return 0; }

        if ('-' == roll) {
            return 0;
        } else {
            return Character.getNumericValue(roll);
        }

    }

    public static List<Frame> chunker(String game) {
        List<Frame> frames = new ArrayList<>();

        int counter = 0;
        char prevChar = 0;
        for (int i = 0; i < game.length(); i++) {
            char c = game.charAt(i);

            counter++;

            if (c == 'X') {
                frames.add(new Frame(c, null));
                counter = 0;
            } else if (counter == 2) {
                frames.add(new Frame(prevChar, c));
                counter = 0;
            }

            prevChar = c;
        }

        if (counter != 0) {
            frames.add(new Frame(prevChar, null));
        }

        return frames;
    }

}
