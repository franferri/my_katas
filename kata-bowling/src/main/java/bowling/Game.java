package bowling;

import java.util.List;

public class Game {

    // 1 game contains 10 frames 2 turns(or 1 if strike)

    public int score(String game) {

        int finalScore = 0;

        List<Frame> frames = Frame.chunker(game);

        Frame previousFrame = null;
        for (Frame frame : frames) {
            if (previousFrame != null) {
                if (previousFrame.isSpare() && frames.indexOf(frame) != 10 - 1) {
                    finalScore += frame.getRoll1Score();
                } else if (previousFrame.isStrike()) {
                    finalScore += frame.getScore();
                }
            }

            finalScore += frame.getScore();
            previousFrame = frame;
        }

        return finalScore;
    }

}
