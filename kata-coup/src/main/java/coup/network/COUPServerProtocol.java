package coup.network;

import java.util.ArrayList;
import java.util.List;

public class COUPServerProtocol {

    private static final int WAITING = 0;
    private static final int ACTIVE = 1;

    private int state = WAITING;

    public List<String> processInput(String theInput) {
        List<String> theOutput = new ArrayList<>();

        if (state == WAITING) {
            theOutput = ASCIIArt.welcome();
            theOutput.add("Tell me your name");
            state = ACTIVE;
        } else {
            theOutput.add("Ack: " + theInput);
        }

        return theOutput;
    }
}