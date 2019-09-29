package coup.cards;

import coup.Card;
import coup.actions.Assassinate;

public class TheAssassin extends Card {

    public TheAssassin() {
        this.setAction(new Assassinate());
    }

}
