package coup.cards;

import coup.Card;
import coup.actions.Assassinate;

public class TheContessa extends Card {

    public TheContessa() {
        this.setBlocks(new Assassinate());
    }

}
